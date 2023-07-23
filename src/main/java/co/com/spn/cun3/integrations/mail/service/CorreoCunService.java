package co.com.spn.cun3.integrations.mail.service;

import org.apache.commons.mail.util.MimeMessageParser;

public interface CorreoCunService {
    void processCorreo(MimeMessageParser messageParser);
}
