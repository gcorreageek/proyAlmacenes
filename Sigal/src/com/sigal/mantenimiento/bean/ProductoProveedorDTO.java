/**
 * ProveedorDTO 24/07/2013
 */
package com.sigal.mantenimiento.bean;

import java.io.Serializable;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class ProductoProveedorDTO  implements
 Serializable{  
	private Integer cod_producto_proveedor;
	private	Integer	cod_producto	;
	private	String	desc_producto	;
	private	String	unidadMedida	;
	private	String	marca	;
	private String 	categoria;
	private Integer cod_proveedor;
	private String raz_social; 
	private Double precio;
	private String habilitado;
	
	private Integer inicio;
	private Integer tamano;
	
	
	
	
	
	public Integer getCod_producto_proveedor() {
		return cod_producto_proveedor;
	}
	public void setCod_producto_proveedor(Integer cod_producto_proveedor) {
		this.cod_producto_proveedor = cod_producto_proveedor;
	}
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
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
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
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	
	
	

}
