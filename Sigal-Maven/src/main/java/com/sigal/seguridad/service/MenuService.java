package com.sigal.seguridad.service;

import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.seguridad.bean.MenuDTO;
import com.sigal.seguridad.dao.MenuDAO;
import com.sigal.util.Constantes;

public class MenuService {
	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	MenuDAO objMenuDAO = fabrica.getMenuDAO(); 
	
	public List<MenuDTO>  listaMenu1() throws Exception {
		return objMenuDAO.listarMenu();
	}  
	public List<MenuDTO>  listaMenu2(Integer idSubMenu) throws Exception {
		return objMenuDAO.listarMenuXidSubMenu(idSubMenu);
	} 
	public MenuDTO  getMenu(Integer idMenu) throws Exception {
		return objMenuDAO.getMenu(idMenu);
	} 
	 
}
