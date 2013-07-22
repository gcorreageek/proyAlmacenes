package com.sigal.pedido.dao;

import java.util.ArrayList;

import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.pedido.bean.SolicitudPedidoDTO;

public interface SolicitudPedidoDAO {

	void RegistrarPedido(SolicitudPedidoDTO objSolP,
			ArrayList<DetallePedidoDTO> lstDetPed);

}
