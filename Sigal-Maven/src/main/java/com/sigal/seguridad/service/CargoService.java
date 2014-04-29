package com.sigal.seguridad.service;

import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.seguridad.bean.CargoDTO;
import com.sigal.seguridad.dao.CargoDAO;
import com.sigal.util.Constantes;

public class CargoService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	CargoDAO objCargoDAO = fabrica.getCargoDAO();
	public List<CargoDTO>  listaCargoXIdArea(Integer idArea) throws Exception {
		CargoDTO cargo = new CargoDTO();
		cargo.setCod_area(idArea);
		return objCargoDAO.buscarCargo(cargo);
	}
	
	
	public List<CargoDTO>  listaCargo() throws Exception {
		return objCargoDAO.buscarCargo(null);
	} 
	
	
	public List<CargoDTO> listaCargoPaginado(Integer inicio,Integer tamano)throws Exception  {
		return objCargoDAO.buscarCargoPaginados(null, inicio,tamano);
	} 
	public List<CargoDTO> buscarCargoXDescPaginado(CargoDTO cargo,Integer inicio,Integer tamano)throws Exception  {
		return objCargoDAO.buscarCargoPaginados(cargo, inicio, tamano);
	}
	public Integer listaCargoTotal()throws Exception  {
		return objCargoDAO.buscarCargo(null).size();
	}
	public Integer buscarCargoXDescTotal(CargoDTO cargo ) throws Exception {
		return objCargoDAO.buscarCargo(cargo).size();
	}
	
	
	
	
	
	
	
	public Boolean registrarCargo(CargoDTO objCargo) throws Exception {
		return (Boolean) objCargoDAO.registrarCargo(objCargo);
	} 
	public Boolean actualizarCargo(CargoDTO objCargo) throws Exception {
		return (Boolean) objCargoDAO.actualizarCargo(objCargo);
	}
	public Boolean eliminarCargo(CargoDTO objCargo) throws Exception {
		return (Boolean) objCargoDAO.eliminarCargo(objCargo);
	}
	
	public  CargoDTO  getCargo(Integer cod) {
		return objCargoDAO.getCargo(cod);
	}
	
}
 