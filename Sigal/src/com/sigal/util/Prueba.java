/**
 * Prueba 26/07/2013
 */
package com.sigal.util;

import java.sql.DriverManager;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mysql.jdbc.Connection;


/**
 * @author Gustavo A. Correa C.
 *
 */
public class Prueba {

	private static Log log = LogFactory.getLog(Prueba.class);
	public static void main(String[] args) {
		 log.info("Testing Info Message.");
	        if (log.isDebugEnabled()) {
	            log.debug("Testing Debug Message.");
	        } 
	        Connection conexion = null;
	        
	        try {
				Class.forName("com.mysql.jdbc.Driver");
				 conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_sigal", "root", "root");  
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        
	        try {
				JasperReport reporte = (JasperReport) JRLoader.loadObject("report2.jasper");
				JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, conexion);
				JRExporter exporter = new JRPdfExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint); 
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE,new java.io.File("reportePDF.pdf"));
				exporter.exportReport();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        log.info("Paso x aqui!");
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
//		UtilSigal.fechaActual();
//		 SimpleDateFormat formateador = new SimpleDateFormat( "dd/MM/yyyy", new Locale("es_ES"));
//				   Date fechaDate = new Date();
//				   String fecha = formateador.format(fechaDate); 
//				   
//				   
//				   
//				   try
//			        {
//			            // Propiedades de la conexión
//			            Properties props = new Properties();
//			            props.setProperty("mail.smtp.host", "smtp.gmail.com");
//			            props.setProperty("mail.smtp.starttls.enable", "true");
//			            props.setProperty("mail.smtp.port", "465");
//			            props.setProperty("mail.smtp.user", "gcorreageek@gmail.com");
//			            props.setProperty("mail.smtp.auth", "true");
//
//			            // Preparamos la sesion
//			            Session session = Session.getDefaultInstance(props);
//
//			            // Construimos el mensaje
//			            MimeMessage message = new MimeMessage(session);
//			            message.setFrom(new InternetAddress("gcorreageek@gmail.com"));
//			            message.addRecipient(
//			                Message.RecipientType.TO,
//			                new InternetAddress("gcorreageek@gmail.com"));
//			            message.setSubject("Hola");
//			            message.setText(
//			                "Mensajito con Java Mail" + "de los buenos." + "poque si");
//
//			            // Lo enviamos.
//			            Transport t = session.getTransport("smtp");
//			            t.connect("gcorreageek@gmail.com", "5526296CPc");
//			            t.sendMessage(message, message.getAllRecipients());
//
//			            // Cierre.
//			            t.close();
//			        }
//			        catch (Exception e)
//			        {
//			            e.printStackTrace();
//			        }
				   
///////////////////////////////////
	   // Create the email message
//		HtmlEmail email = new HtmlEmail();
//		email.setHostName("smtp.gmail.com");
//		email.setSmtpPort(587);
//		email.setAuthentication("gcorreageek", "5526296CPc");
//		email.setStartTLSEnabled(true);
//		email.setStartTLSRequired(true);
////		email.setAuthentication("gcorreageek", "5526296CPc");
//		
////		 props.setProperty("mail.smtp.starttls.enable", "true");
////         props.setProperty("mail.smtp.port", "587");
////         props.setProperty("mail.smtp.user", "chuidiang@gmail.com");
////         props.setProperty("mail.smtp.auth", "true");
//		
//		try {
//			email.addTo("gcorreacaja@facebook.com", "Correa Facebbok");
//			email.setFrom("gcorreageek@gmail.com", "GusiGuz");
//			email.setSubject("Asunto!");
//			// embed the image and get the content id
//			URL url = null;
//			url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
//			String cid = null;
//			cid = email.embed(url, "Apache logo");
//			// set the html message
//			email.setHtmlMsg("<html>The apache logo - <img src=\"cid:" + cid + "\"></html>");
//			// set the alternative message
//			email.setTextMsg("Your email client does not support HTML messages");
//			// send the email
//			email.send();
//		} catch (Exception e) { 
//			log.error("error",e); 
//		}	   
//				   
				   
				   
				   
	}
}
