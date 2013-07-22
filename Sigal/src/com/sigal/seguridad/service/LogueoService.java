package com.sigal.seguridad.service;

import java.util.ArrayList;
import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.seguridad.bean.DetallePerfilDTO;
import com.sigal.seguridad.bean.DetalleUsuarioDTO;
import com.sigal.seguridad.bean.MenuDTO;
import com.sigal.seguridad.bean.OpcionesDTO;
import com.sigal.seguridad.bean.OpcionesMenuDTO;
import com.sigal.seguridad.dao.UsuarioDAO;
import com.sigal.util.Constantes;

public class LogueoService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	UsuarioDAO objUsuDAO = fabrica.getUsuarioDAO();
	public void listadoPrueba() {
		objUsuDAO.listadoPrueba();
	}
	public DetalleUsuarioDTO validarPorUsuario(String id_usuario) {
		// TODO Auto-generated method stub
		return objUsuDAO.validarPorUsuario(id_usuario);
	}
	public ArrayList<MenuDTO> obtenerMenu(String cod_perfil) {
		// TODO Auto-generated method stub
		return objUsuDAO.obtenerMenu(cod_perfil);
	}
	public ArrayList<OpcionesMenuDTO> obtenerOpcMenu(String codigo, String cod_perfil) {
		// TODO Auto-generated method stub
		return objUsuDAO.obtenerOpcMenu(codigo,cod_perfil);
	}
	public ArrayList<OpcionesMenuDTO> obtenerOpcMenu(DetallePerfilDTO objDetalle) {
		// TODO Auto-generated method stub
		return objUsuDAO.obtenerOpcMenu(objDetalle);
	}
	
	public List<OpcionesDTO> obtenerListadoMenu(String codPerfil) {
		return objUsuDAO.obtenerMenuOpciones(codPerfil);
	}
	
	
}
