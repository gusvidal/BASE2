package cl.gvidal.mail.service;

import cl.gvidal.mail.infra.MailManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    MailManager mailManager;

    public void sendMessageUser(String subject, String mailTo, String body){
        mailManager.sendMessage(subject, mailTo, body);
    }
}
