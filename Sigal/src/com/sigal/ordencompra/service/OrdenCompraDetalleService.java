package com.sigal.ordencompra.service;

import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.ordencompra.bean.OrdenCompraDetalleDTO;
import com.sigal.ordencompra.dao.OrdenCompraDetalleDAO;
import com.sigal.util.Constantes;

public class OrdenCompraDetalleService {

	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
//	pedido objSolPDAO = fabrica.getSolicitudPedidoDAO();
	OrdenCompraDetalleDAO objOrdenCompraDetDAO = fabrica.getOrdenCompraDetalleDAO();
	 
	public List<OrdenCompraDetalleDTO> listaOrdenCompraXidOrdenCompra(OrdenCompraDetalleDTO det) throws Exception {
		return objOrdenCompraDetDAO.getOCDetalle(det);
	}  
	
	
	

}
