/**
 * MySqlProductoProveedorDAO 24/07/2013
 */
package com.sigal.mantenimiento.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.mantenimiento.bean.ProductoProveedorDTO;
import com.sigal.util.MySqlConexion;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class MySqlProductoProveedorDAO implements ProductoProveedorDAO {
 
	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();
 
	@Override
	public ProductoProveedorDTO getProductoProveedor(
			ProductoProveedorDTO productoProveedorViene) throws Exception {
		SqlSession sesion = sqlMapper.openSession();
		ProductoProveedorDTO productoProveedor = new ProductoProveedorDTO();
		try {
			if (productoProveedorViene != null) {
				if (productoProveedorViene.getCod_producto_proveedor() != null) {
					productoProveedor = (ProductoProveedorDTO) sesion.selectOne(
							"productoproveedor.SQL_getProductoProveedorXCodProductoProveedor",
							productoProveedorViene.getCod_producto_proveedor());
				}
			}
		} finally {
			sesion.close();
		}
		return productoProveedor;
	}
 
	@Override
	public List<ProductoProveedorDTO> buscarProductoProveedorPaginados(
			ProductoProveedorDTO productoProveedor, Integer inicio,
			Integer tamano) throws Exception {
		SqlSession sesion = sqlMapper.openSession();
		List<ProductoProveedorDTO> lstProductosProveedor = new ArrayList<ProductoProveedorDTO>();
		try {
			if (productoProveedor == null) {
				ProductoProveedorDTO prodProvee = new ProductoProveedorDTO();
				prodProvee.setInicio(inicio);
				prodProvee.setTamano(tamano);
				lstProductosProveedor = (List<ProductoProveedorDTO>) sesion.selectList(
						"productoproveedor.SQL_listaProductoProveedorPaginados", prodProvee);
			} else {
				if (!productoProveedor.getRaz_social().isEmpty() || !productoProveedor.getDesc_producto().isEmpty()) {
					productoProveedor.setDesc_producto("%" + productoProveedor.getDesc_producto()+ "%");
					productoProveedor.setRaz_social("%" + productoProveedor.getRaz_social()+ "%");
					productoProveedor.setInicio(inicio);
					productoProveedor.setTamano(tamano);
					lstProductosProveedor = (List<ProductoProveedorDTO>) sesion.selectList(
							"productoproveedor.SQL_listaProductoProveedorRazonSocialDescProductoPaginados",
							productoProveedor);
				}
			}
		} finally {
			sesion.close();
		}
		return lstProductosProveedor;
	}
 
	@Override
	public List<ProductoProveedorDTO> buscarProductoProveedor(
			ProductoProveedorDTO productoProveedor) throws Exception {
		SqlSession sesion = sqlMapper.openSession();
		List<ProductoProveedorDTO> lstProductosProveedor = new ArrayList<ProductoProveedorDTO>();
		try {
			if (productoProveedor == null) {
				lstProductosProveedor = (List<ProductoProveedorDTO>) sesion
						.selectList("productoproveedor.SQL_listaProductoProveedor");
			} else {
				if (!productoProveedor.getRaz_social().isEmpty() || !productoProveedor.getDesc_producto().isEmpty()) {
					productoProveedor.setDesc_producto("%" + productoProveedor.getDesc_producto()+ "%");
					productoProveedor.setRaz_social("%" + productoProveedor.getRaz_social()+ "%");
					lstProductosProveedor = (List<ProductoProveedorDTO>) sesion.selectList(
							"productoproveedor.SQL_listaProductoProveedorRazonSocialAndDescProducto", productoProveedor);
				}
			}
		}  finally {
			sesion.close();
		}
		return lstProductosProveedor;
	}
 
	@Override
	public Boolean registrarProductoProveedor(
			ProductoProveedorDTO objProductoProvedor) throws Exception {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.insert("productoproveedor.SQL_registraProductoProveedor", objProductoProvedor);
			session.commit();
			result = true;
		} finally {
			session.close();
		}
		return result;
	}
 
	@Override
	public Boolean actualizarProductoProveedor(
			ProductoProveedorDTO objProductoProvedor) throws Exception {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.update("productoproveedor.SQL_updateProductoProveedor", objProductoProvedor);
			session.commit();
			result = true;
		} finally {
			session.close();
		}
		return result;
	}
 
	@Override
	public Boolean eliminarProductoProveedor(
			ProductoProveedorDTO objProductoProvedor) throws Exception {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.delete("productoproveedor.SQL_deleteProductoProveedor",
					objProductoProvedor.getCod_producto_proveedor());
			session.commit();
			result = true;
		}  finally {
			session.close();
		}
		return result;
	}

	 
}
