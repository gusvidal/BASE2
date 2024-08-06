package cl.gvidal.mail.app.model;

import lombok.Data;

@Data
public class MailModel {
    public String subject;
    public String body;
    public String mailTo;
}
