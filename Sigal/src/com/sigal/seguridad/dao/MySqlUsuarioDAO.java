package com.sigal.seguridad.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.seguridad.bean.MenuDTO;
import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.util.MySqlConexion;

public class MySqlUsuarioDAO implements UsuarioDAO {
 
	 
	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();
	
 

	@Override
	public UsuarioDTO buscaUsuario(String id_usuario) {
		SqlSession sesion =sqlMapper.openSession();
		UsuarioDTO objUsu = new UsuarioDTO(); 
		try {
			objUsu= (UsuarioDTO)sesion.selectOne("usuario.SQL_getUsuario",id_usuario);
		} catch (Exception e) {
		System.out.println(e  +" "+this.getClass().toString()); 
		}
		finally{
			sesion.close();
		}
		return objUsu;
	}
 

 
	@Override
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

}
