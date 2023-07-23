package co.com.spn.cun3.controllers;

import co.com.spn.cun3.db.entities.Organizacion;
import co.com.spn.cun3.db.repositories.OperacionRepository;
import co.com.spn.cun3.db.repositories.OrganizacionRepository;
import co.com.spn.cun3.integrations.mail.service.ReceiveMailService;
import co.com.spn.cun3.services.andes.CorreoCertificadoService;
import co.com.spn.cun3.services.andes.MailStateDTO;
import co.com.spn.cun3.services.mail.MailAttachment;
import co.com.spn.cun3.webService.ObtenerTokenResponse;
import co.com.spn.cun3.webService.RegistrarMensajeResponse;
import com.microsoft.aad.msal4j.ClientCredentialFactory;
import com.microsoft.aad.msal4j.ClientCredentialParameters;
import com.microsoft.aad.msal4j.ConfidentialClientApplication;
import com.microsoft.aad.msal4j.IAuthenticationResult;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.Folder;
import javax.mail.Session;
import javax.mail.Store;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.CompletableFuture;


@Data
class MailDTO {
    private String sender;
    private String subject;
    private String body;
    private String destinataryMail;
    private String destinataryName;
}

@Data
class MailExtendedDTO {
    Integer idMensaje;
    String estado;
    String observacion;
    Instant fecha;
    MailAttachment mailAttachment;
    byte[] xmlAttachment;
    private String andesCode;
    private String internCode;

    public MailExtendedDTO(MailStateDTO mailStateDTO, String andesCode, String internCode) {
        this.idMensaje = mailStateDTO.getIdMensaje();
        this.estado = mailStateDTO.getEstado();
        this.observacion = mailStateDTO.getObservacion();
        this.fecha = mailStateDTO.getFecha();
        this.mailAttachment = mailStateDTO.getMailAttachment();
        this.xmlAttachment = mailStateDTO.getXmlAttachment();
        this.andesCode = andesCode;
        this.internCode = internCode;
    }
}

