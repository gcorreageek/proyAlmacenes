/**
 * InformeInternoDTO 29/07/2013
 */
package com.sigal.informeinterno.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author Gustavo A. Correa C.
 *
 */
public class InformeInternoDTO  implements Serializable{ 
	private static final long serialVersionUID = 338366121961987591L;
	//	select cod_informe_interno, nro_informe_interno,fecha_informe_interno,
//	tipo_informe_interno, cod_usuario, cod_pedido from tb_informe_interno
	private Integer cod_informe_interno;
	private java.sql.Date fecha_informe_interno;
	private String tipo_informe_interno;
	private Integer cod_usuario;
	private Integer cod_pedido;
	private String obs_informeinterno;
	
	private String nom_usuario;
	private Integer inicio;
	private Integer tamano;
	private java.sql.Date fechaInicio;
	private java.sql.Date fechaFin;
	
	/**
	 * 
	 */
//	private String nom_usuario;
	private String desc_cargo;
	private String desc_area;
	private	String	comentario_pedido	;
	private	String	tipo_pedido	;//objPedido.tipo_pedido
	private	java.sql.Date	fechaDevolucion_pedido	;
	private	java.sql.Date	fechaRegistro_pedido	;//objPedido.fechaRegistro_pedido
	private	java.sql.Date	fechaEntrega_pedido	;
	private String    estado_pedido;
	private	java.sql.Date	fechaEvaluacion_pedido	;
	private String comentarioevaluacion_pedido;
    //Detalle
	private	Integer	cantidad	;
	private	String	desc_producto	;
	private	String	unidadMedida	; 
	
	/**
	 * 
	 */
	
	
	
	
	
	
	
	
	
	List<InformeInternoDetalleDTO> detalle ;
	
	
	
	public Integer getCod_informe_interno() {
		return cod_informe_interno;
	}
	public void setCod_informe_interno(Integer cod_informe_interno) {
		this.cod_informe_interno = cod_informe_interno;
	}
	public java.sql.Date getFecha_informe_interno() {
		return fecha_informe_interno;
	}
	public void setFecha_informe_interno(java.sql.Date fecha_informe_interno) {
		this.fecha_informe_interno = fecha_informe_interno;
	}
	public String getTipo_informe_interno() {
		return tipo_informe_interno;
	}
	public void setTipo_informe_interno(String tipo_informe_interno) {
		this.tipo_informe_interno = tipo_informe_interno;
	}
	public Integer getCod_usuario() {
		return cod_usuario;
	}
	public void setCod_usuario(Integer cod_usuario) {
		this.cod_usuario = cod_usuario;
	}
	public Integer getCod_pedido() {
		return cod_pedido;
	}
	public void setCod_pedido(Integer cod_pedido) {
		this.cod_pedido = cod_pedido;
	}
	public String getNom_usuario() {
		return nom_usuario;
	}
	public void setNom_usuario(String nom_usuario) {
		this.nom_usuario = nom_usuario;
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
	public java.sql.Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(java.sql.Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public java.sql.Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(java.sql.Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getObs_informeinterno() {
		return obs_informeinterno;
	}
	public void setObs_informeinterno(String obs_informeinterno) {
		this.obs_informeinterno = obs_informeinterno;
	}
	/**
	 * @return the detalle
	 */
	public List<InformeInternoDetalleDTO> getDetalle() {
		return detalle;
	}
	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<InformeInternoDetalleDTO> detalle) {
		this.detalle = detalle;
	}
	/**
	 * @return the desc_cargo
	 */
	public String getDesc_cargo() {
		return desc_cargo;
	}
	/**
	 * @param desc_cargo the desc_cargo to set
	 */
	public void setDesc_cargo(String desc_cargo) {
		this.desc_cargo = desc_cargo;
	}
	/**
	 * @return the desc_area
	 */
	public String getDesc_area() {
		return desc_area;
	}
	/**
	 * @param desc_area the desc_area to set
	 */
	public void setDesc_area(String desc_area) {
		this.desc_area = desc_area;
	}
	/**
	 * @return the comentario_pedido
	 */
	public String getComentario_pedido() {
		return comentario_pedido;
	}
	/**
	 * @param comentario_pedido the comentario_pedido to set
	 */
	public void setComentario_pedido(String comentario_pedido) {
		this.comentario_pedido = comentario_pedido;
	}
	/**
	 * @return the tipo_pedido
	 */
	public String getTipo_pedido() {
		return tipo_pedido;
	}
	/**
	 * @param tipo_pedido the tipo_pedido to set
	 */
	public void setTipo_pedido(String tipo_pedido) {
		this.tipo_pedido = tipo_pedido;
	}
	/**
	 * @return the fechaDevolucion_pedido
	 */
	public java.sql.Date getFechaDevolucion_pedido() {
		return fechaDevolucion_pedido;
	}
	/**
	 * @param fechaDevolucion_pedido the fechaDevolucion_pedido to set
	 */
	public void setFechaDevolucion_pedido(java.sql.Date fechaDevolucion_pedido) {
		this.fechaDevolucion_pedido = fechaDevolucion_pedido;
	}
	/**
	 * @return the fechaRegistro_pedido
	 */
	public java.sql.Date getFechaRegistro_pedido() {
		return fechaRegistro_pedido;
	}
	/**
	 * @param fechaRegistro_pedido the fechaRegistro_pedido to set
	 */
	public void setFechaRegistro_pedido(java.sql.Date fechaRegistro_pedido) {
		this.fechaRegistro_pedido = fechaRegistro_pedido;
	}
	/**
	 * @return the fechaEntrega_pedido
	 */
	public java.sql.Date getFechaEntrega_pedido() {
		return fechaEntrega_pedido;
	}
	/**
	 * @param fechaEntrega_pedido the fechaEntrega_pedido to set
	 */
	public void setFechaEntrega_pedido(java.sql.Date fechaEntrega_pedido) {
		this.fechaEntrega_pedido = fechaEntrega_pedido;
	}
	/**
	 * @return the estado_pedido
	 */
	public String getEstado_pedido() {
		return estado_pedido;
	}
	/**
	 * @param estado_pedido the estado_pedido to set
	 */
	public void setEstado_pedido(String estado_pedido) {
		this.estado_pedido = estado_pedido;
	}
	/**
	 * @return the fechaEvaluacion_pedido
	 */
	public java.sql.Date getFechaEvaluacion_pedido() {
		return fechaEvaluacion_pedido;
	}
	/**
	 * @param fechaEvaluacion_pedido the fechaEvaluacion_pedido to set
	 */
	public void setFechaEvaluacion_pedido(java.sql.Date fechaEvaluacion_pedido) {
		this.fechaEvaluacion_pedido = fechaEvaluacion_pedido;
	}
	/**
	 * @return the comentarioevaluacion_pedido
	 */
	public String getComentarioevaluacion_pedido() {
		return comentarioevaluacion_pedido;
	}
	/**
	 * @param comentarioevaluacion_pedido the comentarioevaluacion_pedido to set
	 */
	public void setComentarioevaluacion_pedido(String comentarioevaluacion_pedido) {
		this.comentarioevaluacion_pedido = comentarioevaluacion_pedido;
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
