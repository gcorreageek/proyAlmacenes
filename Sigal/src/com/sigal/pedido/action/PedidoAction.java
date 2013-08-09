package com.sigal.pedido.action;

//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sigal.mantenimiento.bean.ProductoDTO;
import com.sigal.mantenimiento.service.ProductoService;
import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.pedido.bean.SolicitudPedidoDTO;
import com.sigal.pedido.service.PedidoDetalleService;
import com.sigal.pedido.service.PedidoService;
import com.sigal.seguridad.bean.AreaDTO;
import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.seguridad.dao.AreaDAO;
import com.sigal.seguridad.service.AreaService;
import com.sigal.util.Constantes;
import com.sigal.util.UtilSigal;
/**
 * 
 * @author David
 * @descripcion Clase encargada de la gestion de las solicitudes de pedido
 */
@ParentPackage("proy_calidad_SIGAL2")
public class PedidoAction extends ActionSupport {
 
//	LogueoService objLogServ = new LogueoService();
	PedidoService objPedidoServ = new PedidoService(); 
	PedidoDetalleService objPedidoDetalleServ = new PedidoDetalleService();
	ProductoService objProductoServ = new ProductoService(); 
	
	AreaService objAreaServ = new AreaService();
	 
	private Map<String, Object> lasesion = ActionContext.getContext().getSession(); 
	private List<DetallePedidoDTO> lstDetPed ;
	private String mensaje;
	private Integer rsult;
	 
	private SolicitudPedidoDTO objPedido;
	private DetallePedidoDTO objDetallePedido;
	private Integer idProd;
	private Integer cantidad;
	
	private String tipoPedido;
	private String fechaEntrega;
	private String fechaDevolucion;
	private String obsDevolucion;
	
	private List<SolicitudPedidoDTO> lstPedido ;
	private Integer inicio;
	private Integer numeroPaginasModalPedido;
	private List<AreaDTO> lstArea = new ArrayList<AreaDTO>();
	private AreaDTO area;
	 
	
	
//	Date fecha = new Date();
	SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
	
	//variable para mostrar resultado de registro
	
	private String mensajeR;
	
	Integer cod_area;
	String desc_area; 
	 
	
	
