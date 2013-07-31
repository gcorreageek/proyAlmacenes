/**
 * MySqlCotizacionDetalleDAO 28/07/2013
 */
package com.sigal.cotizacion.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.cotizacion.bean.CotizacionDetalleDTO;
import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.util.MySqlConexion;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class MySqlCotizacionDetalleDAO implements CotizacionDetalleDAO {

 SqlSessionFactory sqlMapper = MySqlConexion.getMapper();
 
	@SuppressWarnings("unchecked")
	@Override
	public List<CotizacionDetalleDTO> getCotizacionDetalle(
			CotizacionDetalleDTO detalle) { 
		SqlSession sesion = sqlMapper.openSession();
		List<CotizacionDetalleDTO> det = new ArrayList<CotizacionDetalleDTO>();
		try {
			if (detalle != null) {
				if (detalle.getCod_cotizacion() != null) {
					det = (List<CotizacionDetalleDTO>) sesion.selectList(//SQL_getDetalleCotizacion 
							"cotizaciondetalle.SQL_getDetalleCotizacion",
							detalle.getCod_cotizacion());
				}
			}
		}  finally {
			sesion.close();
		}
		return det;
	}
	 
 

}
