/**
 * ProveedorAction 21/07/2013
 */
package com.sigal.mantenimiento.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Gustavo A. Correa C.
 *
 */
@ParentPackage("proy_calidad_SIGAL2")
public class ProveedorAction extends ActionSupport {

	
	@Action(value="/mainProveedor",results={@Result(name="success",type="tiles",location="d_mainproveedor")})
	public String mainProveedor(){ 
		return SUCCESS;
	}
	@Action(value="/nuevoProveedor",results={@Result(name="success",type="tiles",location="d_nuevoproveedor")})
	public String nuevoProveedor(){
		return SUCCESS;
	}
	
	
}
