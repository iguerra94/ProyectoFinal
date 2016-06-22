package org.proyectofinal.ui.util;

import java.io.File; 
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class BoletoEmail {
	
	public BoletoEmail(){
		
	}
	
	public void enviarMail(String usuario, File archivoAdjunto) {
		
		Properties props = new Properties();
		
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.starttls.enable", "true");
		props.setProperty("mail.smtp.port", "587");
		props.setProperty("mail.smtp.user", "aeromanagement2016@gmail.com");
		props.setProperty("mail.smtp.auth", "true");
		
		Session session = Session.getDefaultInstance(props);

		BodyPart body = new MimeBodyPart();
		BodyPart adjunto = new MimeBodyPart();
		
		MimeMultipart multiParte = new MimeMultipart();
		
		MimeMessage message = new MimeMessage(session);
		
		try {
			body.setText("Gracias por elegir viajar con nosotros.\n\n\u00A9 AeroManagement.");
			
			adjunto.setDataHandler(new DataHandler(new FileDataSource(archivoAdjunto)));
			adjunto.setFileName(archivoAdjunto.getName());
			
			multiParte.addBodyPart(body);
			multiParte.addBodyPart(adjunto);

			message.setFrom(new InternetAddress("aeromanagement2016@gmail.com"));
			
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(usuario));

			message.setSubject("Reserva de Boleto AeroManagement");

			message.setContent(multiParte);
			
			Transport t = session.getTransport("smtp");
			t.connect("aeromanagement2016@gmail.com","aero1234");
			t.sendMessage(message,message.getAllRecipients());
			
			t.close();
			
		} catch (AddressException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}