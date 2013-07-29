/**
 * OrdenCompraAction 21/07/2013
 */
package com.sigal.ordencompra.action;

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
import com.sigal.ordencompra.bean.OrdenCompraDTO;
import com.sigal.ordencompra.bean.OrdenCompraDetalleDTO;
import com.sigal.ordencompra.service.OrdenCompraDetalleService;
import com.sigal.ordencompra.service.OrdenCompraService;
import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.util.Constantes;
import com.sigal.util.UtilSigal;

/**
 * @author Gustavo A. Correa C.
 *
 */
@ParentPackage("proy_calidad_SIGAL2")
public class OrdenCompraAction extends ActionSupport {

	Map<String, Object> lasesion = ActionContext.getContext().getSession(); 
	OrdenCompraService objOrdenCompraServ = new OrdenCompraService(); 
	OrdenCompraDetalleService objOrdenCompraDetalleServ = new OrdenCompraDetalleService(); 
	
	
	private OrdenCompraDTO objOrdenCompra;
	private String mensaje;
	private Integer inicio;
	private List<OrdenCompraDTO> lstOrdenCompra ;
	private List<OrdenCompraDetalleDTO> lstDetOC ;
	private Integer numeroPaginasModalOrdenCompra;
	
	@Action(value="/mainOrdenCompra",results={@Result(name="success",type="tiles",location="d_mainordencompra")})
	public String mainCotizacion(){
		lasesion.remove("lstDetCoti");
		return SUCCESS;
	} 
	@Action(value="/guardarOrdenCompra",results={@Result(name="success",location="/paginas/orden_compra/ordencompra_mensaje.jsp")})
	public String guardarOrdenCompra(){
		try {
			System.out.println("Guadrarr OC!"); 
			UsuarioDTO usuario =  (UsuarioDTO) lasesion.get("objUsuario");
			System.out.println("d1:"+usuario);
			System.out.println("d2:"+usuario.getCod_usuario());
			objOrdenCompra.setCod_usuario(usuario.getCod_usuario()); 
			lstDetOC = new ArrayList<>();
			List<CotizacionDetalleDTO> lstDetCotizacion = (List<CotizacionDetalleDTO>) lasesion.get("lstDetCoti"); 
			for (CotizacionDetalleDTO cotizacionDetalleDTO : lstDetCotizacion) {
				OrdenCompraDetalleDTO det = new OrdenCompraDetalleDTO();
				det.setCantidad(cotizacionDetalleDTO.getCant_detallecotizacion());
				det.setCod_producto_proveedor(cotizacionDetalleDTO.getCod_producto_proveedor());
				lstDetOC.add(det);
			}
			objOrdenCompraServ.registrarOrdenCompra(objOrdenCompra, lstDetOC);
			lasesion.remove("lstDetCoti");
			this.mensaje="Se guardo correctamente!";
		} catch (Exception e) {
			System.out.println("Try:"+e);
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	@Action(value = "/getDetalleOrdenCompra", results = { @Result(name = "success", location = "/paginas/orden_compra/detalle_orden_compra.jsp") })
	public String getDetalleOrdenCompra() { 
		try { 
			lstDetOC = new ArrayList<OrdenCompraDetalleDTO>();
			OrdenCompraDetalleDTO det = new OrdenCompraDetalleDTO();
			det.setCod_ordenCompra(objOrdenCompra.getCod_OrdenCompra()); 
			this.lstDetOC = objOrdenCompraDetalleServ.listaOrdenCompraXidOrdenCompra(det); 
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return SUCCESS;
	}
	//Modal
	@Action(value = "/listarOrdenCompraPagModal", results = { @Result(name = "success", location = "/paginas/orden_compra/buscar_orden_compra.jsp") })
	public String listarOrdenCompraPagModal() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		} 
		try {  
			lstOrdenCompra =   objOrdenCompraServ.listaOrdenCompraPaginado(comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (OrdenCompraDTO dd : lstOrdenCompra) {
			System.out.println("ee:"+dd.getCod_proveedor()+"|"+dd.getRaz_social());
		}
		return SUCCESS;
	} 
	@Action(value = "/buscarOrdenCompraPagModal", results = { @Result(name = "success", location = "/paginas/orden_compra/buscar_orden_compra.jsp") })
	public String buscarOrdenCompraPagModal() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstOrdenCompra = objOrdenCompraServ.buscarOrdenCompraPaginado(objOrdenCompra, comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	@Action(value = "/listarOrdenCompraTotal", results = { @Result(name = "success", location = "/paginas/orden_compra/orden_compra_listado_total.jsp") })
	public String listarOrdenCompraTotal() { 
		try {
			System.out.println("totla:"+objOrdenCompraServ.listaOrdenCompraTotal());
			this.numeroPaginasModalOrdenCompra= UtilSigal.totalDePaginas(objOrdenCompraServ.listaOrdenCompraTotal());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("nunmeroPaginas:"+numeroPaginasModalOrdenCompra); 
		return SUCCESS;
	}
	@Action(value = "/buscarOrdenCompraTotal", results = { @Result(name = "success", location = "/paginas/orden_compra/orden_compra_buscar_total.jsp") })
	public String buscarOrdenCompraTotal() { 
		try {
			System.out.println("total reg:"+objOrdenCompraServ.buscarOrdenCompraTotal(objOrdenCompra));
			this.numeroPaginasModalOrdenCompra= UtilSigal.totalDePaginas(objOrdenCompraServ.buscarOrdenCompraTotal(objOrdenCompra));
			System.out.println("total paginas:"+numeroPaginasModalOrdenCompra);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return SUCCESS;
	}
	public OrdenCompraDTO getObjOrdenCompra() {
		return objOrdenCompra;
	}
	public void setObjOrdenCompra(OrdenCompraDTO objOrdenCompra) {
		this.objOrdenCompra = objOrdenCompra;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public Integer getInicio() {
		return inicio;
	}
	public void setInicio(Integer inicio) {
		this.inicio = inicio;
	}
	public List<OrdenCompraDTO> getLstOrdenCompra() {
		return lstOrdenCompra;
	}
	public void setLstOrdenCompra(List<OrdenCompraDTO> lstOrdenCompra) {
		this.lstOrdenCompra = lstOrdenCompra;
	}
	public List<OrdenCompraDetalleDTO> getLstDetOC() {
		return lstDetOC;
	}
	public void setLstDetOC(List<OrdenCompraDetalleDTO> lstDetOC) {
		this.lstDetOC = lstDetOC;
	}
	public Integer getNumeroPaginasModalOrdenCompra() {
		return numeroPaginasModalOrdenCompra;
	}
	public void setNumeroPaginasModalOrdenCompra(
			Integer numeroPaginasModalOrdenCompra) {
		this.numeroPaginasModalOrdenCompra = numeroPaginasModalOrdenCompra;
	}
	
	
	
	
	
	
	
	
	
	
}
