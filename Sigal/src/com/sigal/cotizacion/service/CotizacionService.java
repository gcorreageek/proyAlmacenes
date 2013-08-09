package com.sigal.cotizacion.service;

import java.util.List;

import com.sigal.cotizacion.bean.CotizacionDTO;
import com.sigal.cotizacion.bean.CotizacionDetalleDTO;
import com.sigal.cotizacion.dao.CotizacionDAO;
import com.sigal.dao.DAOFactory;
import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.pedido.bean.SolicitudPedidoDTO;
import com.sigal.pedido.dao.SolicitudPedidoDAO;
import com.sigal.util.Constantes;

public class CotizacionService {

	
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	CotizacionDAO objSolPDAO = fabrica.getCotizacionDAO();
	
	
//	//Lista todo
	public List<CotizacionDTO> listaCotizacion() throws Exception {
		return objSolPDAO.buscarCotizacion(null);
	} 
	public List<CotizacionDTO> buscarCotizacion(CotizacionDTO cot)throws Exception {
		return objSolPDAO.buscarCotizacion(cot);
	}
//	//Total
	public Integer listaCotizacionTotal() throws Exception {
		return objSolPDAO.buscarCotizacion(null).size();
	}
	public Integer buscarCotizacionTotal(CotizacionDTO cot ) throws Exception{
		return objSolPDAO.buscarCotizacion(cot).size();
	}
//	//Paginacion
	public List<CotizacionDTO> listaCotizacionPaginado(Integer inicio,Integer tamano) throws Exception {
		return objSolPDAO.buscarCotizacionPag(null, inicio,tamano);
	} 
	public List<CotizacionDTO> buscarCotizacionPaginado(CotizacionDTO cot,Integer inicio,Integer tamano) throws Exception{
		return objSolPDAO.buscarCotizacionPag(cot, inicio, tamano);
	}
	
	public void registrarCotizacion(CotizacionDTO objSolP, List<CotizacionDetalleDTO> lstDetPed) throws Exception  {
		objSolPDAO.insertarCotizacion(objSolP,lstDetPed);
	} 
	
	

}
