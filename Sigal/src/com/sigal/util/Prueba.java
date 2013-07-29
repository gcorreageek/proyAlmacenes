/**
 * Prueba 26/07/2013
 */
package com.sigal.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class Prueba {

	
	public static void main(String[] args) {
		
		UtilSigal.fechaActual();
		 SimpleDateFormat formateador = new SimpleDateFormat( "dd/MM/yyyy", new Locale("es_ES"));
				   Date fechaDate = new Date();
				   String fecha = formateador.format(fechaDate);
				   System.out.println(fecha);
//				   String url = "https://Esto/Jaha";
//				   	System.out.println(url.substring(0,url.indexOf("/",8)));
				   	
				   	
				   	
				   	
				   	
				   	
				   	try {
				         // Se abre la conexión
				         URL url = new URL("http://www.chuidiang.com");
				         URLConnection conexion = url.openConnection();
				         conexion.connect();
				         
				         // Lectura
				         InputStream is = conexion.getInputStream();
				         BufferedReader br = new BufferedReader(new InputStreamReader(is));
				         char[] buffer = new char[1000];
				         int leido;
				         while ((leido = br.read(buffer)) > 0) {
				            System.out.println(new String(buffer, 0, leido));
				         }
				      } catch (MalformedURLException e) {
				         // TODO Auto-generated catch block
				         e.printStackTrace();
				      } catch (IOException e) {
				         // TODO Auto-generated catch block
				         e.printStackTrace();
				      }
				   
	}
}
