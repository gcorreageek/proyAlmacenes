package com.sigal.seguridad.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sigal.pedido.bean.DetallePedidoDTO;
import com.sigal.seguridad.bean.DetalleUsuarioDTO;
import com.sigal.seguridad.bean.MenuDTO;
import com.sigal.seguridad.bean.OpcionesDTO;
import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.seguridad.service.LogueoService;
import com.sigal.util.UtilSigal;

/**
 * @author David
 *@Descripcion Clase encargada del logeo de usuarios
 */
@ParentPackage("proy_calidad_SIGAL2")
public class LogueoAcion extends ActionSupport {

	LogueoService objLogServ = new LogueoService();
	
	private UsuarioDTO objUsu;
	private DetalleUsuarioDTO objDetUsu; 
	private Map<String, Object> lasesion;
	private ArrayList<MenuDTO> listaMenu;
	private String mensaje;
	
	
	@Action(value="/inicio",results={@Result(name="success",type="tiles",location="d_index")})
	public String inicio(){ 
		return SUCCESS;
	}
	
	/**
	 * @author David
	 * @descripcion  Metodo encargado de la autenticacion de usuarios
	 * @return success = exito , error=fracaso 
	 */
	@SuppressWarnings("unused")
	@Action(value="/login",results={@Result(name="success",type="tiles",location="d_index"),@Result(name="error",location="/paginas/seguridad/login.jsp")})
	public String Login(){
		System.out.println("Entro!!");
		System.out.println("Mira1:"+objDetUsu.getId_usuario());
		System.out.println("Mira2:"+objDetUsu.getPass_usuario());
		String ir=SUCCESS;
		
		
		DetalleUsuarioDTO objCandidato = new DetalleUsuarioDTO(); 
		objCandidato.setId_usuario(objDetUsu.getId_usuario());
		 
		DetalleUsuarioDTO objUsuario=null;
		
		try {
							
			objUsuario = objLogServ.validarPorUsuario(objCandidato.getId_usuario());
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if(objUsuario!=null){
			if(objUsuario.getPass_usuario().equals(UtilSigal.getHash(objDetUsu.getPass_usuario()))){
				//si la contraseña del usuario concuerda creamos la sesion
				System.out.println("bienvenido");
				//ya valide el usuario ahora obtengo los modulos a los que tiene el acceso el usuario
				listaMenu=objLogServ.obtenerMenu(objUsuario.getCod_perfil());
				List<OpcionesDTO> listaMenuOpciones = objLogServ.obtenerListadoMenu(objUsuario.getCod_perfil());
				 
						
				lasesion =ActionContext.getContext().getSession();
				lasesion.put("listaMenuOpciones", listaMenuOpciones);
				for (OpcionesDTO opcionesDTO : listaMenuOpciones) {
					System.out.println(opcionesDTO.getNom_opcion()+"|"+opcionesDTO.getCod_opcion());
				}
				
				
				lasesion.put("listaMenu", listaMenu);
				lasesion.put("objUsuario", objUsuario);
				
				System.out.println("PERFIL   :"+objUsuario.getCod_perfil());
				ArrayList<DetallePedidoDTO> lstDetPed = new ArrayList<DetallePedidoDTO>();
				lasesion.put("lstDetPed", lstDetPed);
			}
			else {
				ir=ERROR;
				mensaje="La contraseña es incorrecta";System.out.println("la contraeña es incorrecta");
			}
		}
		else{
			ir=ERROR;
			mensaje="Usuario no existe";
			System.out.println("Usuario no existe");
		}
		return ir; 
	}
	/**
	 * @author David
	 * @descripcion Metodo encargado de finalizar la sesion de usuarios
	 * @return success = exito , error=fracaso 
	 */
	@Action(value="/logout",results={@Result(name="success",location="/pages/login.jsp")})
	public String logOut(){
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}
	

	
	public UsuarioDTO getObjUsu() {
		return objUsu;
	}

	public void setObjUsu(UsuarioDTO objUsu) {
		this.objUsu = objUsu;
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

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public DetalleUsuarioDTO getObjDetUsu() {
		return objDetUsu;
	}

	public void setObjDetUsu(DetalleUsuarioDTO objDetUsu) {
		this.objDetUsu = objDetUsu;
	}

	
	

}
