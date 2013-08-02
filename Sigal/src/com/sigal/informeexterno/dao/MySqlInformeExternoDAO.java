/**
 * MySqlInformeExternoDAO 29/07/2013
 */
package com.sigal.informeexterno.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.informeexterno.bean.InformeExternoDTO;
import com.sigal.informeexterno.bean.InformeExternoDetalleDTO;
import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.mantenimiento.bean.ProductoProveedorDTO;
import com.sigal.ordencompra.bean.OrdenCompraDTO;
import com.sigal.ordencompra.bean.OrdenCompraDetalleDTO;
import com.sigal.pedido.bean.DetallePedidoDTO;
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
		Integer rsult=0;
		SqlSession sesion =sqlMapper.openSession();
		try {  
			sesion.insert("ie.SQL_registraIE",ie);
			OrdenCompraDTO ordenc = new OrdenCompraDTO();
			ordenc.setCod_OrdenCompra(ie.getCod_ordencompra());
			if("Entrada".equals(ie.getTipo_informe_externo())){
				ordenc.setEstado_ordencompra("Entregada");
			}else{//salida
				ordenc.setEstado_ordencompra("Pendiente");
			}
			sesion.update("oc.SQL_actualizarOCEstado",ordenc);
			for (InformeExternoDetalleDTO  detalleInformeExternoDTO : ieDet) {  
				detalleInformeExternoDTO.setCod_informe_externo(ie.getCod_informe_externo());
				
				OrdenCompraDetalleDTO ocDet =  (OrdenCompraDetalleDTO)sesion.selectOne("ocdetalle.SQL_getDetalleOC1",ie.getCod_ordencompra());
				 
				ProductoProveedorDTO prodProvee =  (ProductoProveedorDTO) sesion.selectOne("productoproveedor.SQL_getProductoProveedorXCodProductoProveedor",ocDet.getCod_producto_proveedor());
				
				 
				 
				
				ProductoDTO  objProducto = (ProductoDTO) sesion.selectOne("producto.SQL_getProductoXCodProd",prodProvee.getCod_producto()); 
				Integer stock=0; 
				if("Entrada".equals(ie.getTipo_informe_externo())){
					stock = objProducto.getStock_producto() +  ocDet.getCantidad();
				}else{
					stock = objProducto.getStock_producto() -   ocDet.getCantidad();
				}
				
				objProducto.setStock_producto(stock);
				sesion.update("producto.SQL_updateProducto", objProducto);
				
				
				
				
				sesion.insert("iedetalle.SQL_registraDetalleIE",detalleInformeExternoDTO);
			} 
			sesion.commit();
			rsult=1;
		} catch (Exception e) {
			e.printStackTrace();
			sesion.rollback();
			sesion.close();
			rsult=-1;
		}finally{
			sesion.close();
		} 
		return rsult;
	}

 

}
