/**
 * MySqlPedidoDetalleDAO 27/07/2013
 */
package com.sigal.pedido.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.util.MySqlConexion;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class MySqlPedidoDetalleDAO implements PedidoDetalleDAO {
	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DetallePedidoDTO> getPedidoDetalle(DetallePedidoDTO detalle) {
		SqlSession sesion = sqlMapper.openSession();
		List<DetallePedidoDTO> det = new ArrayList<>();
		try {
			if (detalle != null) {
				if (detalle.getCod_solicitudPedido() != null) {
					det = (List<DetallePedidoDTO>) sesion.selectList(
							"pedidodetalle.SQL_getDetallePedido",
							detalle.getCod_solicitudPedido());
				}
			}
		}  finally {
			sesion.close();
		}
		return det;
	} 
	@SuppressWarnings("unchecked")
	@Override
	public DetallePedidoDTO getPedidoDetalle1(DetallePedidoDTO detalle) {
		SqlSession sesion = sqlMapper.openSession();
		 DetallePedidoDTO  det = new DetallePedidoDTO();
		try {
			if (detalle != null) {
				if (detalle.getCod_detallePedido() != null) {
					det = (DetallePedidoDTO) sesion.selectOne(
							"pedidodetalle.SQL_getDetallePedido1",
							detalle.getCod_detallePedido());
				}
			}
		}  finally {
			sesion.close();
		}
		return det;
	}

}
