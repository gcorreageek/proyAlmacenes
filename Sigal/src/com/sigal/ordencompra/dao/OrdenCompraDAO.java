/**
 * OrdenCompraDAO 28/07/2013
 */
package com.sigal.ordencompra.dao;

import java.util.List;

import com.sigal.ordencompra.bean.OrdenCompraDTO;
import com.sigal.ordencompra.bean.OrdenCompraDetalleDTO;

/**
 * @author Gustavo A. Correa C.
 *
 */
public interface OrdenCompraDAO {
	Object insertarOC(OrdenCompraDTO oc, List<OrdenCompraDetalleDTO> ocDet);
	
	List<OrdenCompraDTO> buscarOCPag(OrdenCompraDTO ocViene,Integer inicio,Integer tamano) throws Exception;
	List<OrdenCompraDTO> buscarOC(OrdenCompraDTO ocViene) throws Exception;
}
