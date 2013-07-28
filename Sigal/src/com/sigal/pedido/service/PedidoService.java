package com.sigal.pedido.service;

import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.pedido.bean.SolicitudPedidoDTO;
import com.sigal.pedido.dao.SolicitudPedidoDAO;
import com.sigal.util.Constantes;

public class PedidoService {

	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	SolicitudPedidoDAO objSolPDAO = fabrica.getSolicitudPedidoDAO();
	
	
//	//Lista todo
	public List<SolicitudPedidoDTO> listaPedido() throws Exception {
		return objSolPDAO.buscarPedido(null);
	} 
	public List<SolicitudPedidoDTO> buscarPedido(SolicitudPedidoDTO pedido)throws Exception {
		return objSolPDAO.buscarPedido(pedido);
	}
//	//Total
	public Integer listaPedidoTotal() throws Exception {
		return objSolPDAO.buscarPedido(null).size();
	}
	public Integer buscarPedidoTotal(SolicitudPedidoDTO pedido ) throws Exception{
		return objSolPDAO.buscarPedido(pedido).size();
	}
//	//Paginacion
	public List<SolicitudPedidoDTO> listaPedidoPaginado(Integer inicio,Integer tamano) throws Exception {
		return objSolPDAO.buscarPedidoPag(null, inicio,tamano);
	} 
	public List<SolicitudPedidoDTO> buscarPedidoPaginado(SolicitudPedidoDTO productoProveedor,Integer inicio,Integer tamano) throws Exception{
		return objSolPDAO.buscarPedidoPag(productoProveedor, inicio, tamano);
	}
	
	public void registrarPedido(SolicitudPedidoDTO objSolP, List<DetallePedidoDTO> lstDetPed) {
		objSolPDAO.registrarPedido(objSolP,lstDetPed);
	}
	public void guardarEvaluacionPedido(SolicitudPedidoDTO objSolP ) {
		objSolPDAO.actualizarPedido(objSolP);
	}
	
	

}