	@Action(value="/nuevoPedido",results={@Result(name="success",type="tiles",location="d_mainpedido")})
	public String mainPedido(){ 
		lasesion.remove("lstDetPed");
		return SUCCESS;
	}
	@Action(value="/evaluarPedido",results={@Result(name="success",type="tiles",location="d_evaluarPedido")})
	public String evaluarPedido(){  
		lstArea = objAreaServ.listaArea(); 
		return SUCCESS;
	}							 
	@Action(value="/agregarDetallePedido",results={
			@Result(name="error",location="/paginas/pedido/detalle_pedido.jsp"),
			@Result(name="success",location="/paginas/pedido/detalle_pedido.jsp")})
	public String agregarDetallePedido(){
		lstDetPed = (ArrayList<DetallePedidoDTO>) lasesion.get("lstDetPed");
		
		DetallePedidoDTO objDetalle = new DetallePedidoDTO();
		ProductoDTO prod = new ProductoDTO();
		prod.setCod_producto(getIdProd());
		prod = objProductoServ.getProducto(prod);
		objDetalle.setCod_producto(prod.getCod_producto());
		objDetalle.setDesc_producto(prod.getDesc_producto());
		objDetalle.setUnidadMedida(prod.getUnidadMedida());
		objDetalle.setCantidad(getCantidad());
		if(lstDetPed==null){
			lstDetPed = new ArrayList<DetallePedidoDTO>();
		}
		for (DetallePedidoDTO prod2 : lstDetPed) {
			if(prod2.getCod_producto().equals(getIdProd())){
				this.rsult=0;
				this.mensaje="Producto ya existe!";
				return ERROR;
			}
		}
		lstDetPed.add(objDetalle); 
		lasesion.put("lstDetPed", lstDetPed);
		return SUCCESS;
	} 
	@Action(value="/eliminarDetallePedido",results={@Result(name="success",location="/paginas/pedido/detalle_pedido.jsp")})
	public String eliminarDetallePedido(){
		lstDetPed = (ArrayList<DetallePedidoDTO>) lasesion.get("lstDetPed");
		for (int i = 0; i < lstDetPed.size(); i++) { 
			DetallePedidoDTO det = lstDetPed.get(i); 
			if(det.getCod_producto().equals(getIdProd())){
				lstDetPed.remove(i);
			}
		}  
		lasesion.put("lstDetPed", lstDetPed);
		return SUCCESS;
	}
	@Action(value="/guardarPedido",results={@Result(name="success",location="/paginas/pedido/detalle_pedido_mensaje.jsp")})
	public String guardarPedido(){
		try {
			System.out.println("Guadrarr!");
			SolicitudPedidoDTO pedido = new SolicitudPedidoDTO();
			UsuarioDTO usuario =  (UsuarioDTO) lasesion.get("objUsuario");
			pedido.setCod_usuario(usuario.getCod_usuario());
			pedido.setComentario_pedido(getObsDevolucion());
			pedido.setEstado_pedido("Sin Atender");
			//validar las fechas
			java.sql.Date fechaEntregaS = UtilSigal.fechaDateSql(getFechaEntrega());
			java.sql.Date fechaDevolucionS = UtilSigal.fechaDateSql(getFechaDevolucion());
			//fecha1 es anterior a la fecha2
			if(fechaEntregaS==null){
				this.rsult=0;
				this.mensaje="Fecha de Entrega vacia";
				return SUCCESS;
			}
			if("Prestamo".equals(getTipoPedido())){
				if(fechaDevolucionS==null){
					this.rsult=0;
					this.mensaje="Fecha de Devolucion vacio";
					return SUCCESS;
				}
				if(fechaDevolucionS.before(fechaEntregaS)){
					this.rsult=0;
					this.mensaje="Fecha de Entrega es mayor a la Fecha de Devolucion";
					return SUCCESS;
				} 	
			}
			  
			pedido.setFechaDevolucion_pedido(UtilSigal.fechaDateSql(getFechaDevolucion()) );
			pedido.setFechaEntrega_pedido(UtilSigal.fechaDateSql(getFechaEntrega())); 
			pedido.setTipo_pedido(getTipoPedido());
			lstDetPed = (ArrayList<DetallePedidoDTO>) lasesion.get("lstDetPed");
			if(lstDetPed==null){
				this.rsult=0;
				this.mensaje="Agregar detalle";
				return SUCCESS;
			}
			objPedidoServ.registrarPedido(pedido, lstDetPed);
			lasesion.remove("lstDetPed");
			this.rsult=1;
			this.mensaje="Se registro su Pedido!";
		} catch (Exception e) { 
			e.printStackTrace();
			this.rsult=0;
			this.mensaje="Ocurrio un error al Grabar";
		}
		
		return SUCCESS;
	}
//	guardarEvaluacionPedido
	@Action(value="/guardarEvaluacionPedido",results={@Result(name="success",location="/paginas/pedido/pedido_evaluacion_mensaje.jsp")})
	public String guardarEvaluacionPedido(){
		try {
			//aprobar o desaprobar
			System.out.println("commenatrio Evaluacion!"+objPedido.getComentarioevaluacion_pedido()); 
			objPedidoServ.guardarEvaluacionPedido(objPedido);
			this.mensaje = "El Pedido se guardo con estado "+objPedido.getEstado_pedido()+"";
			this.rsult= 1;
		} catch (Exception e) {
			System.out.println("Try:"+e);
			e.printStackTrace();
			this.mensaje = "Ocurrio un error en guardar el Pedido";
			this.rsult= 0;
		}
		
		return SUCCESS;
	}

//	getDetallePedido 
	@Action(value = "/getDetallePedido", results = { @Result(name = "success", location = "/paginas/pedido/detalle_pedido_modal.jsp") })
	public String getDetallePedido() { 
		try {
			DetallePedidoDTO det = new DetallePedidoDTO();
			det.setCod_solicitudPedido(getObjPedido().getCod_solicitudPedido());
			this.lstDetPed = objPedidoDetalleServ.listaPedidoXidPedido(det) ;
		} catch (Exception e) { 
			e.printStackTrace();
		}
		return SUCCESS;
	} 
	//Modal
		@Action(value = "/listarPedidoPagModal", results = { @Result(name = "success", location = "/paginas/pedido/buscar_pedido.jsp") })
		public String listarPedidoPagModal() { 
			System.out.println("pedido1");
			Integer comienzo = null;
			if (inicio == null || inicio == 0) {
				comienzo = 0;
			} else {
				comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
			} 
			try {
				lstPedido =   objPedidoServ.listaPedidoPaginadoSinAtender(comienzo, Constantes.FILAS_X_PAGINA);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SUCCESS;
		} 
		@Action(value = "/buscarPedidoPagModal", results = { @Result(name = "success", location = "/paginas/pedido/buscar_pedido.jsp") })
		public String buscarPedidoPagModal() { 
			System.out.println("pedido2");
			Integer comienzo = null;
			if (inicio == null || inicio == 0) {
				comienzo = 0;
			} else {
				comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
			}
			try {
				lstPedido = objPedidoServ.buscarPedidoPaginadoSinAtender(objPedido, comienzo, Constantes.FILAS_X_PAGINA);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return SUCCESS;
		}
		@Action(value = "/listarPedidoTotal", results = { @Result(name = "success", location = "/paginas/pedido/pedido_listado_total.jsp") })
		public String listarPedidoTotal() { 
			System.out.println("pedido3");
			try {
				System.out.println("totla:"+objPedidoServ.listaPedidoTotal());
				this.numeroPaginasModalPedido= UtilSigal.totalDePaginas(objPedidoServ.listaPedidoTotalSinAtender());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("nunmeroPaginas:"+numeroPaginasModalPedido); 
			return SUCCESS;
		}
		@Action(value = "/buscarPedidoTotal", results = { @Result(name = "success", location = "/paginas/pedido/pedido_buscar_total.jsp") })
		public String buscarPedidoTotal() {  
			System.out.println("pedido4");
			try {
				System.out.println("total reg:"+objPedidoServ.buscarPedidoTotal(objPedido));
				this.numeroPaginasModalPedido = UtilSigal.totalDePaginas(objPedidoServ.buscarPedidoTotalSinAtender(objPedido));
				System.out.println("total paginas:"+numeroPaginasModalPedido);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return SUCCESS;
		} 
	
	
	//Modal Pedidos Aprobados
	@Action(value = "/listarPedidoPagModalAprobados", results = { @Result(name = "success", location = "/paginas/pedido/buscar_pedido.jsp") })
	public String listarPedidoPagModalAprobados() { 
		System.out.println("pedido Aprobados 1");
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		} 
		try {
			lstPedido =   objPedidoServ.listaPedidoPaginadoAprobados(comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	} 
	@Action(value = "/buscarPedidoPagModalAprobados", results = { @Result(name = "success", location = "/paginas/pedido/buscar_pedido.jsp") })
	public String buscarPedidoPagModalAprobados() { 
		System.out.println("pedido Aprobados 2");
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstPedido = objPedidoServ.buscarPedidoPaginadoAprobados(objPedido, comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	@Action(value = "/listarPedidoTotalAprobados", results = { @Result(name = "success", location = "/paginas/pedido/pedido_listado_total.jsp") })
	public String listarPedidoTotalAprobados() { 
		System.out.println("pedido Aprobados 3");
		try { 
			this.numeroPaginasModalPedido= UtilSigal.totalDePaginas(objPedidoServ.listaPedidoTotalAprobados());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("nunmeroPaginas:"+numeroPaginasModalPedido); 
		return SUCCESS;
	}
	@Action(value = "/buscarPedidoTotalAprobados", results = { @Result(name = "success", location = "/paginas/pedido/pedido_buscar_total.jsp") })
	public String buscarPedidoTotalAprobados() {   
		System.out.println("pedido Aprobados 4");
		try { 
			this.numeroPaginasModalPedido = UtilSigal.totalDePaginas(objPedidoServ.buscarPedidoTotalAprobados(objPedido));
			System.out.println("total paginas:"+numeroPaginasModalPedido);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return SUCCESS;
	} 
	
	//Modal Pedidos FaltanDevolver  =Falta Devolver
	@Action(value = "/listarPedidoPagModalFaltanDevolver", results = { @Result(name = "success", location = "/paginas/pedido/buscar_pedido.jsp") })
	public String listarPedidoPagModalFaltanDevolver() { 
		System.out.println("pedido Aprobados 1");
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		} 
		try {
			lstPedido =   objPedidoServ.listaPedidoPaginadoFaltanDevolver(comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	} 
	@Action(value = "/buscarPedidoPagModalFaltanDevolver", results = { @Result(name = "success", location = "/paginas/pedido/buscar_pedido.jsp") })
	public String buscarPedidoPagModalFaltanDevolver() { 
		System.out.println("pedido Aprobados 2");
		Integer comienzo = null;
		if (inicio == null || inicio == 0) {
			comienzo = 0;
		} else {
			comienzo = (inicio * Constantes.FILAS_X_PAGINA) - Constantes.FILAS_X_PAGINA;
		}
		try {
			lstPedido = objPedidoServ.buscarPedidoPaginadoFaltanDevolver(objPedido, comienzo, Constantes.FILAS_X_PAGINA);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
	@Action(value = "/listarPedidoTotalFaltanDevolver", results = { @Result(name = "success", location = "/paginas/pedido/pedido_listado_total.jsp") })
	public String listarPedidoTotalFaltanDevolver() { 
		System.out.println("pedido Aprobados 3");
		try { 
			this.numeroPaginasModalPedido= UtilSigal.totalDePaginas(objPedidoServ.listaPedidoTotalFaltanDevolver());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("nunmeroPaginas:"+numeroPaginasModalPedido); 
		return SUCCESS;
	}
	@Action(value = "/buscarPedidoTotalFaltanDevolver", results = { @Result(name = "success", location = "/paginas/pedido/pedido_buscar_total.jsp") })
	public String buscarPedidoTotalFaltanDevolver() {   
		System.out.println("pedido Aprobados 4");
		try { 
			this.numeroPaginasModalPedido = UtilSigal.totalDePaginas(objPedidoServ.buscarPedidoTotalFaltanDevolver(objPedido));
			System.out.println("total paginas:"+numeroPaginasModalPedido);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return SUCCESS;
	} 
	
	
	
	public Integer getIdProd() {
		return idProd;
	}
	public void setIdProd(Integer idProd) {
		this.idProd = idProd;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public String getTipoPedido() {
		return tipoPedido;
	}
	public void setTipoPedido(String tipoPedido) {
		this.tipoPedido = tipoPedido;
	}
 
 
	public String getFechaEntrega() {
		return fechaEntrega;
	}
	public void setFechaEntrega(String fechaEntrega) {
		this.fechaEntrega = fechaEntrega;
	}
	public String getFechaDevolucion() {
		return fechaDevolucion;
	}
	public void setFechaDevolucion(String fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	public String getObsDevolucion() {
		return obsDevolucion;
	}
	public void setObsDevolucion(String obsDevolucion) {
		this.obsDevolucion = obsDevolucion;
	}
	public List<SolicitudPedidoDTO> getLstPedido() {
		return lstPedido;
	}
	public void setLstPedido(List<SolicitudPedidoDTO> lstPedido) {
		this.lstPedido = lstPedido;
	}
	public Integer getInicio() {
		return inicio;
	}
	public void setInicio(Integer inicio) {
		this.inicio = inicio;
	}
	public SolicitudPedidoDTO getObjPedido() {
		return objPedido;
	}
	public void setObjPedido(SolicitudPedidoDTO objPedido) {
		this.objPedido = objPedido;
	}
	public Integer getNumeroPaginasModalPedido() {
		return numeroPaginasModalPedido;
	}
	public void setNumeroPaginasModalPedido(Integer numeroPaginasModalPedido) {
		this.numeroPaginasModalPedido = numeroPaginasModalPedido;
	}
	public List<AreaDTO> getLstArea() {
		return lstArea;
	}
	public void setLstArea(List<AreaDTO> lstArea) {
		this.lstArea = lstArea;
	}
	public AreaDTO getArea() {
		return area;
	}
	public void setArea(AreaDTO area) {
		this.area = area;
	}
	public Integer getCod_area() {
		return cod_area;
	}
	public void setCod_area(Integer cod_area) {
		this.cod_area = cod_area;
	}
	public String getDesc_area() {
		return desc_area;
	}
	public void setDesc_area(String desc_area) {
		this.desc_area = desc_area;
	}
	public List<DetallePedidoDTO> getLstDetPed() {
		return lstDetPed;
	}
	public void setLstDetPed(ArrayList<DetallePedidoDTO> lstDetPed) {
		this.lstDetPed = lstDetPed;
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
	
 
	
 
	
	
}
