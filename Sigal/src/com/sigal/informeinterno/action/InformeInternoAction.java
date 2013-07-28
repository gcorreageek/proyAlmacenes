/**
 * InformeInternoAction 22/07/2013p
 */
package com.sigal.informeinterno.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.mantenimiento.service.ProductoService;
import com.sigal.pedido.bean.DetallePedidoDTO;

/**
 * @author Gustavo A. Correa C.
 *
 */
@ParentPackage("proy_calidad_SIGAL2")
public class InformeInternoAction extends ActionSupport {
	ProductoService objProdServ = new ProductoService();
	ProductoDTO objProducto;
	private Map<String, Object> lasesion = ActionContext.getContext().getSession(); 
	
	private Integer codProd;
	private String mensaje;
	private Integer rsult;
	
//	rsult mensaje
	private final int totalProductoEnElDetalle=2;
	private ArrayList<DetallePedidoDTO> lstDetPed ;
	
	
	@Action(value="/mainInformeInternoSalidaMovil",results={@Result(name="success",location="/paginas/informe_interno/salida_movil.jsp")})
	public String mainInformeInternoSalidaMovil(){ 
		lstDetPed = (ArrayList<DetallePedidoDTO>) lasesion.get("lstProdII");
		System.out.println("CodProd:"+getCodProd());
		ProductoDTO prod = new ProductoDTO();
		prod.setCod_producto(getCodProd());
		prod = objProdServ.getProducto(prod);
		if(prod==null){
			this.setMensaje("No es un producto Valido!");
			this.setRsult(-1);
		}else{ 
			System.out.println("settea");
			
			setObjProducto(prod);
			//Buscamos si ese producto es de un pedido sin atender
			//su pongamos k si es y hay 2 productos
			//los metemos en una arreglo y comparamos si falta uno
			if(lstDetPed==null){ 
				lstDetPed = new ArrayList<DetallePedidoDTO>();
			}
			DetallePedidoDTO detallePed = new DetallePedidoDTO();
			detallePed.setCod_producto(prod.getCod_producto()); 
			lstDetPed.add(detallePed); 
			System.out.println("ttam:"+lstDetPed.size());
			if(lstDetPed.size()<3){//kiero k sean 2 productos
				if(lstDetPed.size()==2){
					this.setMensaje("Producto Completos ahora si les puedes dar Salida");
					this.setRsult(0);
				}else{
					this.setMensaje("Muy bien!Pero Faltan mas productos");
					this.setRsult(1);
				} 
			}else{ 
				this.setMensaje("Se paso el # de productos! Tiene que eliminar 1 producto de la tabla");
				this.setRsult(-2);
			}
			
			lasesion.put("lstProdII", lstDetPed);
			System.out.println("Tamano:"+lstDetPed.size());
			for (DetallePedidoDTO obj : lstDetPed) {
				System.out.println("obj:"+obj.getCod_producto());
			}
		} 
		return SUCCESS;
	}
	
	

	@Action(value="/mainInformeInternoSalida",results={@Result(name="success",type="tiles",location="d_maininformeinternosalida")})
	public String mainInformeInternoSalida(){ 
		return SUCCESS;
	}
	@Action(value="/mainInformeInternoEntrada",results={@Result(name="success",type="tiles",location="d_maininformeinternoentrada")})
	public String mainInformeInternoEntrada(){ 
		return SUCCESS;
	}



	public Integer getCodProd() {
		return codProd;
	} 
	public void setCodProd(Integer codProd) {
		this.codProd = codProd;
	} 

	
	



	public ProductoDTO getObjProducto() {
		return objProducto;
	}



	public void setObjProducto(ProductoDTO objProducto) {
		this.objProducto = objProducto;
	}



	public String getMensaje() {
		return mensaje;
	}



	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}



	public Integer getRsult() {
		return rsult;
	} 
	public void setRsult(Integer rsult) {
		this.rsult = rsult;
	}
	
	
	
	
	
	
	
}
