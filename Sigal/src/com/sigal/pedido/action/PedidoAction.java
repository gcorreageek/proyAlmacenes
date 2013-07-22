package com.sigal.pedido.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.pedido.bean.SolicitudPedidoDTO;
import com.sigal.pedido.service.PedidoService;
import com.sigal.seguridad.bean.DetallePerfilDTO;
import com.sigal.seguridad.bean.DetalleUsuarioDTO;
import com.sigal.seguridad.bean.MenuDTO;
import com.sigal.seguridad.bean.OpcionesMenuDTO;
import com.sigal.seguridad.service.LogueoService;
import com.sigal.util.UtilSigal;
/**
 * 
 * @author David
 * @descripcion Clase encargada de la gestion de las solicitudes de pedido
 */
@ParentPackage("proy_calidad_SIGAL2")
public class PedidoAction extends ActionSupport {

	/*---------------------------- DECLARACION DE VARIABLES -------------------------------------*/
	LogueoService objLogServ = new LogueoService();
	PedidoService objPedidoServ = new PedidoService();
	private SolicitudPedidoDTO objSolP;
	
	private Map<String, Object> lasesion = ActionContext.getContext().getSession();
	private ArrayList<DetallePedidoDTO> lstDetPed = (ArrayList<DetallePedidoDTO>) lasesion.get("lstDetPed");
	////////////
	private ArrayList<MenuDTO> listaMenu =(ArrayList<MenuDTO>) lasesion.get("listaMenu");;
	private ArrayList<OpcionesMenuDTO> listaOpcMenu=objLogServ.obtenerOpcMenu( (DetallePerfilDTO)lasesion.get("objDetalle"));;
	private String mensaje;
	
	
	/// variables para el detalle de producto
	private SolicitudPedidoDTO objSolped;
	private DetallePedidoDTO objDetallePedido;
	private String cod_p;
	private String cant;
	
	//PARA LAS FECHAS DE REGISTRO 
	
	Date fecha = new Date();
	SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
	
	//variable para mostrar resultado de registro
	
	private String mensajeR;
	
	
	/*---------------------------- DECLARACION DE VARIABLES -------------------------------------*/
	
	
	@Action(value="/nuevoPedido",results={@Result(name="success",type="tiles",location="d_mainpedido")})
	public String mainPedido(){ 
		return SUCCESS;
	}
	@Action(value="/evaluarPedido",results={@Result(name="success",type="tiles",location="d_evaluarPedido")})
	public String evaluarPedido(){
		return SUCCESS;
	}
	
	
	/*---------------------------- METODOS -------------------------------------*/
	/**
	 * @author David
	 * @descripcion Metodo encargado de agregar productos al "detalle de productos"
	 */
	@Action(value="/add_product",results={@Result(name="success",type="tiles",location="d_pedidosInternos")})
	public String agregarDetalle(){
		/*listaMenu =(ArrayList<MenuDTO>) lasesion.get("listaMenu");
		listaOpcMenu=objLogServ.obtenerOpcMenu( (DetallePerfilDTO) lasesion.get("objDetalle"));
		System.out.println("codigo"+cod_p);*/
		//se obtiene los datos del producto y se almacenan en un objeto
		DetallePedidoDTO objDetalle = new DetallePedidoDTO();
		objDetalle.setCod_producto(objDetallePedido.getCod_producto());
		objDetalle.setCantidad(objDetallePedido.getCantidad());
		
		//antes de agregar el nuevo elemento verifico si ya existe
		if (validaIngreso(objDetalle)==true){
			lstDetPed.add(objDetalle);
			mensaje="Agregado";
			
		}
		else{
			mensaje="El producto ya existe en el pedido";
			System.out.println("El producto ya existe");
		}
		//agrego el objeto en el array list 
		
		//agrego el array list en la sesion
 		lasesion.put("lstDetPed", lstDetPed);
		return SUCCESS;
	}
	
