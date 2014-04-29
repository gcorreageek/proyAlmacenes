/**
 * MySqlInformeExternoDAO 29/07/2013
 */
package com.sigal.informeexterno.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sigal.informeexterno.bean.InformeExternoDTO;
import com.sigal.informeexterno.bean.InformeExternoDetalleDTO;
import com.sigal.informeinterno.bean.InformeInternoDTO;
import com.sigal.informeinterno.dao.MySqlInformeInternoDAO;
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
	private final Log log = LogFactory.getLog(MySqlInformeExternoDAO.class);
	SqlSessionFactory sqlMapper = MySqlConexion.getMapper();  
  
	public Object registrarIE(InformeExternoDTO ie,
			List<InformeExternoDetalleDTO> ieDet) throws Exception{
		Integer rsult=0;
		SqlSession sesion =sqlMapper.openSession();
		try {  
			sesion.insert("ie.SQL_registraIE",ie);
			
			OrdenCompraDTO ordemperu = new OrdenCompraDTO();
					
			ordemperu = 	(OrdenCompraDTO) sesion.selectOne("oc.SQL_getOC",ie.getCod_ordencompra());
			System.out.println("rei:"+ie.getTipo_informe_externo()); 
			if("Entrada".equals(ie.getTipo_informe_externo())){
				ordemperu.setEstado_ordencompra("Entregada");
			}else{//salida
				ordemperu.setEstado_ordencompra("Pendiente");
			}
			System.out.println("estado:"+ordemperu.getCod_OrdenCompra());
			System.out.println("estado:"+ordemperu.getEstado_ordencompra());
			sesion.update("oc.SQL_actualizarOCEstadoDDDD",ordemperu);
			for (InformeExternoDetalleDTO  detalleInformeExternoDTO : ieDet) {  
				detalleInformeExternoDTO.setCod_informe_externo(ie.getCod_informe_externo());
				System.out.println("Codigo Detalle OC:"+detalleInformeExternoDTO.getCod_detalle_ordencompra());
				OrdenCompraDetalleDTO ocDet =  (OrdenCompraDetalleDTO)sesion.selectOne("ocdetalle.SQL_getDetalleOC1",detalleInformeExternoDTO.getCod_detalle_ordencompra());
				System.out.println("CodProductoProveedor:"+ocDet.getCod_producto_proveedor());
				ProductoProveedorDTO prodProvee =  (ProductoProveedorDTO) sesion.selectOne("productoproveedor.SQL_getProductoProveedorXCodProductoProveedor",ocDet.getCod_producto_proveedor());
				System.out.println("codProducto:"+prodProvee.getCod_producto()); 
				ProductoDTO  objProducto = (ProductoDTO) sesion.selectOne("producto.SQL_getProductoXCodProd",prodProvee.getCod_producto()); 
				System.out.println("Stock del Producto:"+objProducto.getStock_producto());
				System.out.println("Cantidad del Producto:"+ocDet.getCantidad());
				Integer stock=0; 
				if(objProducto.getStock_producto()==null)
					objProducto.setStock_producto(0); 
				if("Entrada".equals(ie.getTipo_informe_externo())){
					stock =  objProducto.getStock_producto() +  ocDet.getCantidad();
				}else{
					stock =  objProducto.getStock_producto() -  ocDet.getCantidad();
				}
				
				objProducto.setStock_producto(stock);
				sesion.update("producto.SQL_updateProducto", objProducto); 
				sesion.insert("iedetalle.SQL_registraDetalleIE",detalleInformeExternoDTO);
			} 
			sesion.commit();
			rsult=1;
		} catch (Exception e) {
			rsult=-1; 
			sesion.rollback();
			throw e; 
		}finally{ 
			sesion.close();
		} 
		return rsult;
	} 
	
	@SuppressWarnings("unchecked") 
	public List<InformeExternoDTO> buscaInformeExterno(InformeExternoDTO ie)
			throws Exception { 
		if(log.isDebugEnabled()){
			log.debug("Tipo:"+ie.getTipo_informe_externo());
			log.debug("codigoie:"+ie.getCod_informe_externo());
		} 
		SqlSession sesion = sqlMapper.openSession();
		List<InformeExternoDTO> det = new ArrayList<InformeExternoDTO>();
		try {
//			SQL_listaInformeInterno SQL_getInformeInterno
			if (ie.getCod_informe_externo() != null) {
				det = (List<InformeExternoDTO>) sesion.selectList(
						"ie.SQL_getInformeExterno",
						ie.getCod_informe_externo());
			}else{
				ie.setTipo_informe_externo("%"+ ie.getTipo_informe_externo() +"%");
				det = (List<InformeExternoDTO>) sesion.selectList(
						"ie.SQL_listaInformeExterno",
						ie.getTipo_informe_externo());
			}
			 
		}  finally {
			sesion.close();
		}
		return det;
	}

 

}
