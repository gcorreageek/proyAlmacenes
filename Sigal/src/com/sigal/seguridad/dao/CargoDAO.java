package com.sigal.seguridad.dao;

import java.util.List;

import com.sigal.seguridad.bean.CargoDTO;

public interface CargoDAO {

	CargoDTO getCargo(Integer codCargo); 
	
	List<CargoDTO> buscarCargoPaginados(CargoDTO cargo,Integer inicio,Integer tamano) throws Exception;
	List<CargoDTO> buscarCargo(CargoDTO cargo) throws Exception; 
	
	
	Object registrarCargo(CargoDTO objCargo) throws Exception;
	Object actualizarCargo(CargoDTO objCargo) throws Exception;
	Object eliminarCargo(CargoDTO objCargo) throws Exception;

}
