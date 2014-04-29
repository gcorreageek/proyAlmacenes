/**
 * OrdenCompraDetalleDAO 28/07/2013
 */
package com.sigal.ordencompra.dao;

import java.util.List;

import com.sigal.ordencompra.bean.OrdenCompraDetalleDTO;

/**
 * @author Gustavo A. Correa C.
 *
 */
public interface OrdenCompraDetalleDAO {
	List<OrdenCompraDetalleDTO> getOCDetalle(OrdenCompraDetalleDTO detalle);
	
	 OrdenCompraDetalleDTO getOCDetalle1(OrdenCompraDetalleDTO detalle);
}
