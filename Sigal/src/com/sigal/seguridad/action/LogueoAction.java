package com.sigal.seguridad.action;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sigal.seguridad.bean.AreaDTO;
import com.sigal.seguridad.bean.CargoDTO;
import com.sigal.seguridad.bean.MenuDTO;
import com.sigal.seguridad.bean.UsuarioDTO;
import com.sigal.seguridad.service.AreaService;
import com.sigal.seguridad.service.CargoService;
import com.sigal.seguridad.service.LogueoService;
import com.sigal.util.UtilSigal;

/**
 * @author David
 *@Descripcion Clase encargada del logeo de usuarios
 */
@ParentPackage("proy_calidad_SIGAL2")
public class LogueoAction extends ActionSupport {
	private final Log log = LogFactory.getLog(getClass());
	private final LogueoService objLogServ = new LogueoService();
	private final AreaService objAreaServ = new AreaService();
	CargoService objCargoServ = new CargoService(); 
	
	private UsuarioDTO objUsu; 
	
	private String mensaje;
	private List<AreaDTO> lstArea;  
	private Integer codProd;
	
	
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
	@Action(value="/login",results={
			@Result(name="success",type="tiles",location="d_index"),
			@Result(name="error",location="/paginas/seguridad/login.jsp"),
			@Result(name="movilsalida",type="tiles",location="d_maininformeinternosalida"),
			@Result(name="movilentrada",type="tiles",location="d_maininformeinternoentrada"),
	})
	public String Login(){ 
		System.out.println("Mira1:"+objUsu.getUsu_usuario());
		System.out.println("Mira2:"+objUsu.getPass_usuario());
		String ir=SUCCESS; 
		 
		UsuarioDTO objUsuario=null;
		
		try {
							
			objUsuario = objLogServ.obtieneXusuario(objUsu.getUsu_usuario());
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if(objUsuario!=null){
			String hash= UtilSigal.getHash(objUsu.getPass_usuario());
			if(objUsuario.getPass_usuario().equals( UtilSigal.getHash(objUsu.getPass_usuario()))){
				//si la contraseña del usuario concuerda creamos la sesion
				System.out.println("bienvenido");
				//ya valide el usuario ahora obtengo los modulos a los que tiene el acceso el usuario
				 Map<String, Object> lasesion;
				 List<MenuDTO> listaMenu;
				
				
				listaMenu=objLogServ.obtenerMenuXcodPerfil(objUsuario.getCod_cargo()); 
		 
						
				lasesion =ActionContext.getContext().getSession();  
				
				
				lasesion.put("listaMenu", listaMenu);
				lasesion.put("objUsuario", objUsuario); 
				CargoDTO objCargo = objCargoServ.getCargo(objUsuario.getCod_cargo());
				lasesion.put("objCargo", objCargo);
				AreaDTO objArea = objAreaServ.getArea(objCargo.getCod_area());
				lasesion.put("objArea", objArea); 
				
				
				
				Object[] obj = null;
				obj = (Object[]) lasesion.get("DatosQR");
				if(obj!=null){
					lstArea = objAreaServ.listaArea();
					this.codProd= (Integer) obj[0];
					String tipo=   obj[1].toString();
					if("Salida".equals(tipo)){
						ir="movilsalida"; 
					}else{
						ir="movilentrada";
					}
					lasesion.remove("DatosQR");
				} 
				
				
			}
			else {
				ir=ERROR;
				mensaje="La contraseña es incorrecta"; 
			}
		}
		else{
			ir=ERROR;
			mensaje="Usuario no existe";
			System.out.println("Usuario no existe");
		}
		log.debug("mensaje:"+ir);
		return ir; 
	}
	/**
	 * @author David
	 * @descripcion Metodo encargado de finalizar la sesion de usuarios
	 * @return success = exito , error=fracaso 
	 */
	@Action(value="/logout",results={@Result(name="success",location="/paginas/seguridad/login.jsp")})
	public String logOut(){
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	}
	@Action(value="/passOlvidado",results={@Result(name="success",location="/paginas/seguridad/login.jsp")})
	public String passOlvidado(){
		ActionContext.getContext().getSession().clear();
		return SUCCESS;
	} 

	
	public UsuarioDTO getObjUsu() {
		return objUsu;
	}

	public void setObjUsu(UsuarioDTO objUsu) {
		this.objUsu = objUsu;
	}

 

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the lstArea
	 */
	public List<AreaDTO> getLstArea() {
		return lstArea;
	}

	/**
	 * @param lstArea the lstArea to set
	 */
	public void setLstArea(List<AreaDTO> lstArea) {
		this.lstArea = lstArea;
	}

	/**
	 * @return the codProd
	 */
	public Integer getCodProd() {
		return codProd;
	}

	/**
	 * @param codProd the codProd to set
	 */
	public void setCodProd(Integer codProd) {
		this.codProd = codProd;
	}
 
	
	

}
