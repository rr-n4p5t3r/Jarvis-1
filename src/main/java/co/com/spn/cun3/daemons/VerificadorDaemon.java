package co.com.spn.cun3.daemons;

import co.com.spn.cun3.controllers.TestController;
import co.com.spn.cun3.db.entities.Error;
import co.com.spn.cun3.db.entities.Operacion;
import co.com.spn.cun3.db.repositories.ErrorRepository;
import co.com.spn.cun3.db.repositories.OperacionRepository;
import co.com.spn.cun3.dto.AcuseXML;
import co.com.spn.cun3.services.andes.CorreoCertificadoService;
import co.com.spn.cun3.services.andes.MailStateDTO;
import co.com.spn.cun3.services.mail.MailAttachment;
import co.com.spn.cun3.services.mail.MailSenderService;
import co.com.spn.cun3.services.mail.SendMailWithAttachmentsDTO;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

//@Configuration
//@EnableScheduling
//@EnableAsync
public class VerificadorDaemon {
    private final CorreoCertificadoService correoCertificadoService;

    private final OperacionRepository operacionRepository;

    private final TestController testController;

    private final MailSenderService mailSenderService;

    private final ErrorRepository errorRepository;

    public VerificadorDaemon(CorreoCertificadoService correoCertificadoService, OperacionRepository operacionRepository, TestController testController, MailSenderService mailSenderService, ErrorRepository errorRepository) {
        this.correoCertificadoService = correoCertificadoService;
        this.operacionRepository = operacionRepository;
        this.testController = testController;
        this.mailSenderService = mailSenderService;
        this.errorRepository = errorRepository;
    }

    @Async
    @Scheduled(fixedDelay = 30000)
    public void checkEmail() throws Exception {
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_GREEN = "\u001B[32m";
        String ANSI_YELLOW = "\u001B[33m";
        List<Operacion> operaciones = operacionRepository.operacionesActivas();
        for (Operacion operacion : operaciones) {
            MailStateDTO mailResponse = testController.getMailAttach(operacion.getOpr_correoorganizacion(), Integer.valueOf(operacion.getOpr_idientificadoranddes()), true);
            try {
                if (mailResponse.getEstado().equals("ENTREGADO")) {
                    AcuseXML acuseXML = new AcuseXML();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
                            .withZone(ZoneId.systemDefault());
                    acuseXML.setFechaenvio(formatter.format(operacion.getOpr_creado()));
                    acuseXML.setAsunto(operacion.getOpr_asunto());
                    acuseXML.setDestinatario(operacion.getOpr_destinatario());
                    acuseXML.setFecharecepcion(formatter.format(mailResponse.getFecha()));
                    acuseXML.setEstadoacuse(mailResponse.getEstado());
                    acuseXML.setFechavisualizacion(formatter.format(mailResponse.getFecha()));
                    acuseXML.setEstadovisualizacion("Abierto");
                    JAXBContext context = JAXBContext.newInstance(AcuseXML.class);
                    Marshaller mar = context.createMarshaller();
                    mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    mar.marshal(acuseXML, byteArrayOutputStream);
                    MailAttachment xmlAttachment = new MailAttachment("Certificado.xml", byteArrayOutputStream.toByteArray());
                    mailSenderService.sendMailWithAttachments(new SendMailWithAttachmentsDTO(operacion.getOpr_correoemisor(), operacion.getOpr_asunto(), "Se Adjunta Certificado de Prueba y Envió Correo Certificado Electrónico", List.of(mailResponse.getMailAttachment(), xmlAttachment)));
                    operacion.setOrg_estado(0);
                    operacionRepository.save(operacion);
                    System.out.println(ANSI_GREEN + mailResponse + ANSI_RESET);
                }
                if (mailResponse.getEstado().equals("NO ENTREGADO")) {
                    mailSenderService.sendMailWithAttachments(new SendMailWithAttachmentsDTO(operacion.getOpr_correoemisor(), operacion.getOpr_asunto(), "No se ha podido entregar el mensaje al destinatario se adjunta Certificado de Prueba y Envió Correo Certificado Electrónico", List.of(mailResponse.getMailAttachment())));
                    operacion.setOrg_estado(0);
                    operacionRepository.save(operacion);
                    System.out.println(ANSI_RED + mailResponse + ANSI_RESET);
                }
                if (mailResponse.getEstado().equals("INDEFINIDO")) {
                    System.out.println(ANSI_YELLOW + mailResponse + ANSI_RESET);
                }
            } catch (NullPointerException nullE) {
                errorRepository.save(Error.builder()
                        .err_andesid(Integer.valueOf(operacion.getOpr_idientificadoranddes()))
                        .err_idmensaje(mailResponse.getIdMensaje())
                        .err_observacion(mailResponse.getObservacion())
                        .err_timestamp(Instant.now())
                        .build());
                System.out.printf("%s%s: %s%s\n", ANSI_RED, operacion.getOpr_correoemisor(), mailResponse.getObservacion(), ANSI_RESET);
            }
        }
    }
}
