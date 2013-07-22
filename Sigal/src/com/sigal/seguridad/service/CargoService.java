package com.sigal.seguridad.service;

import java.util.ArrayList;

import com.sigal.dao.DAOFactory;
import com.sigal.seguridad.bean.CargoDTO;
import com.sigal.seguridad.dao.CargoDAO;
import com.sigal.util.Constantes;

public class CargoService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	CargoDAO objCargoDAO = fabrica.getCargoDAO();
	public ArrayList<CargoDTO> listaCargos() {
		// TODO Auto-generated method stub
		return objCargoDAO.listaCargos();
	}
	
}
 