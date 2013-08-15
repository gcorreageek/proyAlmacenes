/**
 * Reportes 09/08/2013
 */
package com.sigal.reportes.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.sigal.informeexterno.bean.InformeExternoDTO;
import com.sigal.informeexterno.service.InformeExternoService;
import com.sigal.informeinterno.bean.InformeInternoDTO;
import com.sigal.informeinterno.service.InformeInternoService;
import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.mantenimiento.service.ProductoService;

/**
 * @author Gustavo A. Correa C.
 *
 */
@SuppressWarnings("serial")
@ParentPackage("proy_calidad_SIGAL2")
public class Reportes extends ActionSupport {
	private final Log log = org.apache.commons.logging.LogFactory.getLog(getClass());
	private final ProductoService objProServ = new ProductoService();
	private final InformeInternoService  objInfInternoServ = new InformeInternoService();
	private final InformeExternoService  objInfExternoServ = new InformeExternoService();
	
	private String informe;
	private String tipo;
	
	private List<ProductoDTO>  lstProductos = new ArrayList<ProductoDTO>();
	private ProductoDTO objProducto;
	
	
	private List<InformeInternoDTO>  lstInformeInterno = new ArrayList<InformeInternoDTO>();
	private List<InformeExternoDTO>  lstInformeExterno = new ArrayList<InformeExternoDTO>();
	
	
	
	@Action(value="/productos",results={@Result(name="success",type="tiles",location="d_mainreportesproductos")})
	public String productos(){  
		return SUCCESS; 
	}  
	@Action(value="/reporteProductos",results={@Result(name="success",type="jasper",
			params= {"format","PDF","contentDisposition","attachment;filename=\"reportes_productos.pdf\"","dataSource","lstProductos"}, 
			location = "reportes/report1.jasper")})
	public String reporteProductos(){  
		objProducto.setDesc_producto(objProducto.getDesc_producto().trim());
		if("Seleccionar".equals(objProducto.getUnidadMedida())){
			objProducto.setUnidadMedida("");
		}
		try {
			this.lstProductos = objProServ.buscarProductosXDesc(objProducto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return SUCCESS;
	} 
	@Action(value="/informe",results={@Result(name="success",type="tiles",location="d_mainreportesinforme")})
	public String informe(){  
		return SUCCESS; 
	} 
	@Action(value="/reporteInformeInterno",results={@Result(name="success",type="jasper",
			params= {"format","PDF","contentDisposition","attachment;filename=\"reportes_informes_interno.pdf\"","dataSource","lstInformeInterno"}, 
			location = "reportes/report2.jasper")})
	public String reporteInforme(){  
		log.error("Tipo:"+this.tipo);
		InformeInternoDTO ii = new InformeInternoDTO();
		if("Seleccionar".equals(this.tipo)){
			ii.setTipo_informe_interno("");
		}else{
			ii.setTipo_informe_interno(this.tipo);
		} 
		
		try {
			lstInformeInterno= objInfInternoServ.lista(ii); 
			if(log.isDebugEnabled()){
				log.debug("valorr::"+lstInformeInterno);
			}
		} catch (Exception e) {
			log.error(e);
		} 
		return SUCCESS;
	} 
	@Action(value="/reporteInformeExterno",results={@Result(name="success",type="jasper",
			params= {"format","PDF","contentDisposition","attachment;filename=\"reportes_informes_externo.pdf\"","dataSource","lstInformeExterno"}, 
			location = "reportes/report3.jasper")})
	public String reporteInformeExterno(){
		log.error("Tipo:"+this.tipo);
		InformeExternoDTO ie = new InformeExternoDTO();
		if("Seleccionar".equals(this.tipo)){
			ie.setTipo_informe_externo("");
		}else{
			ie.setTipo_informe_externo(this.tipo);
		} 
		
		try {
			lstInformeExterno= objInfExternoServ.lista(ie);
			if(log.isDebugEnabled()){
				log.debug("valorr::"+lstInformeExterno);
			}
		} catch (Exception e) {
			log.error(e);
		} 
		return SUCCESS;
	} 
	
	
	
	/**
	 * @return the lstProductos
	 */
	public List<ProductoDTO> getLstProductos() {
		return lstProductos;
	} 
	/**
	 * @param lstProductos the lstProductos to set
	 */
	public void setLstProductos(List<ProductoDTO> lstProductos) {
		this.lstProductos = lstProductos;
	}
	/**
	 * @return the objProducto
	 */
	public ProductoDTO getObjProducto() {
		return objProducto;
	}
	/**
	 * @param objProducto the objProducto to set
	 */
	public void setObjProducto(ProductoDTO objProducto) {
		this.objProducto = objProducto;
	}
	/**
	 * @return the informe
	 */
	public String getInforme() {
		return informe;
	}
	/**
	 * @param informe the informe to set
	 */
	public void setInforme(String informe) {
		this.informe = informe;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the lstInformeInterno
	 */
	public List<InformeInternoDTO> getLstInformeInterno() {
		return lstInformeInterno;
	}
	/**
	 * @param lstInformeInterno the lstInformeInterno to set
	 */
	public void setLstInformeInterno(List<InformeInternoDTO> lstInformeInterno) {
		this.lstInformeInterno = lstInformeInterno;
	}
	/**
	 * @return the lstInformeExterno
	 */
	public List<InformeExternoDTO> getLstInformeExterno() {
		return lstInformeExterno;
	}
	/**
	 * @param lstInformeExterno the lstInformeExterno to set
	 */
	public void setLstInformeExterno(List<InformeExternoDTO> lstInformeExterno) {
		this.lstInformeExterno = lstInformeExterno;
	}

 
	
	
	
	
	
	
	

}
