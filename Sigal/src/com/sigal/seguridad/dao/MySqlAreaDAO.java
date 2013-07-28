package com.sigal.seguridad.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.seguridad.bean.AreaDTO;
import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.util.MySqlConexion;

public class MySqlAreaDAO implements AreaDAO {

	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();

 
	@Override
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
 
	@Override
	public List<AreaDTO> listarArea(AreaDTO area) {
		SqlSession sesion =sqlMapper.openSession();
		List<AreaDTO> lstArea = new ArrayList<>(); 
		try {
			lstArea= (List<AreaDTO>)sesion.selectList("area.SQL_listaArea");
		} finally{
			sesion.close();
		}
		return lstArea;
	} 
 
	 

}
