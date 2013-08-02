/**
 * OrdenCompraDTO 28/07/2013
 */
package com.sigal.ordencompra.bean;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class OrdenCompraDTO {

	private Integer cod_OrdenCompra;
	private java.sql.Date fecharegistro_ordencompra;
	private Integer cod_usuario;
	private Integer cod_cotizacion;
	private Integer cod_proveedor;
	private String estado_ordencompra;
	
	private String raz_social;
	private String nom_usuario;
	
	private Integer inicio;
	private Integer tamano; 
	private java.sql.Date fechaInicio;
	private java.sql.Date fechaFin;
	public Integer getCod_OrdenCompra() {
		return cod_OrdenCompra;
	}
	public void setCod_OrdenCompra(Integer cod_OrdenCompra) {
		this.cod_OrdenCompra = cod_OrdenCompra;
	}
	public java.sql.Date getFecharegistro_ordencompra() {
		return fecharegistro_ordencompra;
	}
	public void setFecharegistro_ordencompra(java.sql.Date fecharegistro_ordencompra) {
		this.fecharegistro_ordencompra = fecharegistro_ordencompra;
	}
	public Integer getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(Integer cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	public Integer getCod_cotizacion() {
		return cod_cotizacion;
	}
	public void setCod_cotizacion(Integer cod_cotizacion) {
		this.cod_cotizacion = cod_cotizacion;
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
	public String getEstado_ordencompra() {
		return estado_ordencompra;
	}
	public void setEstado_ordencompra(String estado_ordencompra) {
		this.estado_ordencompra = estado_ordencompra;
	} 
 
	
	
	
	
	
}
