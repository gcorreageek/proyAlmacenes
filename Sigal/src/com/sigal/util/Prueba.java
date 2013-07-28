/**
 * Prueba 26/07/2013
 */
package com.sigal.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.sigal.seguridad.bean.AreaDTO;

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
				   
//				   List<AreaDTO>
//				     lstArea = new ArrayList<>();
//					
//					AreaDTO area = new AreaDTO(1,"Sistemas");
//					area.setCod_area(1);
//					area.setDesc_area("Sistemas"); 
//					lstArea.add(area);
//					AreaDTO area2 = new AreaDTO();
//					area2.setCod_area(2);
//					area2.setDesc_area("Finansas"); 
//					lstArea.add(area2);
//					
//					for (AreaDTO areaDTO : lstArea) {
//						System.out.println(areaDTO.getDesc_area());
//					}
				   
	}
}
