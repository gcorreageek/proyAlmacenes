package com.sigal.mantenimiento.bean;

import java.io.Serializable;

public class ProductoDTO implements Serializable {

	
	private	Integer	cod_producto	;
	private	String	desc_producto	;
	private	String	unidadMedida	;  
	private	Integer	stock_producto	; 
	private	Integer	inicio	;
	private	Integer	tamano	;
	
	
	public Integer getCod_producto() {
		return cod_producto;
	}
	public void setCod_producto(Integer cod_producto) {
		this.cod_producto = cod_producto;
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
 
	
	
	
	
	
}
