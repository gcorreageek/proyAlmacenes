package com.sigal.seguridad.bean;

import java.io.Serializable;

public class AreaDTO implements Serializable{
 
	private static final long serialVersionUID = 6452632689958443914L;
	private Integer cod_area;
	private String desc_area;
	
	private Integer inicio;
	private Integer tamano;
	  
	public Integer getCod_area() {
		return cod_area;
	}
	public void setCod_area(Integer cod_area) {
		this.cod_area = cod_area;
	}
	public String getDesc_area() {
		return desc_area;
	}
	public void setDesc_area(String desc_area) {
		this.desc_area = desc_area;
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
