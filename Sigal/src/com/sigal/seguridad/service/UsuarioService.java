package com.sigal.seguridad.service;

import java.util.ArrayList;

import com.sigal.dao.DAOFactory;
import com.sigal.seguridad.bean.DetalleUsuarioDTO;
import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.seguridad.dao.UsuarioDAO;
import com.sigal.util.Constantes;

public class UsuarioService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	UsuarioDAO objUsuDAO = fabrica.getUsuarioDAO();
	public void registrarUsuario(UsuarioDTO objUsu) {
		objUsuDAO.registrarUsuario(objUsu);
	}
	public ArrayList<DetalleUsuarioDTO> listarUsuariosMante() {
		// TODO Auto-generated method stub
		return objUsuDAO.listarUsuariosMante();
	}
	public UsuarioDTO buscaUsuario(String id_usuario) {
		// TODO Auto-generated method stub
		return objUsuDAO.buscaUsuario(id_usuario);
	}

	
	
	 
	
}
