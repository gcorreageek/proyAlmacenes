/**
 * AccesoMenuDTO 30/07/2013
 */
package com.sigal.seguridad.bean;

import java.io.Serializable;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class AccesoMenuDTO implements Serializable { 
	private static final long serialVersionUID = -2029437287427606326L;
	//	select cod_accesomenu,cod_menu,cod_cargo from tb_acceso_menu
	private Integer cod_accesomenu;
	private Integer cod_menu;
	private Integer cod_cargo;
	private String habilitado;
	
	private String nom_menu;
	private String url_menu; 
	private String icono_menu;
	private Integer tipo_menu;
	private Integer id_submenu;
	private Integer orden_menu;
	private Integer master_menu;
	
	private String desc_cargo;
	
	
	
	public Integer getCod_accesomenu() {
		return cod_accesomenu;
	}
	public void setCod_accesomenu(Integer cod_accesomenu) {
		this.cod_accesomenu = cod_accesomenu;
	}
	public Integer getCod_menu() {
		return cod_menu;
	}
	public void setCod_menu(Integer cod_menu) {
		this.cod_menu = cod_menu;
	}
	public Integer getCod_cargo() {
		return cod_cargo;
	}
	public void setCod_cargo(Integer cod_cargo) {
		this.cod_cargo = cod_cargo;
	}
	public String getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}
	public String getNom_menu() {
		return nom_menu;
	}
	public void setNom_menu(String nom_menu) {
		this.nom_menu = nom_menu;
	}
	public String getUrl_menu() {
		return url_menu;
	}
	public void setUrl_menu(String url_menu) {
		this.url_menu = url_menu;
	}
	public String getIcono_menu() {
		return icono_menu;
	}
	public void setIcono_menu(String icono_menu) {
		this.icono_menu = icono_menu;
	}
	public Integer getTipo_menu() {
		return tipo_menu;
	}
	public void setTipo_menu(Integer tipo_menu) {
		this.tipo_menu = tipo_menu;
	}
	public Integer getId_submenu() {
		return id_submenu;
	}
	public void setId_submenu(Integer id_submenu) {
		this.id_submenu = id_submenu;
	}
	public Integer getOrden_menu() {
		return orden_menu;
	}
	public void setOrden_menu(Integer orden_menu) {
		this.orden_menu = orden_menu;
	}
	public Integer getMaster_menu() {
		return master_menu;
	}
	public void setMaster_menu(Integer master_menu) {
		this.master_menu = master_menu;
	}
	public String getDesc_cargo() {
		return desc_cargo;
	}
	public void setDesc_cargo(String desc_cargo) {
		this.desc_cargo = desc_cargo;
	}
	
	
	
	
	
	

}
