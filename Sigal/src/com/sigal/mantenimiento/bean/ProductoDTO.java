package com.sigal.mantenimiento.bean;

public class ProductoDTO {

	
	private	String	cod_producto	;
	private	String	desc_producto	;
	private	String	cod_unidadMedida	;
	private	String	cod_marca	;
	private String 	cod_categoria;
	private	int	stock_producto	;
	
	public String getCod_producto() {
		return cod_producto;
	}
	public void setCod_producto(String cod_producto) {
		this.cod_producto = cod_producto;
	}
	public String getDesc_producto() {
		return desc_producto;
	}
	public void setDesc_producto(String desc_producto) {
		this.desc_producto = desc_producto;
	}
	public String getCod_unidadMedida() {
		return cod_unidadMedida;
	}
	public void setCod_unidadMedida(String cod_unidadMedida) {
		this.cod_unidadMedida = cod_unidadMedida;
	}
	public String getCod_marca() {
		return cod_marca;
	}
	public void setCod_marca(String cod_marca) {
		this.cod_marca = cod_marca;
	}
	public int getStock_producto() {
		return stock_producto;
	}
	public void setStock_producto(int stock_producto) {
		this.stock_producto = stock_producto;
	}
	public String getCod_categoria() {
		return cod_categoria;
	}
	public void setCod_categoria(String cod_categoria) {
		this.cod_categoria = cod_categoria;
	}

	
	
}
