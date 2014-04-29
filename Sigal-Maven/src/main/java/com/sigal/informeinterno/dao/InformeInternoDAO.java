/**
 * InformeInternoDAO 29/07/2013
 */
package com.sigal.informeinterno.dao;

import java.util.List;

import com.sigal.informeinterno.bean.InformeInternoDTO;
import com.sigal.informeinterno.bean.InformeInternoDetalleDTO;

/**
 * @author Gustavo A. Correa C.
 *
 */
public interface InformeInternoDAO {

	Object registrarII(InformeInternoDTO ii, List<InformeInternoDetalleDTO> iiDet) throws Exception;
	
	List<InformeInternoDTO> buscaInformeInterno(InformeInternoDTO ii) throws Exception; 
	
}
