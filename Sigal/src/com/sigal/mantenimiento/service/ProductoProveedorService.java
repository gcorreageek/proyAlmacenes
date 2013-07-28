package com.sigal.mantenimiento.service;

import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.mantenimiento.bean.ProductoProveedorDTO;
import com.sigal.mantenimiento.dao.ProductoProveedorDAO;
import com.sigal.util.Constantes;

public class ProductoProveedorService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	ProductoProveedorDAO objProDAO = fabrica.getProductoProveedorDAO();
	//lista todo
	public List<ProductoProveedorDTO> listaProductoProveedor() throws Exception{
		return objProDAO.buscarProductoProveedor(null);
	} 
	public List<ProductoProveedorDTO> buscarProductosProveedorXRazonSocialAndDescProd(ProductoProveedorDTO productoProveedor)throws Exception {
		return objProDAO.buscarProductoProveedor(productoProveedor);
	}
	//Total
	public Integer listaProductosProveedorTotal() throws Exception {
		return objProDAO.buscarProductoProveedor(null).size();
	}
	public Integer buscarProductosProveedorXRazonSocialAndDescProdTotal(ProductoProveedorDTO productoProveedor ) throws Exception{
		return objProDAO.buscarProductoProveedor(productoProveedor).size();
	}
	//Paginacion
	public List<ProductoProveedorDTO> listaProductosProveedorPaginado(Integer inicio,Integer tamano) throws Exception {
		return objProDAO.buscarProductoProveedorPaginados(null, inicio,tamano);
	} 
	public List<ProductoProveedorDTO> buscarProductosProveedorXRazonSocialAndDescProdPaginado(ProductoProveedorDTO productoProveedor,Integer inicio,Integer tamano) throws Exception{
		return objProDAO.buscarProductoProveedorPaginados(productoProveedor, inicio, tamano);
	}
	
	
	
	public Boolean registrarProductoProveedor(ProductoProveedorDTO objProductoProveedor)throws Exception {
		return objProDAO.registrarProductoProveedor(objProductoProveedor);
	}
	public Boolean actualizarProductoProveedor(ProductoProveedorDTO objProductoProveedor)throws Exception {
		return objProDAO.actualizarProductoProveedor(objProductoProveedor);
	}
	public Boolean eliminarProductoProveedor(ProductoProveedorDTO objProductoProveedor) throws Exception{
		return objProDAO.eliminarProductoProveedor(objProductoProveedor);
	}
	public ProductoProveedorDTO getProductoProveedor(ProductoProveedorDTO productoProveedor)throws Exception {
		return objProDAO.getProductoProveedor(productoProveedor);
	}
	
}
