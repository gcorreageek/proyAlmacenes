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
	
	
	
	
	
}
