/**
 * ProductoProveedorDAO 24/07/2013
 */
package com.sigal.mantenimiento.dao;

import java.util.List;

import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.mantenimiento.bean.ProductoProveedorDTO;

/**
 * @author Gustavo A. Correa C.
 *
 */
public interface ProductoProveedorDAO {
	ProductoProveedorDTO getProductoProveedor(ProductoProveedorDTO productoProveedor) throws Exception;
	ProductoProveedorDTO getProductoProveedorXIdProdAndIdProvee(ProductoProveedorDTO productoProveedor) throws Exception;
	List<ProductoProveedorDTO> buscarProductoProveedorPaginados(ProductoProveedorDTO productoProveedor,Integer inicio,Integer tamano) throws Exception;
	List<ProductoProveedorDTO> buscarProductoProveedor(ProductoProveedorDTO productoProveedor) throws Exception;
	
	Boolean registrarProductoProveedor(ProductoProveedorDTO objProductoProvedor) throws Exception;
	Boolean actualizarProductoProveedor(ProductoProveedorDTO objProductoProvedor) throws Exception;
	Boolean eliminarProductoProveedor(ProductoProveedorDTO objProductoProvedor) throws Exception;

}
