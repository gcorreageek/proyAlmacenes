/**
 * Reportes 09/08/2013
 */
package com.sigal.reportes.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Gustavo A. Correa C.
 *
 */
@SuppressWarnings("serial")
@ParentPackage("proy_calidad_SIGAL2")
public class Reportes extends ActionSupport {
	
	@Action(value="/productos",results={@Result(name="success",type="tiles",location="d_mainreportesproductos")})
	public String productos(){  
		return SUCCESS; 
	} 

}
