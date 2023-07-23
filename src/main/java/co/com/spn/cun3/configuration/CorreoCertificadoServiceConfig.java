package co.com.spn.cun3.configuration;

import co.com.spn.cun3.services.andes.CorreoCertificadoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class CorreoCertificadoServiceConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("co.com.spn.cun3.webService");
        return marshaller;
    }

    @Bean
    public CorreoCertificadoService registrarMensajeService(Jaxb2Marshaller marshaller) {
        CorreoCertificadoService client = new CorreoCertificadoService();
        client.setDefaultUri("https://test.correocertificado4-72.com.co/webService.php");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
