package com.sigal.seguridad.action;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.sigal.seguridad.bean.AreaDTO;
import com.sigal.seguridad.bean.CargoDTO;
import com.sigal.seguridad.bean.DetalleUsuarioDTO;
import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.seguridad.service.AreaService;
import com.sigal.seguridad.service.CargoService;
import com.sigal.seguridad.service.UsuarioService;
import com.sigal.util.UtilSigal;


@ParentPackage("proy_calidad_SIGAL2")
public class UsuarioAction extends ActionSupport {
/*----------------------DECLARACION DE VARIABLES----------------------*/
	
	UsuarioService objUsuServ = new UsuarioService();
	CargoService objCargoServ = new CargoService();
	AreaService objAreaServ = new AreaService();
	
	private ArrayList<AreaDTO> lstAreas;
	private ArrayList<CargoDTO> lstCargos;
	private ArrayList<DetalleUsuarioDTO> lstDetUsuario ;
	
	private UsuarioDTO objUsuario;
	private String id_usuario;
	private String estado_usuario;
	private String mensaje;
	private String fl_tipo;
/*-----------Metodos Action----------- */	 
@Action(value="/mantenimientoUsuario",results={@Result(name="success",type="tiles",location="d_manteUsuario")}) 
public String registraUsuario(){
	UsuarioDTO objUsu = new UsuarioDTO();
	objUsu.setNom_usuario(objUsuario.getNom_usuario());
	objUsu.setApePat_usuario(objUsuario.getApePat_usuario());
	objUsu.setApeMat_usuario(objUsuario.getApeMat_usuario());
	objUsu.setCod_cargo(objUsuario.getCod_cargo());
	objUsu.setCod_area(objUsuario.getCod_area());
	objUsu.setId_usuario(objUsuario.getId_usuario());
	objUsu.setPass_usuario(UtilSigal.getHash(objUsuario.getPass_usuario()));
	
	if(fl_tipo.equals("1")){
		
		try {
			
		} catch (Exception e) {
			mensaje="No se pudo registrar el usuario";
		}
		
		objUsuServ.registrarUsuario(objUsu);		
		System.out.println("registrs");
	}
	else if(fl_tipo.equals("2")){
	
//		objUsuServ.modificarUsuario(objUsu);			
		try {
			System.out.println("modifica");
		} catch (Exception e) {
			mensaje="No se pudo modificar el usuario";
		}
		
	}
	



	lstDetUsuario=objUsuServ.listarUsuariosMante(); 
	

	
	
	return SUCCESS;
}
@Action(value="/ListaAreas",results={@Result(name="success",type="json")})
public String ListaAreas(){
	lstAreas = objAreaServ.listaAreas();
	return SUCCESS;
}
@Action(value="/ListaCargos",results={@Result(name="success",type="json")})
public String ListaCargos(){
	lstCargos= objCargoServ.listaCargos();
	return SUCCESS;
}
@Action(value="/buscarUsuario",results={@Result(name="success",type="tiles",location="d_manteUsuario")})
public String buscarUsuario(){
	
	objUsuario =objUsuServ.buscaUsuario(id_usuario);
	fl_tipo="2";
	lstDetUsuario=objUsuServ.listarUsuariosMante(); 
	return SUCCESS;
}
@Action(value="/cambiaEstadoUsuario",results={@Result(name="success",type="tiles",location="d_manteUsuario")})
public String CambiaEstadoUsuario(){
	System.out.println(estado_usuario);
	if(estado_usuario.equals("A")){
		System.out.println("usuario Desactivado");
	}
	else{
		System.out.println("usuario activado");
	}
	lstDetUsuario=objUsuServ.listarUsuariosMante(); 
	return SUCCESS;
}

@Action(value="/mail",results={@Result(name="success",location="/pages/gadgets/mail.jsp")})
public String mail(){
	UtilSigal.EnviarCorreo(); 
	return SUCCESS; 
}

/*-----------Metodos Action----------- */

public UsuarioDTO getObjUsuario() {
	return objUsuario;
}

public void setObjUsuario(UsuarioDTO objUsuario) {
	this.objUsuario = objUsuario;
}
public ArrayList<AreaDTO> getLstAreas() {
	return lstAreas;
}
public void setLstAreas(ArrayList<AreaDTO> lstAreas) {
	this.lstAreas = lstAreas;
}
public ArrayList<CargoDTO> getLstCargos() {
	return lstCargos;
}
public void setLstCargos(ArrayList<CargoDTO> lstCargos) {
	this.lstCargos = lstCargos;
}
public ArrayList<DetalleUsuarioDTO> getLstDetUsuario() {
	return lstDetUsuario;
}
public void setLstDetUsuario(ArrayList<DetalleUsuarioDTO> lstDetUsuario) {
	this.lstDetUsuario = lstDetUsuario;
}
public String getId_usuario() {
	return id_usuario;
}
public void setId_usuario(String id_usuario) {
	this.id_usuario = id_usuario;
}
public String getEstado_usuario() {
	return estado_usuario;
}
public void setEstado_usuario(String estado_usuario) {
	this.estado_usuario = estado_usuario;
}
public String getFl_tipo() {
	return fl_tipo;
}
public void setFl_tipo(String fl_tipo) {
	this.fl_tipo = fl_tipo;
}
public String getMensaje() {
	return mensaje;
}
public void setMensaje(String mensaje) {
	this.mensaje = mensaje;
}


/*-----------Metodos Acceso----------- */



}