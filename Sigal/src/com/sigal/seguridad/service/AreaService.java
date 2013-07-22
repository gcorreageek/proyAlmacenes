package com.sigal.seguridad.service;

import java.util.ArrayList;

import com.sigal.dao.DAOFactory;
import com.sigal.seguridad.bean.AreaDTO;
import com.sigal.seguridad.dao.AreaDAO;
import com.sigal.util.Constantes;

public class AreaService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	AreaDAO objAreaDAO = fabrica.getAreaDAO();
	public ArrayList<AreaDTO> listaAreas() {
		// TODO Auto-generated method stub
		return objAreaDAO.listaAreas();
	}
}
