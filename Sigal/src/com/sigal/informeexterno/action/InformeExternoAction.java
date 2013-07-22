/**
 * InformeExternoAction 22/07/2013
 */
package com.sigal.informeexterno.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Gustavo A. Correa C.
 *
 */
@ParentPackage("proy_calidad_SIGAL2")
public class InformeExternoAction extends ActionSupport  {

	
	@Action(value="/mainInformeExternoEntrada",results={@Result(name="success",type="tiles",location="d_maininformeexternoentrada")})
	public String mainInformeExternoEntrada(){ 
		return SUCCESS;
	}
}
