/**
 * InformeExternoDetalle 29/07/2013
 */
package com.sigal.informeexterno.bean;

import java.io.Serializable;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class InformeExternoDetalleDTO implements Serializable{
 
	private static final long serialVersionUID = -8522763864909669801L;
	//	 cod_detalle_informe_externo, cod_informe_externo, cod_detalle_ordencompra
	private Integer cod_detalle_informe_externo;
	private Integer cod_informe_externo;
	private Integer cod_detalle_ordencompra;
	
	private	Integer	cantidad	;
	private	String	desc_producto	;
	private	String	unidadMedida	;
	private String raz_social;
	
	
	
	public Integer getCod_detalle_informe_externo() {
		return cod_detalle_informe_externo;
	}
	public void setCod_detalle_informe_externo(Integer cod_detalle_informe_externo) {
		this.cod_detalle_informe_externo = cod_detalle_informe_externo;
	}
	public Integer getCod_informe_externo() {
		return cod_informe_externo;
	}
	public void setCod_informe_externo(Integer cod_informe_externo) {
		this.cod_informe_externo = cod_informe_externo;
	}
	public Integer getCod_detalle_ordencompra() {
		return cod_detalle_ordencompra;
	}
	public void setCod_detalle_ordencompra(Integer cod_detalle_ordencompra) {
		this.cod_detalle_ordencompra = cod_detalle_ordencompra;
	}
	/**
	 * @return the cantidad
	 */
	public Integer getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the desc_producto
	 */
	public String getDesc_producto() {
		return desc_producto;
	}
	/**
	 * @param desc_producto the desc_producto to set
	 */
	public void setDesc_producto(String desc_producto) {
		this.desc_producto = desc_producto;
	}
	/**
	 * @return the unidadMedida
	 */
	public String getUnidadMedida() {
		return unidadMedida;
	}
	/**
	 * @param unidadMedida the unidadMedida to set
	 */
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	/**
	 * @return the raz_social
	 */
	public String getRaz_social() {
		return raz_social;
	}
	/**
	 * @param raz_social the raz_social to set
	 */
	public void setRaz_social(String raz_social) {
		this.raz_social = raz_social;
	}
	
	
	
	
	
}
