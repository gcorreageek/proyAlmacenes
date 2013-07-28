/**
 * CotizacionDetalle 28/07/2013
 */
package com.sigal.cotizacion.bean;

import java.io.Serializable;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class CotizacionDetalleDTO implements Serializable{ 
	 
	private static final long serialVersionUID = 4789276187071888734L;
	private Integer cod_detallecotizacion;
	private Integer cant_detallecotizacion;
	private Integer cod_cotizacion;
	private Integer cod_producto_proveedor;
	
	private Integer cod_producto;
	private	String	desc_producto	;
	private	String	unidadMedida	;
	public Integer getCod_detallecotizacion() {
		return cod_detallecotizacion;
	}
	public void setCod_detallecotizacion(Integer cod_detallecotizacion) {
		this.cod_detallecotizacion = cod_detallecotizacion;
	}
	public Integer getCant_detallecotizacion() {
		return cant_detallecotizacion;
	}
	public void setCant_detallecotizacion(Integer cant_detallecotizacion) {
		this.cant_detallecotizacion = cant_detallecotizacion;
	}
	public Integer getCod_cotizacion() {
		return cod_cotizacion;
	}
	public void setCod_cotizacion(Integer cod_cotizacion) {
		this.cod_cotizacion = cod_cotizacion;
	}
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
	
	
	
	
	
	
	
	
	
}