@Data
class GetMailDTO {
    private String idUsuario;
    private Integer idMensaje;
    private Boolean generarPDF;
}

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    ReceiveMailService receiveMailService;

    @Autowired
    CorreoCertificadoService correoCertificadoService;

    @Autowired
    OrganizacionRepository organizacionRepository;

    @Autowired
    OperacionRepository operacionRepository;

    @Value("${carpeta.correo}")
    String carpetaCorreo;

    //this method returns the token
    public String getAccessTokenByClientCredentialGrant() {
        String accessToken = null;
        // Datos correoCertificado
        String clientId = "a1cc4ebc-a5ce-4e7d-8508-44678706a09b";
        String secret = "O8l8Q~DolX8qEFpir0aXPMYUasgxheeOCvxROakU";
        // Datos CUN3
        //String clientId = "17e7b3c2-2f1b-4ae0-9391-15dad9c4e78e";
        //String secret = "5mN8Q~K-Ll4HpGtk33ZCvGSKQB1bWdzNiIQutcM9";
        String authority = "https://login.microsoftonline.com/be3bc706-8888-4953-93f2-b699081ce4e9/oauth2/v2.0/token";
//        String scope = "https://ps.outlook.com/.default";
        String scope = "https://outlook.office365.com/.default";
        try {
            ConfidentialClientApplication app = ConfidentialClientApplication.builder(
                            clientId,
                            ClientCredentialFactory.createFromSecret(secret))
                    .authority(authority)
                    .build();
            // With client credentials flows the scope is ALWAYS of the shape "resource/.default", as the
            // application permissions need to be set statically (in the portal), and then granted by a tenant administrator
            ClientCredentialParameters clientCredentialParam = ClientCredentialParameters.builder(
                            Collections.singleton(scope))
                    .build();
            CompletableFuture<IAuthenticationResult> future = app.acquireToken(clientCredentialParam);
            IAuthenticationResult result = future.get();
            accessToken = result.accessToken();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accessToken;
    }

    //This method connects to store using the access token
    public Store connect(String userEmailId, String oauth2AccessToken) throws Exception {
        String host = "outlook.office365.com";
        String port = "993";
        Store store = null;
        String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
        Properties props = new Properties();

        props.put("mail.imap.ssl.enable", "true");
        props.put("mail.imap.sasl.enable", "true");
        props.put("mail.imaps.port", port);

        props.put("mail.imaps.auth.mechanisms", "XOAUTH2");
        props.put("mail.imap.sasl.mechanisms", "XOAUTH2");

        props.put("mail.imap.auth.login.disable", "true");
        props.put("mail.imap.auth.plain.disable", "true");

        props.setProperty("mail.imap.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.imap.socketFactory.fallback", "false");
        props.setProperty("mail.imap.socketFactory.port", port);
        props.setProperty("mail.imap.starttls.enable", "true");
//        props.setProperty("mail.imap.partialfetch", "false");
//        props.setProperty("mail.imap.fetchsize", "1048576");


//        props.put("mail.debug", "true");
//        props.put("mail.debug.auth", "true");

        Session session = Session.getInstance(props);
//        session.setDebug(true);

        store = session.getStore("imaps");
//        System.out.println("OAUTH2 IMAP trying to connect with system properties to Host:" + host + ", Port: " + port
//                + ", userEmailId: " + userEmailId + ", AccessToken: " + oauth2AccessToken);
        try {

            store.connect(host, userEmailId, oauth2AccessToken);
//            System.out.println("IMAP connected with system properties to Host:" + host + ", Port: " + port
//                    + ", userEmailId: " + userEmailId + ", AccessToken: " + oauth2AccessToken);
            if (store.isConnected()) {
                System.out.println("Connection Established using imap protocol successfully !");
            }
        } catch (Exception e) {
            System.out.println("Store.Connect failed with the errror: " + e.getMessage());
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            System.out.println(exceptionAsString);
        }
        return store;
    }

    @GetMapping("/testCorreo")
    public void getEmailContents() throws Exception {
        Store store = null;
        String accessToken = getAccessTokenByClientCredentialGrant();
        // Datos CorreoCertificado
        String emailId = "enviocorreocertificado@4-72.com.co";
        // Datos CUN3
        //String emailId = "notificacionesrespuestaspqr@4-72.com.co";
        try {
            store = connect(emailId, accessToken);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        assert store != null;
//        for (Folder folder : store.getFolder("INBOX").list()) {
//            System.out.println(folder.getFullName());
//        }
        ;
        Folder emailFolder = store.getFolder(carpetaCorreo);
//        Folder emailFolder = store.getFolder("BotTest");
        receiveMailService.handleReceivedMail(emailFolder);
    }

    @PostMapping("/sendMail")
    public String sendMail(@RequestBody MailDTO mailDTO) {
        Organizacion organizacion = organizacionRepository.findByorg_usuariosubdominio(mailDTO.getSender());
        RegistrarMensajeResponse registrarMensajeResponse = correoCertificadoService.postMail(mailDTO.getSender(), mailDTO.getSubject(), mailDTO.getBody(), mailDTO.getDestinataryName(), mailDTO.getDestinataryMail(), "", "", organizacion.getOrg_clave(), organizacion.getOrg_subdominio());
        return registrarMensajeResponse.getHash();
    }

    public MailStateDTO getMailAttach(String idUsuario, Integer idMensaje, Boolean generarPDF) {
        MailStateDTO mailStateDTO = new MailStateDTO();
        Organizacion organizacion = organizacionRepository.findByorg_usuariosubdominio(idUsuario);
        System.out.println(organizacion);
        ObtenerTokenResponse obtenerTokenResponse = correoCertificadoService.getMail(idUsuario, idMensaje, generarPDF, organizacion.getOrg_clave(), organizacion.getOrg_subdominio());
        StringTokenizer stringTokenizer = new StringTokenizer(obtenerTokenResponse.getHash(), "\n");
        String archivo = "";
        String observacion = "";
        while (stringTokenizer.hasMoreElements()) {
            String token = stringTokenizer.nextToken();
            int separador = token.indexOf("=");
            String id = token.substring(0, separador);
            String value = token.substring(separador + 1);
            if (id.equals("idMensaje")) {
                mailStateDTO.setIdMensaje(Integer.valueOf(value));
            }
            if (id.equals("Observacion")) {
                observacion = value;
                mailStateDTO.setObservacion(value);
            }
            if (id.equals("Token")) {
                archivo = value;
            } else {
//                System.out.printf("%s: %s\n", id, value);
            }
        }
        if (!archivo.equals("")) {
            byte[] archivoFile = Base64.getDecoder().decode(archivo);
            observacion += ".pdf";
            mailStateDTO.setMailAttachment(new MailAttachment(observacion, archivoFile));
        }
        return mailStateDTO;
    }

    @GetMapping("/getMail")
    public ResponseEntity<?> getMail(@RequestParam String idUsuario, @RequestParam Integer idMensaje) {
        MailStateDTO response = getMailAttach(idUsuario, idMensaje, true);
//        if (response.getMailAttachment() != null) {
//            MailAttachment mailAttachment = response.getMailAttachment();
//            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.parseMediaType("application/pdf"))
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "optional; filename=\"" + mailAttachment.getName() + "\"")
//                    .body(new ByteArrayResource(mailAttachment.getFile()));
//        }
        return ResponseEntity.ok(response);
    }

    public MailExtendedDTO getMailAttachSic(String idUsuario, Integer idMensaje, Boolean generarPDF) {
        MailStateDTO mailStateDTO = new MailStateDTO();
        Organizacion organizacion = organizacionRepository.findByorg_usuariosubdominio(idUsuario);
        System.out.printf("Organizacion: %s\n", organizacion);
        String andesId = operacionRepository.traslateOperacionIdToAndesId(idMensaje.toString(), organizacion.getOrg_usuariosubdominio());
        ObtenerTokenResponse obtenerTokenResponse = correoCertificadoService.getMail(idUsuario, Integer.valueOf(andesId), generarPDF, organizacion.getOrg_clave(), organizacion.getOrg_subdominio());
        StringTokenizer stringTokenizer = new StringTokenizer(obtenerTokenResponse.getHash(), "\n");
        String archivo = "";
        String observacion = "";
        while (stringTokenizer.hasMoreElements()) {
            String token = stringTokenizer.nextToken();
            int separador = token.indexOf("=");
            String id = token.substring(0, separador);
            String value = token.substring(separador + 1);
            if (id.equals("idMensaje")) {
                mailStateDTO.setIdMensaje(Integer.valueOf(value));
            }
            if (id.equals("Observacion")) {
                observacion = value;
                mailStateDTO.setObservacion(value);
            }
            if (id.equals("Token")) {
                archivo = value;
            } else {
//                System.out.printf("%s: %s\n", id, value);
            }
        }
        if (!archivo.equals("")) {
            byte[] archivoFile = Base64.getDecoder().decode(archivo);
            observacion += ".pdf";
            mailStateDTO.setMailAttachment(new MailAttachment(observacion, archivoFile));
        }
        return new MailExtendedDTO(mailStateDTO, andesId, idMensaje.toString());
    }

    @GetMapping("/getMailSic")
    public ResponseEntity<?> getMailSic(@RequestParam String idUsuario, @RequestParam Integer idMensaje) {
        MailExtendedDTO response = getMailAttachSic(idUsuario, idMensaje, true);
//        if (response.getMailAttachment() != null) {
//            MailAttachment mailAttachment = response.getMailAttachment();
//            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.parseMediaType("application/pdf"))
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "optional; filename=\"" + mailAttachment.getName() + "\"")
//                    .body(new ByteArrayResource(mailAttachment.getFile()));
//        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/todosOrganizacion")
    public List<Organizacion> getOrganizaciones() {
        List<Organizacion> organizaciones = organizacionRepository.findAll();
        return organizaciones;
    }

    @GetMapping("/organizacion")
    public Organizacion getOrganizacion() {
        Organizacion organizacion = organizacionRepository.findByorg_usuariosubdominio("jairo.vanegas@linktic.com");
        return organizacion;
    }

}
