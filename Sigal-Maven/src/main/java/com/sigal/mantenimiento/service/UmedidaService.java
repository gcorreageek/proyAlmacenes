package com.sigal.mantenimiento.service;

import com.sigal.dao.DAOFactory;
import com.sigal.mantenimiento.dao.UmedidaDAO;
import com.sigal.util.Constantes;

public class UmedidaService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	UmedidaDAO objUmedidaDAO = fabrica.getUmedidaDAO();
}
