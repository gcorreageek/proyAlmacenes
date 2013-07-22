package com.sigal.seguridad.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.seguridad.bean.CargoDTO;
import com.sigal.util.MySqlConexion;

public class MySqlCargoDAO implements CargoDAO {

	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();
	
	
	@Override
	public ArrayList<CargoDTO> listaCargos() {
		
		SqlSession sesion = sqlMapper.openSession();
		ArrayList<CargoDTO> lstCargos = new ArrayList<CargoDTO>();
		try {
			lstCargos=(ArrayList<CargoDTO>) sesion.selectList("usuario.SQL_ListaCargos");
		} catch (Exception e) {
			System.out.println(e);
			sesion.close();
		}
		finally{
			sesion.close();
		}
		return lstCargos;
	}

}
