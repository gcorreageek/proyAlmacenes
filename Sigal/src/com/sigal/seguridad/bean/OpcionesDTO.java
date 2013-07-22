package com.sigal.seguridad.bean;

import java.io.Serializable;

public class OpcionesDTO implements Serializable { 
	private static final long serialVersionUID = -3137277235959640179L;
//	cod_opcion int primary key auto_increment,
//	nom_opcion varchar(200),
//	url_opcion varchar(200),
//	icono_opcion varchar(200),
//	tipo_opcion int,
//	id_subopcion int,
//	orden_opcion int
	private Integer cod_opcion;
	private String nom_opcion;
	private String url_opcion; 
	private String icono_opcion;
	private Integer tipo_opcion;
	private Integer id_subopcion;
	private Integer orden_opcion;
	private Integer master_opcion;
	public Integer getMaster_opcion() {
		return master_opcion;
	}
	public void setMaster_opcion(Integer master_opcion) {
		this.master_opcion = master_opcion;
	}
	public Integer getCod_opcion() {
		return cod_opcion;
	}
	public void setCod_opcion(Integer cod_opcion) {
		this.cod_opcion = cod_opcion;
	}
	public String getNom_opcion() {
		return nom_opcion;
	}
	public void setNom_opcion(String nom_opcion) {
		this.nom_opcion = nom_opcion;
	}
	public String getUrl_opcion() {
		return url_opcion;
	}
	public void setUrl_opcion(String url_opcion) {
		this.url_opcion = url_opcion;
	}
	public String getIcono_opcion() {
		return icono_opcion;
	}
	public void setIcono_opcion(String icono_opcion) {
		this.icono_opcion = icono_opcion;
	}
	public Integer getTipo_opcion() {
		return tipo_opcion;
	}
	public void setTipo_opcion(Integer tipo_opcion) {
		this.tipo_opcion = tipo_opcion;
	}
	public Integer getId_subopcion() {
		return id_subopcion;
	}
	public void setId_subopcion(Integer id_subopcion) {
		this.id_subopcion = id_subopcion;
	}
	public Integer getOrden_opcion() {
		return orden_opcion;
	}
	public void setOrden_opcion(Integer orden_opcion) {
		this.orden_opcion = orden_opcion;
	} 
	
	
	
	
	
	
}
