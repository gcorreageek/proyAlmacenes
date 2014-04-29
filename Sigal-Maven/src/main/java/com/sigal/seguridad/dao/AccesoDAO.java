/**
 * AccesoDAO 31/07/2013
 */
package com.sigal.seguridad.dao;

import java.util.List;

import com.sigal.seguridad.bean.AccesoMenuDTO;

/**
 * @author Gustavo A. Correa C.
 *
 */
public interface AccesoDAO {

	Object registrar(AccesoMenuDTO acceso) throws Exception;
	Object actualizarEstado(AccesoMenuDTO acceso) throws Exception;
	List<AccesoMenuDTO> listarMenuAccesoXidCargo(Integer idCargo) throws Exception;
	AccesoMenuDTO getAcceso(Integer idAcceso) throws Exception;
	AccesoMenuDTO getAccesoXIdMenu(Integer idMenu) throws Exception;
	AccesoMenuDTO getAccesoXIdMenuIdCargo(Integer idMenu,Integer IdCargo) throws Exception;
//	SQL_getAccesoXIdCargoIdMenu
	
}
