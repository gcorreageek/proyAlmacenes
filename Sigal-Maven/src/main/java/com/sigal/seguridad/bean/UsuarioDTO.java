package com.sigal.seguridad.bean;

import java.io.Serializable;

public class UsuarioDTO  implements Serializable{
 
	private static final long serialVersionUID = 3028111602034688467L;
	private Integer cod_usuario;
	private String nom_usuario; 
	private String correo_usuario;
	private Integer cod_cargo; 
	private String usu_usuario;
	private String pass_usuario;  
	private String habilitado; 
	
	private Integer inicio;
	private Integer tamano;
	private String desc_cargo;
	private Integer cod_area;
	private String desc_area;
//	select usuario.*,cargo.*,area.* from tb_usuario usuario 
//	inner join tb_cargo cargo on usuario.cod_cargo=cargo.cod_cargo
//	inner join tb_area area on cargo.cod_area=area.cod_area
	
	
	
	public Integer getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(Integer cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	public String getNom_usuario() {
		return nom_usuario;
	}
	public void setNom_usuario(String nom_usuario) {
		this.nom_usuario = nom_usuario;
	}
	public String getCorreo_usuario() {
		return correo_usuario;
	}
	public void setCorreo_usuario(String correo_usuario) {
		this.correo_usuario = correo_usuario;
	}
	public Integer getCod_cargo() {
		return cod_cargo;
	}
	public void setCod_cargo(Integer cod_cargo) {
		this.cod_cargo = cod_cargo;
	}
	public String getUsu_usuario() {
		return usu_usuario;
	}
	public void setUsu_usuario(String usu_usuario) {
		this.usu_usuario = usu_usuario;
	}
	public String getPass_usuario() {
		return pass_usuario;
	}
	public void setPass_usuario(String pass_usuario) {
		this.pass_usuario = pass_usuario;
	}
	public Integer getInicio() {
		return inicio;
	}
	public void setInicio(Integer inicio) {
		this.inicio = inicio;
	}
	public Integer getTamano() {
		return tamano;
	}
	public void setTamano(Integer tamano) {
		this.tamano = tamano;
	}
	public String getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}
	public String getDesc_cargo() {
		return desc_cargo;
	}
	public void setDesc_cargo(String desc_cargo) {
		this.desc_cargo = desc_cargo;
	}
	public Integer getCod_area() {
		return cod_area;
	}
	public void setCod_area(Integer cod_area) {
		this.cod_area = cod_area;
	}
	public String getDesc_area() {
		return desc_area;
	}
	public void setDesc_area(String desc_area) {
		this.desc_area = desc_area;
	}
	
	
		
		
		
}