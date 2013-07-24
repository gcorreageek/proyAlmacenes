package com.sigal.mantenimiento.action;

import java.util.List;

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
private List<ProductoDTO> lstProducto;
private String mensaje;
private Integer rsult;
private Integer codProd;
private Integer id;
private String cant;
private Integer bloqueAnterior;
private Integer bloqueSiguiente;
private Integer inicio;
private Integer tamano;
private String cadenaPaginacion;
/*---------------------------- DECLARACION DE VARIABLES -------------------------------------*/

/*---------------------------- METODOS -------------------------------------*/

private final Integer FILAS_X_PAGINA=5;
private final Integer PAGINAS_LINK=3;
//El numero de BLOCKES es el que se halla
// TOTAL/FILAS_X_PAGINA=resultado/PAGINAS_LINK=#BLOCKES

@Action(value="/paginacion",results={@Result(name="success",location="/paginas/mantenimientos/paginacion_producto.jsp")})
public String paginacion(){
	String anterior = "<li><a href=\"#\">Anterior<//a><//li>";
	String siguiente = "<li><a href=\"#\">Siguiente<//a><//li>";
	 
	Integer TOTAL = Integer.parseInt(  cant);
	
	Integer PAGINAS =  (int) Math.floor(TOTAL/FILAS_X_PAGINA)+1;
	System.out.println("Ultimo:"+PAGINAS);
	Integer NUMERO_BLOQUES =(int) Math.floor( PAGINAS/PAGINAS_LINK);
	
	String cadena = ""; 
	if(NUMERO_BLOQUES>PAGINAS_LINK){
		if(bloqueAnterior==0){
			
		}else{
			anterior = anterior.replaceAll("#", bloqueAnterior.toString());
			cadena= cadena +anterior;
		}	
		bloqueAnterior=bloqueAnterior+1;
	}
	System.out.println("1:"+NUMERO_BLOQUES+">"+PAGINAS_LINK);
	inicio = 0;
	tamano = 0; 
	if(NUMERO_BLOQUES>PAGINAS_LINK){
		int sum=-1;
		while(bloqueAnterior>-1){
			sum= sum+1;
			for(int i=0;i<PAGINAS_LINK;i++){
				cadena = cadena+"<li><a href=\"#\">"+(i+sum)+"<//a><//li>";
			} 
		}
		
	}else{System.out.println("education nation!"+PAGINAS); 
		for(int i=1;i<PAGINAS;i++){ System.out.println("ssssss");
			tamano = tamano + FILAS_X_PAGINA;
			inicio =  tamano-(FILAS_X_PAGINA-1);
			cadena = cadena+"<li><a href=\"mainProducto?tamano="+tamano+"&inicio="+inicio+"\">"+i+"<//a><//li>";
		} 
		
	}
	System.out.println("2:"+cadena);
	
	
	if(NUMERO_BLOQUES>PAGINAS_LINK){
		if(bloqueSiguiente==-1){
			
		}else{
			siguiente = siguiente.replaceAll("#", bloqueSiguiente.toString());
			cadena= cadena +siguiente;
		}
	} 
	cadenaPaginacion = cadena;
	System.out.println("3:"+cadena);
	System.out.println("se:"+cadenaPaginacion);
	return SUCCESS;
}

//@Action(value="/add_product",results={@Result(name="success",type="tiles",location="d_pedidosInternos")})
@Action(value="/mainProducto",results={@Result(name="success",type="tiles",location="d_mainproducto")})
public String mainProducto(){
	cant= objProServ.listaProductosTotal().toString();
	if(inicio==null && tamano==null){
		inicio =1;
		tamano =FILAS_X_PAGINA;
	}
	inicio = inicio-1;
	lstProducto=objProServ.listaProductosPaginado(inicio,5 );
	return SUCCESS;
}

