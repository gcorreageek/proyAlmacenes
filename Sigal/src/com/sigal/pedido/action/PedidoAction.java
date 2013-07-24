package com.sigal.pedido.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.pedido.bean.SolicitudPedidoDTO;
import com.sigal.pedido.service.PedidoService;
import com.sigal.seguridad.service.LogueoService;
/**
 * 
 * @author David
 * @descripcion Clase encargada de la gestion de las solicitudes de pedido
 */
@ParentPackage("proy_calidad_SIGAL2")
public class PedidoAction extends ActionSupport {

	/*---------------------------- DECLARACION DE VARIABLES -------------------------------------*/
	LogueoService objLogServ = new LogueoService();
	PedidoService objPedidoServ = new PedidoService(); 
	
	private Map<String, Object> lasesion = ActionContext.getContext().getSession(); 
	private String mensaje;
	 
	private SolicitudPedidoDTO objSolped;
	private DetallePedidoDTO objDetallePedido;
	private String cod_p;
	private String cant;
	 
	
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
	
	
 
	
 
	
	
}
