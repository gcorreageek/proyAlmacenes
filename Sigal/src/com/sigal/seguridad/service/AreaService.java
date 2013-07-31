package com.sigal.seguridad.service;

import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.seguridad.bean.AreaDTO;
import com.sigal.seguridad.dao.AreaDAO;
import com.sigal.util.Constantes;

public class AreaService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	AreaDAO objAreaDAO = fabrica.getAreaDAO(); 
	
	public List<AreaDTO>  listaArea() {
		return objAreaDAO.listarArea(null);
	}
	public AreaDTO  getArea(Integer cod) {
		return objAreaDAO.getArea(cod);
	}
	
	
	
	public List<AreaDTO> listaAreaPaginado(Integer inicio,Integer tamano)throws Exception  {
		return objAreaDAO.buscarAreaPaginados(null, inicio,tamano);
	} 
	public List<AreaDTO> buscarAreaXDescPaginado(AreaDTO area,Integer inicio,Integer tamano)throws Exception  {
		return objAreaDAO.buscarAreaPaginados(area, inicio, tamano);
	}
	public Integer listaAreaTotal()throws Exception  {
		return objAreaDAO.buscarArea(null).size();
	}
	public Integer buscarAreaXDescTotal(AreaDTO area ) throws Exception {
		return objAreaDAO.buscarArea(area).size();
	}
	
	
	
	
	
	
	
	public Boolean registrarArea(AreaDTO objArea) throws Exception {
		return (Boolean) objAreaDAO.registrarArea(objArea);
	} 
	public Boolean actualizarArea(AreaDTO objArea) throws Exception {
		return (Boolean) objAreaDAO.actualizarArea(objArea);
	}
	public Boolean eliminarArea(AreaDTO objArea) throws Exception {
		return (Boolean) objAreaDAO.eliminarArea(objArea);
	}
}
