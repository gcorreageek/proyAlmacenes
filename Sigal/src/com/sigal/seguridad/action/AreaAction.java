/**
 * AreaAction 30/07/2013
 */
package com.sigal.seguridad.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.sigal.seguridad.bean.AreaDTO;
import com.sigal.seguridad.service.AreaService;
import com.sigal.util.Constantes;
import com.sigal.util.UtilSigal;

/**
 * @author Gustavo A. Correa C.
 *
 */
@ParentPackage("proy_calidad_SIGAL2")
public class AreaAction extends ActionSupport {
	AreaService objAreaServ = new AreaService();
	
	private AreaDTO objArea;
	private List<AreaDTO> lstArea;
	private String mensaje;
	private Integer rsult;
	private Integer codArea;
	private Integer id;
	private Integer inicio;
	private Integer numeroPaginas;
	private Integer tagTipoListado;
	private Integer numeroPaginasModalArea;
	

	@Action(value="/mainArea",results={@Result(name="success",type="tiles",location="d_mainarea")})
	public String mainArea(){ 
		try {
			lstArea = objAreaServ.listaAreaPaginado(0, Constantes.FILAS_X_PAGINA);
			this.numeroPaginas = UtilSigal.totalDePaginas(objAreaServ.listaAreaTotal());
			this.tagTipoListado = 1;
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return SUCCESS; 
	} 
	@Action(value = "/listarAreaPag", results = { @Result(name = "success", location = "/paginas/mantenimientos/paginacion_area.jsp") })
	public String listarAreaPag() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA)
					- Constantes.FILAS_X_PAGINA;
		}
		try {  
			lstArea = objAreaServ.listaAreaPaginado(comienzo, Constantes.FILAS_X_PAGINA);
			System.out.println("dddPaginacion:"+lstArea.size());
		} catch (Exception e) { 
			System.out.println(""+e.getMessage());
		}
		return SUCCESS;
	}
 

	@Action(value = "/buscarAreaXDesc_areaPag", results = { @Result(name = "success", location = "/paginas/mantenimientos/paginacion_area.jsp") })
	public String buscarAreaXDesc_areaPag() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA)- Constantes.FILAS_X_PAGINA;
		}
		try {
			lstArea = objAreaServ.buscarAreaXDescPaginado(objArea,comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "/buscarAreaXDesc_area", results = { @Result(name = "success", type = "tiles", location = "d_mainarea") })
	public String buscarAreaXDesc_area() {
		try {
			lstArea = objAreaServ.buscarAreaXDescPaginado(objArea, 0,
					Constantes.FILAS_X_PAGINA);
			this.numeroPaginas = UtilSigal.totalDePaginas(objAreaServ
					.buscarAreaXDescTotal(objArea));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.tagTipoListado = 2;
		return SUCCESS;
	}

	@Action(value = "/accionArea", results = { @Result(name = "success", type = "tiles", location = "d_actuararea") })
	public String accionArea() {
		System.out.println("cod:"+codArea);
		if (this.codArea != null) { 
			System.out.println("codArea:"+codArea);
			try {
				this.objArea = objAreaServ.getArea(this.codArea);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		System.out.println("dd:"+objArea.getDesc_area());
		return SUCCESS;
	}

	@Action(value = "/eliminarArea", results = { @Result(name = "success", type = "tiles", location = "d_mainarea") })
	public String eliminarArea() {
		AreaDTO provee = new AreaDTO();
		provee.setCod_area(this.codArea);
		Boolean rsultado=false;
		try {
			rsultado = objAreaServ.eliminarArea(provee);
		}  
		catch (Exception  e ) { 
//			System.out.println("toda:"+e.getMessage());
			SQLException sqle = (SQLException) e;
			System.out.println("te llegooo!");
			System.out.println("vamos peru1:"+sqle.getErrorCode());
			System.out.println("vamos peru2:"+sqle.getMessage());
			System.out.println("vamos peru3:"+sqle.getSQLState());
			System.out.println("es de aca"+e);
		}
		if (rsultado) {
			this.rsult = 0;
			this.mensaje = "Se Elimino Correctamente";
		} else {
			this.rsult = 1;
			this.mensaje = "Ocurrio un Problema";
		}
		mainArea();
		return SUCCESS;
	}

	@Action(value = "/actuarArea", results = { @Result(name = "success", type = "tiles", location = "d_actuararea") })
	public String actuarArea() {
		System.out.println("accc");
		Boolean rsultado = false;
		try {
			if (objArea.getCod_area() == null) {
				rsultado = objAreaServ.registrarArea(objArea);
			} else {
				rsultado = objAreaServ.actualizarArea(objArea);
			}
		} catch (Exception e) {
			e.printStackTrace();
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
	@Action(value = "/listarAreaPagModal", results = { @Result(name = "success", location = "/paginas/mantenimientos/buscar_area.jsp") })
	public String listarAreaPagModal() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstArea = objAreaServ.listaAreaPaginado(comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	} 
	@Action(value = "/buscarAreaXDesc_areaPagModal", results = { @Result(name = "success", location = "/paginas/mantenimientos/buscar_area.jsp") })
	public String buscarAreaXRazonSocialPagModal() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstArea = objAreaServ.buscarAreaXDescPaginado(objArea, comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	@Action(value = "/listarAreaTotal", results = { @Result(name = "success", location = "/paginas/mantenimientos/area_listado_total.jsp") })
	public String listarAreaTotal() { 
		try {
			this.numeroPaginasModalArea = UtilSigal.totalDePaginas(objAreaServ.listaAreaTotal());
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		return SUCCESS;
	}
	@Action(value = "/buscarAreaTotal", results = { @Result(name = "success", location = "/paginas/mantenimientos/area_buscar_total.jsp") })
	public String buscarAreaTotal() { 
		try {
			this.numeroPaginasModalArea = UtilSigal.totalDePaginas(objAreaServ.buscarAreaXDescTotal(objArea));
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return SUCCESS;
	}






	public AreaDTO getObjArea() {
		return objArea;
	}

	public void setObjArea(AreaDTO objArea) {
		this.objArea = objArea;
	}

	public List<AreaDTO> getLstArea() {
		return lstArea;
	}

	public void setLstArea(List<AreaDTO> lstArea) {
		this.lstArea = lstArea;
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

	public Integer getCodArea() {
		return codArea;
	}

	public void setCodArea(Integer codArea) {
		this.codArea = codArea;
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

	public Integer getNumeroPaginasModalArea() {
		return numeroPaginasModalArea;
	}

	public void setNumeroPaginasModalArea(Integer numeroPaginasModalArea) {
		this.numeroPaginasModalArea = numeroPaginasModalArea;
	}
	
}
