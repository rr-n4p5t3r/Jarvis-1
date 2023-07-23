package co.com.spn.cun3.services.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MailAttachment {
    private String name;
    private byte[] file;
}
