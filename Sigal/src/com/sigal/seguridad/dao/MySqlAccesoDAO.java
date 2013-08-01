/**
 * MySqlAccesoDAO 31/07/2013
 */
package com.sigal.seguridad.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.seguridad.bean.AccesoMenuDTO;
import com.sigal.util.MySqlConexion;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class MySqlAccesoDAO implements AccesoDAO {
	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();
 
	@Override
	public Object registrar(AccesoMenuDTO acceso) throws Exception {
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.insert("acceso.SQL_registraAcceso", acceso);
			session.commit();
			result = true;
		}  finally {
			session.close();
		}
		return result;
	}

 
	@Override
	public Object actualizarEstado(AccesoMenuDTO acceso) throws Exception { 
		Boolean result = false;
		SqlSession session = sqlMapper.openSession();
		try {
			session.update("acceso.SQL_updateAcceso", acceso);
			session.commit();
			result = true;
		} finally {
			session.close();
		}
		return result;
	}

//	select menu.* from tb_menu menu inner join tb_acceso_menu acceso
//	on acceso.cod_menu=menu.cod_menu 
//	inner join tb_cargo cargo
//	on cargo.cod_cargo=acceso.cod_cargo
//	where acceso.cod_cargo=1 
//	order by menu.orden_menu
	@Override
	public List<AccesoMenuDTO> listarMenuAccesoXidCargo(Integer idCargo)
			throws Exception {
		SqlSession sesion =sqlMapper.openSession();
		List<AccesoMenuDTO> lstAcceso = new ArrayList<>(); 
		try {
			lstAcceso= (List<AccesoMenuDTO>)sesion.selectList("acceso.SQL_listaAcceso",idCargo);
		} finally{
			sesion.close();
		}
		return lstAcceso;
	} 
	@Override
	public AccesoMenuDTO getAcceso(Integer idAcceso) throws Exception {
		SqlSession sesion =sqlMapper.openSession();
		AccesoMenuDTO acceso = new AccesoMenuDTO();
		try {
			acceso= (AccesoMenuDTO)sesion.selectOne("acceso.SQL_getAcceso",idAcceso);
		} finally{
			sesion.close();
		}
		return acceso;
	} 
	@Override
	public AccesoMenuDTO getAccesoXIdMenu(Integer idMenu) throws Exception {
		SqlSession sesion =sqlMapper.openSession();
		AccesoMenuDTO acceso = new AccesoMenuDTO();
		try {
			acceso= (AccesoMenuDTO)sesion.selectOne("acceso.SQL_getAccesoXIdMenu",idMenu);
		} finally{
			sesion.close();
		}
		return acceso;
	}


//	SQL_getAccesoXIdCargoIdMenu
	@Override
	public AccesoMenuDTO getAccesoXIdMenuIdCargo(Integer idMenu, Integer IdCargo)
			throws Exception {
		SqlSession sesion =sqlMapper.openSession();
		AccesoMenuDTO acceso = new AccesoMenuDTO();
		try {
			acceso.setCod_cargo(IdCargo);
			acceso.setCod_menu(idMenu);
			acceso= (AccesoMenuDTO)sesion.selectOne("acceso.SQL_getAccesoXIdCargoIdMenu",acceso);
		} finally{
			sesion.close();
		}
		return acceso;
	}

}
