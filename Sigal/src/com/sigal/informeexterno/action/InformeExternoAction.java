/**
 * InformeExternoAction 22/07/2013
 */
package com.sigal.informeexterno.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sigal.informeexterno.bean.InformeExternoDTO;
import com.sigal.informeexterno.bean.InformeExternoDetalleDTO;
import com.sigal.informeexterno.service.InformeExternoService;
import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.mantenimiento.bean.ProductoProveedorDTO;
import com.sigal.mantenimiento.service.ProductoProveedorService;
import com.sigal.mantenimiento.service.ProductoService;
import com.sigal.ordencompra.bean.OrdenCompraDetalleDTO;
import com.sigal.ordencompra.service.OrdenCompraDetalleService;
import com.sigal.seguridad.bean.UsuarioDTO;

/**
 * @author Gustavo A. Correa C.
 * 
 */
@ParentPackage("proy_calidad_SIGAL2")
public class InformeExternoAction extends ActionSupport {
	InformeExternoService objInfExternoServ = new InformeExternoService();
	// ProductoService objProdServ = new ProductoService();
	OrdenCompraDetalleService objOCDetServ = new OrdenCompraDetalleService();
	ProductoProveedorService objProdProveeServ = new ProductoProveedorService();
	ProductoService objProductoServ = new ProductoService();
	// ProductoDTO objProducto;
	// AreaService objAreaServ = new AreaService();

	Map<String, Object> lasesion = ActionContext.getContext().getSession();
	List<InformeExternoDetalleDTO> lstIEDet;

	// private Integer codProd;
	private String mensaje;
	private Integer rsult;
	// private Integer rsult;
	private InformeExternoDTO objInformeExterno;

	@Action(value = "/mainInformeExternoEntrada", results = { @Result(name = "success", type = "tiles", location = "d_maininformeexternoentrada") })
	public String mainInformeExternoEntrada() {
		return SUCCESS;
	}

	@Action(value = "/mainInformeExternoSalida", results = { @Result(name = "success", type = "tiles", location = "d_maininformeexternosalida") })
	public String mainInformeExternoSalida() {
		return SUCCESS;
	}

	// guardarIEE
	@Action(value = "/guardarIEE", results = { @Result(name = "success", location = "/paginas/pedido/pedido_evaluacion_mensaje.jsp") })
	public String guardarIEE() {
		try {
			UsuarioDTO usuario = (UsuarioDTO) lasesion.get("objUsuario");
			objInformeExterno.setCod_usuario(usuario.getCod_usuario());
			objInformeExterno.setTipo_informe_externo("Entrada");
			lstIEDet = new ArrayList<InformeExternoDetalleDTO>();
			OrdenCompraDetalleDTO ocDet = new OrdenCompraDetalleDTO();
			if (objInformeExterno.getCod_ordencompra() == null) {
				this.mensaje = "Agrege Orden de Compra";
				this.rsult = 0;
				return SUCCESS;
			}
			ocDet.setCod_ordenCompra(objInformeExterno.getCod_ordencompra());
			List<OrdenCompraDetalleDTO> lstDetOC = objOCDetServ
					.listaOrdenCompraXidOrdenCompra(ocDet);
			for (OrdenCompraDetalleDTO detalleOCDTO : lstDetOC) {
				InformeExternoDetalleDTO ieDet = new InformeExternoDetalleDTO();
				ieDet.setCod_detalle_ordencompra(detalleOCDTO
						.getCod_DetalleOrdenCompra());
				// coddetalleordencimpra
				lstIEDet.add(ieDet);
			}
			Integer r = (Integer) objInfExternoServ.registrarOrdenCompra(
					objInformeExterno, lstIEDet);
			System.out.println("Respuesta:" + r);
			if (r > 0) {
				System.out.println("No deberia entrar aki1:" + r);
				this.mensaje = "Se ingreso correctamente el Informe Externo Entrada";
				this.rsult = 1;
			} else {
				System.out.println("No deberia entrar aki2:" + r);
				this.mensaje = "Ocurrio un error en guardar el IEE";
				this.rsult = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.mensaje = "Ocurrio un error en guardar el IEE";
			this.rsult = 0;
		}
		return SUCCESS;
	}

	@Action(value = "/guardarIES", results = { @Result(name = "success", location = "/paginas/pedido/pedido_evaluacion_mensaje.jsp") })
	public String guardarIES() {
		try {
			UsuarioDTO usuario = (UsuarioDTO) lasesion.get("objUsuario");
			objInformeExterno.setCod_usuario(usuario.getCod_usuario());
			objInformeExterno.setTipo_informe_externo("Salida");
			lstIEDet = new ArrayList<>();
			OrdenCompraDetalleDTO ocDet = new OrdenCompraDetalleDTO();
			if (objInformeExterno.getCod_ordencompra() == null) {
				this.mensaje = "Agrege Orden de Compra";
				this.rsult = 0;
				return SUCCESS;
			}
			ocDet.setCod_ordenCompra(objInformeExterno.getCod_ordencompra());
			List<OrdenCompraDetalleDTO> lstDetOC = objOCDetServ
					.listaOrdenCompraXidOrdenCompra(ocDet);
			for (OrdenCompraDetalleDTO detalleOCDTO : lstDetOC) {
				InformeExternoDetalleDTO ieDet = new InformeExternoDetalleDTO();
				ieDet.setCod_detalle_ordencompra(detalleOCDTO
						.getCod_DetalleOrdenCompra());
				System.out.println("mediavuelta:"
						+ detalleOCDTO.getCod_producto_proveedor());
				ProductoProveedorDTO prodProvee = new ProductoProveedorDTO();
				prodProvee.setCod_producto_proveedor(detalleOCDTO
						.getCod_producto_proveedor());
				System.out.println("gracias:"
						+ prodProvee.getCod_producto_proveedor());
				prodProvee = objProdProveeServ.getProductoProveedor(prodProvee);
				ProductoDTO prod = new ProductoDTO();
				prod.setCod_producto(prodProvee.getCod_producto());
				prod = objProductoServ.getProducto(prod);
				System.out.println("gracias1:" + prod.getCod_producto());
				System.out.println("gracias2:" + prod.getStock_producto());
				if (prod.getStock_producto() < detalleOCDTO.getCantidad()) {
					this.mensaje = "No hay stock suficiente para el producto \""
							+ prod.getDesc_producto() + "\"";
					this.rsult = 0;
					return SUCCESS;
				}
				lstIEDet.add(ieDet);
			}
			Integer r = (Integer) objInfExternoServ.registrarOrdenCompra(
					objInformeExterno, lstIEDet);
			if (r > 0) {
				this.mensaje = "Se ingreso correctamente el Informe Externo Salida";
				this.rsult = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.mensaje = "Ocurrio un error en guardar el IES";
			this.rsult = 0;
		}
		return SUCCESS;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public InformeExternoDTO getObjInformeExterno() {
		return objInformeExterno;
	}

	public void setObjInformeExterno(InformeExternoDTO objInformeExterno) {
		this.objInformeExterno = objInformeExterno;
	}

	public Integer getRsult() {
		return rsult;
	}

	public void setRsult(Integer rsult) {
		this.rsult = rsult;
	}

}
