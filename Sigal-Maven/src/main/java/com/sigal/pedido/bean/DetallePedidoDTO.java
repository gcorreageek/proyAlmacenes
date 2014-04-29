package com.sigal.pedido.bean;

public class DetallePedidoDTO {

	
	private	Integer	cod_detallePedido	;
	private	Integer	cod_solicitudPedido	;
	private	Integer	cod_producto	;
	private	Integer	cantidad	;
	private	String	desc_producto	;
	private	String	unidadMedida	; 
	
	   
	private	Integer	stock_producto	; 
	
	
	public Integer getCod_detallePedido() {
		return cod_detallePedido;
	}
	public void setCod_detallePedido(Integer cod_detallePedido) {
		this.cod_detallePedido = cod_detallePedido;
	}
	public Integer getCod_solicitudPedido() {
		return cod_solicitudPedido;
	}
	public void setCod_solicitudPedido(Integer cod_solicitudPedido) {
		this.cod_solicitudPedido = cod_solicitudPedido;
	}
	public Integer getCod_producto() {
		return cod_producto;
	}
	public void setCod_producto(Integer cod_producto) {
		this.cod_producto = cod_producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getDesc_producto() {
		return desc_producto;
	}
	public void setDesc_producto(String desc_producto) {
		this.desc_producto = desc_producto;
	}
	public String getUnidadMedida() {
		return unidadMedida;
	}
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	public Integer getStock_producto() {
		return stock_producto;
	}
	public void setStock_producto(Integer stock_producto) {
		this.stock_producto = stock_producto;
	}
	
	
	
	 
	
	
	
	
	
}
