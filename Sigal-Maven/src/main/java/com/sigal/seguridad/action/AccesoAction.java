/**
 * AccesoAction 30/07/2013
 */
package com.sigal.seguridad.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.sigal.seguridad.bean.AccesoMenuDTO;
import com.sigal.seguridad.bean.AreaDTO;
import com.sigal.seguridad.bean.MenuDTO;
import com.sigal.seguridad.service.AccesoService;
import com.sigal.seguridad.service.AreaService;
import com.sigal.seguridad.service.MenuService;

/**
 * @author Gustavo A. Correa C.
 *
 */
@ParentPackage("Sigal-Maven")
public class AccesoAction extends ActionSupport {
	AccesoService objAccesoServ = new AccesoService();
	AreaService objAreaServ = new AreaService();
	MenuService objMenuServ = new MenuService();
	private AccesoMenuDTO  objAcceso;
	private List<AccesoMenuDTO> lstAcceso;
	private List<AreaDTO> lstArea = new ArrayList<AreaDTO>();
	private List<MenuDTO> lstMenu = new ArrayList<MenuDTO>();
	private List<AccesoMenuDTO> lstMenuTabla; 
	private String mensaje;
	private Integer rsult; 
	

	@Action(value="/mainAcceso",results={@Result(name="success",type="tiles",location="d_mainacceso")})
	public String mainAcceso(){ 
		
		try {
			lstArea = objAreaServ.listaArea();
			lstMenu = objMenuServ.listaMenu1();
			
		} catch (Exception e) { 
			e.printStackTrace();
		} 
		return SUCCESS; 
	}
//	cboSubMenu
	@Action(value = "/cboSubMenu", results = { @Result(name = "success", location = "/paginas/mantenimientos/cboSubMenu.jsp") })
	public String cboSubMenu() { 
		System.out.println("menu:"+objAcceso.getCod_menu());
		try {
			this.lstMenu = objMenuServ.listaMenu2(objAcceso.getCod_menu()); 
		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println("cargo:"+objAcceso.getCod_menu());
		return SUCCESS;
	}
//	lstMenuTabla = objAccesoServ.listaAcceso(idCargo)
	@Action(value = "/listaTablaMenu", results = { @Result(name = "success", location = "/paginas/mantenimientos/buscar_menu.jsp") })
	public String listaTablaMenu() { 
		System.out.println("cargo:"+objAcceso.getCod_cargo());
		try {
			this.lstMenuTabla = objAccesoServ.listaAcceso(objAcceso.getCod_cargo()); 
		} catch (Exception e) { 
			e.printStackTrace();
		}
		System.out.println("size:"+lstMenuTabla.size());
		return SUCCESS;
	}
	@Action(value = "/guardarAcceso", results = { @Result(name = "success", location = "/paginas/mantenimientos/mensaje_usuario.jsp") })
	public String guardarAcceso() {  
		objAcceso.setHabilitado("Habilitado"); 
		try { 
			MenuDTO m = objMenuServ.getMenu(objAcceso.getCod_menu());
			Integer idSubMenu = m.getId_submenu();  
			if (!objAcceso.getCod_menu().equals(idSubMenu)) {
				AccesoMenuDTO acceso = objAccesoServ.getAccesoXIdMenuIdCargo(idSubMenu, objAcceso.getCod_cargo());
				if (acceso == null) { 
					AccesoMenuDTO accesoMenuDTO = new AccesoMenuDTO();
					accesoMenuDTO.setCod_cargo(objAcceso.getCod_cargo());
					accesoMenuDTO.setCod_menu(idSubMenu);
					accesoMenuDTO.setHabilitado("Habilitado");
					objAccesoServ.registrarAcceso(accesoMenuDTO);
				}
			} 
			objAccesoServ.registrarAcceso(objAcceso); 
			rsult=1;
			mensaje="Se Guardo existosamente";
		} catch (Exception e) { 
			e.printStackTrace();
			rsult=0;
			mensaje="Ocurrio un problema";
		} 
		return SUCCESS;
	}
	
	@Action(value = "/cambiarEstadoAcceso", results = { @Result(name = "success", location = "/paginas/mantenimientos/mensaje_usuario.jsp") })
	public String cambiarEstadoAcceso() {  
		System.out.println("acceso:"+objAcceso.getCod_accesomenu()); 
		try {
			objAcceso = objAccesoServ.getAcceso(objAcceso.getCod_accesomenu());
			if("Habilitado".equals(objAcceso.getHabilitado())){
				objAcceso.setHabilitado("Desabilitado");
				objAccesoServ.actualizarAcceso(objAcceso);
			}else{
				objAcceso.setHabilitado("Habilitado");
				objAccesoServ.actualizarAcceso(objAcceso);
			}
			rsult=1;
			mensaje="Se Guardo existosamente";
		} catch (Exception e) { 
			e.printStackTrace();
			rsult=0;
			mensaje="Ocurrio un problema";
		} 
		return SUCCESS;
	}
	
	public AccesoMenuDTO getObjAcceso() {
		return objAcceso;
	}

	public void setObjAcceso(AccesoMenuDTO objAcceso) {
		this.objAcceso = objAcceso;
	}

	public List<AccesoMenuDTO> getLstAcceso() {
		return lstAcceso;
	}

	public void setLstAcceso(List<AccesoMenuDTO> lstAcceso) {
		this.lstAcceso = lstAcceso;
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

	public List<MenuDTO> getLstMenu() {
		return lstMenu;
	}

	public void setLstMenu(List<MenuDTO> lstMenu) {
		this.lstMenu = lstMenu;
	}
	public List<AccesoMenuDTO> getLstMenuTabla() {
		return lstMenuTabla;
	}
	public void setLstMenuTabla(List<AccesoMenuDTO> lstMenuTabla) {
		this.lstMenuTabla = lstMenuTabla;
	}
 
	
 



	 
}
