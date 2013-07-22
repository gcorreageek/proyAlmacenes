package com.sigal.mantenimiento.service;

import java.util.ArrayList;

import com.sigal.dao.DAOFactory;
import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.mantenimiento.dao.ProductoDAO;
import com.sigal.util.Constantes;

public class ProductoService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGENDATOS);
	ProductoDAO objProDAO = fabrica.getProductoDAO();
	public ArrayList<ProductoDTO> listaProductos() {
		// TODO Auto-generated method stub
		return objProDAO.listaProductos();
	}
	public void registrarProducto(ProductoDTO objProducto) {
		objProDAO.registrarProducto(objProducto);
		
	}
	
	
}
