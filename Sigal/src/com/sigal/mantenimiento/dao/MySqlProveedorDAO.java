/**
 * MySqlProveedorDAO 24/07/2013
 */
package com.sigal.mantenimiento.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.mantenimiento.bean.ProveedorDTO;
import com.sigal.util.MySqlConexion;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class MySqlProveedorDAO implements ProveedorDAO {

	SqlSessionFactory sqlMapper =MySqlConexion.getMapper();
	
	@Override
	public ProveedorDTO getProveedor(ProveedorDTO proveedorViene) {
		SqlSession sesion = sqlMapper.openSession();
		ProveedorDTO proveedor = new ProveedorDTO();
		try {
			if (proveedorViene != null) {
				if (proveedorViene.getCod_proveedor() != null) {
					proveedor = (ProveedorDTO) sesion.selectOne(
							"proveedor.SQL_getProveedorXCodProveedor",
							proveedorViene.getCod_proveedor());
				}
			}
		}  finally {
			sesion.close();
		}
		return proveedor;
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<ProveedorDTO> buscarProveedorPaginados(ProveedorDTO proveedor,
			Integer inicio, Integer tamano) {
		SqlSession sesion = sqlMapper.openSession();
		List<ProveedorDTO> lstProveedor = new ArrayList<ProveedorDTO>();
		try {
			if (proveedor == null) {
				ProveedorDTO provee = new ProveedorDTO();
				provee.setInicio(inicio);
				provee.setTamano(tamano);
				lstProveedor = (List<ProveedorDTO>) sesion.selectList(
						"proveedor.SQL_listaProveedorPaginados", provee);
			} else {
				if (!proveedor.getRaz_social().isEmpty()) {
					proveedor.setRaz_social("%" + proveedor.getRaz_social()
							+ "%");
					proveedor.setInicio(inicio);
					proveedor.setTamano(tamano);
					lstProveedor = (List<ProveedorDTO>) sesion.selectList(
							"proveedor.SQL_listaProveedorRazonSocialPaginados",
							proveedor);
				}
			}
		}  finally {
			sesion.close();
		}
		return lstProveedor;
	}
 
	@SuppressWarnings("unchecked")
	@Override
	public List<ProveedorDTO> buscarProveedor(ProveedorDTO proveedor) {
		SqlSession sesion = sqlMapper.openSession();
		List<ProveedorDTO> lstProveedor= new ArrayList<ProveedorDTO>();
		try {
			if (proveedor == null) {
				lstProveedor = (List<ProveedorDTO>) sesion
						.selectList("proveedor.SQL_listaProveedor");
			} else {
				if (!proveedor.getRaz_social().isEmpty()) {
					lstProveedor = (List<ProveedorDTO>) sesion.selectList(
							"proveedor.SQL_listaProveedorRazonSocial", "%"
									+ proveedor.getRaz_social() + "%");
				}
			}
		} finally {
			sesion.close();
		}
		return lstProveedor;
	} 
	@Override
	public Boolean registrarProveedor(ProveedorDTO objProveedor) {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.insert("proveedor.SQL_registraProveedor", objProveedor);
			session.commit();
			result = true;
		} finally {
			session.close();
		}
		return result;
	}
 
	@Override
	public Boolean actualizarProveedor(ProveedorDTO objProveedor) {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.update("proveedor.SQL_updateProveedor", objProveedor);
			session.commit();
			result = true;
		}  finally {
			session.close();
		}
		return result;
	}
 
	@Override
	public Boolean eliminarProveedor(ProveedorDTO objProveedor) {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.delete("proveedor.SQL_deleteProveedor",
					objProveedor.getCod_proveedor());
			session.commit();
			result = true;
		}   finally {
			session.close();
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<ProveedorDTO> buscarProveedorPaginadosHabilitado(Object object,
			Integer inicio, Integer tamano) {
		ProveedorDTO proveedor= (ProveedorDTO) object;
		SqlSession sesion = sqlMapper.openSession();
		List<ProveedorDTO> lstProveedor = new ArrayList<ProveedorDTO>();
		try {
			if (proveedor == null) {
				ProveedorDTO provee = new ProveedorDTO();
				provee.setInicio(inicio);
				provee.setTamano(tamano);
				lstProveedor = (List<ProveedorDTO>) sesion.selectList(
						"proveedor.SQL_listaProveedorPaginadosHabilitados", provee);
			} else {
				if (!proveedor.getRaz_social().isEmpty()) {
					proveedor.setRaz_social("%" + proveedor.getRaz_social()
							+ "%");
					proveedor.setInicio(inicio);
					proveedor.setTamano(tamano);
					lstProveedor = (List<ProveedorDTO>) sesion.selectList(
							"proveedor.SQL_listaProveedorRazonSocialPaginadosHabilitados",
							proveedor);
				}
			}
		}  finally {
			sesion.close();
		}
		return lstProveedor;
	} 
	@SuppressWarnings("unchecked")
	@Override
	public List<ProveedorDTO> buscarProveedorHabilitado(Object object) {
		ProveedorDTO proveedor= (ProveedorDTO) object;
		SqlSession sesion = sqlMapper.openSession();
		List<ProveedorDTO> lstProveedor= new ArrayList<ProveedorDTO>();
		try {
			if (proveedor == null) {
				lstProveedor = (List<ProveedorDTO>) sesion
						.selectList("proveedor.SQL_listaProveedorHabilitados");
			} else {
				if (!proveedor.getRaz_social().isEmpty()) {
					lstProveedor = (List<ProveedorDTO>) sesion.selectList(
							"proveedor.SQL_listaProveedorRazonSocialHabilitados", "%"
									+ proveedor.getRaz_social() + "%");
				}
			}
		} finally {
			sesion.close();
		}
		return lstProveedor;
	}

}
