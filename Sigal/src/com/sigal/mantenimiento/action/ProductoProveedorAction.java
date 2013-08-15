/**
 * ProveedorAction 21/07/2013
 */
package com.sigal.mantenimiento.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.mantenimiento.bean.ProductoProveedorDTO;
import com.sigal.mantenimiento.service.ProductoProveedorService;
import com.sigal.mantenimiento.service.ProductoService;
import com.sigal.util.Constantes;
import com.sigal.util.UtilSigal;

/**
 * @author Gustavo A. Correa C.
 *
 */
@ParentPackage("proy_calidad_SIGAL2")
public class ProductoProveedorAction extends ActionSupport {
	private final Log log = LogFactory.getLog(getClass());
	ProductoProveedorService objProServ = new ProductoProveedorService();
	ProductoService objProductoServ = new ProductoService();
	private ProductoProveedorDTO objProductoProveedor;
	private List<ProductoProveedorDTO> lstProductoProveedor;
	private List<ProductoDTO> lstProducto;
	private String mensaje;
	private Integer rsult;
	private Integer codProdProvee;
	private Integer id;
	private Integer inicio;
	private Integer numeroPaginas;
	private Integer tagTipoListado;

	@Action(value = "/listarProductoProveedorPag", results = { @Result(name = "success", location = "/paginas/mantenimientos/paginacion_producto_proveedor.jsp") })
	public String listarProductoProveedorPag() {
		log.debug("paso:"+inicio);
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA)
					- Constantes.FILAS_X_PAGINA;
		} 
		try {
			lstProductoProveedor = objProServ.listaProductosProveedorPaginado(comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) { 
			log.error("",e);
		}
		return SUCCESS;
	}

	@Action(value = "/mainProductoProveedor", results = { @Result(name = "success", type = "tiles", location = "d_mainproductoproveedor") })
	public String mainProductoProveedor() {
		try {
			lstProductoProveedor = objProServ.listaProductosProveedorPaginado(0, Constantes.FILAS_X_PAGINA);
			this.numeroPaginas = UtilSigal.totalDePaginas(objProServ.listaProductosProveedorTotal());
			this.tagTipoListado = 1;
		} catch (Exception e) { 
			log.error("",e);
		}
		return SUCCESS;
	}
	
	@Action(value = "/buscarProductoProveedorXRazonSocialAndDescProdPag", results = { @Result(name = "success", location = "/paginas/mantenimientos/paginacion_producto_proveedor.jsp") })
	public String buscarProductoProveedorXRazonSocialAndDescProdPag() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstProductoProveedor = objProServ.buscarProductosProveedorXRazonSocialAndDescProdPaginado(objProductoProveedor, comienzo, Constantes.FILAS_X_PAGINA);
			
		} catch (Exception e) {
			log.error("",e);
		}
		return SUCCESS;
	}

	@Action(value = "/buscarProductoProveedorXRazonSocialAndDescProd", results = { @Result(name = "success", type = "tiles", location = "d_mainproductoproveedor") })
	public String buscarProductoProveedorXRazonSocialAndDescProd() {
		try {

			System.out.println("lsita"+objProductoProveedor.getDesc_producto());
			System.out.println("lsita"+objProductoProveedor.getRaz_social());
			lstProductoProveedor = objProServ.buscarProductosProveedorXRazonSocialAndDescProdPaginado(objProductoProveedor, 0, Constantes.FILAS_X_PAGINA);
			this.numeroPaginas = UtilSigal.totalDePaginas(objProServ.buscarProductosProveedorXRazonSocialAndDescProdTotal(objProductoProveedor));
			System.out.println("lsita"+lstProductoProveedor.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.tagTipoListado = 2;
		return SUCCESS;
	}

	@Action(value = "/accionProductoProveedor", results = { @Result(name = "success", type = "tiles", location = "d_actuarproductoproveedor") })
	public String accionProductoProveedor() {
		if (this.codProdProvee != null) {
			ProductoProveedorDTO prodProvee = new ProductoProveedorDTO();
			prodProvee.setCod_producto_proveedor(this.codProdProvee);
			try {
				this.objProductoProveedor = objProServ.getProductoProveedor(prodProvee);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//		lstProducto = objProductoServ.listaProductosPaginado(0, Constantes.FILAS_X_PAGINA);
		return SUCCESS;
	}

	@Action(value = "/eliminarProductoProveedor", results = { @Result(name = "success", type = "tiles", location = "d_mainproductoproveedor") })
	public String eliminarProductoProveedor() {
		ProductoProveedorDTO productProve = new ProductoProveedorDTO();
		productProve.setCod_producto_proveedor(this.codProdProvee);
		Boolean rsultado=false;
		try {
			rsultado = objProServ.eliminarProductoProveedor(productProve);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (rsultado) {
			this.rsult = 0;
			this.mensaje = "Se Elimino Correctamente";
		} else {
			this.rsult = 1;
			this.mensaje = "Ocurrio un Problema";
		}
		mainProductoProveedor();
		return SUCCESS;
	}

	@Action(value = "/actuarProductoProveedor", results = { @Result(name = "success", type = "tiles", location = "d_actuarproductoproveedor") })
	public String actuarProductoProveedor() {
		log.debug("mra:"+objProductoProveedor.getDesc_producto());
		Boolean rsultado = false;
		try {
			if (objProductoProveedor.getCod_producto_proveedor() == null) {
				rsultado = objProServ.registrarProductoProveedor(objProductoProveedor);
			} else {
				rsultado = objProServ.actualizarProductoProveedor(objProductoProveedor);
			}
		} catch (Exception e) {
			rsultado=false;
			e.printStackTrace();
		}
		log.debug("mra:"+objProductoProveedor.getDesc_producto());
		if (rsultado) {
			this.rsult = 0;
			this.mensaje = "Todo Correctamente";
		} else {
			this.rsult = 1;
			this.mensaje = "Ocurrio un Problema";
		}
		return SUCCESS;
	}

	public ProductoProveedorDTO getObjProductoProveedor() {
		return objProductoProveedor;
	}

	public void setObjProductoProveedor(ProductoProveedorDTO objProductoProveedor) {
		this.objProductoProveedor = objProductoProveedor;
	}

	public List<ProductoProveedorDTO> getLstProductoProveedor() {
		return lstProductoProveedor;
	}

	public void setLstProductoProveedor(
			List<ProductoProveedorDTO> lstProductoProveedor) {
		this.lstProductoProveedor = lstProductoProveedor;
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

	public Integer getCodProdProvee() {
		return codProdProvee;
	}

	public void setCodProdProvee(Integer codProdProvee) {
		this.codProdProvee = codProdProvee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getTagTipoListado() {
		return tagTipoListado;
	}

	public void setTagTipoListado(Integer tagTipoListado) {
		this.tagTipoListado = tagTipoListado;
	}

	public List<ProductoDTO> getLstProducto() {
		return lstProducto;
	}

	public void setLstProducto(List<ProductoDTO> lstProducto) {
		this.lstProducto = lstProducto;
	}


	 
	
	
	
	
	
	
}
