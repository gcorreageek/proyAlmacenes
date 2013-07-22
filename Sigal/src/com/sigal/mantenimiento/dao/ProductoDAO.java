package com.sigal.mantenimiento.dao;

import java.util.ArrayList;

import com.sigal.mantenimiento.bean.ProductoDTO;

public interface ProductoDAO {

	ArrayList<ProductoDTO> listaProductos();

	void registrarProducto(ProductoDTO objProducto);

}
