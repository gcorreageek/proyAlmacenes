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
public class ProductoProveedorAction extends ActionSupport {

	
	@Action(value="/mainProductoProveedor",results={@Result(name="success",type="tiles",location="d_mainproductoproveedor")})
	public String mainProductoProveedor(){ 
		return SUCCESS;
	}
	@Action(value="/nuevoProductoProveedor",results={@Result(name="success",type="tiles",location="d_nuevoproductoproveedor")})
	public String nuevoProductoProveedor(){
		return SUCCESS;
	}
	
	
}
