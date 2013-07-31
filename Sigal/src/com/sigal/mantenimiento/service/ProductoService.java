package com.sigal.mantenimiento.service;

import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.mantenimiento.dao.ProductoDAO;
import com.sigal.util.Constantes;

public class ProductoService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	ProductoDAO objProDAO = fabrica.getProductoDAO();
	
	
	public List<ProductoDTO> buscarProductosXDesc(ProductoDTO producto) {
		return objProDAO.buscarProductos(producto);
	} 
	public List<ProductoDTO> listaProductos() {
		return objProDAO.buscarProductos(null);
	}
	//Modal
	public List<ProductoDTO> buscarProductosXDescPaginado(ProductoDTO producto,Integer inicio,Integer tamano) {
		return objProDAO.buscarProductosPaginados(producto, inicio, tamano);//Se cambio
	}
	public List<ProductoDTO> listaProductosPaginado(Integer inicio,Integer tamano) {
		return objProDAO.buscarProductosPaginados(null, inicio,tamano);//se cambio
	}
	public Integer buscarProductosXDescTotal(ProductoDTO producto ) {
		return objProDAO.buscarProductos(producto).size();
	}
	public Integer listaProductosTotal() {
		return objProDAO.buscarProductos(null).size();
	}
	//Modal idProvee
	public List<ProductoDTO> buscarProductosIdProveeXDescPaginado(ProductoDTO producto,Integer idProvee,Integer inicio,Integer tamano) {
		return objProDAO.buscarProductosIdProveePaginados(producto,idProvee, inicio, tamano);
	}
	public List<ProductoDTO> listaProductosIdProveePaginado(Integer idProvee,Integer inicio,Integer tamano) {
		return objProDAO.buscarProductosIdProveePaginados(null,idProvee, inicio,tamano);
	}
	public Integer buscarProductosIdProveeXDescTotal(ProductoDTO producto,Integer idProvee) {
		return objProDAO.buscarProductosIdProvee(producto,idProvee).size();
	}
	public Integer listaProductosIdProveeTotal(Integer idProvee) {
		return objProDAO.buscarProductosIdProvee(null,idProvee).size();
	}
	//------------------------------------
	
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
	
	public List<ProductoDTO> listaProductosPaginadoHabilitados(
			Integer comienzo, Integer filasXPagina) {
		return objProDAO.buscarHabilitadosProductosPaginados(null, comienzo,filasXPagina);//se cambio
	} 
	public List<ProductoDTO> buscarProductosXDescPaginadoHabilitados(
			ProductoDTO objProducto, Integer comienzo, Integer filasXPagina) {
		return objProDAO.buscarHabilitadosProductosPaginados(objProducto, comienzo, filasXPagina);//Se cambio
	} 
	public Integer listaProductosTotalHabilitados() {
		return objProDAO.buscarHabilitadosProductos(null).size();
	} 
	public Integer buscarProductosXDescTotalHabilitados(ProductoDTO objProducto) {
		return objProDAO.buscarHabilitadosProductos(objProducto).size();
	} 
	public List<ProductoDTO> listaProductosIdProveePaginadoHabilitados(
			Integer idProve, Integer comienzo, Integer filasXPagina) {
		return objProDAO.buscarHabilitadosProductosIdProveePaginados(null,idProve, comienzo,filasXPagina);
	} 
	public List<ProductoDTO> buscarProductosIdProveeXDescPaginadoHabilitados(
			ProductoDTO objProducto, Integer idProve, Integer comienzo,
			Integer filasXPagina) {
		return objProDAO.buscarHabilitadosProductosIdProveePaginados(objProducto,idProve, comienzo, filasXPagina);
	} 
	public Integer listaProductosIdProveeTotalHabilitados(Integer idProve) {
		return objProDAO.buscarHabilitadosProductosIdProvee(null,idProve).size();
	} 
	public Integer buscarProductosIdProveeXDescTotalHabilitados(
			ProductoDTO objProducto, Integer idProve) {
		return objProDAO.buscarHabilitadosProductosIdProvee(objProducto,idProve).size();
	}
	
}
