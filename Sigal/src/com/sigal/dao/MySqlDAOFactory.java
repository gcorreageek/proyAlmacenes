package com.sigal.dao;

import com.sigal.mantenimiento.dao.CategoriaDAO;
import com.sigal.mantenimiento.dao.MySqlCategoriaDAO;
import com.sigal.mantenimiento.dao.MySqlProductoDAO;
import com.sigal.mantenimiento.dao.MySqlUmedidaDAO;
import com.sigal.mantenimiento.dao.ProductoDAO;
import com.sigal.mantenimiento.dao.UmedidaDAO;
import com.sigal.pedido.dao.MySqlSolicitudPedidoDAO;
import com.sigal.pedido.dao.SolicitudPedidoDAO;
import com.sigal.seguridad.dao.AreaDAO;
import com.sigal.seguridad.dao.CargoDAO;
import com.sigal.seguridad.dao.MySqlAreaDAO;
import com.sigal.seguridad.dao.MySqlCargoDAO;
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
		// TODO Auto-generated method stub
		return new MySqlCargoDAO();
	}
 
	@Override
	public AreaDAO getAreaDAO() {
		// TODO Auto-generated method stub
		return new MySqlAreaDAO();
	}

 
 
}
