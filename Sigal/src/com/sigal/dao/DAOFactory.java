package com.sigal.dao;

import com.sigal.cotizacion.dao.CotizacionDAO;
import com.sigal.cotizacion.dao.CotizacionDetalleDAO;
import com.sigal.mantenimiento.dao.CategoriaDAO;
import com.sigal.mantenimiento.dao.ProductoDAO;
import com.sigal.mantenimiento.dao.ProductoProveedorDAO;
import com.sigal.mantenimiento.dao.ProveedorDAO;
import com.sigal.mantenimiento.dao.UmedidaDAO;
import com.sigal.ordencompra.dao.OrdenCompraDAO;
import com.sigal.ordencompra.dao.OrdenCompraDetalleDAO;
import com.sigal.pedido.dao.PedidoDetalleDAO;
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
	
	//producto
	public abstract ProductoDAO getProductoDAO();
	public abstract CategoriaDAO getCategoriaDAO();
	public abstract UmedidaDAO getUmedidaDAO();
	public abstract ProveedorDAO getProveedorDAO();
	public abstract ProductoProveedorDAO getProductoProveedorDAO();
	//pedido
	public abstract SolicitudPedidoDAO getSolicitudPedidoDAO();
	public abstract PedidoDetalleDAO getPedidoDetalleDAO();
	//cotizacion
	public abstract CotizacionDAO getCotizacionDAO();
	public abstract CotizacionDetalleDAO getCotizacionDetalleDAO();
	//oc
	public abstract OrdenCompraDAO getOrdenCompraDAO();
	public abstract OrdenCompraDetalleDAO getOrdenCompraDetalleDAO();
	
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
