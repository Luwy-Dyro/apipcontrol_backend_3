package com.apirest.sisgespro.components;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.apirest.sisgespro.entity.Proyecto;



public class SendEmail {
	
	public boolean envioCorreoPostulacion(Proyecto proyecto) {
		
		String representante = "luwy.dyro@gmail.com"; //AQUI INGRESA EL CORREO A DONDE QUIERES ENVIAR
		
		//final String username = "mail.test.upc@gmail.com"; //CORREO DE GOOGLE
		//final String password = "UPC@2022"; //CONTRASENIA DE CORREO

		
		final String username = "jorgebardales94@gmail.com"; //CORREO DE GOOGLE
		final String password = "glcpfawcgtmlltoy"; //CONTRASENIA DE CORREO
		
		
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.smtp.socketFactory.port", "25");
		props.setProperty("mail.smtp.user", username);
		props.setProperty("mail.smtp.password", password);
		props.setProperty("mail.smtp.auth", "true"); 
		
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {
			//build body email
			MimeBodyPart textBodyPart = new MimeBodyPart();
			String mensaje = "<table style=\"margin:auto; width:625px; background-color: #f8f8f8\">\r\n"
					+ "			<tr>\r\n" + "            "
					+ "				<td>\r\n"
					+ "                 <img src=\"http://apps.trabajo.gob.pe/suspension-perfecta/images/logo.jpg\" width=\"40%\" style=\"margin-bottom: -10px;margin-top: 10px;\">\r\n"
					+ "             </td>\r\n" 
					+ "         </tr>\r\n" 
					+ "         <tr>\r\n"
					+ "            <td>\r\n"
					+ "                <table style=\"margin:auto;margin-top: 10px; margin-bottom: 10px; width:800px; border: 1px solid #e0e0e0; border-radius: 6px; padding: 10px;background-color: #ffffff\">\r\n"
					+ "                    <tr>\r\n"
					+ "                        <td style=\"margin-left: 15px; margin-right: 15px; text-align: justify; font-size:14px;\">\r\n"
					+ "                            <p>\r\n"
					+ "                                Estimado usuario:\r\n<strong></strong>"
					+ "                            </p>\r\n" 
					+ "                            <p>\r\n"
					+ "                          	Se registro de manera correcta el proyecto con los siguientes datos:  <br>" 
					+ "                          	Proyecto 		: <strong>" + proyecto.getNombreProyecto().toUpperCase() + "</strong> <br>" 
					+ "                          	Soporte 		:  <strong>" + proyecto.getSoporte().toUpperCase() + "</strong> <br>" 
					+ "                          	Coordinador 	:  <strong>" + proyecto.getCoordinador().toUpperCase() + "</strong> <br>"  
					+ "                          	Direccion 		:  <strong>" + proyecto.getDireccion().toUpperCase() + "</strong> <br>"
					+ "                          	Tipo proyecto 	:  <strong>" + proyecto.getTipoProyecto().getDestipoProyecto().toUpperCase() + "</strong> <br>" 
					+ "                          	Estado 			:  <strong>" + proyecto.getEstadoProyecto().getEstadoProyecto().toUpperCase() + "</strong> <br>" 
					+ "                          	Sector 			:  <strong>" + proyecto.getSector().getNombreSector().toUpperCase() + "</strong> <br>" 
					+ "                          	Observacion 	:  <strong>" + proyecto.getObservacion().toUpperCase() + "</strong> <br><br>" 
					
					+								"Para esclarecer cualquier duda que tengan o realizar alguna consulta, pueden enviar un mensaje electrónico otic@trabajo.gob.pe."  
					+ "								<br>" 
					+ "                            </p>\r\n"
					+ "                            <p>Saludos Cordiales\r\n"
					+ "                            </p><br>\r\n" 
					+ "                        </td>\r\n"
					+ "                    </tr>\r\n" 
					+ "                </table>\r\n"
					+ "            </td>\r\n" 
					+ "        </tr>\r\n" 
					+ "        <tr>\r\n"
					+ "            <td style=\"background: #4d4d4d;margin-top: 22px;color: white; padding-left: 11px; text-align: justify; font-size:14px;padding-top: 5px;padding-bottom: 5px;\">\r\n"
					+ "                             Ministerio de Trabajo y Promoción del Empleo - Av. Salaverry 655, Jesús María, Lima / Perú \r\n"
					+ "                             <br/>Central telefónica: (511) 630-6000 / (511) 630-6030 \r\n"
					+ "                             <br/>MTPE © 2020 Todos los derechos reservados<br/> \r\n"
					+ "            </td>\r\n" 
					+ "        </tr>\r\n" 
					+ "    </table>";
			
			
			textBodyPart.setContent(mensaje,"text/html; charset=utf-8");
			
			//put together email components
			MimeMultipart mimeMultipart = new MimeMultipart();
			mimeMultipart.addBodyPart(textBodyPart);

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));

			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(representante));			
			message.setSubject("CORREO DE CONSTANCIA DE REGISTRO PROYECTO");
			message.setContent(mimeMultipart,"text/html");
			
			Transport.send(message);
			System.out.println("Correo de postulacion enviado a: " + representante);
			return true;

		} catch (MessagingException e) {
			e.printStackTrace();
			System.out.println("ERROR ARREGLALO: " + e.getMessage());
			return false;
		}
		
	}

}
