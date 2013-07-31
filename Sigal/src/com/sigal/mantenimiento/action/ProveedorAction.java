/**
 * ProveedorAction 21/07/2013
 */
package com.sigal.mantenimiento.action;

import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.sigal.mantenimiento.bean.ProveedorDTO;
import com.sigal.mantenimiento.service.ProveedorService;
import com.sigal.util.Constantes;
import com.sigal.util.UtilSigal;

/**
 * @author Gustavo A. Correa C.
 *
 */
@ParentPackage("proy_calidad_SIGAL2")
public class ProveedorAction extends ActionSupport {
	ProveedorService objProServ = new ProveedorService();
	private ProveedorDTO objProveedor;
	private List<ProveedorDTO> lstProveedor;
	private String mensaje;
	private Integer rsult;
	private Integer codProvee;
	private Integer id;
	private Integer inicio;
	private Integer numeroPaginas;
	private Integer tagTipoListado;
	private Integer numeroPaginasModalProveedor;

	@Action(value = "/listarProveedorPag", results = { @Result(name = "success", location = "/paginas/mantenimientos/paginacion_proveedor.jsp") })
	public String listarProveedorPag() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA)
					- Constantes.FILAS_X_PAGINA;
		}
		try {  
			lstProveedor = objProServ.listaProveedorPaginado(comienzo, Constantes.FILAS_X_PAGINA);
			System.out.println("dddPaginacion:"+lstProveedor.size());
		} catch (Exception e) { 
			System.out.println(""+e.getMessage());
		}
		return SUCCESS;
	}

	@Action(value = "/mainProveedor", results = { @Result(name = "success", type = "tiles", location = "d_mainproveedor") })
	public String mainProveedor() {
		try {
			lstProveedor = objProServ.listaProveedorPaginado(0, Constantes.FILAS_X_PAGINA);
			this.numeroPaginas = UtilSigal.totalDePaginas(objProServ.listaProveedorTotal());
			this.tagTipoListado = 1;
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "/buscarProveedorXRazonSocialPag", results = { @Result(name = "success", location = "/paginas/mantenimientos/paginacion_proveedor.jsp") })
	public String buscarProveedorXRazonSocialPag() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA)
					- Constantes.FILAS_X_PAGINA;
		}
		try {
			lstProveedor = objProServ.buscarProveedorXDescPaginado(objProveedor,
					comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "/buscarProveedorXRazonSocial", results = { @Result(name = "success", type = "tiles", location = "d_mainproveedor") })
	public String buscarProveedorXRazonSocial() {
		try {
			lstProveedor = objProServ.buscarProveedorXDescPaginado(objProveedor, 0,
					Constantes.FILAS_X_PAGINA);
			this.numeroPaginas = UtilSigal.totalDePaginas(objProServ
					.buscarProveedorXDescTotal(objProveedor));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.tagTipoListado = 2;
		return SUCCESS;
	}

	@Action(value = "/accionProveedor", results = { @Result(name = "success", type = "tiles", location = "d_actuarproveedor") })
	public String accionProveedor() {
		if (this.codProvee != null) {
			ProveedorDTO provee = new ProveedorDTO();
			provee.setCod_proveedor(this.codProvee);
			try {
				this.objProveedor = objProServ.getProveedor(provee);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return SUCCESS;
	}

	@Action(value = "/eliminarProveedor", results = { @Result(name = "success", type = "tiles", location = "d_mainproveedor") })
	public String eliminarProveedor() {
		ProveedorDTO provee = new ProveedorDTO();
		provee.setCod_proveedor(this.codProvee);
		Boolean rsultado=false;
		try {
			rsultado = objProServ.eliminarProveedor(provee);
		}  
		catch (Exception  e ) { 
			e.printStackTrace();
		}
		if (rsultado) {
			this.rsult = 0;
			this.mensaje = "Se Elimino Correctamente";
		} else {
			this.rsult = 1;
			this.mensaje = "Ocurrio un Problema";
		}
		mainProveedor();
		return SUCCESS;
	}

	@Action(value = "/actuarProveedor", results = { @Result(name = "success", type = "tiles", location = "d_actuarproveedor") })
	public String actuarProveedor() { 
		Boolean rsultado = false;
		if(!"".equals(objProveedor.getRaz_social())){
			rsultado = true;
		}
		if(!"".equals(objProveedor.getCorreo())){
			rsultado = true;
		}
		try {
			if (objProveedor.getCod_proveedor() == null) {
				rsultado = objProServ.registrarProveedor(objProveedor);
			} else {
				rsultado = objProServ.actualizarProveedor(objProveedor);
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
	@Action(value = "/listarProveedorPagModal", results = { @Result(name = "success", location = "/paginas/mantenimientos/buscar_proveedor.jsp") })
	public String listarProveedorPagModal() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstProveedor = objProServ.listaProveedorPaginado(comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	} 
	@Action(value = "/buscarProveedorXRazonSocialPagModal", results = { @Result(name = "success", location = "/paginas/mantenimientos/buscar_proveedor.jsp") })
	public String buscarProveedorXRazonSocialPagModal() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstProveedor = objProServ.buscarProveedorXDescPaginado(objProveedor, comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	@Action(value = "/listarProveedorTotal", results = { @Result(name = "success", location = "/paginas/mantenimientos/proveedor_listado_total.jsp") })
	public String listarProveedorTotal() { 
		try {
			this.numeroPaginasModalProveedor = UtilSigal.totalDePaginas(objProServ.listaProveedorTotal());
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		return SUCCESS;
	}
	@Action(value = "/buscarProveedorTotal", results = { @Result(name = "success", location = "/paginas/mantenimientos/proveedor_buscar_total.jsp") })
	public String buscarProveedorTotal() { 
		try {
			this.numeroPaginasModalProveedor = UtilSigal.totalDePaginas(objProServ.buscarProveedorXDescTotal(objProveedor));
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return SUCCESS;
	} 
	
	
	
	public ProveedorDTO getObjProveedor() {
		return objProveedor;
	}

	public void setObjProveedor(ProveedorDTO objProveedor) {
		this.objProveedor = objProveedor;
	}

	public List<ProveedorDTO> getLstProveedor() {
		return lstProveedor;
	}

	public void setLstProveedor(List<ProveedorDTO> lstProveedor) {
		this.lstProveedor = lstProveedor;
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

	public Integer getCodProvee() {
		return codProvee;
	}

	public void setCodProvee(Integer codProvee) {
		this.codProvee = codProvee;
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

	public Integer getNumeroPaginasModalProveedor() {
		return numeroPaginasModalProveedor;
	}

	public void setNumeroPaginasModalProveedor(Integer numeroPaginasModalProveedor) {
		this.numeroPaginasModalProveedor = numeroPaginasModalProveedor;
	}

 
	
	
	
	
	
	
	
	
	
}
