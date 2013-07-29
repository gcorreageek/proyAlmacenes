/**
 * MySqlInformeExternoDAO 29/07/2013
 */
package com.sigal.informeexterno.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.informeexterno.bean.InformeExternoDTO;
import com.sigal.informeexterno.bean.InformeExternoDetalleDTO;
import com.sigal.util.MySqlConexion;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class MySqlInformeExternoDAO implements InformeExternoDAO {
	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();  
 
	@Override
	public Object registrarIE(InformeExternoDTO ie,
			List<InformeExternoDetalleDTO> ieDet) {
		SqlSession sesion =sqlMapper.openSession();
		try {  
			sesion.insert("ie.SQL_registraIE",ie);
			for (InformeExternoDetalleDTO  detalleInformeExternoDTO : ieDet) {  
				detalleInformeExternoDTO.setCod_informe_externo(ie.getCod_informe_externo());
				sesion.insert("iedetalle.SQL_registraDetalleIE",detalleInformeExternoDTO);
			} 
			sesion.commit();
		} catch (Exception e) {
			e.printStackTrace();
			sesion.rollback();
			sesion.close();
		}finally{
			sesion.close();
		} 
		return null;
	}

 

}
