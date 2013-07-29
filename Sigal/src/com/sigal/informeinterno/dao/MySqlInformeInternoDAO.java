/**
 * MySqlInformeInternoDAO 29/07/2013
 */
package com.sigal.informeinterno.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.informeinterno.bean.InformeInternoDTO;
import com.sigal.informeinterno.bean.InformeInternoDetalleDTO;
import com.sigal.util.MySqlConexion;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class MySqlInformeInternoDAO implements InformeInternoDAO {
	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();  
	@Override
	public Object registrarII(InformeInternoDTO ii,
			List<InformeInternoDetalleDTO> iiDet) {
		SqlSession sesion =sqlMapper.openSession();
		try {  
			sesion.insert("ii.SQL_registraII",ii);
			for (InformeInternoDetalleDTO  detalleInformeInternoDTO : iiDet) {  
				detalleInformeInternoDTO.setCod_informe_interno(ii.getCod_informe_interno());
				sesion.insert("iidetalle.SQL_registraDetalleII",detalleInformeInternoDTO);
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
