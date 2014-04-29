package com.sigal.seguridad.service;

import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.seguridad.bean.MenuDTO;
import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.seguridad.dao.UsuarioDAO;
import com.sigal.util.Constantes;

public class LogueoService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	UsuarioDAO objUsuDAO = fabrica.getUsuarioDAO();
 
	public UsuarioDTO obtieneXusuario(String id_usuario) {
		return objUsuDAO.buscaUsuario(id_usuario);
	}
	public List<MenuDTO> obtenerMenuXcodPerfil(Integer codPerfil) {
		return objUsuDAO.obtenerMenu(codPerfil);
	}
	
	
}
