/**
 * InformeInternoAction 22/07/2013p
 */
package com.sigal.informeinterno.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sigal.informeinterno.bean.InformeInternoDTO;
import com.sigal.informeinterno.bean.InformeInternoDetalleDTO;
import com.sigal.informeinterno.service.InformeInternoService;
import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.mantenimiento.service.ProductoService;
import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.pedido.service.PedidoDetalleService;
import com.sigal.seguridad.bean.AreaDTO;
import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.seguridad.service.AreaService;

/**
 * @author Gustavo A. Correa C.
 *
 */
@ParentPackage("proy_calidad_SIGAL2")
public class InformeInternoAction extends ActionSupport {
	InformeInternoService objInfInterServ = new InformeInternoService();
	ProductoService objProdServ = new ProductoService();
	PedidoDetalleService objPedDetServ = new PedidoDetalleService();
	ProductoDTO objProducto;
	AreaService objAreaServ = new AreaService();
	
	private List<AreaDTO> lstArea;
	Map<String, Object> lasesion = ActionContext.getContext().getSession(); 
	
	private Integer codProd;
	private String mensaje;
	private Integer rsult;
	private InformeInternoDTO objInformeInterno;
	List<InformeInternoDetalleDTO> lstIIDet;
	
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
			setObjProducto(prod); 
		} 
		return SUCCESS;
	}
	
	

	@Action(value="/mainInformeInternoSalida",results={@Result(name="success",type="tiles",location="d_maininformeinternosalida")})
	public String mainInformeInternoSalida(){
		System.out.println("entra1");
		Object[] obj =  (Object[]) lasesion.get("DatosQR"); 
		if(obj!=null){
			if("Salida".equals(obj[1])){
				codProd = (Integer) obj[0];
			} 
		}
		lstArea = objAreaServ.listaArea();
		return SUCCESS;
	}
	
	@Action(value="/guardarIIS",results={@Result(name="success",location="/paginas/pedido/pedido_evaluacion_mensaje.jsp")})
	public String guardarIIS(){
		try {
			UsuarioDTO usuario =  (UsuarioDTO) lasesion.get("objUsuario");
			objInformeInterno.setCod_usuario(usuario.getCod_usuario()); 
			objInformeInterno.setTipo_informe_interno("Salida"); 
			lstIIDet = new ArrayList<>();
			DetallePedidoDTO pedDet = new DetallePedidoDTO();
			pedDet.setCod_solicitudPedido(objInformeInterno.getCod_pedido()); 
			List<DetallePedidoDTO> lstDetPedido= objPedDetServ.listaPedidoXidPedido(pedDet);
			for (DetallePedidoDTO detallePedidoDTO : lstDetPedido) {
				InformeInternoDetalleDTO iiDet = new InformeInternoDetalleDTO();
				iiDet.setCod_detalle_pedido(detallePedidoDTO.getCod_detallePedido()); 
				lstIIDet.add(iiDet);
			} 
			objInfInterServ.registrar(objInformeInterno, lstIIDet);  
			this.mensaje = "Se ingreso correctamente el Informe Interno Salida";
		} catch (Exception e) {
			System.out.println("Try:"+e);
			e.printStackTrace();
		} 
		return SUCCESS;
	}
	@Action(value="/guardarIIE",results={@Result(name="success",location="/paginas/pedido/pedido_evaluacion_mensaje.jsp")})
	public String guardarIIE(){
		try {
			UsuarioDTO usuario =  (UsuarioDTO) lasesion.get("objUsuario");
			objInformeInterno.setCod_usuario(usuario.getCod_usuario()); 
			objInformeInterno.setTipo_informe_interno("Entrada"); 
			lstIIDet = new ArrayList<>();
			DetallePedidoDTO pedDet = new DetallePedidoDTO();
			pedDet.setCod_solicitudPedido(objInformeInterno.getCod_pedido()); 
			List<DetallePedidoDTO> lstDetPedido= objPedDetServ.listaPedidoXidPedido(pedDet);
			for (DetallePedidoDTO detallePedidoDTO : lstDetPedido) {
				InformeInternoDetalleDTO iiDet = new InformeInternoDetalleDTO();
				iiDet.setCod_detalle_pedido(detallePedidoDTO.getCod_detallePedido()); 
				lstIIDet.add(iiDet);
			} 
			objInfInterServ.registrar(objInformeInterno, lstIIDet);  
			this.mensaje = "Se ingreso correctamente el Informe Interno Entrada";
		} catch (Exception e) {
			System.out.println("Try:"+e);
			e.printStackTrace();
		} 
		return SUCCESS;
	} 
	@Action(value="/mainInformeInternoEntrada",results={@Result(name="success",type="tiles",location="d_maininformeinternoentrada")})
	public String mainInformeInternoEntrada(){ 
		lstArea = objAreaServ.listaArea();
		Object[] obj =  (Object[]) lasesion.get("DatosQR");
		if(obj!=null){
			if("Entrada".equals(obj[1])){
				codProd = (Integer) obj[0];
			} 
		} 
		return SUCCESS;
	}

	
	public Object getPedidos(Integer idProd){
		if(idProd!=null ){
//			objPedDetServ.listaPedidoXidPedido(det)
		}
		
		
		return null;
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



	public List<AreaDTO> getLstArea() {
		return lstArea;
	}



	public void setLstArea(List<AreaDTO> lstArea) {
		this.lstArea = lstArea;
	}



	public InformeInternoDTO getObjInformeInterno() {
		return objInformeInterno;
	}



	public void setObjInformeInterno(InformeInternoDTO objInformeInterno) {
		this.objInformeInterno = objInformeInterno;
	}
	
	
	
	
	
	
	
}
