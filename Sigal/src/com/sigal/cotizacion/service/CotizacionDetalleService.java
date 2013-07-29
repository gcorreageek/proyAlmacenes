package com.sigal.cotizacion.service;

import java.util.List;

import com.sigal.cotizacion.bean.CotizacionDetalleDTO;
import com.sigal.cotizacion.dao.CotizacionDetalleDAO;
import com.sigal.dao.DAOFactory;
import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.pedido.bean.SolicitudPedidoDTO;
import com.sigal.pedido.dao.PedidoDetalleDAO;
import com.sigal.util.Constantes;

public class CotizacionDetalleService {

	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
//	pedido objSolPDAO = fabrica.getSolicitudPedidoDAO();
	CotizacionDetalleDAO objCotDetDAO = fabrica.getCotizacionDetalleDAO();
	 
	public List<CotizacionDetalleDTO> listaCotizacionXidCotizacion(CotizacionDetalleDTO det) throws Exception {
		return objCotDetDAO.getCotizacionDetalle(det);
	}  
	
	
	

}
