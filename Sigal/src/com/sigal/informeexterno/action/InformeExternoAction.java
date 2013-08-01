/**
 * InformeExternoAction 22/07/2013
 */
package com.sigal.informeexterno.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sigal.informeexterno.bean.InformeExternoDTO;
import com.sigal.informeexterno.bean.InformeExternoDetalleDTO;
import com.sigal.informeexterno.service.InformeExternoService;
import com.sigal.ordencompra.bean.OrdenCompraDetalleDTO;
import com.sigal.ordencompra.service.OrdenCompraDetalleService;
import com.sigal.seguridad.bean.UsuarioDTO;

/**
 * @author Gustavo A. Correa C.
 *
 */
@ParentPackage("proy_calidad_SIGAL2")
public class InformeExternoAction extends ActionSupport  { 
	InformeExternoService objInfExternoServ = new InformeExternoService();
//	ProductoService objProdServ = new ProductoService();
	OrdenCompraDetalleService objOCDetServ = new OrdenCompraDetalleService();
//	ProductoDTO objProducto;
//	AreaService objAreaServ = new AreaService();
	 
	Map<String, Object> lasesion = ActionContext.getContext().getSession(); 
	List<InformeExternoDetalleDTO> lstIEDet;
	
//	private Integer codProd;
	private String mensaje;
//	private Integer rsult;
	private InformeExternoDTO objInformeExterno;
	
	
	@Action(value="/mainInformeExternoEntrada",results={@Result(name="success",type="tiles",location="d_maininformeexternoentrada")})
	public String mainInformeExternoEntrada(){ 
		return SUCCESS;
	}
	@Action(value="/mainInformeExternoSalida",results={@Result(name="success",type="tiles",location="d_maininformeexternosalida")})
	public String mainInformeExternoSalida(){ 
		return SUCCESS;
	}
	
//	guardarIEE
	@Action(value="/guardarIEE",results={@Result(name="success",location="/paginas/pedido/pedido_evaluacion_mensaje.jsp")})
	public String guardarIEE(){
		try {
			UsuarioDTO usuario =  (UsuarioDTO) lasesion.get("objUsuario");
			objInformeExterno.setCod_usuario(usuario.getCod_usuario()); 
			objInformeExterno.setTipo_informe_externo("Entrada");
			lstIEDet = new ArrayList<InformeExternoDetalleDTO>();
			OrdenCompraDetalleDTO ocDet = new OrdenCompraDetalleDTO();
			ocDet.setCod_ordenCompra(objInformeExterno.getCod_ordencompra()); 
			List<OrdenCompraDetalleDTO> lstDetOC= objOCDetServ.listaOrdenCompraXidOrdenCompra(ocDet);
			for (OrdenCompraDetalleDTO detalleOCDTO : lstDetOC) {
				InformeExternoDetalleDTO ieDet = new InformeExternoDetalleDTO(); 
				ieDet.setCod_detalle_ordencompra(detalleOCDTO.getCod_DetalleOrdenCompra());
				lstIEDet.add(ieDet);
			} 
			objInfExternoServ.registrarOrdenCompra(objInformeExterno, lstIEDet);  
			this.mensaje = "Se ingreso correctamente el Informe Externo Entrada";
		} catch (Exception e) {
			System.out.println("Try:"+e);
			e.printStackTrace();
		} 
		return SUCCESS;
	}
	
	@Action(value="/guardarIES",results={@Result(name="success",location="/paginas/pedido/pedido_evaluacion_mensaje.jsp")})
	public String guardarIES(){
		try {
			UsuarioDTO usuario =  (UsuarioDTO) lasesion.get("objUsuario");
			objInformeExterno.setCod_usuario(usuario.getCod_usuario()); 
			objInformeExterno.setTipo_informe_externo("Salida");
			lstIEDet = new ArrayList<>();
			OrdenCompraDetalleDTO ocDet = new OrdenCompraDetalleDTO();
			ocDet.setCod_ordenCompra(objInformeExterno.getCod_ordencompra()); 
			List<OrdenCompraDetalleDTO> lstDetOC= objOCDetServ.listaOrdenCompraXidOrdenCompra(ocDet);
			for (OrdenCompraDetalleDTO detalleOCDTO : lstDetOC) {
				InformeExternoDetalleDTO ieDet = new InformeExternoDetalleDTO(); 
				ieDet.setCod_detalle_ordencompra(detalleOCDTO.getCod_DetalleOrdenCompra());
				lstIEDet.add(ieDet);
			} 
			objInfExternoServ.registrarOrdenCompra(objInformeExterno, lstIEDet);  
			this.mensaje = "Se ingreso correctamente el Informe Externo Salida";
		} catch (Exception e) {
			System.out.println("Try:"+e);
			e.printStackTrace();
		} 
		return SUCCESS;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public InformeExternoDTO getObjInformeExterno() {
		return objInformeExterno;
	}

	public void setObjInformeExterno(InformeExternoDTO objInformeExterno) {
		this.objInformeExterno = objInformeExterno;
	}
	
	
}
