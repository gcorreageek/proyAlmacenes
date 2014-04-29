package com.sigal.mantenimiento.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.mantenimiento.service.ProductoService;
import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.util.Constantes;
import com.sigal.util.UtilSigal;

@ParentPackage("Sigal-Maven")
public class ProductoAction extends ActionSupport {
	private final Log log = LogFactory.getLog(getClass());
	Map<String, Object> lasesion = ActionContext.getContext().getSession(); 
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
	private Integer idProve;
	private String url;
	private String tipo;

	@Action(value = "/listarProductoPag", results = { @Result(name = "success", location = "/paginas/mantenimientos/paginacion_producto.jsp") })
	public String listarProductoPag() {
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstProducto = objProServ.listaProductosPaginado(comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			log.error("",e);
		}
		return SUCCESS;
	}
	@Action(value = "/mainProducto", results = { @Result(name = "success", type = "tiles", location = "d_mainproducto") })
	public String mainProducto() {
		try {
			lstProducto = objProServ.listaProductosPaginado(0,
					Constantes.FILAS_X_PAGINA);
			this.numeroPaginas = UtilSigal.totalDePaginas(objProServ
					.listaProductosTotal());
		} catch (Exception e) {
			log.error("",e);
		}
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
		try {
			objProducto.setDesc_producto(objProducto.getDesc_producto().trim());
			if("Seleccionar".equals(objProducto.getUnidadMedida()) || objProducto.getUnidadMedida()==null){
				objProducto.setUnidadMedida("");
			}
			lstProducto = objProServ.buscarProductosXDescPaginado(objProducto, comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			log.error("",e);
		}
		return SUCCESS;
	}
	@Action(value = "/buscarProductosXDescProd", results = { @Result(name = "success", type = "tiles", location = "d_mainproducto") })
	public String buscarProductosXDescProd() {
		try {
			String prod = objProducto.getDesc_producto();
			log.debug("prod:"+objProducto.getDesc_producto());
			objProducto.setDesc_producto(objProducto.getDesc_producto().trim());
			if("Seleccionar".equals(objProducto.getUnidadMedida()) || objProducto.getUnidadMedida()==null){
				objProducto.setUnidadMedida("");
			}
			lstProducto = objProServ.buscarProductosXDescPaginado(objProducto, 0,Constantes.FILAS_X_PAGINA);
			log.debug("tamm:"+lstProducto.size());
			this.numeroPaginas = UtilSigal.totalDePaginas(objProServ.buscarProductosXDescTotal(objProducto));
			objProducto.setDesc_producto(prod);
		} catch (Exception e) {
			log.error("",e);
		}
		this.tagTipoListado = 2;
		return SUCCESS;
	} 
	@Action(value = "/accionProducto", results = { @Result(name = "success", type = "tiles", location = "d_actuarproducto") })
	public String accionProducto() {
		if (this.codProd != null) {
			ProductoDTO prod = new ProductoDTO();
			prod.setCod_producto(this.codProd);
			try {
				this.objProducto = objProServ.getProducto(prod);
			} catch (Exception e) {
				log.error("",e);
			}
		}
		return SUCCESS;
	}

	@Action(value = "/eliminarProducto", results = { @Result(name = "success", type = "tiles", location = "d_mainproducto") })
	public String eliminarProducto() {
//		lasesion
		UsuarioDTO usuario =  (UsuarioDTO) lasesion.get("objUsuario");
		if(usuario!=null){
			ProductoDTO prod = new ProductoDTO();
			prod.setCod_producto(this.codProd);
			Boolean rsultado= false;
			try {
				rsultado = objProServ.eliminarProducto(prod);
			} catch (Exception e) { 
				String errorMessage = e.getMessage(); 
				if(errorMessage.indexOf("fk_codproducto_producto")!=-1){
					this.rsult = 0;
					this.mensaje = "No se puede eliminar, se encuentra en una transacci�n; elimine as transacciones";
					mainProducto();
					return SUCCESS;
				} 
				log.error("",e);
			}
			if (rsultado) {
				this.rsult = 1;
				this.mensaje = "Se Elimino Correctamente";
			} else {
				this.rsult = 0;
				this.mensaje = "Ocurrio un Problema";
			}
			mainProducto();	
		} 
		return SUCCESS;
	}

	@Action(value = "/actuarProducto", results = { @Result(name = "success", type = "tiles", location = "d_actuarproducto") })
	public String actuarProducto() {
		Boolean rsultado = true;
		objProducto.setDesc_producto(objProducto.getDesc_producto().trim());
		if("".equals(objProducto.getDesc_producto())){ 
			this.rsult = 0;
			this.mensaje = "Ingrese Producto Valido"; 
			return SUCCESS;
		} 
		try {
			if (rsultado) {
				if (objProducto.getCod_producto() == null) {
					objProducto.setStock_producto(0);
					rsultado = objProServ.registrarProducto(objProducto);
				} else {
					Integer stock = objProServ.getProducto(objProducto).getStock_producto();
					objProducto.setStock_producto(stock);
					rsultado = objProServ.actualizarProducto(objProducto);
				}
			} 
		} catch (Exception e) { 
			rsultado=false; 
			String errorMessage = e.getMessage(); 
			if(errorMessage.indexOf("desc_producto_umedidad_UNIQUE")!=-1){
				this.rsult = 0;
				this.mensaje = "El producto y la unidad ya existen";
				return SUCCESS;
			} 
			log.error("",e);
		}
		
		if (rsultado) {
			this.rsult = 1;
			this.mensaje = "Todo Correctamente";
		} else {
			this.rsult = 0;
			this.mensaje = "Ocurrio un Problema";
		}
		return SUCCESS;
	} 
	//Modal
	@Action(value = "/listarProductoPagModalHabilitados", results = { @Result(name = "success", location = "/paginas/mantenimientos/buscar_producto.jsp") })
	public String listarProductoPagModalHabilitados() {
		System.out.println("buscar1");
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstProducto = objProServ.listaProductosPaginadoHabilitados(comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			log.error("",e);
		}
		return SUCCESS;
	} 
	@Action(value = "/buscarProductosXDescProdPagModalHabilitados", results = { @Result(name = "success", location = "/paginas/mantenimientos/buscar_producto.jsp") })
	public String buscarProductosXDescProdPagModalHabilitados() {
		System.out.println("buscar2");
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			objProducto.setDesc_producto(objProducto.getDesc_producto().trim());
			if("Seleccionar".equals(objProducto.getUnidadMedida()) || objProducto.getUnidadMedida()==null){
				objProducto.setUnidadMedida("");
			}
			lstProducto = objProServ.buscarProductosXDescPaginadoHabilitados(objProducto, comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			log.error("",e);
		}
		return SUCCESS;
	}
	@Action(value = "/listarProductoTotalHabilitados", results = { @Result(name = "success", location = "/paginas/mantenimientos/producto_listado_total.jsp") })
	public String listarProductoTotalHabilitados() {  
		try {
			this.numeroPaginasModalProducto = UtilSigal.totalDePaginas(objProServ.listaProductosTotalHabilitados());
		} catch (Exception e) {
			log.error("",e);
		}
		return SUCCESS;
	}
	@Action(value = "/buscarProductoTotalHabilitados" , results = { @Result(name = "success", location = "/paginas/mantenimientos/producto_buscar_total.jsp") })
	public String buscarProductoTotalHabilitados() { 
		try {
			this.numeroPaginasModalProducto = UtilSigal.totalDePaginas(objProServ.buscarProductosXDescTotalHabilitados(objProducto));
		} catch (Exception e) {
			log.error("",e);
		} 
		return SUCCESS;
	}  
	//Modal idProve
	@Action(value = "/listarProductoPagModalidProve", results = { @Result(name = "success", location = "/paginas/mantenimientos/buscar_producto.jsp") })
	public String listarProductoPagModalidProve() {
		System.out.println("buscar3");
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstProducto = objProServ.listaProductosIdProveePaginadoHabilitados(this.idProve,comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			log.error("",e);
		}
		return SUCCESS;
	} 
	@Action(value = "/buscarProductosXDescProdPagModalidProve", results = { @Result(name = "success", location = "/paginas/mantenimientos/buscar_producto.jsp") })
	public String buscarProductosXDescProdPagModalidProve() {
		System.out.println("buscar4");
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstProducto = objProServ.buscarProductosIdProveeXDescPaginadoHabilitados(objProducto,this.idProve, comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			log.error("",e);
		}
		return SUCCESS;
	}
	@Action(value = "/listarProductoTotalidProve", results = { @Result(name = "success", location = "/paginas/mantenimientos/producto_listado_total_idproveedor.jsp") })
	public String listarProductoTotalidProve() {  
		try {
			this.numeroPaginasModalProducto = UtilSigal.totalDePaginas(objProServ.listaProductosIdProveeTotalHabilitados(this.idProve));
		} catch (Exception e) {
			log.error("",e);
		} 
		return SUCCESS;
	}
	@Action(value = "/buscarProductoTotalidProve", results = { @Result(name = "success", location = "/paginas/mantenimientos/producto_buscar_total_idproveedor.jsp") })
	public String buscarProductoTotalidProve() { 
		try {
			this.numeroPaginasModalProducto = UtilSigal.totalDePaginas(objProServ.buscarProductosIdProveeXDescTotalHabilitados(objProducto,this.idProve));
			log.debug("total:"+numeroPaginasModalProducto);
		} catch (Exception e) {
			log.error("",e);
		} 
		return SUCCESS;
	} 
	@Action(value = "/generarQR", results = { @Result(name = "success", location = "/paginas/mantenimientos/ver_qr.jsp") })
	public String generarQR() {   
		return SUCCESS;
	} 
	@Action(value = "/leerQR", results = { @Result(name = "success", location = "/paginas/mantenimientos/leer_qr.jsp") })
	public String leerQR() {
		Integer cod = getCodProd();
		ProductoDTO prod =  new ProductoDTO();
		prod.setCod_producto(cod);
		try {
			objProducto = objProServ.getProducto(prod);
		} catch (Exception e) {
			log.error("",e);
		} 
		return SUCCESS;
	}
//	guardaSessionQR
	@Action(value = "/guardaSessionQR", results = { @Result(name = "success", location = "/paginas/seguridad/login.jsp") })
	public String guardaSessionQR() {
		Integer cod = getCodProd();
		String tipo = getTipo(); 
		Object[] obj = null;
		obj = (Object[]) lasesion.get("DatosQR");
		if(obj==null){
			obj = new Object[2];
		} 
		obj[0]=cod;
		obj[1]=tipo;
		lasesion.put("DatosQR", obj);  
		return SUCCESS;
	}
	//Reportessss
	@Action(value = "/listarProductoTotal", results = { @Result(name = "success", location = "/paginas/mantenimientos/producto_listado_total_reportes.jsp") })
	public String listarProductoTotal() {  
		try {
			this.numeroPaginasModalProducto = UtilSigal.totalDePaginas(objProServ.listaProductosTotal());
		} catch (Exception e) {
			log.error("",e);
		}
		return SUCCESS;
	}
	@Action(value = "/listarProductoPagModal", results = { @Result(name = "success", location = "/paginas/mantenimientos/buscar_producto_reportes.jsp") })
	public String listarProductoPagModal() {
		System.out.println("buscar1 Reportes");
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstProducto = objProServ.listaProductosPaginado(comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			log.error("",e);
		}
		return SUCCESS;
	}
	@Action(value = "/buscarProductosXDescProdPagModal", results = { @Result(name = "success", location = "/paginas/mantenimientos/buscar_producto_reportes.jsp") })
	public String buscarProductosXDescProdPagModal() {
		System.out.println("buscar2 reportes");
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		objProducto.setDesc_producto(objProducto.getDesc_producto().trim());
		if("Seleccionar".equals(objProducto.getUnidadMedida())){
			objProducto.setUnidadMedida("");
		}
		try {
			lstProducto = objProServ.buscarProductosXDescPaginado(objProducto, comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			log.error("",e);
		}
		return SUCCESS;
	}
	@Action(value = "/buscarProductoTotal" , results = { @Result(name = "success", location = "/paginas/mantenimientos/producto_buscar_total_reportes.jsp") })
	public String buscarProductoTotal() { 
		objProducto.setDesc_producto(objProducto.getDesc_producto().trim());
		if("Seleccionar".equals(objProducto.getUnidadMedida())){
			objProducto.setUnidadMedida("");
		}
		try {
			this.numeroPaginasModalProducto = UtilSigal.totalDePaginas(objProServ.buscarProductosXDescTotal(objProducto));
		} catch (Exception e) {
			log.error("",e);
		} 
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
	public Integer getIdProve() {
		return idProve;
	}
	public void setIdProve(Integer idProve) {
		this.idProve = idProve;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
 
	
	
	
	
}
