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
import com.sigal.cotizacion.service.CotizacionDetalleService;
import com.sigal.cotizacion.service.CotizacionService;
import com.sigal.mantenimiento.bean.ProductoProveedorDTO;
import com.sigal.mantenimiento.service.ProductoProveedorService;
import com.sigal.mantenimiento.service.ProductoService;
import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.util.Constantes;
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
	CotizacionDetalleService objCotizacionDetalleServ = new CotizacionDetalleService();
	ProductoService objProductoServ = new ProductoService(); 
	ProductoProveedorService objProdProveeServ = new ProductoProveedorService();
//	idProd cantidad
	private Integer idProd;
	private Integer cantidad;
	private CotizacionDTO objCotizacion;
	private Integer rsult;
	private String mensaje;
	private Integer inicio;
	private List<CotizacionDTO> lstCotizacion ;
	private Integer numeroPaginasModalCotizacion;
	
	@Action(value="/mainCotizacion",results={@Result(name="success",type="tiles",location="d_maincotizacion")})
	public String mainCotizacion(){ 
		lasesion.remove("lstDetCoti");
		return SUCCESS;
	}
	@Action(value="/agregarDetalleCotizacion",results={
			@Result(name="error",location="/paginas/cotizacion/detalle_cotizacion.jsp"),
			@Result(name="success",location="/paginas/cotizacion/detalle_cotizacion.jsp")})
	public String agregarDetallePedido(){
		lstDetCoti = (List<CotizacionDetalleDTO>) lasesion.get("lstDetCoti");
		
		CotizacionDetalleDTO objDetalle = new CotizacionDetalleDTO(); 
		ProductoProveedorDTO prodProvee = new ProductoProveedorDTO();
		prodProvee.setCod_producto(getIdProd());
		prodProvee.setCod_proveedor(objCotizacion.getCod_proveedor());
		
		try {
			prodProvee = objProdProveeServ.getProductoProveedorIdProdAndIdProvee(prodProvee);
		} catch (Exception e) { 
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
		for (CotizacionDetalleDTO prod2 : lstDetCoti) {
			if(prod2.getCod_producto().equals(getIdProd())){
				this.rsult=0;
				this.mensaje="Producto ya existe!";
				return ERROR;
			}
		}
		lstDetCoti.add(objDetalle); 
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
			if(objCotizacion.getCod_proveedor()==null){
				this.rsult=0;
				this.mensaje="Agregar Proveedor";
				return SUCCESS;
			}
			lstDetCoti = (ArrayList<CotizacionDetalleDTO>) lasesion.get("lstDetCoti"); 
			if(lstDetCoti==null){
				this.rsult=0;
				this.mensaje="Agregar detalle";
				return SUCCESS;
			}
			objCotizacionServ.registrarCotizacion(objCotizacion, lstDetCoti);
			lasesion.remove("lstDetCoti");
			this.rsult=1;
			this.mensaje="Se guardo correctamente!";
		} catch (Exception e) {
			System.out.println("Try:"+e);
			e.printStackTrace();
			this.rsult=0;
			this.mensaje="Ocurrio un error al Grabar";
		} 
		return SUCCESS;
	}
	@Action(value = "/getDetalleCotizacion", results = { @Result(name = "success", location = "/paginas/cotizacion/detalle_cotizacion.jsp") })
	public String getDetalleCotizacion() { 
		try {
			lstDetCoti = (List<CotizacionDetalleDTO>) lasesion.get("lstDetCoti");
			if(lstDetCoti==null){
				lstDetCoti = new ArrayList<CotizacionDetalleDTO>();
			}
			CotizacionDetalleDTO det = new CotizacionDetalleDTO();
			det.setCod_cotizacion(getObjCotizacion().getCod_cotizacion()); 
			this.lstDetCoti = objCotizacionDetalleServ.listaCotizacionXidCotizacion(det);
			lasesion.put("lstDetCoti", lstDetCoti); 
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return SUCCESS;
	}
	//Modal
	@Action(value = "/listarCotizacionPagModal", results = { @Result(name = "success", location = "/paginas/cotizacion/buscar_cotizacion.jsp") })
	public String listarCotizacionPagModal() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		} 
		try {  
			lstCotizacion =   objCotizacionServ.listaCotizacionPaginado(comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (CotizacionDTO dd : lstCotizacion) {
			System.out.println("ee:"+dd.getCod_proveedor()+"|"+dd.getRaz_social());
		}
		return SUCCESS;
	} 
	@Action(value = "/buscarCotizacionPagModal", results = { @Result(name = "success", location = "/paginas/cotizacion/buscar_cotizacion.jsp") })
	public String buscarCotizacionPagModal() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstCotizacion = objCotizacionServ.buscarCotizacionPaginado(objCotizacion, comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	@Action(value = "/listarCotizacionTotal", results = { @Result(name = "success", location = "/paginas/cotizacion/cotizacion_listado_total.jsp") })
	public String listarCotizacionTotal() { 
		try {
			System.out.println("totla:"+objCotizacionServ.listaCotizacionTotal());
			this.numeroPaginasModalCotizacion= UtilSigal.totalDePaginas(objCotizacionServ.listaCotizacionTotal());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("nunmeroPaginas:"+numeroPaginasModalCotizacion); 
		return SUCCESS;
	}
	@Action(value = "/buscarCotizacionTotal", results = { @Result(name = "success", location = "/paginas/cotizacion/cotizacion_buscar_total.jsp") })
	public String buscarCotizacionTotal() { 
		try {
			System.out.println("total reg:"+objCotizacionServ.buscarCotizacionTotal(objCotizacion));
			this.numeroPaginasModalCotizacion= UtilSigal.totalDePaginas(objCotizacionServ.buscarCotizacionTotal(objCotizacion));
			System.out.println("total paginas:"+numeroPaginasModalCotizacion);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
	public Integer getInicio() {
		return inicio;
	}
	public void setInicio(Integer inicio) {
		this.inicio = inicio;
	}
	public List<CotizacionDTO> getLstCotizacion() {
		return lstCotizacion;
	}
	public void setLstCotizacion(List<CotizacionDTO> lstCotizacion) {
		this.lstCotizacion = lstCotizacion;
	}
	public Integer getNumeroPaginasModalCotizacion() {
		return numeroPaginasModalCotizacion;
	}
	public void setNumeroPaginasModalCotizacion(Integer numeroPaginasModalCotizacion) {
		this.numeroPaginasModalCotizacion = numeroPaginasModalCotizacion;
	}
	public Integer getRsult() {
		return rsult;
	}
	public void setRsult(Integer rsult) {
		this.rsult = rsult;
	} 

	
	
}
