package com.sigal.seguridad.dao;

import java.util.List;

import com.sigal.seguridad.bean.AreaDTO;

public interface AreaDAO {

	AreaDTO getArea(Integer codarea);
	List<AreaDTO> listarArea(AreaDTO area);
	
	List<AreaDTO> buscarAreaPaginados(AreaDTO area,Integer inicio,Integer tamano) throws Exception;
	List<AreaDTO> buscarArea(AreaDTO area) throws Exception; 
	
	Object registrarArea(AreaDTO objArea) throws Exception;
	Object actualizarArea(AreaDTO objArea) throws Exception;
	Object eliminarArea(AreaDTO objArea) throws Exception;
	
	
	
	
	
}
