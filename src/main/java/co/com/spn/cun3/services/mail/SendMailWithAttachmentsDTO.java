package co.com.spn.cun3.services.mail;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SendMailWithAttachmentsDTO {
    private String to;
    private String subject;
    private String message;

    private List<MailAttachment> mailAttachments;

    public SendMailWithAttachmentsDTO(String to, String subject, String message, List<MailAttachment> mailAttachments) {
        this.to = to;
        this.subject = subject;
        this.message = message;
        this.mailAttachments = mailAttachments;
    }
}
