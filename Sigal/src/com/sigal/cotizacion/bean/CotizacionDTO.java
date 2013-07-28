/**
 * CotizacionDTO 28/07/2013
 */
package com.sigal.cotizacion.bean;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class CotizacionDTO { 
	
	private Integer cod_cotizacion;
	private String obs_cotizacion;
	private Integer cod_usuario;
	private java.sql.Date fecharegistro_cotizacion;
	private Integer cod_proveedor;
	
	private String raz_social;
	private String nom_usuario;
	
	private Integer inicio;
	private Integer tamano; 
	private java.sql.Date fechaInicio;
	private java.sql.Date fechaFin;
	
	public Integer getCod_cotizacion() {
		return cod_cotizacion;
	}
	public void setCod_cotizacion(Integer cod_cotizacion) {
		this.cod_cotizacion = cod_cotizacion;
	}
	public String getObs_cotizacion() {
		return obs_cotizacion;
	}
	public void setObs_cotizacion(String obs_cotizacion) {
		this.obs_cotizacion = obs_cotizacion;
	}
	public Integer getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(Integer cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	public java.sql.Date getFecharegistro_cotizacion() {
		return fecharegistro_cotizacion;
	}
	public void setFecharegistro_cotizacion(java.sql.Date fecharegistro_cotizacion) {
		this.fecharegistro_cotizacion = fecharegistro_cotizacion;
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
	public Integer getCod_proveedor() {
		return cod_proveedor;
	}
	public void setCod_proveedor(Integer cod_proveedor) {
		this.cod_proveedor = cod_proveedor;
	}
	public String getRaz_social() {
		return raz_social;
	}
	public void setRaz_social(String raz_social) {
		this.raz_social = raz_social;
	}
	public String getNom_usuario() {
		return nom_usuario;
	}
	public void setNom_usuario(String nom_usuario) {
		this.nom_usuario = nom_usuario;
	}
	public java.sql.Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(java.sql.Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public java.sql.Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(java.sql.Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
	
	
	
	
	
}
