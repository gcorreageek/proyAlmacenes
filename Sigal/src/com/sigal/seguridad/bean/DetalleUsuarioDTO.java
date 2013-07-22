package com.sigal.seguridad.bean;

import java.io.Serializable;

public class DetalleUsuarioDTO implements Serializable{

	private String cod_usuario;
	private String nom_usuario;
	private String apePat_usuario;
	private String apeMat_usuario;
	private String id_usuario;
	private String pass_usuario;
	private String cod_perfil;
	private String desc_cargo;
	private String desc_area;
	private String desc_perfil;
	private String estado_usuario;
	
	
	public String getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(String cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	public String getNom_usuario() {
		return nom_usuario;
	}
	public void setNom_usuario(String nom_usuario) {
		this.nom_usuario = nom_usuario;
	}
	public String getApePat_usuario() {
		return apePat_usuario;
	}
	public void setApePat_usuario(String apePat_usuario) {
		this.apePat_usuario = apePat_usuario;
	}
	public String getApeMat_usuario() {
		return apeMat_usuario;
	}
	public void setApeMat_usuario(String apeMat_usuario) {
		this.apeMat_usuario = apeMat_usuario;
	}
	public String getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getPass_usuario() {
		return pass_usuario;
	}
	public void setPass_usuario(String pass_usuario) {
		this.pass_usuario = pass_usuario;
	}
	public String getCod_perfil() {
		return cod_perfil;
	}
	public void setCod_perfil(String cod_perfil) {
		this.cod_perfil = cod_perfil;
	}
	public String getDesc_cargo() {
		return desc_cargo;
	}
	public void setDesc_cargo(String desc_cargo) {
		this.desc_cargo = desc_cargo;
	}
	public String getDesc_area() {
		return desc_area;
	}
	public void setDesc_area(String desc_area) {
		this.desc_area = desc_area;
	}
	public String getDesc_perfil() {
		return desc_perfil;
	}
	public void setDesc_perfil(String desc_perfil) {
		this.desc_perfil = desc_perfil;
	}
	public String getEstado_usuario() {
		return estado_usuario;
	}
	public void setEstado_usuario(String estado_usuario) {
		this.estado_usuario = estado_usuario;
	}
		
	
	
	
	
}
