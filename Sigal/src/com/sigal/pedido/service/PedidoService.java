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
	
	public void registrarPedido(SolicitudPedidoDTO objSolP, List<DetallePedidoDTO> lstDetPed) throws Exception{
		objSolPDAO.registrarPedido(objSolP,lstDetPed);
	}
	public void guardarEvaluacionPedido(SolicitudPedidoDTO objSolP ) {
		objSolPDAO.actualizarPedido(objSolP);
	} 
	
	
	
	//////////////////////////////////////////////////////////////
	public List<SolicitudPedidoDTO> listaPedidoPaginadoSinAtender(
			Integer inicio, Integer tamano) throws Exception {
		return objSolPDAO.buscarPedidoPagSinAtender(null, inicio,tamano);
	} 
	public List<SolicitudPedidoDTO> buscarPedidoPaginadoSinAtender(
			SolicitudPedidoDTO objPedido, Integer inicio, Integer tamano) throws Exception {
		return objSolPDAO.buscarPedidoPagSinAtender(objPedido, inicio, tamano);
	} 
	public Integer listaPedidoTotalSinAtender() throws Exception {
		return objSolPDAO.buscarPedidoSinAtender(null).size();
	} 
	public Integer buscarPedidoTotalSinAtender(SolicitudPedidoDTO pedido) throws Exception {
		return objSolPDAO.buscarPedidoSinAtender(pedido).size();
	} 
	
	
	/////////////////////////////////////////////////////////
	public List<SolicitudPedidoDTO> listaPedidoPaginadoAprobados(
			Integer inicio, Integer tamano) {
		return objSolPDAO.buscarPedidoPagAprobados(null, inicio,tamano);
	} 
	public List<SolicitudPedidoDTO> buscarPedidoPaginadoAprobados(
			SolicitudPedidoDTO objPedido, Integer inicio, Integer tamano) {
		return objSolPDAO.buscarPedidoPagAprobados(objPedido, inicio, tamano);
	} 
	public Integer listaPedidoTotalAprobados() {
		return objSolPDAO.buscarPedidoAprobados(null).size();
	} 
	public Integer buscarPedidoTotalAprobados(SolicitudPedidoDTO pedido) {
		return objSolPDAO.buscarPedidoAprobados(pedido).size();
	} 
	public List<SolicitudPedidoDTO> listaPedidoPaginadoFaltanDevolver(
			Integer comienzo, Integer filasXPagina) {
		return objSolPDAO.buscarPedidoPagFaltanDevolver(null, comienzo,filasXPagina);
	} 
	public List<SolicitudPedidoDTO> buscarPedidoPaginadoFaltanDevolver(
			SolicitudPedidoDTO objPedido, Integer comienzo, Integer filasXPagina) {
		return objSolPDAO.buscarPedidoPagFaltanDevolver(objPedido, comienzo, filasXPagina);
	} 
	public Integer listaPedidoTotalFaltanDevolver() {
		return objSolPDAO.buscarPedidoFaltanDevolver(null).size();
	} 
	public Integer buscarPedidoTotalFaltanDevolver(SolicitudPedidoDTO objPedido) {
		return objSolPDAO.buscarPedidoFaltanDevolver(objPedido).size();
	}
	
	

}
