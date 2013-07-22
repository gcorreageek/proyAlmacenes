/**
 * OrdenCompraAction 21/07/2013
 */
package com.sigal.ordencompra.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Gustavo A. Correa C.
 *
 */
@ParentPackage("proy_calidad_SIGAL2")
public class OrdenCompraAction extends ActionSupport {

	@Action(value="/mainOrdenCompra",results={@Result(name="success",type="tiles",location="d_mainordencompra")})
	public String mainCotizacion(){ 
		return SUCCESS;
	}
}
