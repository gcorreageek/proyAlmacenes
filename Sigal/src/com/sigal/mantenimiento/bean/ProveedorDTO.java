/**
 * ProveedorDTO 24/07/2013
 */
package com.sigal.mantenimiento.bean;

import java.io.Serializable;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class ProveedorDTO  implements
 Serializable{
	
	private Integer cod_proveedor;
	private String raz_social; 
	private String ruc;
	private String telefono; 
	private Integer inicio;
	private Integer tamano;
	private String correo;
	private String habilitado;
	
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
 
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
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
	public String getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}
	
	
	
	
	
	
	

}
