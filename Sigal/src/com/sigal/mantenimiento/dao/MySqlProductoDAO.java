package com.sigal.mantenimiento.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.mysql.jdbc.log.LogFactory;
import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.util.MySqlConexion;

public class MySqlProductoDAO implements ProductoDAO {
	private final Log log = org.apache.commons.logging.LogFactory.getLog(getClass());

	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();

	@Override
	public Boolean registrarProducto(ProductoDTO objProducto) throws Exception {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.insert("producto.SQL_registraProducto", objProducto);
			session.commit();
			result = true;
		} catch (Exception e) { 
			result = false;
			session.rollback();
			throw e;
		} finally {
			session.close();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoDTO> buscarProductos(ProductoDTO producto) throws Exception  {
		SqlSession sesion = sqlMapper.openSession();
		List<ProductoDTO> lstProductos = new ArrayList<ProductoDTO>();
		try {
			if (producto == null) {
				lstProductos = (List<ProductoDTO>) sesion.selectList("producto.SQL_listaProductos");
			} else { 
				producto.setDesc_producto("%"+producto.getDesc_producto()+"%");
				producto.setUnidadMedida("%"+producto.getUnidadMedida()+"%");
				if(log.isDebugEnabled()){
				log.debug("producto desproducto:"+producto.getDesc_producto());
				log.debug("producto umedida:"+producto.getUnidadMedida());
				}

					lstProductos = (List<ProductoDTO>) sesion.selectList(
							"producto.SQL_listaProductosDescProducto", producto  );
			}
		}  finally {
			sesion.close();
		}
		return lstProductos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoDTO> buscarProductosPaginados(ProductoDTO producto, Integer inicio, Integer tamano)throws Exception  {
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
				    producto.setUnidadMedida("%" + producto.getUnidadMedida()
						+ "%");
					producto.setDesc_producto("%" + producto.getDesc_producto()
							+ "%");
					producto.setInicio(inicio);
					producto.setTamano(tamano);
					lstProductos = (List<ProductoDTO>) sesion.selectList(
							"producto.SQL_listaProductosDescProductoPaginados",
							producto); 
			}
		}   finally {
			sesion.close();
		}
		return lstProductos;
	}
	
	//Para el PROVEEDOR!!
	

	@Override
	public ProductoDTO getProducto(ProductoDTO productoViene) throws Exception {
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
		}  finally {
			sesion.close();
		}
		return producto;
	}

	@Override
	public Boolean actualizarProducto(ProductoDTO objProducto)throws Exception {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.update("producto.SQL_updateProducto", objProducto);
			session.commit();
			result = true;
		} catch (Exception e) { 
			session.rollback();
			throw e;
		} finally { 
			session.close();
		}
		return result;
	}

	@Override
	public Boolean eliminarProducto(ProductoDTO objProducto) throws Exception {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.delete("producto.SQL_deleteProducto",
					objProducto.getCod_producto());
			session.commit();
			result = true;
		} catch (Exception e) { 
			result = false;
			session.rollback();
			throw e;
		} finally {
			session.close();
		}
		return result;
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoDTO> buscarProductosIdProveePaginados(
			ProductoDTO producto, Integer idProvee, Integer inicio,
			Integer tamano) throws Exception {
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
					producto.setCod_proveedor(idProvee);
					producto.setDesc_producto("%" + producto.getDesc_producto()
							+ "%");
					producto.setInicio(inicio);
					producto.setTamano(tamano);
					lstProductos = (List<ProductoDTO>) sesion.selectList(
							"producto.SQL_listaProductosDescProductoPaginadosIdProvee",
							producto);
			}
		}  finally {
			sesion.close();
		}
		return lstProductos;
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoDTO> buscarProductosIdProvee(ProductoDTO producto,
			Integer idProvee)throws Exception  {
		SqlSession sesion = sqlMapper.openSession();
		List<ProductoDTO> lstProductos = new ArrayList<ProductoDTO>();
		try {
			if (producto == null) {
				ProductoDTO prod = new ProductoDTO();
				prod.setCod_proveedor(idProvee);
				lstProductos = (List<ProductoDTO>) sesion.selectList("producto.SQL_listaProductosIdProvee",prod);
			} else {
					producto.setCod_proveedor(idProvee);
					lstProductos = (List<ProductoDTO>) sesion.selectList(
							"producto.SQL_listaProductosDescProductoIdProvee", "%"
									+ producto.getDesc_producto() + "%");
			}
		} finally {
			sesion.close();
		}
		return lstProductos;
	} 
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoDTO> buscarHabilitadosProductosPaginados(
			ProductoDTO producto, Integer inicio, Integer tamano)throws Exception  {
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
					producto.setDesc_producto("%" + producto.getDesc_producto()
							+ "%");
					producto.setInicio(inicio);
					producto.setTamano(tamano);
					lstProductos = (List<ProductoDTO>) sesion.selectList(
							"producto.SQL_listaProductosDescProductoPaginadosHabilitados",
							producto);
			}
		} finally {
			sesion.close();
		}
		return lstProductos;
	} 
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoDTO> buscarHabilitadosProductos(ProductoDTO producto)throws Exception {
		SqlSession sesion = sqlMapper.openSession();
		List<ProductoDTO> lstProductos = new ArrayList<ProductoDTO>();
		try {
			if (producto == null) {
				lstProductos = (List<ProductoDTO>) sesion.selectList("producto.SQL_listaProductosHabilitados");
			} else { 
					lstProductos = (List<ProductoDTO>) sesion.selectList(
							"producto.SQL_listaProductosDescProductoHabilitados", "%"
									+ producto.getDesc_producto() + "%");
			}
		} finally {
			sesion.close();
		}
		return lstProductos;
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoDTO> buscarHabilitadosProductosIdProveePaginados  (
			Object  producto2, Integer idProvee, Integer inicio,
			Integer tamano) throws Exception{
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
					producto.setCod_proveedor(idProvee);
					producto.setDesc_producto("%" + producto.getDesc_producto()
							+ "%");
					producto.setInicio(inicio);
					producto.setTamano(tamano);
					lstProductos = (List<ProductoDTO>) sesion.selectList(
							"producto.SQL_listaProductosDescProductoPaginadosIdProveeHabilitados",
							producto); 
			}
		}  finally {
			sesion.close();
		}
		return lstProductos;
	}

 
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoDTO> buscarHabilitadosProductosIdProvee(Object object,
			Integer idProvee) throws Exception {
		ProductoDTO producto = (ProductoDTO) object;
		SqlSession sesion = sqlMapper.openSession();
		List<ProductoDTO> lstProductos = new ArrayList<ProductoDTO>();
		try {
			if (producto == null) {
				ProductoDTO prod = new ProductoDTO();
				prod.setCod_proveedor(idProvee);
				lstProductos = (List<ProductoDTO>) sesion.selectList("producto.SQL_listaProductosIdProveeHabilitados",prod);
			} else { 
					producto.setCod_proveedor(idProvee);
					producto.setDesc_producto( "%"+ producto.getDesc_producto() + "%");
					lstProductos = (List<ProductoDTO>) sesion.selectList(
							"producto.SQL_listaProductosDescProductoIdProveeHabilitados",producto);
			}
		}  finally {
			sesion.close();
		}
		return lstProductos;
	}
 
 

}
