package com.sigal.mantenimiento.dao;

import java.util.List;

import com.sigal.mantenimiento.bean.ProductoDTO;

public interface ProductoDAO {
	ProductoDTO getProducto(ProductoDTO producto)throws Exception ;
	List<ProductoDTO> buscarProductosPaginados(ProductoDTO producto,Integer inicio,Integer tamano) throws Exception ;
	List<ProductoDTO> buscarProductos(ProductoDTO producto) throws Exception ; 
	List<ProductoDTO> buscarProductosIdProveePaginados(ProductoDTO producto,Integer idProvee,Integer inicio,Integer tamano) throws Exception ;
	List<ProductoDTO> buscarProductosIdProvee(ProductoDTO producto, Integer idProvee) throws Exception ;
	Boolean registrarProducto(ProductoDTO objProducto) throws Exception;
	Boolean actualizarProducto(ProductoDTO objProducto) throws Exception;
	Boolean eliminarProducto(ProductoDTO objProducto) throws Exception;
	
	List<ProductoDTO> buscarHabilitadosProductosPaginados(ProductoDTO producto,Integer inicio,Integer tamano) throws Exception ;
	List<ProductoDTO> buscarHabilitadosProductos(ProductoDTO producto) throws Exception ;
 
	List<ProductoDTO> buscarHabilitadosProductosIdProveePaginados( Object object, Integer idProve, Integer comienzo, Integer filasXPagina)throws Exception ;
	List<ProductoDTO> buscarHabilitadosProductosIdProvee(Object object, Integer idProve)throws Exception ;

}
