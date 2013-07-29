/**
 * OrdenCompraDetalleDTO 28/07/2013
 */
package com.sigal.ordencompra.bean;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class OrdenCompraDetalleDTO {

	private Integer cod_DetalleOrdenCompra;
	private Integer cod_ordenCompra;
	private Integer cod_producto_proveedor;
	private Integer cantidad;
	
	private String desc_producto;
	private String unidadMedida;
	private Integer stock_producto; 
	
	
	public Integer getCod_DetalleOrdenCompra() {
		return cod_DetalleOrdenCompra;
	}
	public void setCod_DetalleOrdenCompra(Integer cod_DetalleOrdenCompra) {
		this.cod_DetalleOrdenCompra = cod_DetalleOrdenCompra;
	}
	public Integer getCod_ordenCompra() {
		return cod_ordenCompra;
	}
	public void setCod_ordenCompra(Integer cod_ordenCompra) {
		this.cod_ordenCompra = cod_ordenCompra;
	}
	public Integer getCod_producto_proveedor() {
		return cod_producto_proveedor;
	}
	public void setCod_producto_proveedor(Integer cod_producto_proveedor) {
		this.cod_producto_proveedor = cod_producto_proveedor;
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
