package com.sigal.seguridad.dao;

import java.util.List;

import com.sigal.seguridad.bean.MenuDTO;
import com.sigal.seguridad.bean.UsuarioDTO;

public interface UsuarioDAO { 

	List<MenuDTO> obtenerMenu(Integer codCargo);
 

	UsuarioDTO buscaUsuario(String usuario);

}
