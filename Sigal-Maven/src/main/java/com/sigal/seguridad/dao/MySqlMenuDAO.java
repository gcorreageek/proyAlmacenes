/**
 * MySqlMenuDAO 31/07/2013
 */
package com.sigal.seguridad.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.seguridad.bean.MenuDTO;
import com.sigal.util.MySqlConexion;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class MySqlMenuDAO implements MenuDAO {
	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();
	 
	@SuppressWarnings("unchecked")
	 
	public List<MenuDTO> listarMenu() throws Exception {
		SqlSession sesion =sqlMapper.openSession();
		List<MenuDTO> lstMenu = new ArrayList<MenuDTO>(); 
		try {
			lstMenu= (List<MenuDTO>)sesion.selectList("menu.SQL_listaMenuConTipo1");
		} finally{
			sesion.close();
		}
		return lstMenu;
	} 
	@SuppressWarnings("unchecked")
	 
	public List<MenuDTO> listarMenuXidSubMenu(Integer idSubMenu)
			throws Exception {
		SqlSession sesion =sqlMapper.openSession();
		List<MenuDTO> lstAcceso = new ArrayList<MenuDTO>(); 
		try {
			lstAcceso= (List<MenuDTO>)sesion.selectList("menu.SQL_listaMenuConTipo2XSubMenu",idSubMenu);
		} finally{
			sesion.close();
		}
		return lstAcceso;
	} 
	 
	public MenuDTO getMenu(Integer idMenu) throws Exception {
		SqlSession sesion =sqlMapper.openSession();
		MenuDTO menu = new MenuDTO(); 
		try {
			menu= (MenuDTO)sesion.selectOne("menu.SQL_getMenu",idMenu);
		} finally{
			sesion.close();
		}
		return menu;
	}

}
