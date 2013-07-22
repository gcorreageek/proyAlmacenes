package com.sigal.seguridad.bean;

import java.io.Serializable;

public class MenuDTO implements Serializable {

	private String cod_Menu;
	private String desc_Menu;
	private String actionUrl_Menu;
	
	
	
	
	public String getCod_Menu() {
		return cod_Menu;
	}
	public void setCod_Menu(String cod_Menu) {
		this.cod_Menu = cod_Menu;
	}
	public String getDesc_Menu() {
		return desc_Menu;
	}
	public void setDesc_Menu(String desc_Menu) {
		this.desc_Menu = desc_Menu;
	}
	public String getActionUrl_Menu() {
		return actionUrl_Menu;
	}
	public void setActionUrl_Menu(String actionUrl_Menu) {
		this.actionUrl_Menu = actionUrl_Menu;
	}
	
	
	
	
}
