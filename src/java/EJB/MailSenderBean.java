/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Blair
 */
@Stateless
public class MailSenderBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public void sendEmail(String fromEmail, String username, String password, String toEmail, String subject, String message){
        try {
            Properties props = System.getProperties();
            
            props.put("mail.smtp.host", "smtp.rediffmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "25");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.port", "25");
            props.put("mail.smtp.socketFactory.fallback", "false");
            /*props.setProperty("mail.smtp.ssl.enable","true");
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");*/
            
            Session mailSession = Session.getDefaultInstance(props,null);
            mailSession.setDebug(true);
            
            Message mailMessage = new MimeMessage(mailSession);
            mailMessage.setFrom(new InternetAddress(fromEmail));
            mailMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mailMessage.setText(message);
            mailMessage.setSubject(subject);
            
            Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.rediffmail.com", username, password);
            
            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
        } catch (MessagingException ex) {
            Logger.getLogger(MailSenderBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
