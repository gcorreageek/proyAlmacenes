package com.sigal.mantenimiento.service;

import java.util.List;

import com.sigal.dao.DAOFactory;
import com.sigal.mantenimiento.bean.ProductoProveedorDTO;
import com.sigal.mantenimiento.dao.ProductoProveedorDAO;
import com.sigal.util.Constantes;

public class ProductoProveedorService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	ProductoProveedorDAO objProDAO = fabrica.getProductoProveedorDAO();
	
	public List<ProductoProveedorDTO> listaProductoProveedor() throws Exception{
		return objProDAO.buscarProductoProveedor(null);
	}
	public List<ProductoProveedorDTO> buscarProductosProveedorXRazonSocialAndDescProd(ProductoProveedorDTO productoProveedor)throws Exception {
		return objProDAO.buscarProductoProveedor(productoProveedor);
	}
	public List<ProductoProveedorDTO> listaProductosProveedorPaginado(Integer inicio,Integer tamano) throws Exception {
		return objProDAO.buscarProductoProveedorPaginados(null, inicio,tamano);
	}
	public Integer listaProductosProveedorTotal() throws Exception {
		return objProDAO.buscarProductoProveedor(null).size();
	}
	public List<ProductoProveedorDTO> buscarProductosProveedorXRazonSocialAndDescProdPaginado(ProductoProveedorDTO productoProveedor,Integer inicio,Integer tamano) throws Exception{
		return objProDAO.buscarProductoProveedorPaginados(productoProveedor, inicio, tamano);
	}
	public Integer buscarProductosProveedorXRazonSocialAndDescProdTotal(ProductoProveedorDTO productoProveedor ) throws Exception{
		return objProDAO.buscarProductoProveedor(productoProveedor).size();
	}
	public Boolean registrarProductoProveedor(ProductoProveedorDTO objProductoProveedor)throws Exception {
		return objProDAO.registrarProductoProveedor(objProductoProveedor);
	}
	public ProductoProveedorDTO getProductoProveedor(ProductoProveedorDTO productoProveedor)throws Exception {
		return objProDAO.getProductoProveedor(productoProveedor);
	}
	public Boolean actualizarProductoProveedor(ProductoProveedorDTO objProductoProveedor)throws Exception {
		return objProDAO.actualizarProductoProveedor(objProductoProveedor);
	}
	public Boolean eliminarProductoProveedor(ProductoProveedorDTO objProductoProveedor) throws Exception{
		return objProDAO.eliminarProductoProveedor(objProductoProveedor);
	}
	
}
