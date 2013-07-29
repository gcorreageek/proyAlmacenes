<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html" import="java.util.*"%>

  <% 
  
   Object obj=null;
   Boolean val=false;
  try{
	  obj=  session.getAttribute("objUsuario"); 
  }catch(NullPointerException e){ 
  }

  if(obj==null){ %>
  	<jsp:forward page="/paginas/seguridad/login.jsp"  /> 
	 <%   
	}else{  %>  
	<% }
  
  
  %>
 
