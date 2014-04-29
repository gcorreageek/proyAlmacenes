package com.sigal.seguridad.service;

import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.seguridad.dao.UsuarioDAO;
import com.sigal.util.Constantes;

public class UsuarioService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	UsuarioDAO objUsuarioDAO = fabrica.getUsuarioDAO();
 
	public UsuarioDTO  getUsuario(Integer cod) throws Exception { 
		return objUsuarioDAO.getUsuario(cod);
	}
	
	
	
	public List<UsuarioDTO> listaUsuarioPaginado(Integer inicio,Integer tamano)throws Exception  {
		return objUsuarioDAO.buscarUsuarioPaginados(null, inicio,tamano);
	} 
	public List<UsuarioDTO> buscarUsuarioXDescPaginado(UsuarioDTO usuario,Integer inicio,Integer tamano)throws Exception  {
		return objUsuarioDAO.buscarUsuarioPaginados(usuario, inicio, tamano);
	}
	public Integer listaUsuarioTotal()throws Exception  {
		return objUsuarioDAO.buscarUsuario(null).size();
	}
	public Integer buscarUsuarioXDescTotal(UsuarioDTO usuario ) throws Exception {
		return objUsuarioDAO.buscarUsuario(usuario).size();
	}
	
	
	
	
	
	
	
	public Boolean registrarUsuario(UsuarioDTO objUsuario) throws Exception {
		return (Boolean) objUsuarioDAO.registrarUsuario(objUsuario);
	} 
	public Boolean actualizarUsuario(UsuarioDTO objUsuario) throws Exception {
		return (Boolean) objUsuarioDAO.actualizarUsuario(objUsuario);
	}
	public Boolean eliminarUsuario(UsuarioDTO objUsuario) throws Exception {
		return (Boolean) objUsuarioDAO.eliminarUsuario(objUsuario);
	}

	
	
	 
	
}
