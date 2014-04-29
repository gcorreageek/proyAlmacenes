package com.sigal.util;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 
 * @author David 
 * 
 * @Informacion Esta clase contiene metodos utiles para el desarrollo de la aplicacion. 
 *
 */
public class UtilSigal {

	
	public static Integer totalDePaginas(Integer total){   
		return (int) Math.ceil((double)total/(double)Constantes.FILAS_X_PAGINA);
	}
	public static java.sql.Date fechaDateSql(String fecString){ 
		java.sql.Date fecFormatoDate = null;
		try {													   
		      SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy", new Locale("es", "ES"));
		      fecFormatoDate = new java.sql.Date(sdf.parse(fecString).getTime()); 
		} catch (Exception ex) {
		      System.out.println("Error al obtener el formato de la fecha/hora: " + ex.getMessage());
		}
		
		return fecFormatoDate;
	}
	public static String fechaActual(){
		SimpleDateFormat formateador = new SimpleDateFormat( "dd/MM/yyyy", new Locale("es_ES"));
		   Date fechaDate = new Date();
		   String fecha = formateador.format(fechaDate);
		   return fecha;
	}
	/**
	 * @descripcion Este metodo sirve para hacer la encriptacion de una cadena
	 * @param message --> es el parametro enviado
	 * @return retorna la constraseña encriptada 
	 */
	public static String getHash(String message){        
		MessageDigest md; 
		byte[] buffer;
		byte[] digest;
		StringBuffer hash = new StringBuffer();
		
		try {
				buffer = message.getBytes("UTF-8");
				/*System.out.println("ingreso metodo gethash ");
				System.out.println(message);
				System.out.println(buffer);*/
				md = MessageDigest.getInstance("SHA1");

			} catch (Exception e) {
				throw new RuntimeException(e);
			}        
			md.update(buffer);        
			digest = md.digest();        
			
			for(byte aux : digest) {            
				int b = aux & 0xff;        
				String s = Integer.toHexString(b);        
				if (s.length() == 1) hash.append("0");        
				hash.append(s);
			}				
			return hash.toString();
	}		
	
	/**
	 * @Descripcion Este metodo sirve para hacer la conversion de formato de fecha 
	 * para registro en la base de datos con formato  yy/mm/dd
	 * @param strFecha
	 * @param strSeparador
	 * @return
	 */
	
	public static String formateaFecha(String strFecha,String strSeparador){
		
		String dia = strFecha.substring(0, strFecha.indexOf(strSeparador));

		strFecha = strFecha.substring(dia.length() + 1);
		String mes = strFecha.substring(0, strFecha.indexOf(strSeparador));

		strFecha = strFecha.substring(mes.length() + 1);
		String anio = strFecha;

		if (dia.length() == 1)
			dia = "0" + dia;
		if (mes.length() == 1)
			mes = "0" + mes;
		String strFechaFinal = anio + "/" + mes + "/" + dia;
		
		return strFechaFinal;
	}
	/**
	 * @author David
	 * @Descripcion Generacion de correlativos 
	 * @return  Correlativo 
	 */
	public static String GenerarCorrelativoPedido(){
		
		SqlSessionFactory sqlMapper = MySqlConexion.getMapper();
		
		
		String cod=null;
		
		SqlSession sesion = sqlMapper.openSession();
		
		try {
			cod = (String) sesion.selectOne("pedido.SQL_obtenerUltimoCodigo");
			System.out.println(cod);
			if (cod==null){
				cod="SOL00001";
			}
			else{

				String cadena =cod;//este sera el ultimo codigo que se reciba
				String primero =cadena.substring(0,cadena.length()-5); // extraigo la parte de "Lic"
				int ultimo = Integer.parseInt( cadena.substring(4))+1; // extraigo el valor de el numero y lo aumento en 1
				if (ultimo<10){
					cod=primero+"0000"+ultimo;
				}
				else if (ultimo<100) {
					cod=primero+"000"+ultimo;
				}
				else if (ultimo<1000) {
					cod=primero+"00"+ultimo;
				}
				else if (ultimo<10000) {
					cod=primero+"0"+ultimo;
				}
				else{
					cod=primero+ultimo;
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
		finally{
			sesion.close();
		}
		return cod;
	}
	

	public static void main(String[] args) {
		EnviarCorreo();
	}
	public static void EnviarCorreo(){
		try {
			Properties prop = new Properties();
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.setProperty("mail.smtp.starttls.enable","true");
			prop.setProperty("mail.smtp.port", "587");
			prop.setProperty("mail.smtp.user","perzc.david@gmail.com");
			prop.setProperty("mail.smtp.auth","true");
			
			
			Session session =  Session.getDefaultInstance(prop,null);
			
			//parte del texto
			BodyPart texto = new MimeBodyPart();
			texto.setText("Texto del mensaje");
			
			//se compone el adjunto con la imagen
			
			BodyPart adjunto = new MimeBodyPart();
			adjunto.setDataHandler(new DataHandler(new FileDataSource("imagen.png")));
			adjunto.setFileName("imagen.png");
			
			
			//Una multiparte para agrupar el texto e imagen
			
			MimeMultipart multiparte = new MimeMultipart();
			multiparte.addBodyPart(texto);
			multiparte.addBodyPart(adjunto);
			
			
			
			//se compone el correo , dando to, from, subject, y el contenido
			
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("perzc.david@gmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("perzc.david@gmail.com"));
			message.setSubject("Prueba");
			message.setContent(multiparte);
			
			
			//Se envia el correo
			
			Transport t = session.getTransport("smtp");
			t.connect("proyectos.cibertec@gmail.com", "123cibertec");
			t.sendMessage(message, message.getAllRecipients());
			t.close();
			
			
		} catch (Exception e) {
				System.out.println(e);
		}

	}
	
	
	
	
}
