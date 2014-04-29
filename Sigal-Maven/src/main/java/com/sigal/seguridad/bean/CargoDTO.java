package com.sigal.seguridad.bean;

import java.io.Serializable;

public class CargoDTO implements Serializable{
 
	private static final long serialVersionUID = -3830777767106851948L;
	private Integer cod_cargo;
	private String desc_cargo;
	private Integer cod_area;
	
	private Integer inicio;
	private Integer tamano;
	private String desc_area;
	
	public Integer getCod_cargo() {
		return cod_cargo;
	}
	public void setCod_cargo(Integer cod_cargo) {
		this.cod_cargo = cod_cargo;
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
	public String getDesc_area() {
		return desc_area;
	}
	public void setDesc_area(String desc_area) {
		this.desc_area = desc_area;
	}
 
	
	
	
	
	
}
