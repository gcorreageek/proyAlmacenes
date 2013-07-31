/**
 * MenuDAO 31/07/2013
 */
package com.sigal.seguridad.dao;

import java.util.List;

import com.sigal.seguridad.bean.MenuDTO;

/**
 * @author Gustavo A. Correa C.
 *
 */
public interface MenuDAO {

	List<MenuDTO> listarMenu() throws Exception;
	List<MenuDTO> listarMenuXidSubMenu(Integer idSubMenu) throws Exception;
	MenuDTO getMenu(Integer idMenu) throws Exception;
}
