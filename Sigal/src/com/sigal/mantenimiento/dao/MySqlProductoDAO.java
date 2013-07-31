package com.sigal.mantenimiento.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.util.MySqlConexion;

public class MySqlProductoDAO implements ProductoDAO {

	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();

	@Override
	public Boolean registrarProducto(ProductoDTO objProducto) {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.insert("producto.SQL_registraProducto", objProducto);
			session.commit();
			result = true;
		} catch (Exception e) {
			System.out.println(e);
			session.close();
		} finally {
			session.close();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoDTO> buscarProductos(ProductoDTO producto) {
		SqlSession sesion = sqlMapper.openSession();
		List<ProductoDTO> lstProductos = new ArrayList<ProductoDTO>();
		try {
			if (producto == null) {
				lstProductos = (List<ProductoDTO>) sesion.selectList("producto.SQL_listaProductos");
			} else {
				if (!producto.getDesc_producto().isEmpty()) {
					lstProductos = (List<ProductoDTO>) sesion.selectList(
							"producto.SQL_listaProductosDescProducto", "%"
									+ producto.getDesc_producto() + "%");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sesion.close();
		}
		return lstProductos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoDTO> buscarProductosPaginados(ProductoDTO producto,
			Integer inicio, Integer tamano) {

		SqlSession sesion = sqlMapper.openSession();
		List<ProductoDTO> lstProductos = new ArrayList<ProductoDTO>();
		try {
			if (producto == null) {
				ProductoDTO prod = new ProductoDTO();
				prod.setInicio(inicio);
				prod.setTamano(tamano);
				lstProductos = (List<ProductoDTO>) sesion.selectList(
						"producto.SQL_listaProductosPaginados", prod);
			} else {
				if (!producto.getDesc_producto().isEmpty()) {
					producto.setDesc_producto("%" + producto.getDesc_producto()
							+ "%");
					producto.setInicio(inicio);
					producto.setTamano(tamano);
					lstProductos = (List<ProductoDTO>) sesion.selectList(
							"producto.SQL_listaProductosDescProductoPaginados",
							producto);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sesion.close();
		}
		return lstProductos;
	}
	
	//Para el PROVEEDOR!!
	

	@Override
	public ProductoDTO getProducto(ProductoDTO productoViene) {
		SqlSession sesion = sqlMapper.openSession();
		ProductoDTO producto = new ProductoDTO();
		try {
			if (productoViene != null) {
				if (productoViene.getCod_producto() != null) {
					producto = (ProductoDTO) sesion.selectOne(
							"producto.SQL_getProductoXCodProd",
							productoViene.getCod_producto());
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sesion.close();
		}
		return producto;
	}

	@Override
	public Boolean actualizarProducto(ProductoDTO objProducto) {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.update("producto.SQL_updateProducto", objProducto);
			session.commit();
			result = true;
		} catch (Exception e) {
			System.out.println(e);
			session.close();
		} finally {
			session.close();
		}
		return result;
	}

	@Override
	public Boolean eliminarProducto(ProductoDTO objProducto) {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.delete("producto.SQL_deleteProducto",
					objProducto.getCod_producto());
			session.commit();
			result = true;
		} catch (Exception e) {
			System.out.println(e);
			session.close();
		} finally {
			session.close();
		}
		return result;
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoDTO> buscarProductosIdProveePaginados(
			ProductoDTO producto, Integer idProvee, Integer inicio,
			Integer tamano) {
		SqlSession sesion = sqlMapper.openSession();
		List<ProductoDTO> lstProductos = new ArrayList<ProductoDTO>();
		try {
			if (producto == null) {
				ProductoDTO prod = new ProductoDTO();
				prod.setCod_proveedor(idProvee);
				prod.setInicio(inicio);
				prod.setTamano(tamano);
				lstProductos = (List<ProductoDTO>) sesion.selectList(
						"producto.SQL_listaProductosPaginadosIdProvee", prod);
			} else {
				if (!producto.getDesc_producto().isEmpty()) {
					producto.setCod_proveedor(idProvee);
					producto.setDesc_producto("%" + producto.getDesc_producto()
							+ "%");
					producto.setInicio(inicio);
					producto.setTamano(tamano);
					lstProductos = (List<ProductoDTO>) sesion.selectList(
							"producto.SQL_listaProductosDescProductoPaginadosIdProvee",
							producto);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sesion.close();
		}
		return lstProductos;
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoDTO> buscarProductosIdProvee(ProductoDTO producto,
			Integer idProvee) {
		SqlSession sesion = sqlMapper.openSession();
		List<ProductoDTO> lstProductos = new ArrayList<ProductoDTO>();
		try {
			if (producto == null) {
				ProductoDTO prod = new ProductoDTO();
				prod.setCod_proveedor(idProvee);
				lstProductos = (List<ProductoDTO>) sesion.selectList("producto.SQL_listaProductosIdProvee",prod);
			} else {
				if (!producto.getDesc_producto().isEmpty()) {
					producto.setCod_proveedor(idProvee);
					lstProductos = (List<ProductoDTO>) sesion.selectList(
							"producto.SQL_listaProductosDescProductoIdProvee", "%"
									+ producto.getDesc_producto() + "%");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sesion.close();
		}
		return lstProductos;
	} 
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoDTO> buscarHabilitadosProductosPaginados(
			ProductoDTO producto, Integer inicio, Integer tamano) {
		SqlSession sesion = sqlMapper.openSession();
		List<ProductoDTO> lstProductos = new ArrayList<ProductoDTO>();
		try {
			if (producto == null) {
				ProductoDTO prod = new ProductoDTO();
				prod.setInicio(inicio);
				prod.setTamano(tamano);
				lstProductos = (List<ProductoDTO>) sesion.selectList(
						"producto.SQL_listaProductosPaginadosHabilitados", prod);
			} else {
				if (!producto.getDesc_producto().isEmpty()) {
					producto.setDesc_producto("%" + producto.getDesc_producto()
							+ "%");
					producto.setInicio(inicio);
					producto.setTamano(tamano);
					lstProductos = (List<ProductoDTO>) sesion.selectList(
							"producto.SQL_listaProductosDescProductoPaginadosHabilitados",
							producto);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sesion.close();
		}
		return lstProductos;
	} 
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoDTO> buscarHabilitadosProductos(ProductoDTO producto) {
		SqlSession sesion = sqlMapper.openSession();
		List<ProductoDTO> lstProductos = new ArrayList<ProductoDTO>();
		try {
			if (producto == null) {
				lstProductos = (List<ProductoDTO>) sesion.selectList("producto.SQL_listaProductosHabilitados");
			} else {
				if (!producto.getDesc_producto().isEmpty()) {
					lstProductos = (List<ProductoDTO>) sesion.selectList(
							"producto.SQL_listaProductosDescProductoHabilitados", "%"
									+ producto.getDesc_producto() + "%");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sesion.close();
		}
		return lstProductos;
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoDTO> buscarHabilitadosProductosIdProveePaginados(
			Object  producto2, Integer idProvee, Integer inicio,
			Integer tamano) {
		ProductoDTO producto = (ProductoDTO) producto2;
		SqlSession sesion = sqlMapper.openSession();
		List<ProductoDTO> lstProductos = new ArrayList<ProductoDTO>();
		try {
			if (producto == null) {
				ProductoDTO prod = new ProductoDTO();
				prod.setCod_proveedor(idProvee);
				prod.setInicio(inicio);
				prod.setTamano(tamano);
				lstProductos = (List<ProductoDTO>) sesion.selectList(
						"producto.SQL_listaProductosPaginadosIdProveeHabilitados", prod);
			} else {
				if (!producto.getDesc_producto().isEmpty()) {
					producto.setCod_proveedor(idProvee);
					producto.setDesc_producto("%" + producto.getDesc_producto()
							+ "%");
					producto.setInicio(inicio);
					producto.setTamano(tamano);
					lstProductos = (List<ProductoDTO>) sesion.selectList(
							"producto.SQL_listaProductosDescProductoPaginadosIdProveeHabilitados",
							producto);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sesion.close();
		}
		return lstProductos;
	}

 
	@Override
	public List<ProductoDTO> buscarHabilitadosProductosIdProvee(Object object,
			Integer idProvee) {
		ProductoDTO producto = (ProductoDTO) object;
		SqlSession sesion = sqlMapper.openSession();
		List<ProductoDTO> lstProductos = new ArrayList<ProductoDTO>();
		try {
			if (producto == null) {
				ProductoDTO prod = new ProductoDTO();
				prod.setCod_proveedor(idProvee);
				lstProductos = (List<ProductoDTO>) sesion.selectList("producto.SQL_listaProductosIdProveeHabilitados",prod);
			} else {
				if (!producto.getDesc_producto().isEmpty()) {
					producto.setCod_proveedor(idProvee);
					lstProductos = (List<ProductoDTO>) sesion.selectList(
							"producto.SQL_listaProductosDescProductoIdProveeHabilitados", "%"
									+ producto.getDesc_producto() + "%");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			sesion.close();
		}
		return lstProductos;
	}
 
 

}
