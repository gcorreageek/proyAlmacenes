package com.sigal.pedido.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.pedido.bean.SolicitudPedidoDTO;
import com.sigal.util.MySqlConexion;

public class MySqlSolicitudPedidoDAO implements SolicitudPedidoDAO {

	@Override
	public void RegistrarPedido(SolicitudPedidoDTO objSolP,ArrayList<DetallePedidoDTO> lstDetPed) {
		
		SqlSessionFactory  sqlMapper = MySqlConexion.getMapper();
		SqlSession sesion =sqlMapper.openSession();
		try {
			//imprimo datos del pedido
			System.out.println("------------------DATOS DEL PEDIDO----------------");
			System.out.println("codigo de usuario"+objSolP.getCod_usuario());
			System.out.println("Comentario"+objSolP.getComentario_pedido());
			System.out.println("Tipo de pedido"+objSolP.getTipo_pedido());
			System.out.println("Fecha de registro"+objSolP.getFechaRegistro_pedido());
			System.out.println("Fecha de devolucion"+objSolP.getFechaDevolucion_pedido());
			System.out.println("Estado de pedido"+objSolP.getEstado_pedido());
			
			
			
		System.out.println("valor de registro de pedido"+sesion.insert("pedido.SQL_registrarSolicitudPedido",objSolP));	
			
			
			System.out.println("----------------DATOS DEL DETALLE---------------");
			for (DetallePedidoDTO obj :lstDetPed){
				obj.setCod_solicitudPedido(objSolP.getCod_solicitudPedido());
				System.out.println("valor de registro del detalle de pedido"+sesion.insert("detallepedido.SQL_registraDetallePedido",obj));
			}
			sesion.commit();
		} catch (Exception e) {
			System.out.println(e);
			sesion.rollback();
			sesion.close();
		}
		finally{
			sesion.close();
		}

		
	}

}
