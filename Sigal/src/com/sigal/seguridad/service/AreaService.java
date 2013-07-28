package com.sigal.seguridad.service;

import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.seguridad.bean.AreaDTO;
import com.sigal.seguridad.dao.AreaDAO;
import com.sigal.util.Constantes;

public class AreaService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	AreaDAO objAreaDAO = fabrica.getAreaDAO(); 
	public AreaDTO  getArea(Integer cod) {
		return objAreaDAO.getArea(cod);
	}
	public List<AreaDTO>  listaArea() {
		return objAreaDAO.listarArea(null);
	}
}
