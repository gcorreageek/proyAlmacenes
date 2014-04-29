/**
 * InformeInternoDetalleDTO 29/07/2013
 */
package com.sigal.informeinterno.bean;

import java.io.Serializable;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class InformeInternoDetalleDTO implements Serializable{
//	cod_detalle_informe_interno,cod_informe_interno,cod_detalle_pedido
	 
	private static final long serialVersionUID = -4296690978663298816L;
	private Integer cod_detalle_informe_interno;
	private Integer cod_informe_interno;
	private Integer cod_detalle_pedido;
	
	
	private	Integer	cantidad	;
	private	String	desc_producto	;
	private	String	unidadMedida	; 
	
	public Integer getCod_detalle_informe_interno() {
		return cod_detalle_informe_interno;
	}
	public void setCod_detalle_informe_interno(Integer cod_detalle_informe_interno) {
		this.cod_detalle_informe_interno = cod_detalle_informe_interno;
	}
	public Integer getCod_informe_interno() {
		return cod_informe_interno;
	}
	public void setCod_informe_interno(Integer cod_informe_interno) {
		this.cod_informe_interno = cod_informe_interno;
	}
	public Integer getCod_detalle_pedido() {
		return cod_detalle_pedido;
	}
	public void setCod_detalle_pedido(Integer cod_detalle_pedido) {
		this.cod_detalle_pedido = cod_detalle_pedido;
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
	
	
	
	
	

}
