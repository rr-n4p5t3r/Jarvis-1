package co.com.spn.cun3.integrations.mail.service;

import co.com.spn.cun3.db.entities.Operacion;
import co.com.spn.cun3.db.entities.Organizacion;
import co.com.spn.cun3.db.repositories.OperacionRepository;
import co.com.spn.cun3.db.repositories.OrganizacionRepository;
import co.com.spn.cun3.services.andes.CorreoCertificadoService;
import co.com.spn.cun3.webService.RegistrarMensajeResponse;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.mail.util.MimeMessageParser;
import org.apache.poi.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.internet.InternetAddress;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Service
public class StandardCorreoCunService implements CorreoCunService {

    @Autowired
    OrganizacionRepository organizacionRepository;

    @Autowired
    OperacionRepository operacionRepository;

    @Autowired
    CorreoCertificadoService correoCertificadoService;

    @SneakyThrows
    @Override
    public void processCorreo(MimeMessageParser messageParser) {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_BLUE = "\u001B[34m";
        String sender = messageParser.getFrom();
        System.out.printf("Empezando el procesamiento del correo enviado desde %s, con asunto %s\n", sender, messageParser.getSubject());
        try {
            Pattern pattern = Pattern.compile("((.*)@(([^.]*)\\..*))");
            Matcher matcher = pattern.matcher(sender);
            if (matcher.find()) {
                String correo = matcher.group(1);
                String usuario = matcher.group(2);
                String dominio = matcher.group(3);
                String subdominio = matcher.group(4);
                Organizacion organizacion = null;
//                Organizacion organizacion = organizacionRepository.findByorg_usuariosubdominio(correo);
                List<Organizacion> organizaciones = organizacionRepository.organizacionesPorDominio(dominio);
                if (organizaciones.size() == 1) {
                    organizacion = organizaciones.get(0);
                } else if (organizaciones.size() > 1) {
                    organizacion = organizacionRepository.findByorg_usuariosubdominio(correo);
                }
                if (organizacion != null) {
                    if (!operacionRepository.checkIfExists(messageParser.getSubject(), ((InternetAddress) messageParser.getTo().get(0)).getAddress()).isEmpty()) {
                        return;
                    }
                    String attachments = processAttachments(messageParser);
                    String attachmentsString = "_adjuntos_sealmail_";
                    System.out.println("Inicia llamado al servicio de andes");
                    RegistrarMensajeResponse registrarMensajeResponse = correoCertificadoService.postMail(organizacion.getOrg_usuariosubdominio(), messageParser.getSubject(), messageParser.parse().getHtmlContent(), "Sr Usuario", ((InternetAddress) messageParser.getTo().get(0)).getAddress(), attachments, attachmentsString, organizacion.getOrg_clave(), organizacion.getOrg_subdominio());
                    System.out.println("Se recibe respuesta por parte de andes");
                    System.out.printf("Respuesta de andes: %s\n", registrarMensajeResponse.getHash());
                    Pattern patternForResponse = Pattern.compile("idMensaje=(\\d*)\\n");
                    Matcher matcherForResponse = patternForResponse.matcher(registrarMensajeResponse.getHash());
                    if (matcherForResponse.find()) {
                        String idMensaje = matcherForResponse.group(1);
//                        System.out.printf("idMensaje: %s\n", idMensaje);
                        Pattern patternForClient = Pattern.compile(".*\\|(\\d*)");
                        Matcher matcherForClient = patternForClient.matcher(messageParser.getSubject());
                        String identificadoCliente = "";
                        if (matcherForClient.find()) {
                            identificadoCliente = matcherForClient.group(1);
                        }
//                        System.out.printf("identificadoCliente: %s\n", identificadoCliente);
                        Operacion operacion = Operacion.builder()
                                .fopr_id(organizacion.getOrg_id())
                                .opr_idientificadorcliente(identificadoCliente)
                                .opr_idientificadoranddes(idMensaje)
                                .opr_correoemisor(correo)
                                .opr_asunto(messageParser.getSubject())
                                .opr_correoorganizacion(organizacion.getOrg_usuariosubdominio())
                                .opr_destinatario(((InternetAddress) messageParser.getTo().get(0)).getAddress())
                                .build();
                        operacionRepository.save(operacion);
                        System.out.println(ANSI_BLUE + operacion + ANSI_RESET);
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String processAttachments(MimeMessageParser messageParser) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ZipOutputStream zipOut = new ZipOutputStream(byteArrayOutputStream);
            messageParser.getAttachmentList().forEach(dataSource -> {
                if (StringUtils.isNotBlank(dataSource.getName())) {
                    try {
                        System.out.printf("\t- Procesando adjunto: %s\n", dataSource.getName());
                        ByteArrayOutputStream out = new ByteArrayOutputStream();
                        InputStream in = dataSource.getInputStream();
                        IOUtils.copy(in, out);
                        byte[] byteFile = out.toByteArray();
                        ZipEntry zipEntry = new ZipEntry(dataSource.getName());
                        zipOut.putNextEntry(zipEntry);
                        zipOut.write(byteFile);
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println("Termina el procesado de adjuntos");
            zipOut.close();
            return Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
