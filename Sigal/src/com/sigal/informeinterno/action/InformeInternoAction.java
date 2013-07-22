/**
 * InformeInternoAction 22/07/2013
 */
package com.sigal.informeinterno.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Gustavo A. Correa C.
 *
 */
@ParentPackage("proy_calidad_SIGAL2")
public class InformeInternoAction extends ActionSupport {

	@Action(value="/mainInformeInternoSalida",results={@Result(name="success",type="tiles",location="d_maininformeinternosalida")})
	public String mainInformeInternoSalida(){ 
		return SUCCESS;
	}
	@Action(value="/mainInformeInternoEntrada",results={@Result(name="success",type="tiles",location="d_maininformeinternoentrada")})
	public String mainInformeInternoEntrada(){ 
		return SUCCESS;
	}
}
