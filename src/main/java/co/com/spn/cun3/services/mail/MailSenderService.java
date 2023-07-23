package co.com.spn.cun3.services.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeUtility;
import java.io.UnsupportedEncodingException;

@Service
public class MailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMailWithAttachments(SendMailWithAttachmentsDTO mailWithAttachmentsEvent) {
        MimeMessagePreparator preparator = mimeMessage -> {
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(mailWithAttachmentsEvent.getTo()));
            mimeMessage.setFrom(new InternetAddress("enviocorreocertificado@4-72.com.co"));
            mimeMessage.setSubject(mailWithAttachmentsEvent.getSubject());
            mimeMessage.setText(mailWithAttachmentsEvent.getMessage());
            MimeMessageHelper helper = null;
            helper = new MimeMessageHelper(mimeMessage, true);
            MimeMessageHelper finalHelper = helper;
            mailWithAttachmentsEvent.getMailAttachments().forEach(mailAttachment -> {
                try {
                    ByteArrayResource file = new ByteArrayResource(mailAttachment.getFile());
                    finalHelper.addAttachment(MimeUtility.encodeText(mailAttachment.getName()), file);
                } catch (MessagingException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            });
            finalHelper.setText(mailWithAttachmentsEvent.getMessage(), true);
        };

        try {
            javaMailSender.send(preparator);
        } catch (MailException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }
    }
}
