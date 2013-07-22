package com.sigal.seguridad.dao;

import java.util.ArrayList;
import java.util.List;

import com.sigal.seguridad.bean.DetallePerfilDTO;
import com.sigal.seguridad.bean.DetalleUsuarioDTO;
import com.sigal.seguridad.bean.MenuDTO;
import com.sigal.seguridad.bean.OpcionesDTO;
import com.sigal.seguridad.bean.OpcionesMenuDTO;
import com.sigal.seguridad.bean.UsuarioDTO;

public interface UsuarioDAO {

	void listadoPrueba();
	
	DetalleUsuarioDTO validarPorUsuario(String id_usuario);
	
	List<OpcionesDTO> obtenerMenuOpciones(String cod_perfil);

	ArrayList<MenuDTO> obtenerMenu(String cod_perfil);

	ArrayList<OpcionesMenuDTO> obtenerOpcMenu(String codigo, String cod_perfil);

	ArrayList<OpcionesMenuDTO> obtenerOpcMenu(DetallePerfilDTO objDetalle);

	void registrarUsuario(UsuarioDTO objUsu);

	ArrayList<DetalleUsuarioDTO> listarUsuariosMante();

	UsuarioDTO buscaUsuario(String id_usuario);

}
