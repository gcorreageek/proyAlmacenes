/**
 * InformeInternoDTO 29/07/2013
 */
package com.sigal.informeinterno.bean;

import java.io.Serializable;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class InformeInternoDTO  implements Serializable{ 
	private static final long serialVersionUID = 338366121961987591L;
	//	select cod_informe_interno, nro_informe_interno,fecha_informe_interno,
//	tipo_informe_interno, cod_usuario, cod_pedido from tb_informe_interno
	private Integer cod_informe_interno;
	private java.sql.Date fecha_informe_interno;
	private String tipo_informe_interno;
	private Integer cod_usuario;
	private Integer cod_pedido;
	private String obs_informeinterno;
	
	private String nom_usuario;
	private Integer inicio;
	private Integer tamano;
	private java.sql.Date fechaInicio;
	private java.sql.Date fechaFin;
	public Integer getCod_informe_interno() {
		return cod_informe_interno;
	}
	public void setCod_informe_interno(Integer cod_informe_interno) {
		this.cod_informe_interno = cod_informe_interno;
	}
	public java.sql.Date getFecha_informe_interno() {
		return fecha_informe_interno;
	}
	public void setFecha_informe_interno(java.sql.Date fecha_informe_interno) {
		this.fecha_informe_interno = fecha_informe_interno;
	}
	public String getTipo_informe_interno() {
		return tipo_informe_interno;
	}
	public void setTipo_informe_interno(String tipo_informe_interno) {
		this.tipo_informe_interno = tipo_informe_interno;
	}
	public Integer getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(Integer cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	public Integer getCod_pedido() {
		return cod_pedido;
	}
	public void setCod_pedido(Integer cod_pedido) {
		this.cod_pedido = cod_pedido;
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
	public String getObs_informeinterno() {
		return obs_informeinterno;
	}
	public void setObs_informeinterno(String obs_informeinterno) {
		this.obs_informeinterno = obs_informeinterno;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
