package com.sigal.pedido.bean;

import java.io.Serializable;
import java.sql.Date;

public class SolicitudPedidoDTO  implements Serializable{
 
	private static final long serialVersionUID = 645338127658125217L;
	private	Integer	cod_solicitudPedido	; //objPedido.cod_solicitudPedido
	private	Integer	cod_usuario	;
	private	String	comentario_pedido	;
	private	String	tipo_pedido	;//objPedido.tipo_pedido
	private	java.sql.Date	fechaDevolucion_pedido	;
	private	java.sql.Date	fechaRegistro_pedido	;//objPedido.fechaRegistro_pedido
	private	java.sql.Date	fechaEntrega_pedido	;
	private String    estado_pedido;
	private	java.sql.Date	fechaEvaluacion_pedido	;
	private String comentarioevaluacion_pedido;
	 
	private String nom_usuario;//objPedido.nom_usuario
	private String apePat_usuario;
	private String apeMat_usuario;
	private Integer cod_area;//objPedido.cod_area
	private String desc_area;
	private Integer cod_cargo;
	private String desc_cargo;
	private Integer inicio;
	private Integer tamano;
	private java.sql.Date fechaInicio;
	private java.sql.Date fechaFin;
	
	
	public Integer getCod_solicitudPedido() {
		return cod_solicitudPedido;
	}
	public void setCod_solicitudPedido(Integer cod_solicitudPedido) {
		this.cod_solicitudPedido = cod_solicitudPedido;
	}
	public Integer getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(Integer cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	public String getComentario_pedido() {
		return comentario_pedido;
	}
	public void setComentario_pedido(String comentario_pedido) {
		this.comentario_pedido = comentario_pedido;
	}
	public String getTipo_pedido() {
		return tipo_pedido;
	}
	public void setTipo_pedido(String tipo_pedido) {
		this.tipo_pedido = tipo_pedido;
	}

	public java.sql.Date getFechaDevolucion_pedido() {
		return fechaDevolucion_pedido;
	}
	public void setFechaDevolucion_pedido(java.sql.Date fechaDevolucion_pedido) {
		this.fechaDevolucion_pedido = fechaDevolucion_pedido;
	}
	public java.sql.Date getFechaRegistro_pedido() {
		return fechaRegistro_pedido;
	}
	public void setFechaRegistro_pedido(java.sql.Date fechaRegistro_pedido) {
		this.fechaRegistro_pedido = fechaRegistro_pedido;
	}
	public java.sql.Date getFechaEntrega_pedido() {
		return fechaEntrega_pedido;
	}
	public void setFechaEntrega_pedido(java.sql.Date fechaEntrega_pedido) {
		this.fechaEntrega_pedido = fechaEntrega_pedido;
	}
	public String getEstado_pedido() {
		return estado_pedido;
	}
	public void setEstado_pedido(String estado_pedido) {
		this.estado_pedido = estado_pedido;
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
	public String getDesc_area() {
		return desc_area;
	}
	public void setDesc_area(String desc_area) {
		this.desc_area = desc_area;
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
	public Integer getCod_cargo() {
		return cod_cargo;
	}
	public void setCod_cargo(Integer cod_cargo) {
		this.cod_cargo = cod_cargo;
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
	public String getComentarioevaluacion_pedido() {
		return comentarioevaluacion_pedido;
	}
	public void setComentarioevaluacion_pedido(String comentarioevaluacion_pedido) {
		this.comentarioevaluacion_pedido = comentarioevaluacion_pedido;
	}
	public java.sql.Date getFechaEvaluacion_pedido() {
		return fechaEvaluacion_pedido;
	}
	public void setFechaEvaluacion_pedido(java.sql.Date fechaEvaluacion_pedido) {
		this.fechaEvaluacion_pedido = fechaEvaluacion_pedido;
	}
	
	
	
	
	
	
	
}
