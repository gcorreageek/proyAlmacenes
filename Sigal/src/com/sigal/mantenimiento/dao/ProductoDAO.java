package com.sigal.mantenimiento.dao;

import java.util.List;

import com.sigal.mantenimiento.bean.ProductoDTO;

public interface ProductoDAO {
	ProductoDTO getProducto(ProductoDTO producto);
	List<ProductoDTO> buscarProductosPaginados(ProductoDTO producto,Integer inicio,Integer tamano);
	List<ProductoDTO> buscarProductos(ProductoDTO producto); 
	List<ProductoDTO> buscarProductosIdProveePaginados(ProductoDTO producto,Integer idProvee,Integer inicio,Integer tamano);
	List<ProductoDTO> buscarProductosIdProvee(ProductoDTO producto, Integer idProvee);
	Boolean registrarProducto(ProductoDTO objProducto);
	Boolean actualizarProducto(ProductoDTO objProducto);
	Boolean eliminarProducto(ProductoDTO objProducto);

}
