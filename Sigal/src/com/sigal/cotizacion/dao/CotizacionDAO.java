/**
 * CotizacionDAO 28/07/2013
 */
package com.sigal.cotizacion.dao;

import java.util.List;

import com.sigal.cotizacion.bean.CotizacionDTO;
import com.sigal.cotizacion.bean.CotizacionDetalleDTO;
import com.sigal.pedido.bean.SolicitudPedidoDTO;

/**
 * @author Gustavo A. Correa C.
 *
 */
public interface CotizacionDAO {

	Object insertarCotizacion(CotizacionDTO coti, List<CotizacionDetalleDTO> cotiDet);
	
	List<CotizacionDTO> buscarCotizacionPag(CotizacionDTO cotizacionViene,Integer inicio,Integer tamano) throws Exception;
	List<CotizacionDTO> buscarCotizacion(CotizacionDTO cotizacionViene) throws Exception;
}
