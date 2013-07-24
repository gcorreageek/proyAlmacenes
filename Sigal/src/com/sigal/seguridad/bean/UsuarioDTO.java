package com.sigal.seguridad.bean;

import java.io.Serializable;

public class UsuarioDTO  implements Serializable{


	private Integer cod_usuario;
	private String nom_usuario;
	private String apePat_usuario;
	private String apeMat_usuario;
	private Integer cod_cargo; 
	private String id_usuario;
	private String pass_usuario;
	private String cod_perfil;
	private Integer estado_usuario;
	
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
	public Integer getCod_cargo() {
		return cod_cargo;
	}
	public void setCod_cargo(Integer cod_cargo) {
		this.cod_cargo = cod_cargo;
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
	public Integer getEstado_usuario() {
		return estado_usuario;
	}
	public void setEstado_usuario(Integer estado_usuario) {
		this.estado_usuario = estado_usuario;
	}
 
		
		
		
		
}