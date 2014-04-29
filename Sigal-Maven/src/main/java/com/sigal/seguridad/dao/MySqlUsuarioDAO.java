package com.sigal.seguridad.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.seguridad.bean.MenuDTO;
import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.util.MySqlConexion;

public class MySqlUsuarioDAO implements UsuarioDAO {
	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();
	
	 
	public UsuarioDTO buscaUsuario(String id_usuario) {
		SqlSession sesion =sqlMapper.openSession();
		UsuarioDTO objUsu = new UsuarioDTO(); 
		try {
			objUsu= (UsuarioDTO)sesion.selectOne("usuario.SQL_getUsuarioLogueo",id_usuario);
		} catch (Exception e) {
		System.out.println(e  +" "+this.getClass().toString()); 
		} finally{
			sesion.close();
		}
		return objUsu;
	} 
	@SuppressWarnings("unchecked")
	 
	public List<MenuDTO> obtenerMenu(Integer codCargo) {
		SqlSession sesion = sqlMapper.openSession();
		List<MenuDTO> listaMenu = new ArrayList<MenuDTO>();
		try {
			listaMenu = (List<MenuDTO>) sesion.selectList("menu.SQL_listaMenuXCargo",codCargo);
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			sesion.close();
		} 
		return listaMenu;
	} 
	
	
	 
	public UsuarioDTO getUsuario(Integer codusuario) throws Exception {
		SqlSession sesion =sqlMapper.openSession();
		UsuarioDTO objUsuario = new UsuarioDTO(); 
		try {
			objUsuario= (UsuarioDTO)sesion.selectOne("usuario.SQL_getUsuario",codusuario);
		} finally{
			sesion.close();
		}
		return objUsuario;
	} 
	@SuppressWarnings("unchecked")
	 
	public List<UsuarioDTO> buscarUsuarioPaginados(UsuarioDTO usuario,
			Integer inicio, Integer tamano) throws Exception {
		SqlSession sesion = sqlMapper.openSession();
		List<UsuarioDTO> lstUsuario = new ArrayList<UsuarioDTO>();
		try {
			if (usuario == null) {
				UsuarioDTO provee = new UsuarioDTO();
				provee.setInicio(inicio);
				provee.setTamano(tamano);
				lstUsuario = (List<UsuarioDTO>) sesion.selectList(
						"usuario.SQL_listaUsuarioPaginados", provee);
			} else {
				if (!usuario.getNom_usuario().isEmpty()) {
					usuario.setNom_usuario("%" + usuario.getNom_usuario()+ "%");
					usuario.setInicio(inicio);
					usuario.setTamano(tamano);
					lstUsuario = (List<UsuarioDTO>) sesion.selectList(
							"usuario.SQL_listaUsuarioNom_usuarioPaginados",
							usuario);
				}
			}
		}  finally {
			sesion.close();
		}
		return lstUsuario;
	} 
	@SuppressWarnings("unchecked")
	 
	public List<UsuarioDTO> buscarUsuario(UsuarioDTO usuario) throws Exception {
		SqlSession sesion = sqlMapper.openSession();
		List<UsuarioDTO> lstUsuario= new ArrayList<UsuarioDTO>();
		try {
			if (usuario == null) {
				lstUsuario = (List<UsuarioDTO>) sesion.selectList("usuario.SQL_listaUsuario");
			} else {
				if (!usuario.getNom_usuario().isEmpty()) {
					lstUsuario = (List<UsuarioDTO>) sesion.selectList( 
							"usuario.SQL_listaNom_usuario", "%"
									+ usuario.getNom_usuario() + "%");
				}
			}
		} finally {
			sesion.close();
		}
		return lstUsuario;
	} 
	 
	public Object registrarUsuario(UsuarioDTO objUsuario) throws Exception {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.insert("usuario.SQL_registraUsuario", objUsuario);
			session.commit();
			result = true;
		}  finally {
			session.close();
		}
		return result;
	} 
	 
	public Object actualizarUsuario(UsuarioDTO objUsuario) throws Exception {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			System.out.println("1:"+objUsuario.getCod_usuario());
			System.out.println("2:"+objUsuario.getHabilitado());
			System.out.println("3:"+objUsuario.getUsu_usuario());
			session.update("usuario.SQL_updateUsuario", objUsuario);
			session.commit();
			result = true;
		} finally {
			session.close();
		}
		return result;
	} 
	 
	public Object eliminarUsuario(UsuarioDTO objUsuario) throws Exception {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.delete("usuario.SQL_deleteUsuario", objUsuario.getCod_usuario());
			session.commit();
			result = true;
		} finally {
			session.close();
		}
		return result;
	} 
 

}
