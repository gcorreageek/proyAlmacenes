/**
 * UsuarioAction 30/07/2013
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
import com.sigal.seguridad.service.UsuarioService;
import com.sigal.util.Constantes;
import com.sigal.util.UtilSigal;

/**
 * @author Gustavo A. Correa C.
 *
 */
@ParentPackage("Sigal-Maven")
public class UsuarioAction extends ActionSupport {
	private final Map<String, Object> lasesion = ActionContext.getContext().getSession();
	private final Log log = LogFactory.getLog(getClass());
	UsuarioService objUsuarioServ = new UsuarioService();
	AreaService objAreaServ = new AreaService();
	CargoService objCargoServ = new CargoService();
	private UsuarioDTO objUsuario;
	private List<UsuarioDTO> lstUsuario;
	private String mensaje;
	private Integer rsult;
	private Integer codUsuario;
	private Integer id;
	private Integer inicio;
	private Integer numeroPaginas;
	private Integer tagTipoListado;
	private Integer numeroPaginasModalUsuario;
	private List<AreaDTO> lstArea = new ArrayList<AreaDTO>();
	private List<CargoDTO> lstCargo = new ArrayList<CargoDTO>(); 
	

	@Action(value="/mainUsuario",results={@Result(name="success",type="tiles",location="d_mainusuario")})
	public String mainUsuario(){ 
		try {
			lstUsuario = objUsuarioServ.listaUsuarioPaginado(0, Constantes.FILAS_X_PAGINA);
			this.numeroPaginas = UtilSigal.totalDePaginas(objUsuarioServ.listaUsuarioTotal());
			this.tagTipoListado = 1;
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return SUCCESS; 
	} 
	@Action(value = "/listarUsuarioPag", results = { @Result(name = "success", location = "/paginas/mantenimientos/paginacion_usuario.jsp") })
	public String listarUsuarioPag() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA)
					- Constantes.FILAS_X_PAGINA;
		}
		try {  
			lstUsuario = objUsuarioServ.listaUsuarioPaginado(comienzo, Constantes.FILAS_X_PAGINA);
			System.out.println("dddPaginacion:"+lstUsuario.size());
		} catch (Exception e) { 
			System.out.println(""+e.getMessage());
		}
		return SUCCESS;
	}
 

	@Action(value = "/buscarUsuarioXDesc_usuarioPag", results = { @Result(name = "success", location = "/paginas/mantenimientos/paginacion_usuario.jsp") })
	public String buscarUsuarioXDesc_usuarioPag() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA)- Constantes.FILAS_X_PAGINA;
		}
		try {
			lstUsuario = objUsuarioServ.buscarUsuarioXDescPaginado(objUsuario,comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Action(value = "/buscarUsuarioXDesc_usuario", results = { @Result(name = "success", type = "tiles", location = "d_mainusuario") })
	public String buscarUsuarioXDesc_usuario() {
		try {
			lstUsuario = objUsuarioServ.buscarUsuarioXDescPaginado(objUsuario, 0,
					Constantes.FILAS_X_PAGINA);
			this.numeroPaginas = UtilSigal.totalDePaginas(objUsuarioServ
					.buscarUsuarioXDescTotal(objUsuario));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.tagTipoListado = 2;
		return SUCCESS;
	}

	@Action(value = "/accionUsuario", results = { @Result(name = "success", type = "tiles", location = "d_actuarusuario") })
	public String accionUsuario() {
		System.out.println("cod:" + codUsuario);
		try {
			lstArea = objAreaServ.listaArea(); 
			if (this.codUsuario != null) {
				System.out.println("codUsuario:" + codUsuario);
				this.objUsuario = objUsuarioServ.getUsuario(this.codUsuario);
				objUsuario.setPass_usuario("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return SUCCESS;
	}

	@Action(value = "/eliminarUsuario", results = { @Result(name = "success", type = "tiles", location = "d_mainusuario") })
	public String eliminarUsuario() {
		UsuarioDTO usuario =  (UsuarioDTO) lasesion.get("objUsuario");
		if(usuario!=null){
			UsuarioDTO provee = new UsuarioDTO();
			provee.setCod_usuario(this.codUsuario);
			Boolean rsultado=false;
			try {
				rsultado = objUsuarioServ.eliminarUsuario(provee);
			}catch (Exception  e ) { 
				e.printStackTrace();
			}
			if (rsultado) {
				this.rsult = 0;
				this.mensaje = "Se Elimino Correctamente";
			} else {
				this.rsult = 1;
				this.mensaje = "Ocurrio un Problema";
			}
			mainUsuario();
		} 
		return SUCCESS;
	}

	@Action(value = "/actuarUsuario", results = { @Result(name = "success", location = "/paginas/mantenimientos/mensaje_usuario.jsp") })
	public String actuarUsuario() { 
		Boolean rsultado = false;
		objUsuario.setNom_usuario(objUsuario.getNom_usuario().trim());
		objUsuario.setCorreo_usuario(objUsuario.getCorreo_usuario().trim());
		objUsuario.setUsu_usuario(objUsuario.getUsu_usuario().trim()); 
		objUsuario.setPass_usuario(objUsuario.getPass_usuario().trim());
		if(!"".equals(objUsuario.getNom_usuario()) && !"".equals(objUsuario.getCorreo_usuario())
				&& !"".equals(objUsuario.getUsu_usuario()) ){ 
			rsultado = true;
		}
		if(rsultado){
			try {
				if (objUsuario.getCod_usuario() == null) { 
					if(!"".equals(objUsuario.getPass_usuario())){
						String pass= objUsuario.getPass_usuario(); 
						pass = UtilSigal.getHash(pass); 
						objUsuario.setPass_usuario(pass);
						rsultado = objUsuarioServ.registrarUsuario(objUsuario);
					} else{
						rsultado=false;
					}
				} else {
					String pass=objUsuarioServ.getUsuario(objUsuario.getCod_usuario()).getPass_usuario();
					objUsuario.setPass_usuario(pass);
					rsultado = objUsuarioServ.actualizarUsuario(objUsuario);
				}
			} catch (Exception e) {
				rsultado=false;
				e.printStackTrace();
			}	
		} 
		if (rsultado) {
			this.rsult = 1;
			this.mensaje = "Todo Correctamente";
		} else {
			this.rsult = 0;
			this.mensaje = "Ocurrio un Problema";
		} 
		return SUCCESS;
	}
	 
	@Action(value = "/actualizaPassUsuario", results = { @Result(name = "success", location = "/paginas/mantenimientos/mensaje_usuario.jsp") })
	public String actualizaPassUsuario() { 
		Boolean rsultado = false;
		String pass= objUsuario.getPass_usuario();
		if (!"".equals(pass)) {
			rsultado = true;
		} 
		if (rsultado) {
			try {
				// String pass= objUsuario.getPass_usuario();
				pass = UtilSigal.getHash(pass);
				objUsuario = objUsuarioServ.getUsuario(objUsuario.getCod_usuario());
				objUsuario.setPass_usuario(pass); 
				rsultado = objUsuarioServ.actualizarUsuario(objUsuario);
			} catch (Exception e) {
				rsultado = false;
				e.printStackTrace();
			}
		}
		
		
		if (rsultado) {
			this.rsult = 1;
			this.mensaje = "Todo Correctamente";
		} else {
			this.rsult = 0;
			this.mensaje = "Ocurrio un Problema";
		} 
		return SUCCESS;
	}

	//Modal
	@Action(value = "/listarUsuarioPagModal", results = { @Result(name = "success", location = "/paginas/mantenimientos/buscar_usuario.jsp") })
	public String listarUsuarioPagModal() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstUsuario = objUsuarioServ.listaUsuarioPaginado(comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	} 
	@Action(value = "/buscarUsuarioXDesc_usuarioPagModal", results = { @Result(name = "success", location = "/paginas/mantenimientos/buscar_usuario.jsp") })
	public String buscarUsuarioXRazonSocialPagModal() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstUsuario = objUsuarioServ.buscarUsuarioXDescPaginado(objUsuario, comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	@Action(value = "/listarUsuarioTotal", results = { @Result(name = "success", location = "/paginas/mantenimientos/usuario_listado_total.jsp") })
	public String listarUsuarioTotal() { 
		try {
			this.numeroPaginasModalUsuario = UtilSigal.totalDePaginas(objUsuarioServ.listaUsuarioTotal());
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		return SUCCESS;
	}
	@Action(value = "/buscarUsuarioTotal", results = { @Result(name = "success", location = "/paginas/mantenimientos/usuario_buscar_total.jsp") })
	public String buscarUsuarioTotal() { 
		try {
			this.numeroPaginasModalUsuario = UtilSigal.totalDePaginas(objUsuarioServ.buscarUsuarioXDescTotal(objUsuario));
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return SUCCESS;
	}
	@Action(value = "/cboCargo", results = { @Result(name = "success", location = "/paginas/mantenimientos/cboCargo.jsp") })
	public String cboCargo() { 
		System.out.println("area:"+objUsuario.getCod_area());
		System.out.println("cargo:"+objUsuario.getCod_cargo());
		try {
			this.lstCargo = objCargoServ.listaCargoXIdArea(objUsuario.getCod_area()); 
		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println("cargo:"+objUsuario.getCod_cargo());
		return SUCCESS;
	}





	public UsuarioDTO getObjUsuario() {
		return objUsuario;
	}

	public void setObjUsuario(UsuarioDTO objUsuario) {
		this.objUsuario = objUsuario;
	}

	public List<UsuarioDTO> getLstUsuario() {
		return lstUsuario;
	}

	public void setLstUsuario(List<UsuarioDTO> lstUsuario) {
		this.lstUsuario = lstUsuario;
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

	public Integer getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
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

	public Integer getNumeroPaginasModalUsuario() {
		return numeroPaginasModalUsuario;
	}

	public void setNumeroPaginasModalUsuario(Integer numeroPaginasModalUsuario) {
		this.numeroPaginasModalUsuario = numeroPaginasModalUsuario;
	}
	public List<AreaDTO> getLstArea() {
		return lstArea;
	}
	public void setLstArea(List<AreaDTO> lstArea) {
		this.lstArea = lstArea;
	}
	public List<CargoDTO> getLstCargo() {
		return lstCargo;
	}
	public void setLstCargo(List<CargoDTO> lstCargo) {
		this.lstCargo = lstCargo;
	}
	
	
	
	
	
	
}