@Action(value="/buscarProductosXDescProd",results={@Result(name="success",type="tiles",location="d_mainproducto")})
public String buscarProductosXDescProd(){
	System.out.println(objProducto);
	System.out.println(objProducto.getDesc_producto());
	lstProducto=objProServ.buscarProductosXDesc(objProducto);
	for (ProductoDTO prod : lstProducto) {
		System.out.println("Prod:"+prod.getDesc_producto());
	}
	return SUCCESS;
}

@Action(value="/accionProducto",results={@Result(name="success",type="tiles",location="d_actuarproducto")})
public String accionProducto(){  
	ProductoDTO prod = new ProductoDTO();
	prod.setCod_producto(this.codProd);
	this.objProducto = objProServ.getProducto(prod);
	return SUCCESS;
}
@Action(value="/eliminarProducto",results={@Result(name="success",type="tiles",location="d_mainproducto")})
public String eliminarProducto(){  
	ProductoDTO prod = new ProductoDTO();
	prod.setCod_producto(this.codProd);
	Boolean rsultado = objProServ.eliminarProducto(prod);
	if(rsultado){
		this.rsult = 0;
		this.mensaje="Se Elimino Correctamente";
	}else{
		this.rsult = 1;
		this.mensaje="Ocurrio un Problema";
	}
	this.lstProducto=objProServ.listaProductos();
	return SUCCESS;
}


@Action(value="/actuarProducto",results={@Result(name="success",type="tiles",location="d_actuarproducto")})
public String actuarProducto(){
	Boolean rsultado = false;
	if(objProducto.getCod_producto()==null){
		rsultado = objProServ.registrarProducto(objProducto);
	}else{
		rsultado = objProServ.actualizarProducto(objProducto); 
	}
	if(rsultado){
		this.rsult = 0;
		this.mensaje="Todo Correctamente";
	}else{
		this.rsult = 1;
		this.mensaje="Ocurrio un Problema";
	}
	
	return SUCCESS;
}
@Action(value="/productoStocks",results={@Result(name="success",type="tiles",location="d_productostocks")})
public String productoStocks(){ 
	return SUCCESS;
}



/*---------------------------- METODOS -------------------------------------*/


//@Action(value="/listaProductos",results={@Result(name="success",type="json")})
//public String listaArticulos(){
//	lstProducto =objProServ.listaProductos();
//	return SUCCESS;
//}




/*---------------------------- METODOS DE ACCESO -------------------------------------*/
public ProductoDTO getObjProducto() {
	return objProducto;
}
public void setObjProducto(ProductoDTO objProducto) {
	this.objProducto = objProducto;
}
public List<ProductoDTO> getLstProducto() {
	return lstProducto;
}
public void setLstProducto(List<ProductoDTO> lstProducto) {
	this.lstProducto = lstProducto;
}

public String getMensaje() {
	return mensaje;
}

public void setMensaje(String mensaje) {
	this.mensaje = mensaje;
}

public Integer getRsult() {
	return rsult;
}

public void setRsult(Integer rsult) {
	this.rsult = rsult;
}

public Integer getCodProd() {
	return codProd;
}

public void setCodProd(Integer codProd) {
	this.codProd = codProd;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getCant() {
	return cant;
}

public void setCant(String cant) {
	this.cant = cant;
}

public Integer getBloqueAnterior() {
	return bloqueAnterior;
}

public void setBloqueAnterior(Integer bloqueAnterior) {
	this.bloqueAnterior = bloqueAnterior;
}

public Integer getBloqueSiguiente() {
	return bloqueSiguiente;
}

public void setBloqueSiguiente(Integer bloqueSiguiente) {
	this.bloqueSiguiente = bloqueSiguiente;
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

public String getCadenaPaginacion() {
	return cadenaPaginacion;
}

public void setCadenaPaginacion(String cadenaPaginacion) {
	this.cadenaPaginacion = cadenaPaginacion;
}

 


	
/*---------------------------- METODOS DE ACCESO -------------------------------------*/	






}
