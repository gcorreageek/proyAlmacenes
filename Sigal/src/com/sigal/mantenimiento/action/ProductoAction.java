package com.sigal.mantenimiento.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.mantenimiento.service.ProductoService;
import com.sigal.util.Constantes;
import com.sigal.util.UtilSigal;

@ParentPackage("proy_calidad_SIGAL2")
public class ProductoAction extends ActionSupport {

	ProductoService objProServ = new ProductoService();
	private ProductoDTO objProducto;
	private List<ProductoDTO> lstProducto;
	private String mensaje;
	private Integer rsult;
	private Integer codProd;
	private Integer id;
	private Integer inicio;
	private Integer numeroPaginas;
	private Integer tagTipoListado; 
	private Integer numeroPaginasModalProducto;

	@Action(value = "/listarProductoPag", results = { @Result(name = "success", location = "/paginas/mantenimientos/paginacion_producto.jsp") })
	public String listarProductoPag() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		lstProducto = objProServ.listaProductosPaginado(comienzo, Constantes.FILAS_X_PAGINA);
		return SUCCESS;
	}
	@Action(value = "/mainProducto", results = { @Result(name = "success", type = "tiles", location = "d_mainproducto") })
	public String mainProducto() {
		lstProducto = objProServ.listaProductosPaginado(0,
				Constantes.FILAS_X_PAGINA);
		this.numeroPaginas = UtilSigal.totalDePaginas(objProServ
				.listaProductosTotal());
		this.tagTipoListado = 1;
		return SUCCESS;
	}
	
	@Action(value = "/buscarProductosXDescProdPag", results = { @Result(name = "success", location = "/paginas/mantenimientos/paginacion_producto.jsp") })
	public String buscarProductosXDescProdPag() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		lstProducto = objProServ.buscarProductosXDescPaginado(objProducto, comienzo, Constantes.FILAS_X_PAGINA);
		return SUCCESS;
	}
	@Action(value = "/buscarProductosXDescProd", results = { @Result(name = "success", type = "tiles", location = "d_mainproducto") })
	public String buscarProductosXDescProd() {
		lstProducto = objProServ.buscarProductosXDescPaginado(objProducto, 0,Constantes.FILAS_X_PAGINA);
		this.numeroPaginas = UtilSigal.totalDePaginas(objProServ.buscarProductosXDescTotal(objProducto));
		this.tagTipoListado = 2;
		return SUCCESS;
	} 
	@Action(value = "/accionProducto", results = { @Result(name = "success", type = "tiles", location = "d_actuarproducto") })
	public String accionProducto() {
		if (this.codProd != null) {
			ProductoDTO prod = new ProductoDTO();
			prod.setCod_producto(this.codProd);
			this.objProducto = objProServ.getProducto(prod);
		}
		return SUCCESS;
	}

	@Action(value = "/eliminarProducto", results = { @Result(name = "success", type = "tiles", location = "d_mainproducto") })
	public String eliminarProducto() {
		ProductoDTO prod = new ProductoDTO();
		prod.setCod_producto(this.codProd);
		Boolean rsultado = objProServ.eliminarProducto(prod);
		if (rsultado) {
			this.rsult = 0;
			this.mensaje = "Se Elimino Correctamente";
		} else {
			this.rsult = 1;
			this.mensaje = "Ocurrio un Problema";
		}
		mainProducto();
		return SUCCESS;
	}

	@Action(value = "/actuarProducto", results = { @Result(name = "success", type = "tiles", location = "d_actuarproducto") })
	public String actuarProducto() {
		Boolean rsultado = false;
		if (objProducto.getCod_producto() == null) {
			rsultado = objProServ.registrarProducto(objProducto);
		} else {
			rsultado = objProServ.actualizarProducto(objProducto);
		}
		if (rsultado) {
			this.rsult = 0;
			this.mensaje = "Todo Correctamente";
		} else {
			this.rsult = 1;
			this.mensaje = "Ocurrio un Problema";
		}
		return SUCCESS;
	} 
	//Modal
	@Action(value = "/listarProductoPagModal", results = { @Result(name = "success", location = "/paginas/mantenimientos/buscar_producto.jsp") })
	public String listarProductoPagModal() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		lstProducto = objProServ.listaProductosPaginado(comienzo, Constantes.FILAS_X_PAGINA);
		return SUCCESS;
	} 
	@Action(value = "/buscarProductosXDescProdPagModal", results = { @Result(name = "success", location = "/paginas/mantenimientos/buscar_producto.jsp") })
	public String buscarProductosXDescProdPagModal() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		lstProducto = objProServ.buscarProductosXDescPaginado(objProducto, comienzo, Constantes.FILAS_X_PAGINA);
		return SUCCESS;
	}
	@Action(value = "/listarProductoTotal", results = { @Result(name = "success", location = "/paginas/mantenimientos/producto_listado_total.jsp") })
	public String listarProductoTotal() { 
		this.numeroPaginasModalProducto = UtilSigal.totalDePaginas(objProServ.listaProductosTotal());
		System.out.println("nunmeroPaginas:"+numeroPaginasModalProducto); 
		return SUCCESS;
	}
	@Action(value = "/buscarProductoTotal", results = { @Result(name = "success", location = "/paginas/mantenimientos/producto_buscar_total.jsp") })
	public String buscarProductoTotal() { 
		this.numeroPaginasModalProducto = UtilSigal.totalDePaginas(objProServ.buscarProductosXDescTotal(objProducto)); 
		return SUCCESS;
	} 

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

	public Integer getInicio() {
		return inicio;
	}

	public void setInicio(Integer inicio) {
		this.inicio = inicio;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTagTipoListado() {
		return tagTipoListado;
	}

	public void setTagTipoListado(Integer tagTipoListado) {
		this.tagTipoListado = tagTipoListado;
	}
	public Integer getNumeroPaginasModalProducto() {
		return numeroPaginasModalProducto;
	}
	public void setNumeroPaginasModalProducto(Integer numeroPaginasModalProducto) {
		this.numeroPaginasModalProducto = numeroPaginasModalProducto;
	}
 
	
	
	
	
}
