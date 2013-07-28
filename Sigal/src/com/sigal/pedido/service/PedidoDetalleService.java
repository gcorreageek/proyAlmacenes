package com.sigal.pedido.service;

import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.pedido.bean.SolicitudPedidoDTO;
import com.sigal.pedido.dao.PedidoDetalleDAO;
import com.sigal.util.Constantes;

public class PedidoDetalleService {

	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
//	pedido objSolPDAO = fabrica.getSolicitudPedidoDAO();
	PedidoDetalleDAO objPedDetDAO = fabrica.getPedidoDetalleDAO();
	 
	public List<DetallePedidoDTO> listaPedidoXidPedido(DetallePedidoDTO det) throws Exception {
		return objPedDetDAO.getPedidoDetalle(det);
	}  
	
	
	

}
