package com.sigal.mantenimiento.service;

import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.mantenimiento.dao.ProductoDAO;
import com.sigal.util.Constantes;

public class ProductoService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	ProductoDAO objProDAO = fabrica.getProductoDAO();
	public List<ProductoDTO> listaProductos() {
		return objProDAO.buscarProductos(null);
	}
	public List<ProductoDTO> buscarProductosXDesc(ProductoDTO producto) {
		return objProDAO.buscarProductos(producto);
	}
	
	
	public List<ProductoDTO> listaProductosPaginado(Integer inicio,Integer tamano) {
		return objProDAO.buscarProductosPaginados(null, inicio,tamano);
	}
	public Integer listaProductosTotal() {
		return objProDAO.buscarProductos(null).size();
	}
	public List<ProductoDTO> buscarProductosXDescPaginado(ProductoDTO producto,Integer inicio,Integer tamano) {
		return objProDAO.buscarProductosPaginados(producto, inicio, tamano);
	}
	public Integer buscarProductosXDescTotal(ProductoDTO producto ) {
		return objProDAO.buscarProductos(producto).size();
	}
	public Boolean registrarProducto(ProductoDTO objProducto) {
		return objProDAO.registrarProducto(objProducto);
	}
	public ProductoDTO getProducto(ProductoDTO producto) {
		return objProDAO.getProducto(producto);
	}
	public Boolean actualizarProducto(ProductoDTO objProducto) {
		return objProDAO.actualizarProducto(objProducto);
	}
	public Boolean eliminarProducto(ProductoDTO objProducto) {
		return objProDAO.eliminarProducto(objProducto);
	}
	
}
