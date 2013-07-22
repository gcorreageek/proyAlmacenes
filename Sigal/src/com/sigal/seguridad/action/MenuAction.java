package com.sigal.seguridad.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sigal.mantenimiento.service.ProductoService;
import com.sigal.seguridad.bean.DetallePerfilDTO;
import com.sigal.seguridad.bean.DetalleUsuarioDTO;
import com.sigal.seguridad.bean.MenuDTO;
import com.sigal.seguridad.bean.OpcionesMenuDTO;
import com.sigal.seguridad.service.LogueoService;
/**
 * 
 * @author David
 *@Descripcion Clase encargada de los redireccionamientos
 */
@ParentPackage("proy_calidad_SIGAL2")
public class MenuAction extends ActionSupport {
	
	/*---------------------------- DECLARACION DE VARIABLES -------------------------------------*/
	/*----Declaracion de services----*/
	LogueoService objLogServ = new LogueoService();
	ProductoService objProServ = new ProductoService();
	/*----Declaracion de services----*/
	
	private ArrayList<MenuDTO> listaMenu ;
	private ArrayList<OpcionesMenuDTO> listaOpcMenu;
	private String cod_Menu;
	String cod_perfil;
	private Map<String, Object> lasesion = ActionContext.getContext().getSession();
	DetalleUsuarioDTO objDetUsuario ;
	private String fl_tipo; //1 para registro, 2 para actualizacion 

	/*---------------------------- DECLARACION DE VARIABLES -------------------------------------*/
	
	
	 
	/*---------------------------- METODOS -------------------------------------*/

	/**
	 * @author David
	 * @Descripcion Este metodo tiene como finalidad listar las opciones del modulo
	 * 
	 */
	@Action(value="/SPI",results={@Result(name="success",type="tiles",location="d_index")})	
public String CargarModulo(){
	
	DetalleUsuarioDTO obj=  (DetalleUsuarioDTO) lasesion.get("objUsuario")  ;
	cod_perfil=   	obj.getCod_perfil()	;
	
	DetallePerfilDTO objDetalle = new DetallePerfilDTO();
	objDetalle.setCod_Menu(cod_Menu);
	objDetalle.setCod_Perfil(cod_perfil);
	
	lasesion.put("objDetalle", objDetalle);

	
	lasesion.put("codigo_Menu", cod_Menu);
	listaMenu =(ArrayList<MenuDTO>) lasesion.get("listaMenu");	
	listaOpcMenu=objLogServ.obtenerOpcMenu( (DetallePerfilDTO)lasesion.get("objDetalle"));

	return SUCCESS;
}
	
	
	/**
	 * @author David  
	 * @description  Este metodo tiene como finalidad mostrar la interfaz de 
	 * solicitud de pedidos internos
	 * @return success = exito , error=fracaso 
	 */
	@SuppressWarnings("unchecked")
	@Action(value="/registrarSol_Ped",results={@Result(name="success",type="tiles",location="d_pedidosInternos")})	
public String registrarSol_PedIn(){
		
		DetalleUsuarioDTO obj=  (DetalleUsuarioDTO) lasesion.get("objUsuario")  ;
		cod_perfil=   	obj.getCod_perfil()	;
		listaMenu =(ArrayList<MenuDTO>) lasesion.get("listaMenu");
		listaOpcMenu=objLogServ.obtenerOpcMenu(lasesion.get("codigo_Menu").toString(),cod_perfil);
		
		objDetUsuario = (DetalleUsuarioDTO)lasesion.get("objUsuario");

	
	return SUCCESS;
}	
	/**
	 * @author David
	 * @descripcion Mostrar interfaz de mantenimientos
	 * @return success = exito , error=fracaso 
	 */
	@Action(value="/Mantenimientos",results={@Result(name="success",type="tiles",location="d_mantenimientos")})
	public String irMantenimientos(){
		listaMenu =(ArrayList<MenuDTO>) lasesion.get("listaMenu");
		return SUCCESS;
	}
	/**
	 * @author David
	 * @descripcion Mostrar interfaz de mantenimiento de usuarios
	 * @return success = exito , error=fracaso 
	 */
@Action(value="/irManteUsuarios",results={@Result(name="success",type="tiles",location="d_manteUsuario")})
public String irManteUsuarios(){
	fl_tipo="1";
	return SUCCESS;
}

	
/*---------------------------- METODOS -------------------------------------*/










/*---------------------------- METODOS DE ACCESO -------------------------------------*/
	
	
public ArrayList<MenuDTO> getListaMenu() {
	return listaMenu;
}

public void setListaMenu(ArrayList<MenuDTO> listaMenu) {
	this.listaMenu = listaMenu;
}

public ArrayList<OpcionesMenuDTO> getListaOpcMenu() {
	return listaOpcMenu;
}

public void setListaOpcMenu(ArrayList<OpcionesMenuDTO> listaOpcMenu) {
	this.listaOpcMenu = listaOpcMenu;
}
public String getCod_Menu() {
	return cod_Menu;
}
public void setCod_Menu(String cod_Menu) {
	this.cod_Menu = cod_Menu;
}
public DetalleUsuarioDTO getObjDetUsuario() {
	return objDetUsuario;
}
public void setObjDetUsuario(DetalleUsuarioDTO objDetUsuario) {
	this.objDetUsuario = objDetUsuario;
}
public String getFl_tipo() {
	return fl_tipo;
}
public void setFl_tipo(String fl_tipo) {
	this.fl_tipo = fl_tipo;
}



/*---------------------------- METODOS DE ACCESO -------------------------------------*/
}
