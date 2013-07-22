package com.sigal.mantenimiento.service;

import com.sigal.dao.DAOFactory;
import com.sigal.mantenimiento.dao.CategoriaDAO;
import com.sigal.util.Constantes;

public class CategoriaService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	CategoriaDAO objCategoriaDAO = fabrica.getCategoriaDAO();
}
