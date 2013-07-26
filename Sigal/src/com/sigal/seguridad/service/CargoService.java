package com.sigal.seguridad.service;

import com.sigal.dao.DAOFactory;
import com.sigal.seguridad.bean.CargoDTO;
import com.sigal.seguridad.dao.CargoDAO;
import com.sigal.util.Constantes;

public class CargoService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	CargoDAO objCargoDAO = fabrica.getCargoDAO();
	public  CargoDTO  getCargo(Integer cod) {
		return objCargoDAO.getCargo(cod);
	}
	
}
 