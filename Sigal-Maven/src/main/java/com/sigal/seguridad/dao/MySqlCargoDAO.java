package com.sigal.seguridad.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.seguridad.bean.CargoDTO;
import com.sigal.util.MySqlConexion;

public class MySqlCargoDAO implements CargoDAO {

	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();
  
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
	@SuppressWarnings("unchecked") 
	public List<CargoDTO> buscarCargoPaginados(CargoDTO cargo, Integer inicio,
			Integer tamano) throws Exception {
		SqlSession sesion = sqlMapper.openSession();
		List<CargoDTO> lstCargo = new ArrayList<CargoDTO>();
		try {
			if (cargo == null) {
				CargoDTO provee = new CargoDTO();
				provee.setInicio(inicio);
				provee.setTamano(tamano);
				lstCargo = (List<CargoDTO>) sesion.selectList(
						"cargo.SQL_listaCargoPaginados", provee);
			} else {
				if (!cargo.getDesc_cargo().isEmpty()) {
					cargo.setDesc_cargo("%" + cargo.getDesc_cargo()+ "%");
					cargo.setInicio(inicio);
					cargo.setTamano(tamano);
					lstCargo = (List<CargoDTO>) sesion.selectList(
							"cargo.SQL_listaCargoDesc_cargoPaginados",
							cargo);
				}
			}
		}  finally {
			sesion.close();
		}
		return lstCargo;
	} 
	@SuppressWarnings("unchecked") 
	public List<CargoDTO> buscarCargo(CargoDTO cargo) throws Exception {
		SqlSession sesion = sqlMapper.openSession();
		List<CargoDTO> lstCargo= new ArrayList<CargoDTO>();
		try {
			if (cargo == null) {
				lstCargo = (List<CargoDTO>) sesion.selectList("cargo.SQL_listaCargo");
			} else {
				if (cargo.getDesc_cargo()!=null) {
					lstCargo = (List<CargoDTO>) sesion.selectList( 
							"cargo.SQL_listaDesc_cargo", "%"
									+ cargo.getDesc_cargo() + "%");
				}else if(cargo.getCod_area()!=null){
					lstCargo = (List<CargoDTO>) sesion.selectList( 
							"cargo.SQL_listaCod_area",  cargo.getCod_area());
				}
			}
		} finally {
			sesion.close();
		}
		return lstCargo;
	}  
	public Object registrarCargo(CargoDTO objCargo) throws Exception {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.insert("cargo.SQL_registraCargo", objCargo);
			session.commit();
			result = true;
		}  finally {
			session.close();
		}
		return result;
	}  
	public Object actualizarCargo(CargoDTO objCargo) throws Exception {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.update("cargo.SQL_updateCargo", objCargo);
			session.commit();
			result = true;
		} finally {
			session.close();
		}
		return result;
	}  
	public Object eliminarCargo(CargoDTO objCargo) throws Exception {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.delete("cargo.SQL_deleteCargo", objCargo.getCod_cargo());
			session.commit();
			result = true;
		} finally {
			session.close();
		}
		return result;
	}
 

}
