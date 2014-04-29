/**
 * InformeExternoDTO 29/07/2013
 */
package com.sigal.informeexterno.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class InformeExternoDTO implements Serializable{
 
	private static final long serialVersionUID = -5157598625173843001L;
	//	select cod_informe_externo,fecha_informe_externo,tipo_informe_externo,cod_usuario,cod_ordencompra
	//	from tb_informe_externo;
	private Integer cod_informe_externo;
	private java.sql.Date fecha_informe_externo;
	private String tipo_informe_externo;
	private Integer cod_usuario;
	private Integer cod_ordencompra;
	private String obs_informeexterno;
	
	private String nom_usuario;
	private Integer inicio;
	private Integer tamano;
	private java.sql.Date fechaInicio;
	private java.sql.Date fechaFin;
 
	private String desc_cargo;
	private String desc_area;
	private java.sql.Date fecharegistro_ordencompra;
	private String estado_ordencompra;
	
	private	Integer	cantidad	;
	private	String	desc_producto	;
	private	String	unidadMedida	;
	private String raz_social;
	
	private List<InformeExternoDetalleDTO> detalle;
	
	
	
	
	
	
	
	public Integer getCod_informe_externo() {
		return cod_informe_externo;
	}
	public void setCod_informe_externo(Integer cod_informe_externo) {
		this.cod_informe_externo = cod_informe_externo;
	}
	public java.sql.Date getFecha_informe_externo() {
		return fecha_informe_externo;
	}
	public void setFecha_informe_externo(java.sql.Date fecha_informe_externo) {
		this.fecha_informe_externo = fecha_informe_externo;
	}
	public String getTipo_informe_externo() {
		return tipo_informe_externo;
	}
	public void setTipo_informe_externo(String tipo_informe_externo) {
		this.tipo_informe_externo = tipo_informe_externo;
	}
	public Integer getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(Integer cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	public Integer getCod_ordencompra() {
		return cod_ordencompra;
	}
	public void setCod_ordencompra(Integer cod_ordencompra) {
		this.cod_ordencompra = cod_ordencompra;
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
	public String getObs_informeexterno() {
		return obs_informeexterno;
	}
	public void setObs_informeexterno(String obs_informeexterno) {
		this.obs_informeexterno = obs_informeexterno;
	}
	/**
	 * @return the desc_cargo
	 */
	public String getDesc_cargo() {
		return desc_cargo;
	}
	/**
	 * @param desc_cargo the desc_cargo to set
	 */
	public void setDesc_cargo(String desc_cargo) {
		this.desc_cargo = desc_cargo;
	}
	/**
	 * @return the desc_area
	 */
	public String getDesc_area() {
		return desc_area;
	}
	/**
	 * @param desc_area the desc_area to set
	 */
	public void setDesc_area(String desc_area) {
		this.desc_area = desc_area;
	}
	/**
	 * @return the fecharegistro_ordencompra
	 */
	public java.sql.Date getFecharegistro_ordencompra() {
		return fecharegistro_ordencompra;
	}
	/**
	 * @param fecharegistro_ordencompra the fecharegistro_ordencompra to set
	 */
	public void setFecharegistro_ordencompra(java.sql.Date fecharegistro_ordencompra) {
		this.fecharegistro_ordencompra = fecharegistro_ordencompra;
	}
	/**
	 * @return the estado_ordencompra
	 */
	public String getEstado_ordencompra() {
		return estado_ordencompra;
	}
	/**
	 * @param estado_ordencompra the estado_ordencompra to set
	 */
	public void setEstado_ordencompra(String estado_ordencompra) {
		this.estado_ordencompra = estado_ordencompra;
	}
	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the desc_producto
	 */
	public String getDesc_producto() {
		return desc_producto;
	}
	/**
	 * @param desc_producto the desc_producto to set
	 */
	public void setDesc_producto(String desc_producto) {
		this.desc_producto = desc_producto;
	}
	/**
	 * @return the unidadMedida
	 */
	public String getUnidadMedida() {
		return unidadMedida;
	}
	/**
	 * @param unidadMedida the unidadMedida to set
	 */
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	/**
	 * @return the raz_social
	 */
	public String getRaz_social() {
		return raz_social;
	}
	/**
	 * @param raz_social the raz_social to set
	 */
	public void setRaz_social(String raz_social) {
		this.raz_social = raz_social;
	}
	/**
	 * @return the detalle
	 */
	public List<InformeExternoDetalleDTO> getDetalle() {
		return detalle;
	}
	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<InformeExternoDetalleDTO> detalle) {
		this.detalle = detalle;
	}
	
	
	
	
	
	
	
	
	
}
