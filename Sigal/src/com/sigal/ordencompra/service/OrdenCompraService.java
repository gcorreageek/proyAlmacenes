package com.sigal.ordencompra.service;

import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.ordencompra.bean.OrdenCompraDTO;
import com.sigal.ordencompra.bean.OrdenCompraDetalleDTO;
import com.sigal.ordencompra.dao.OrdenCompraDAO;
import com.sigal.util.Constantes;

public class OrdenCompraService {

	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	OrdenCompraDAO objOrdenCompraPDAO = fabrica.getOrdenCompraDAO();
	
	
//	//Lista todo
	public List<OrdenCompraDTO> listaOrdenCompra() throws Exception {
		return objOrdenCompraPDAO.buscarOC(null);
	} 
	public List<OrdenCompraDTO> buscarOrdenCompra(OrdenCompraDTO cot)throws Exception {
		return objOrdenCompraPDAO.buscarOC(cot);
	}
//	//Total
	public Integer listaOrdenCompraTotal() throws Exception {
		return objOrdenCompraPDAO.buscarOC(null).size();
	}
	public Integer buscarOrdenCompraTotal(OrdenCompraDTO cot ) throws Exception{
		return objOrdenCompraPDAO.buscarOC(cot).size();
	}
//	//Paginacion
	public List<OrdenCompraDTO> listaOrdenCompraPaginado(Integer inicio,Integer tamano) throws Exception {
		return objOrdenCompraPDAO.buscarOCPag(null, inicio,tamano);
	} 
	public List<OrdenCompraDTO> buscarOrdenCompraPaginado(OrdenCompraDTO cot,Integer inicio,Integer tamano) throws Exception{
		return objOrdenCompraPDAO.buscarOCPag(cot, inicio, tamano);
	}
	
	public void registrarOrdenCompra(OrdenCompraDTO objOrdenCompraP, List<OrdenCompraDetalleDTO> lstDetOrdenCompra) {
		objOrdenCompraPDAO.insertarOC(objOrdenCompraP,lstDetOrdenCompra);
	} 
	
	

}
