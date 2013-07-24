/**
 * Cotizacion 21/07/2013
 */
package com.sigal.cotizacion.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Gustavo A. Correa C.
 *
 */
@ParentPackage("proy_calidad_SIGAL2")
public class CotizacionAction extends ActionSupport {
//Como veras!
	
	@Action(value="/mainCotizacion",results={@Result(name="success",type="tiles",location="d_maincotizacion")})
	public String mainCotizacion(){ 
		return SUCCESS;
	}

	
	
}
