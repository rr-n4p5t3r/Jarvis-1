package co.com.spn.cun3.integrations.mail.service;

import org.apache.commons.mail.util.MimeMessageParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;

@Service
public class ReceiveMailServiceImpl implements ReceiveMailService {

    @Autowired
    private CorreoCunService correoCunService;

    @Override
    public void handleReceivedMail(Folder folder) {
        try {
            folder.open(Folder.READ_WRITE);
            Flags seen = new Flags(Flags.Flag.SEEN);
            FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
            Message[] messages = folder.search(unseenFlagTerm);
            for (Message message : messages) {
                System.out.printf("Procesando correo: %s\n", message.getSubject());
                extractMail(message);
            }
            folder.close(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void extractMail(Message message) {
        try {
            final MimeMessage messageToExtract = (MimeMessage) message;
            final MimeMessageParser mimeMessageParser = new MimeMessageParser(messageToExtract).parse();
            System.out.printf("Parseando el correo: %s\n", message.getSubject());
            correoCunService.processCorreo(mimeMessageParser);
            messageToExtract.setFlag(Flags.Flag.SEEN, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showMailContent(MimeMessageParser mimeMessageParser) throws Exception {
        System.out.printf("From: %s to: %s | Subject: %s%n", mimeMessageParser.getFrom(), mimeMessageParser.getTo(), mimeMessageParser.getSubject());
        System.out.printf("Mail content: %s", mimeMessageParser.getPlainContent());
    }
}
