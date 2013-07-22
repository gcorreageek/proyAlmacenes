package com.sigal.pedido.bean;

import java.io.Serializable;

public class SolicitudPedidoDTO  implements Serializable{

	private	String	cod_solicitudPedido	;
	private	String	cod_usuario	;
	private	String	comentario_pedido	;
	private	String	tipo_pedido	;
	private	String	fechaDevolucion_pedido	;
	private	String	fechaRegistro_pedido	;
	private	String	fechaRespuesta_pedido	;
	private String    estado_pedido;
	
	
	
	
	
	
	
	public String getCod_solicitudPedido() {
		return cod_solicitudPedido;
	}
	public void setCod_solicitudPedido(String cod_solicitudPedido) {
		this.cod_solicitudPedido = cod_solicitudPedido;
	}
	public String getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(String cod_usuario) {
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
	public String getFechaDevolucion_pedido() {
		return fechaDevolucion_pedido;
	}
	public void setFechaDevolucion_pedido(String fechaDevolucion_pedido) {
		this.fechaDevolucion_pedido = fechaDevolucion_pedido;
	}
	public String getFechaRegistro_pedido() {
		return fechaRegistro_pedido;
	}
	public void setFechaRegistro_pedido(String fechaRegistro_pedido) {
		this.fechaRegistro_pedido = fechaRegistro_pedido;
	}
	public String getFechaRespuesta_pedido() {
		return fechaRespuesta_pedido;
	}
	public void setFechaRespuesta_pedido(String fechaRespuesta_pedido) {
		this.fechaRespuesta_pedido = fechaRespuesta_pedido;
	}
	public String getEstado_pedido() {
		return estado_pedido;
	}
	public void setEstado_pedido(String estado_pedido) {
		this.estado_pedido = estado_pedido;
	}
	
	
	
	
}
