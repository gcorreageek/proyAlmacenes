package com.sigal.seguridad.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.seguridad.bean.AreaDTO;
import com.sigal.util.MySqlConexion;

public class MySqlAreaDAO implements AreaDAO {

	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();

  
	public AreaDTO getArea(Integer codarea) {
		SqlSession sesion =sqlMapper.openSession();
		AreaDTO objArea = new AreaDTO(); 
		try {
			objArea= (AreaDTO)sesion.selectOne("area.SQL_getArea",codarea);
		} finally{
			sesion.close();
		}
		return objArea;
	}
 
	@SuppressWarnings("unchecked") 
	public List<AreaDTO> listarArea(AreaDTO area) {
		SqlSession sesion =sqlMapper.openSession();
		List<AreaDTO> lstArea = new ArrayList<AreaDTO>(); 
		try {
			lstArea= (List<AreaDTO>)sesion.selectList("area.SQL_listaArea");
		} finally{
			sesion.close();
		}
		return lstArea;
	}  
	public Object registrarArea(AreaDTO objArea) throws Exception {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.insert("area.SQL_registraArea", objArea);
			session.commit();
			result = true;
		}  finally {
			session.close();
		}
		return result;
	}  
	public Object actualizarArea(AreaDTO objArea) throws Exception {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.update("area.SQL_updateArea", objArea);
			session.commit();
			result = true;
		} finally {
			session.close();
		}
		return result;
	}  
	public Object eliminarArea(AreaDTO objArea) throws Exception {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.delete("area.SQL_deleteArea", objArea.getCod_area());
			session.commit();
			result = true;
		} finally {
			session.close();
		}
		return result;
	} 
	@SuppressWarnings("unchecked") 
	public List<AreaDTO> buscarAreaPaginados(AreaDTO area, Integer inicio,
			Integer tamano) throws Exception {
		SqlSession sesion = sqlMapper.openSession();
		List<AreaDTO> lstArea = new ArrayList<AreaDTO>();
		try {
			if (area == null) {
				AreaDTO provee = new AreaDTO();
				provee.setInicio(inicio);
				provee.setTamano(tamano);
				lstArea = (List<AreaDTO>) sesion.selectList(
						"area.SQL_listaAreaPaginados", provee);
			} else {
				if (!area.getDesc_area().isEmpty()) {
					area.setDesc_area("%" + area.getDesc_area()+ "%");
					area.setInicio(inicio);
					area.setTamano(tamano);
					lstArea = (List<AreaDTO>) sesion.selectList(
							"area.SQL_listaAreaDesc_areaPaginados",
							area);
				}
			}
		}  finally {
			sesion.close();
		}
		return lstArea;
	} 
	@SuppressWarnings("unchecked") 
	public List<AreaDTO> buscarArea(AreaDTO area) throws Exception {
		SqlSession sesion = sqlMapper.openSession();
		List<AreaDTO> lstArea= new ArrayList<AreaDTO>();
		try {
			if (area == null) {
				lstArea = (List<AreaDTO>) sesion.selectList("area.SQL_listaArea");
			} else {
				if (!area.getDesc_area().isEmpty()) {
					lstArea = (List<AreaDTO>) sesion.selectList( 
							"area.SQL_listaDesc_area", "%"
									+ area.getDesc_area() + "%");
				}
			}
		} finally {
			sesion.close();
		}
		return lstArea;
	}  
 
	 

}
