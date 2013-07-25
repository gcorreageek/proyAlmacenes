package com.sigal.dao;

import com.sigal.mantenimiento.dao.CategoriaDAO;
import com.sigal.mantenimiento.dao.ProductoDAO;
import com.sigal.mantenimiento.dao.ProductoProveedorDAO;
import com.sigal.mantenimiento.dao.ProveedorDAO;
import com.sigal.mantenimiento.dao.UmedidaDAO;
import com.sigal.pedido.dao.SolicitudPedidoDAO;
import com.sigal.seguridad.dao.AreaDAO;
import com.sigal.seguridad.dao.CargoDAO;
import com.sigal.seguridad.dao.UsuarioDAO;



public abstract class DAOFactory {
	public static final int MYSQL=1;
	public static final int ORACLE=2;
	
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract CargoDAO getCargoDAO();
	public abstract AreaDAO getAreaDAO();
	//pedido
	public abstract SolicitudPedidoDAO getSolicitudPedidoDAO();
	//producto
	public abstract ProductoDAO getProductoDAO();
	public abstract CategoriaDAO getCategoriaDAO();
	public abstract UmedidaDAO getUmedidaDAO();
	public abstract ProveedorDAO getProveedorDAO();
	public abstract ProductoProveedorDAO getProductoProveedorDAO();
	 
	
	
	public static DAOFactory getDAOFactory(int wichFactory){
		
		switch (wichFactory) {
		
		case MYSQL:
			return new MySqlDAOFactory();
		case ORACLE:
			//return new MySqlDAOFactory();
		default:
			return null;
		}

	}
    
    
}
