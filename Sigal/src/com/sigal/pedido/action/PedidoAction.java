package com.sigal.pedido.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.mantenimiento.service.ProductoService;
import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.pedido.bean.SolicitudPedidoDTO;
import com.sigal.pedido.service.PedidoService;
/**
 * 
 * @author David
 * @descripcion Clase encargada de la gestion de las solicitudes de pedido
 */
@ParentPackage("proy_calidad_SIGAL2")
public class PedidoAction extends ActionSupport {
 
//	LogueoService objLogServ = new LogueoService();
	PedidoService objPedidoServ = new PedidoService(); 
	ProductoService objProductoServ = new ProductoService(); 
	 
	private Map<String, Object> lasesion = ActionContext.getContext().getSession(); 
	private ArrayList<DetallePedidoDTO> lstDetPed = (ArrayList<DetallePedidoDTO>) lasesion.get("lstDetPed");
	private String mensaje;
	 
	private SolicitudPedidoDTO objSolped;
	private DetallePedidoDTO objDetallePedido;
	private Integer idProd;
	private Integer cantidad;
	 
	
	Date fecha = new Date();
	SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
	
	//variable para mostrar resultado de registro
	
	private String mensajeR;
	
	 
	
	
	@Action(value="/nuevoPedido",results={@Result(name="success",type="tiles",location="d_mainpedido")})
	public String mainPedido(){ 
		return SUCCESS;
	}
	@Action(value="/evaluarPedido",results={@Result(name="success",type="tiles",location="d_evaluarPedido")})
	public String evaluarPedido(){
		return SUCCESS;
	}																				 
	@Action(value="/agregarDetallePedido",results={@Result(name="success",location="/paginas/pedido/detalle_pedido.jsp")})
	public String agregarDetallePedido(){
		
		DetallePedidoDTO objDetalle = new DetallePedidoDTO();
		ProductoDTO prod = new ProductoDTO();
		prod.setCod_producto(getIdProd());
		prod = objProductoServ.getProducto(prod);
		objDetalle.setCod_producto(prod.getCod_producto());
		objDetalle.setDesc_producto(prod.getDesc_producto());
		objDetalle.setUnidadMedida(prod.getUnidadMedida());
		objDetalle.setCantidad(getCantidad());
		if(lstDetPed==null){
			lstDetPed = new ArrayList<DetallePedidoDTO>();
		}
		lstDetPed.add(objDetalle);
		for (DetallePedidoDTO iterable_element : lstDetPed) {
			System.out.println("det:"+iterable_element.getCod_producto());
		}
		lasesion.put("lstDetPed", lstDetPed);
		return SUCCESS;
	}
	public Integer getIdProd() {
		return idProd;
	}
	public void setIdProd(Integer idProd) {
		this.idProd = idProd;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
 
	
 
	
	
}
