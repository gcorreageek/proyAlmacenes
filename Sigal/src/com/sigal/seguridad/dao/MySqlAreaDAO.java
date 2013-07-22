package com.sigal.seguridad.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.seguridad.bean.AreaDTO;
import com.sigal.util.MySqlConexion;

public class MySqlAreaDAO implements AreaDAO {

	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();
	
	
	@Override
	public ArrayList<AreaDTO> listaAreas() {
	
		SqlSession sesion = sqlMapper.openSession();
		ArrayList<AreaDTO> lstAreas = new ArrayList<AreaDTO>();
		try {
			lstAreas = (ArrayList<AreaDTO>) sesion.selectList("usuario.SQL_ListaAreas");
		} catch (Exception e) {
		System.out.println(e);
		sesion.close();
		}
		finally{
			sesion.close();
			
		}
		
		return lstAreas;
	}

}
