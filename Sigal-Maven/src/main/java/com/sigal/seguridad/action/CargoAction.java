/**
 * CargoAction 30/07/2013
 */
package com.sigal.seguridad.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sigal.seguridad.bean.AreaDTO;
import com.sigal.seguridad.bean.CargoDTO;
import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.seguridad.service.AreaService;
import com.sigal.seguridad.service.CargoService;
import com.sigal.util.Constantes;
import com.sigal.util.UtilSigal;

/**
 * @author Gustavo A. Correa C.
 *
 */
@ParentPackage("Sigal-Maven")
public class CargoAction extends ActionSupport {
	private final Map<String, Object> lasesion = ActionContext.getContext().getSession();
	private final Log log = LogFactory.getLog(getClass());
	CargoService objCargoServ = new CargoService();
	AreaService objAreaServ = new AreaService();
	
	private CargoDTO objCargo;
	private List<CargoDTO> lstCargo;
	private List<AreaDTO> lstArea = new ArrayList<AreaDTO>();
	private String mensaje;
	private Integer rsult;
	private Integer codCargo;
	private Integer id;
	private Integer inicio;
	private Integer numeroPaginas;
	private Integer tagTipoListado;
	private Integer numeroPaginasModalCargo;

	@Action(value="/mainCargo",results={@Result(name="success",type="tiles",location="d_maincargo")})
	public String mainCargo(){ 
		try {
			lstCargo = objCargoServ.listaCargoPaginado(0, Constantes.FILAS_X_PAGINA);
			this.numeroPaginas = UtilSigal.totalDePaginas(objCargoServ.listaCargoTotal());
			this.tagTipoListado = 1;
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return SUCCESS; 
	} 
	@Action(value = "/listarCargoPag", results = { @Result(name = "success", location = "/paginas/mantenimientos/paginacion_cargo.jsp") })
	public String listarCargoPag() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA)
					- Constantes.FILAS_X_PAGINA;
		}
		try {  
			lstCargo = objCargoServ.listaCargoPaginado(comienzo, Constantes.FILAS_X_PAGINA);
			System.out.println("dddPaginacion:"+lstCargo.size());
		} catch (Exception e) { 
			System.out.println(""+e.getMessage());
		}
		return SUCCESS;
	}
 

	@Action(value = "/buscarCargoXDesc_cargoPag", results = { @Result(name = "success", location = "/paginas/mantenimientos/paginacion_cargo.jsp") })
	public String buscarCargoXDesc_cargoPag() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA)- Constantes.FILAS_X_PAGINA;
		}
		try {
			lstCargo = objCargoServ.buscarCargoXDescPaginado(objCargo,comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "/buscarCargoXDesc_cargo", results = { @Result(name = "success", type = "tiles", location = "d_maincargo") })
	public String buscarCargoXDesc_cargo() {
		try {
			lstCargo = objCargoServ.buscarCargoXDescPaginado(objCargo, 0,
					Constantes.FILAS_X_PAGINA);
			this.numeroPaginas = UtilSigal.totalDePaginas(objCargoServ
					.buscarCargoXDescTotal(objCargo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.tagTipoListado = 2;
		return SUCCESS;
	}

	@Action(value = "/accionCargo", results = { @Result(name = "success", type = "tiles", location = "d_actuarcargo") })
	public String accionCargo() { 
		lstArea = objAreaServ.listaArea(); 
		if (this.codCargo != null) {  
			try {
				this.objCargo = objCargoServ.getCargo(this.codCargo);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		return SUCCESS;
	}

	@Action(value = "/eliminarCargo", results = { @Result(name = "success", type = "tiles", location = "d_maincargo") })
	public String eliminarCargo() {
		UsuarioDTO usuario =  (UsuarioDTO) lasesion.get("objUsuario");
		if(usuario!=null){
			CargoDTO provee = new CargoDTO();
			provee.setCod_cargo(this.codCargo);
			Boolean rsultado=false;
			try {
				rsultado = objCargoServ.eliminarCargo(provee);
			} catch (Exception  e ) {  
				e.printStackTrace();
			}
			if (rsultado) {
				this.rsult = 0;
				this.mensaje = "Se Elimino Correctamente";
			} else {
				this.rsult = 1;
				this.mensaje = "Ocurrio un Problema";
			}
			mainCargo();
		} 
		return SUCCESS;
	}

	@Action(value = "/actuarCargo", results = { @Result(name = "success", type = "tiles", location = "d_actuarcargo") })
	public String actuarCargo() {
		lstArea = objAreaServ.listaArea(); 
		Boolean rsultado = false;
		objCargo.setDesc_cargo(objCargo.getDesc_cargo().trim());
		if(!"".equals(objCargo.getDesc_cargo())){
			rsultado=true;
		}
		if(rsultado){
			try {
				if (objCargo.getCod_cargo() == null) {
					rsultado = objCargoServ.registrarCargo(objCargo);
				} else {
					rsultado = objCargoServ.actualizarCargo(objCargo);
				}
			} catch (Exception e) {
				rsultado=false;
				e.printStackTrace();
			}	
		}
		
		if (rsultado) {
			this.rsult = 0;
			this.mensaje = "Todo Correctamente";
		} else {
			this.rsult = 1;
			this.mensaje = "Ocurrio un Problema";
		}

		return SUCCESS;
	}

	//Modal
	@Action(value = "/listarCargoPagModal", results = { @Result(name = "success", location = "/paginas/mantenimientos/buscar_cargo.jsp") })
	public String listarCargoPagModal() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstCargo = objCargoServ.listaCargoPaginado(comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	} 
	@Action(value = "/buscarCargoXDesc_cargoPagModal", results = { @Result(name = "success", location = "/paginas/mantenimientos/buscar_cargo.jsp") })
	public String buscarCargoXRazonSocialPagModal() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstCargo = objCargoServ.buscarCargoXDescPaginado(objCargo, comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	@Action(value = "/listarCargoTotal", results = { @Result(name = "success", location = "/paginas/mantenimientos/cargo_listado_total.jsp") })
	public String listarCargoTotal() { 
		try {
			this.numeroPaginasModalCargo = UtilSigal.totalDePaginas(objCargoServ.listaCargoTotal());
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		return SUCCESS;
	}
	@Action(value = "/buscarCargoTotal", results = { @Result(name = "success", location = "/paginas/mantenimientos/cargo_buscar_total.jsp") })
	public String buscarCargoTotal() { 
		try {
			this.numeroPaginasModalCargo = UtilSigal.totalDePaginas(objCargoServ.buscarCargoXDescTotal(objCargo));
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return SUCCESS;
	}






	public CargoDTO getObjCargo() {
		return objCargo;
	}

	public void setObjCargo(CargoDTO objCargo) {
		this.objCargo = objCargo;
	}

	public List<CargoDTO> getLstCargo() {
		return lstCargo;
	}

	public void setLstCargo(List<CargoDTO> lstCargo) {
		this.lstCargo = lstCargo;
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

	public Integer getCodCargo() {
		return codCargo;
	}

	public void setCodCargo(Integer codCargo) {
		this.codCargo = codCargo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInicio() {
		return inicio;
	}

	public void setInicio(Integer inicio) {
		this.inicio = inicio;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public Integer getTagTipoListado() {
		return tagTipoListado;
	}

	public void setTagTipoListado(Integer tagTipoListado) {
		this.tagTipoListado = tagTipoListado;
	}

	public Integer getNumeroPaginasModalCargo() {
		return numeroPaginasModalCargo;
	}

	public void setNumeroPaginasModalCargo(Integer numeroPaginasModalCargo) {
		this.numeroPaginasModalCargo = numeroPaginasModalCargo;
	}
	public List<AreaDTO> getLstArea() {
		return lstArea;
	}
	public void setLstArea(List<AreaDTO> lstArea) {
		this.lstArea = lstArea;
	}
	
	
	
	
}
