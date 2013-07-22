package com.sigal.mantenimiento.action;

import java.util.ArrayList;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.mantenimiento.service.ProductoService;

@ParentPackage("proy_calidad_SIGAL2")
public class ProductoAction extends ActionSupport  {

	/*---------------------------- DECLARACION DE VARIABLES -------------------------------------*/	
ProductoService objProServ = new ProductoService();
private ProductoDTO  objProducto;
private ArrayList<ProductoDTO> lstProducto;
/*---------------------------- DECLARACION DE VARIABLES -------------------------------------*/

/*---------------------------- METODOS -------------------------------------*/
//@Action(value="/add_product",results={@Result(name="success",type="tiles",location="d_pedidosInternos")})
@Action(value="/mainProducto",results={@Result(name="success",type="tiles",location="d_mainproducto")})
public String mainProducto(){
//	objProServ.registrarProducto(objProducto);
	return SUCCESS;
}

@Action(value="/nuevoProducto",results={@Result(name="success",type="tiles",location="d_nuevoproducto")})
public String nuevoProducto(){
//	objProServ.registrarProducto(objProducto);
	return SUCCESS;
}


@Action(value="/registrarProducto",results={@Result(name="success",location="/pages/mantenimientos/mante_productos.jsp")})
public String registrarProducto(){
//	objProServ.registrarProducto(objProducto);
	return SUCCESS;
}
@Action(value="/productoStocks",results={@Result(name="success",type="tiles",location="d_productostocks")})
public String productoStocks(){ 
	return SUCCESS;
}



/*---------------------------- METODOS -------------------------------------*/


@Action(value="/listaProductos",results={@Result(name="success",type="json")})
public String listaArticulos(){
	lstProducto =objProServ.listaProductos();
	return SUCCESS;
}




/*---------------------------- METODOS DE ACCESO -------------------------------------*/
public ProductoDTO getObjProducto() {
	return objProducto;
}
public void setObjProducto(ProductoDTO objProducto) {
	this.objProducto = objProducto;
}
public ArrayList<ProductoDTO> getLstProducto() {
	return lstProducto;
}
public void setLstProducto(ArrayList<ProductoDTO> lstProducto) {
	this.lstProducto = lstProducto;
}	
	
/*---------------------------- METODOS DE ACCESO -------------------------------------*/	






}
