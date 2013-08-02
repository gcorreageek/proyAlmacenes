/**
 * MySqlOrdenCompraDetalleDAO 28/07/2013
 */
package com.sigal.ordencompra.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.ordencompra.bean.OrdenCompraDetalleDTO;
import com.sigal.util.MySqlConexion;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class MySqlOrdenCompraDetalleDAO implements OrdenCompraDetalleDAO {
//	SQL_getDetalleOC SQL_registraDetalleOC 
	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();
	@SuppressWarnings("unchecked")
	@Override
	public List<OrdenCompraDetalleDTO> getOCDetalle(
			OrdenCompraDetalleDTO detalle) {
		SqlSession sesion = sqlMapper.openSession();
		List<OrdenCompraDetalleDTO> det = new ArrayList<>();
		try {
			if (detalle != null) {
				if (detalle.getCod_ordenCompra() != null) {
					det = (List<OrdenCompraDetalleDTO>) sesion.selectList(//SQL_getDetalleCotizacion 
							"ocdetalle.SQL_getDetalleOC",
							detalle.getCod_ordenCompra());
				}
			}
		}  finally {
			sesion.close();
		}
		return det;
	} 
	@SuppressWarnings("unchecked")
	@Override
	public OrdenCompraDetalleDTO getOCDetalle1(OrdenCompraDetalleDTO detalle) {
		SqlSession sesion = sqlMapper.openSession();
		OrdenCompraDetalleDTO det = new  OrdenCompraDetalleDTO();
		try {
			if (detalle != null) {
				if (detalle.getCod_ordenCompra() != null) {
					det =  (OrdenCompraDetalleDTO) sesion.selectOne(//SQL_getDetalleCotizacion 
							"ocdetalle.SQL_getDetalleOC1",
							detalle.getCod_ordenCompra());
				}
			}
		}  finally {
			sesion.close();
		}
		return det;
	}
 
	 

}
