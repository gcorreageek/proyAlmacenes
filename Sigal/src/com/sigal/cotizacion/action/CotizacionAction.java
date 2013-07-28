/**
 * Cotizacion 21/07/2013
 */
package com.sigal.cotizacion.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sigal.cotizacion.bean.CotizacionDTO;
import com.sigal.cotizacion.bean.CotizacionDetalleDTO;
import com.sigal.cotizacion.service.CotizacionService;
import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.mantenimiento.bean.ProductoProveedorDTO;
import com.sigal.mantenimiento.service.ProductoProveedorService;
import com.sigal.mantenimiento.service.ProductoService;
import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.pedido.bean.SolicitudPedidoDTO;
import com.sigal.pedido.dao.PedidoDetalleDAO;
import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.util.UtilSigal;

/**
 * @author Gustavo A. Correa C.
 *
 */
@ParentPackage("proy_calidad_SIGAL2")
public class CotizacionAction extends ActionSupport {

	private Map<String, Object> lasesion = ActionContext.getContext().getSession(); 
	private List<CotizacionDetalleDTO> lstDetCoti ;
	CotizacionService objCotizacionServ = new CotizacionService();
	ProductoService objProductoServ = new ProductoService(); 
	ProductoProveedorService objProdProveeServ = new ProductoProveedorService();
//	idProd cantidad
	private Integer idProd;
	private Integer cantidad;
	private CotizacionDTO objCotizacion;
	private String mensaje;
	
	
	@Action(value="/mainCotizacion",results={@Result(name="success",type="tiles",location="d_maincotizacion")})
	public String mainCotizacion(){ 
		lasesion.remove("lstDetCoti");
		return SUCCESS;
	}
	@Action(value="/agregarDetalleCotizacion",results={@Result(name="success",location="/paginas/cotizacion/detalle_cotizacion.jsp")})
	public String agregarDetallePedido(){
		lstDetCoti = (List<CotizacionDetalleDTO>) lasesion.get("lstDetCoti");
		
		CotizacionDetalleDTO objDetalle = new CotizacionDetalleDTO(); 
		ProductoProveedorDTO prodProvee = new ProductoProveedorDTO();
		prodProvee.setCod_producto(getIdProd());
		prodProvee.setCod_proveedor(objCotizacion.getCod_proveedor());
		
		try {
			prodProvee = objProdProveeServ.getProductoProveedorIdProdAndIdProvee(prodProvee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		objDetalle.setCod_producto_proveedor(prodProvee.getCod_producto_proveedor());
		objDetalle.setCod_producto(getIdProd());
		objDetalle.setDesc_producto(prodProvee.getDesc_producto());
		objDetalle.setUnidadMedida(prodProvee.getUnidadMedida());
		objDetalle.setCant_detallecotizacion(getCantidad());
		if(lstDetCoti==null){
			lstDetCoti = new ArrayList<CotizacionDetalleDTO>();
		}
		
		lstDetCoti.add(objDetalle);
		for (CotizacionDetalleDTO cot : lstDetCoti) {
			System.out.println("mamachota:"+cot.getDesc_producto());
		}
		lasesion.put("lstDetCoti", lstDetCoti);
		return SUCCESS;
	}
//	eliminarDetalleCotizacion
	@Action(value="/eliminarDetalleCotizacion",results={@Result(name="success",location="/paginas/cotizacion/detalle_cotizacion.jsp")})
	public String eliminarDetalleCotizacion(){
		lstDetCoti = (List<CotizacionDetalleDTO>) lasesion.get("lstDetCoti");
		for (int i = 0; i < lstDetCoti.size(); i++) { 
			CotizacionDetalleDTO det = lstDetCoti.get(i); 
			if(det.getCod_producto().equals(getIdProd())){
				lstDetCoti.remove(i);
			}
		}  
		lasesion.put("lstDetCoti", lstDetCoti);
		return SUCCESS;
	}
	@Action(value="/guardarCotizacion",results={@Result(name="success",location="/paginas/cotizacion/cotizacion_mensaje.jsp")})
	public String guardarCotizacion(){
		try {
			System.out.println("Guadrarr!"); 
			UsuarioDTO usuario =  (UsuarioDTO) lasesion.get("objUsuario");
			objCotizacion.setCod_usuario(usuario.getCod_usuario()); 
			lstDetCoti = (ArrayList<CotizacionDetalleDTO>) lasesion.get("lstDetCoti"); 
			
			objCotizacionServ.registrarCotizacion(objCotizacion, lstDetCoti);
			lasesion.remove("lstDetCoti");
			this.mensaje="Se guardo correctamente!";
		} catch (Exception e) {
			System.out.println("Try:"+e);
			e.printStackTrace();
		}
		
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
	public CotizacionDTO getObjCotizacion() {
		return objCotizacion;
	}
	public void setObjCotizacion(CotizacionDTO objCotizacion) {
		this.objCotizacion = objCotizacion;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public List<CotizacionDetalleDTO> getLstDetCoti() {
		return lstDetCoti;
	}
	public void setLstDetCoti(List<CotizacionDetalleDTO> lstDetCoti) {
		this.lstDetCoti = lstDetCoti;
	} 

	
	
}
