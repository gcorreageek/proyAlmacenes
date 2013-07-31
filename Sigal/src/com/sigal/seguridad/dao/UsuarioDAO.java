package com.sigal.seguridad.dao;

import java.util.List;

import com.sigal.seguridad.bean.MenuDTO;
import com.sigal.seguridad.bean.UsuarioDTO;

public interface UsuarioDAO { 

	List<MenuDTO> obtenerMenu(Integer codCargo); 
	UsuarioDTO buscaUsuario(String usuario);
	
	UsuarioDTO getUsuario(Integer codusuario) throws Exception; 
	
	List<UsuarioDTO> buscarUsuarioPaginados(UsuarioDTO usuario,Integer inicio,Integer tamano) throws Exception;
	List<UsuarioDTO> buscarUsuario(UsuarioDTO usuario) throws Exception; 
	
	Object registrarUsuario(UsuarioDTO objUsuario) throws Exception;
	Object actualizarUsuario(UsuarioDTO objUsuario) throws Exception;
	Object eliminarUsuario(UsuarioDTO objUsuario) throws Exception;
	
	
	
	
	

}
