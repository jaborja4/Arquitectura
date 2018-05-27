/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Notificaciones;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author joeli
 */
public class Mail {
    private String dirección;
    private String tema;
    private String texto;

    public Mail(String dirección, String tema, String texto) {
        this.dirección = dirección;
        this.tema = tema;
        this.texto = texto;
    }
    
    public String EnviarMail(){
        String estado="ERR";
        try
        {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "notificacionesarquitectura@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("notificacionesarquitectura@gmail.com"));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(dirección));
            message.setSubject(tema);
            message.setText(texto);

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("notificacionesarquitectura@gmail.com", "Jaborja.5635");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
            estado="EXT";
        }
        catch (Exception e)
        {
           estado="ERR";
        }
        return estado;
    }
    
           
}
