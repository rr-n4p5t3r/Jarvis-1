package co.com.spn.cun3.integrations.mail.service;

import javax.mail.Folder;

public interface ReceiveMailService {
    void handleReceivedMail(Folder folder);
}
