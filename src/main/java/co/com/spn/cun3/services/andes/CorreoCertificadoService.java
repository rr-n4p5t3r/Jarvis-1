package co.com.spn.cun3.services.andes;

import co.com.spn.cun3.webService.ObtenerTokenRequest;
import co.com.spn.cun3.webService.ObtenerTokenResponse;
import co.com.spn.cun3.webService.RegistrarMensajeRequest;
import co.com.spn.cun3.webService.RegistrarMensajeResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.xml.transform.StringSource;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Base64;

import static java.lang.System.currentTimeMillis;

@Data
@AllArgsConstructor
@ToString
class PassDigest {
    String digest;
    String nonce;
    String created;
}

class MessageCallback implements WebServiceMessageCallback {
    String securityHeader = "";

    private SecureRandom RANDOM;
    private int NONCE_SIZE_IN_BYTES = 16;
    private String MESSAGE_DIGEST_ALGORITHM_NAME_SHA_1 = "SHA-1";
    private String SECURE_RANDOM_ALGORITHM_SHA_1_PRNG = "SHA1PRNG";

    public PassDigest generarHeader(String password) throws DatatypeConfigurationException {
        try {
            RANDOM = SecureRandom.getInstance(SECURE_RANDOM_ALGORITHM_SHA_1_PRNG);
            RANDOM.setSeed(currentTimeMillis());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        final var nonceBytes = generateNonce();
        final var createdDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(Instant.now().toString());
        final var passwordDigestBytes = constructPasswordDigest(nonceBytes, createdDate, password);
        final var base64Encoder = Base64.getEncoder();
        final var nonceBase64Encoded = base64Encoder.encodeToString(nonceBytes);
        final var passwordDigestBase64Encoded = base64Encoder.encodeToString(passwordDigestBytes);
//        System.out.println(String.format("nonce: [%s], password digest: [%s]", nonceBase64Encoded, passwordDigestBase64Encoded));
//        System.out.flush();
        return new PassDigest(passwordDigestBase64Encoded, nonceBase64Encoded, createdDate.toXMLFormat());
    }

    private byte[] generateNonce() {
        var nonceBytes = new byte[NONCE_SIZE_IN_BYTES];
        RANDOM.nextBytes(nonceBytes);
        return nonceBytes;
    }

    /**
     * @noinspection SameParameterValue
     */
    private byte[] constructPasswordDigest(byte[] nonceBytes, XMLGregorianCalendar createdDate, String password) {
        try {
            final var sha1MessageDigest = MessageDigest.getInstance(MESSAGE_DIGEST_ALGORITHM_NAME_SHA_1);
            sha1MessageDigest.update(nonceBytes);
            final var createdDateAsString = createdDate.toString();
            sha1MessageDigest.update(createdDateAsString.getBytes(StandardCharsets.UTF_8));
            sha1MessageDigest.update(password.getBytes(StandardCharsets.UTF_8));
            return sha1MessageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public MessageCallback(String idUsuario, String pass) {
//        System.out.printf("Nombre de usuario: %s\n", idUsuario);
//        System.out.printf("Contraseña desde DB: %s\n", pass);
        String encodedPass = DigestUtils.sha1Hex(pass);
//        System.out.printf("Contraseña en SHA1: %s\n", encodedPass);
        try {
            PassDigest passDigest = generarHeader(encodedPass);
//            System.out.printf("Digest: %s\n", passDigest);
            this.securityHeader = "<wsse:Security xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsse:UsernameToken wsu:Id=\"UsernameToken-0D565D5BF5CDB27F1716794887798471\"><wsse:Username>" + idUsuario + "</wsse:Username><wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordDigest\">" + passDigest.digest + "</wsse:Password><wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">" + passDigest.nonce + "</wsse:Nonce><wsu:Created>" + passDigest.created + "</wsu:Created></wsse:UsernameToken></wsse:Security>";
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void doWithMessage(WebServiceMessage webServiceMessage) throws IOException, TransformerException {
        SaajSoapMessage saajSoapMessage = (SaajSoapMessage) webServiceMessage;
        SoapHeader soapHeader = saajSoapMessage.getSoapHeader();
        StringSource headerSource = new StringSource(securityHeader);
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(headerSource, soapHeader.getResult());
    }
}

public class CorreoCertificadoService extends WebServiceGatewaySupport {
    public RegistrarMensajeResponse postMail(String idUsuario, String asunto, String texto, String nombreDestinatario, String correoDestinatario, String adjunto, String nombreArchivo, String pass, String subdominio) {
//        System.out.printf("idUsuario: %s\nnombreDestinatario: %s\ncorreoDestinatario: %s\nsubdominio: %s\n", idUsuario, nombreDestinatario, correoDestinatario, subdominio);
        RegistrarMensajeRequest registrarMensajeRequest = new RegistrarMensajeRequest();
        registrarMensajeRequest.setIdUsuario(idUsuario);
        registrarMensajeRequest.setAsunto(asunto);
        registrarMensajeRequest.setTexto(texto);
        registrarMensajeRequest.setNombreDestinatario(nombreDestinatario);
        registrarMensajeRequest.setCorreoDestinatario(correoDestinatario);
        registrarMensajeRequest.setAdjunto(adjunto);
        registrarMensajeRequest.setNombreArchivo(nombreArchivo);
        WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
        webServiceTemplate.setDefaultUri("https://" + subdominio + ".correocertificado4-72.com.co/webService.php");
        return (RegistrarMensajeResponse) webServiceTemplate.marshalSendAndReceive(registrarMensajeRequest, new MessageCallback(idUsuario, pass));
    }

    public ObtenerTokenResponse getMail(String idUsuario, Integer idMensaje, Boolean generarPDF, String pass, String subdominio) {
        ObtenerTokenRequest obtenerTokenRequest = new ObtenerTokenRequest();
        obtenerTokenRequest.setIdUsuario(idUsuario);
        obtenerTokenRequest.setIdMensaje(idMensaje);
        obtenerTokenRequest.setGenerarPDF(generarPDF);
        WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
        webServiceTemplate.setDefaultUri("https://" + subdominio + ".correocertificado4-72.com.co/webService.php");
        return (ObtenerTokenResponse) getWebServiceTemplate().marshalSendAndReceive(obtenerTokenRequest, new MessageCallback(idUsuario, pass));
    }

    public ObtenerTokenResponse getMailSic(String idUsuario, Integer idMensaje, Boolean generarPDF, String pass, String subdominio) {
        ObtenerTokenRequest obtenerTokenRequest = new ObtenerTokenRequest();
        obtenerTokenRequest.setIdUsuario(idUsuario);
        obtenerTokenRequest.setIdMensaje(idMensaje);
        obtenerTokenRequest.setGenerarPDF(generarPDF);
        WebServiceTemplate webServiceTemplate = getWebServiceTemplate();
        webServiceTemplate.setDefaultUri("https://" + subdominio + ".correocertificado4-72.com.co/webService.php");
        return (ObtenerTokenResponse) getWebServiceTemplate().marshalSendAndReceive(obtenerTokenRequest, new MessageCallback(idUsuario, pass));
    }
}