	/**
	 * @author David
	 * @descripcion Metodo encargado del registro de solicitudes de pedido
	 * @return success = exito , error=fracaso 
	 */
	@Action(value="RegistrarPedido",results={@Result(name="success",type="tiles",location="d_pedidosInternos")})
	public String  RegistrarPedido(){
		System.out.println("entra en registrar");
		
		
				//Para registrar el pedido necesito 
				// 1  los datos de pedido (cabecera : codido_pedido,codigo_usuario,comentario tipo)
				//recibo y envio los atributos del objeto que deseo registrar 
		try {
				//para obtener el codigo del usuario en la sesion
				DetalleUsuarioDTO objUsu =  (DetalleUsuarioDTO) lasesion.get("objUsuario");
				//para enviar el objeto con los datos que necesito
				SolicitudPedidoDTO objPedido = new SolicitudPedidoDTO();
				//seteo los datos que siempre van
				
				
				objPedido.setCod_solicitudPedido(UtilSigal.GenerarCorrelativoPedido());
				objPedido.setCod_usuario(objUsu.getCod_usuario());
				objPedido.setComentario_pedido(objSolP.getComentario_pedido());
				objPedido.setFechaRespuesta_pedido(UtilSigal.formateaFecha(objSolP.getFechaRespuesta_pedido(), "/"));
				objPedido.setFechaRegistro_pedido(format.format(fecha));
				objPedido.setTipo_pedido(objSolP.getTipo_pedido());
				objPedido.setEstado_pedido("Pendiente");
				
			if(objSolP.getTipo_pedido().equals("Prestamo")){
				
				objPedido.setFechaDevolucion_pedido(UtilSigal.formateaFecha(objSolP.getFechaDevolucion_pedido(), "/"));
			}
			
			objPedidoServ.RegistrarPedido(objPedido,lstDetPed);
			mensajeR ="E";
		} catch (Exception e) {
			System.out.println(e);
			mensajeR ="F";
		}

		
		//2 los datos del detalla  cod producto, cantidad
	
		
		return SUCCESS;
	} 
	
	
	@Action(value="/pruebaAction",results={@Result(name="success",location="index.jsp")})
	public String pruebaAction(){
		System.out.println("Entro");
		return SUCCESS;
	}
	
	/**
	 * @author David
	 * @Descripcion Validacion de productos que se agregan al detalle
	 * @param objDetalle
	 * @return resultado boolean  si ya esta agregado false caso contrario true
	 */
	private boolean validaIngreso(DetallePedidoDTO objDetalle) {
		boolean resultado = false;
		
		if (lstDetPed.isEmpty()){
			resultado=true;
		}
		else{
			for (DetallePedidoDTO obj :lstDetPed){
				
				if(obj.getCod_producto().equals(objDetalle.getCod_producto())){
					 resultado= false;
				}
				else{
					 resultado= true;
				}
			
		}		
		}
		

		
		return resultado;
	}
	
	/*---------------------------- METODOS -------------------------------------*/

	
	/*---------------------------- METODOS DE ACCESO -------------------------------------*/
	
	
	





	public SolicitudPedidoDTO getObjSolP() {
		return objSolP;
	}
	public void setObjSolP(SolicitudPedidoDTO objSolP) {
		this.objSolP = objSolP;
	}
	public ArrayList<DetallePedidoDTO> getLstDetPed() {
		return lstDetPed;
	}
	public void setLstDetPed(ArrayList<DetallePedidoDTO> lstDetPed) {
		this.lstDetPed = lstDetPed;
	}
	public Map<String, Object> getLasesion() {
		return lasesion;
	}
	public void setLasesion(Map<String, Object> lasesion) {
		this.lasesion = lasesion;
	}
	public ArrayList<MenuDTO> getListaMenu() {
		return listaMenu;
	}
	public void setListaMenu(ArrayList<MenuDTO> listaMenu) {
		this.listaMenu = listaMenu;
	}
	public ArrayList<OpcionesMenuDTO> getListaOpcMenu() {
		return listaOpcMenu;
	}
	public void setListaOpcMenu(ArrayList<OpcionesMenuDTO> listaOpcMenu) {
		this.listaOpcMenu = listaOpcMenu;
	}
	public String getCod_p() {
		return cod_p;
	}
	public void setCod_p(String cod_p) {
		this.cod_p = cod_p;
	}
	public String getCant() {
		return cant;
	}
	public void setCant(String cant) {
		this.cant = cant;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public SolicitudPedidoDTO getObjSolped() {
		return objSolped;
	}
	public void setObjSolped(SolicitudPedidoDTO objSolped) {
		this.objSolped = objSolped;
	}
	public DetallePedidoDTO getObjDetallePedido() {
		return objDetallePedido;
	}
	public void setObjDetallePedido(DetallePedidoDTO objDetallePedido) {
		this.objDetallePedido = objDetallePedido;
	}
	public String getMensajeR() {
		return mensajeR;
	}
	public void setMensajeR(String mensajeR) {
		this.mensajeR = mensajeR;
	}

	
	
	
	/*---------------------------- METODOS DE ACCESO -------------------------------------*/
	
	
}
