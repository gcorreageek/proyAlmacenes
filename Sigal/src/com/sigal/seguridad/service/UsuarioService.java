package com.sigal.seguridad.service;

import com.sigal.dao.DAOFactory;
import com.sigal.seguridad.dao.UsuarioDAO;
import com.sigal.util.Constantes;

public class UsuarioService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	UsuarioDAO objUsuDAO = fabrica.getUsuarioDAO();
 
//	public UsuarioDTO buscaUsuario(String id_usuario) {
//		// TODO Auto-generated method stub
//		return objUsuDAO.buscaUsuario(id_usuario);
//	}

	
	
	 
	
}
