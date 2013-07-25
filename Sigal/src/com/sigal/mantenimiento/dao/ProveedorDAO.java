/**
 * ProveedorDAO 24/07/2013
 */
package com.sigal.mantenimiento.dao;

import java.util.List;

import com.sigal.mantenimiento.bean.ProveedorDTO;

/**
 * @author Gustavo A. Correa C.
 *
 */
public interface ProveedorDAO {
	ProveedorDTO getProveedor(ProveedorDTO proveedor) throws Exception;
	List<ProveedorDTO> buscarProveedorPaginados(ProveedorDTO proveedor,Integer inicio,Integer tamano) throws Exception;
	List<ProveedorDTO> buscarProveedor(ProveedorDTO proveedor) throws Exception; 
	Boolean registrarProveedor(ProveedorDTO objProveedor) throws Exception;
	Boolean actualizarProveedor(ProveedorDTO objProveedor) throws Exception;
	Boolean eliminarProveedor(ProveedorDTO objProveedor) throws Exception;
	
	
}
