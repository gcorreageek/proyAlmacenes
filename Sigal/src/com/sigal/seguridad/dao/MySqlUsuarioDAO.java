package com.sigal.seguridad.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.seguridad.bean.DetallePerfilDTO;
import com.sigal.seguridad.bean.DetalleUsuarioDTO;
import com.sigal.seguridad.bean.MenuDTO;
import com.sigal.seguridad.bean.OpcionesDTO;
import com.sigal.seguridad.bean.OpcionesMenuDTO;
import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.util.MySqlConexion;

public class MySqlUsuarioDAO implements UsuarioDAO {
 
	 
	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();
	
	
	public void listadoPrueba() {
	
		SqlSession sesion = sqlMapper.openSession();
		
		UsuarioDTO objUsu = new UsuarioDTO();
		try {
			objUsu=  (UsuarioDTO) sesion.selectOne("usuario.SQL_listaUsuarios");
			
			System.out.println(objUsu.getNom_usuario());
	
		} catch (Exception e) {
		System.out.println(e);
		}
		finally{
			sesion.close();
		}
		
		
	}

	@Override
	public DetalleUsuarioDTO validarPorUsuario(String id_usuario) {
		
		SqlSession sesion = sqlMapper.openSession();
		DetalleUsuarioDTO objusu=null;
		try {
			objusu =(DetalleUsuarioDTO) sesion.selectOne("usuario.SQL_buscaUsuario", id_usuario);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return objusu;
	}

	@Override
	public ArrayList<MenuDTO> obtenerMenu( String cod_perfil ) {
		
		SqlSession sesion = sqlMapper.openSession();
		ArrayList<MenuDTO> listaMenu = new ArrayList<MenuDTO>();
		
		
		try {
			listaMenu = (ArrayList<MenuDTO>) sesion.selectList("menu.SQL_listaMenu",cod_perfil);
		} catch (Exception e) {
			System.out.println(e);
		}
		finally{
			sesion.close();
		}
		
		return listaMenu;
	}

	@Override
	public ArrayList<OpcionesMenuDTO> obtenerOpcMenu(String codigo, String cod_perfil) {
		SqlSession sesion = sqlMapper.openSession();
		ArrayList<OpcionesMenuDTO> listaOp = new ArrayList<OpcionesMenuDTO>();
		try {
			listaOp = (ArrayList<OpcionesMenuDTO>) sesion.selectList("menu.SQL_listaMenuOpc",codigo);
			 
		} catch (Exception e) {
			System.out.println(e);
		}
		finally{
			sesion.close();
		}
		return listaOp;
	}

	@Override
	public ArrayList<OpcionesMenuDTO> obtenerOpcMenu(DetallePerfilDTO objDetalle) {
		SqlSession sesion = sqlMapper.openSession();
		ArrayList<OpcionesMenuDTO> listaOp = new ArrayList<OpcionesMenuDTO>();
		try {
			listaOp = (ArrayList<OpcionesMenuDTO>) sesion.selectList("menu.SQL_listaMenuOpc1",objDetalle);
			 for (OpcionesMenuDTO a :listaOp){
				 System.out.println("Opcion Menu"+a.getDesc_OpcionesMenu());;
			 }
		} catch (Exception e) {
			sesion.rollback();
			sesion.close();
			System.out.println(e);
		}
		finally{
			sesion.close();
		}
		return listaOp;
	}

	@Override
	public void registrarUsuario(UsuarioDTO objUsu) {
			
		SqlSession sesion = sqlMapper.openSession(); 
		
		try {
			
			sesion.insert("usuario.SQL_registraUsuario",objUsu);
			sesion.commit();
			
		} catch ( Exception e) { 	
			System.out.println(e.getMessage());
			sesion.rollback();
			sesion.close();
			
		} 
		finally{
			sesion.close();
		}
		
		
		
	}

	@Override
	public ArrayList<DetalleUsuarioDTO> listarUsuariosMante() {
		SqlSession  session= sqlMapper.openSession();
		ArrayList<DetalleUsuarioDTO> lstDetUsuario = new ArrayList<DetalleUsuarioDTO>();
		try {
			lstDetUsuario=(ArrayList<DetalleUsuarioDTO>) session.selectList("usuario.SQL_listaDetUsuarios");	
		} catch (Exception e) {
				System.out.println(e+this.getClass().toString());
				session.close();
		}
		finally{
			session.close();
		}
		
		
		return lstDetUsuario;
	} 

	@Override
	public UsuarioDTO buscaUsuario(String id_usuario) {
		SqlSession sesion =sqlMapper.openSession();
		UsuarioDTO objUsu = new UsuarioDTO(); 
		try {
			objUsu= (UsuarioDTO)sesion.selectOne("usuario.SQL_buscaUsuarioM",id_usuario);
		} catch (Exception e) {
		System.out.println(e  +" "+this.getClass().toString());
		sesion.close();
		}
		finally{
			sesion.close();
		}
		return objUsu;
	}

	 
	@Override
	public List<OpcionesDTO> obtenerMenuOpciones(String cod_perfil) {
		SqlSession sesion = sqlMapper.openSession();
		List<OpcionesDTO> listaMenu = new ArrayList<OpcionesDTO>();
		
		
		try {
			listaMenu = (ArrayList<OpcionesDTO>) sesion.selectList("opcion.SQL_listaOpcionesXidPerfil",cod_perfil);
		} catch (Exception e) {
			System.out.println(e);
		}
		finally{
			sesion.close();
		}
		
		return listaMenu;
	}

}
