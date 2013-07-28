/**
 * PedidoDetalleDAO 27/07/2013
 */
package com.sigal.pedido.dao;

import java.util.List;

import com.sigal.pedido.bean.DetallePedidoDTO;

/**
 * @author Gustavo A. Correa C.
 *
 */
public interface PedidoDetalleDAO {

	List<DetallePedidoDTO> getPedidoDetalle(DetallePedidoDTO detalle);
}
