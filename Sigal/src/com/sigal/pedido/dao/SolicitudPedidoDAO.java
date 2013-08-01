package com.sigal.pedido.dao;

import java.util.List;

import com.sigal.mantenimiento.bean.ProductoProveedorDTO;
import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.pedido.bean.SolicitudPedidoDTO;

public interface SolicitudPedidoDAO {

	Object registrarPedido(SolicitudPedidoDTO objSolP,List<DetallePedidoDTO> lstDetPed) ;
	List<SolicitudPedidoDTO> buscarPedidoPag(SolicitudPedidoDTO pedidoViene,Integer inicio,Integer tamano) throws Exception;
	List<SolicitudPedidoDTO> buscarPedido(SolicitudPedidoDTO pedidoViene) throws Exception;
	
	Object actualizarPedido(SolicitudPedidoDTO objSolP) ;
	/**
	 * @param objPedido
	 * @param inicio
	 * @param tamano
	 * @return
	 */
	List<SolicitudPedidoDTO> buscarPedidoPagSinAtender(
			SolicitudPedidoDTO objPedido, Integer inicio, Integer tamano);
	/**
	 * @param pedido
	 * @return
	 */
	List<SolicitudPedidoDTO> buscarPedidoSinAtender(SolicitudPedidoDTO pedido);
	 
	
}
