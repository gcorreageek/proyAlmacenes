package com.sigal.pedido.service;

import java.util.ArrayList;

import com.sigal.dao.DAOFactory;
import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.pedido.bean.SolicitudPedidoDTO;
import com.sigal.pedido.dao.SolicitudPedidoDAO;
import com.sigal.util.Constantes;

public class PedidoService {

	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	SolicitudPedidoDAO objSolPDAO = fabrica.getSolicitudPedidoDAO();
	
	public void RegistrarPedido(SolicitudPedidoDTO objSolP,
			ArrayList<DetallePedidoDTO> lstDetPed) {
		
		objSolPDAO.RegistrarPedido(objSolP,lstDetPed);
	}
	
	
	

}
