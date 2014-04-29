package com.sigal.dao;

import com.sigal.cotizacion.dao.CotizacionDAO;
import com.sigal.cotizacion.dao.CotizacionDetalleDAO;
import com.sigal.cotizacion.dao.MySqlCotizacionDAO;
import com.sigal.cotizacion.dao.MySqlCotizacionDetalleDAO;
import com.sigal.informeexterno.dao.InformeExternoDAO;
import com.sigal.informeexterno.dao.InformeExternoDetalleDAO;
import com.sigal.informeexterno.dao.MySqlInformeExternoDAO;
import com.sigal.informeexterno.dao.MySqlInformeExternoDetalleDAO;
import com.sigal.informeinterno.dao.InformeInternoDAO;
import com.sigal.informeinterno.dao.InformeInternoDetalleDAO;
import com.sigal.informeinterno.dao.MySqlInformeInternoDAO;
import com.sigal.informeinterno.dao.MySqlInformeInternoDetalleDAO;
import com.sigal.mantenimiento.dao.CategoriaDAO;
import com.sigal.mantenimiento.dao.MySqlCategoriaDAO;
import com.sigal.mantenimiento.dao.MySqlProductoDAO;
import com.sigal.mantenimiento.dao.MySqlProductoProveedorDAO;
import com.sigal.mantenimiento.dao.MySqlProveedorDAO;
import com.sigal.mantenimiento.dao.MySqlUmedidaDAO;
import com.sigal.mantenimiento.dao.ProductoDAO;
import com.sigal.mantenimiento.dao.ProductoProveedorDAO;
import com.sigal.mantenimiento.dao.ProveedorDAO;
import com.sigal.mantenimiento.dao.UmedidaDAO;
import com.sigal.ordencompra.dao.MySqlOrdenCompraDAO;
import com.sigal.ordencompra.dao.MySqlOrdenCompraDetalleDAO;
import com.sigal.ordencompra.dao.OrdenCompraDAO;
import com.sigal.ordencompra.dao.OrdenCompraDetalleDAO;
import com.sigal.pedido.dao.MySqlPedidoDetalleDAO;
import com.sigal.pedido.dao.MySqlSolicitudPedidoDAO;
import com.sigal.pedido.dao.PedidoDetalleDAO;
import com.sigal.pedido.dao.SolicitudPedidoDAO;
import com.sigal.seguridad.dao.AccesoDAO;
import com.sigal.seguridad.dao.AreaDAO;
import com.sigal.seguridad.dao.CargoDAO;
import com.sigal.seguridad.dao.MenuDAO;
import com.sigal.seguridad.dao.MySqlAccesoDAO;
import com.sigal.seguridad.dao.MySqlAreaDAO;
import com.sigal.seguridad.dao.MySqlCargoDAO;
import com.sigal.seguridad.dao.MySqlMenuDAO;
import com.sigal.seguridad.dao.MySqlUsuarioDAO;
import com.sigal.seguridad.dao.UsuarioDAO;


public class MySqlDAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

	@Override
	public SolicitudPedidoDAO getSolicitudPedidoDAO() {
		// TODO Auto-generated method stub
		return new MySqlSolicitudPedidoDAO();
	}

	@Override
	public ProductoDAO getProductoDAO() {
		// TODO Auto-generated method stub
		return new MySqlProductoDAO();
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return new MySqlCategoriaDAO();
	}

	@Override
	public UmedidaDAO getUmedidaDAO() {
		// TODO Auto-generated method stub
		return new MySqlUmedidaDAO();
	}

	@Override
	public CargoDAO getCargoDAO() {
		return new MySqlCargoDAO();
	}
 
	@Override
	public AreaDAO getAreaDAO() {
		return new MySqlAreaDAO();
	} 
	@Override
	public ProveedorDAO getProveedorDAO() {
		return new MySqlProveedorDAO();
	}
 
	@Override
	public ProductoProveedorDAO getProductoProveedorDAO() {
		return new MySqlProductoProveedorDAO();
	} 
	@Override
	public PedidoDetalleDAO getPedidoDetalleDAO() {
		return new MySqlPedidoDetalleDAO();
	}
 
	@Override
	public CotizacionDAO getCotizacionDAO() {
		return new MySqlCotizacionDAO();
	}
 
	@Override
	public CotizacionDetalleDAO getCotizacionDetalleDAO() {
		return new MySqlCotizacionDetalleDAO();
	} 
	@Override
	public OrdenCompraDAO getOrdenCompraDAO() {
		return new MySqlOrdenCompraDAO();
	} 
	@Override
	public OrdenCompraDetalleDAO getOrdenCompraDetalleDAO() {
		return new MySqlOrdenCompraDetalleDAO();
	} 
	@Override
	public InformeInternoDAO getInformeInternoDAO() {
		return new MySqlInformeInternoDAO();
	} 
	@Override
	public InformeInternoDetalleDAO getInformeInternoDetalleDAO() {
		return new MySqlInformeInternoDetalleDAO();
	} 
	@Override
	public InformeExternoDAO getInformeExternoDAO() {
		return new MySqlInformeExternoDAO();
	} 
	@Override
	public InformeExternoDetalleDAO getInformeExternoDetalleDAO() {
		return new MySqlInformeExternoDetalleDAO();
	} 
	@Override
	public AccesoDAO getAccesoDAO() {
		return new MySqlAccesoDAO();
	} 
	@Override
	public MenuDAO getMenuDAO() {
		return new MySqlMenuDAO();
	}

 
 
}
