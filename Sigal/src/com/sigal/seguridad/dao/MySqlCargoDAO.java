package com.sigal.seguridad.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.seguridad.bean.AreaDTO;
import com.sigal.seguridad.bean.CargoDTO;
import com.sigal.util.MySqlConexion;

public class MySqlCargoDAO implements CargoDAO {

	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();
 
	@Override
	public CargoDTO getCargo(Integer codCargo) {
		SqlSession sesion =sqlMapper.openSession();
		CargoDTO objCargo = new CargoDTO(); 
		try {
			objCargo= (CargoDTO)sesion.selectOne("cargo.SQL_getCargo",codCargo);
		} finally{
			sesion.close();
		}
		return objCargo;
	}
 

}
