/**
 * InformeExternoDTO 29/07/2013
 */
package com.sigal.informeexterno.bean;

import java.io.Serializable;

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
	
	
	
	
	
	
	
	
	
}
