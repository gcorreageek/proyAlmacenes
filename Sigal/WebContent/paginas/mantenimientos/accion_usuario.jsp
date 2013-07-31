<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() {  
	 $("#cod_area").change(function () { 
		  $("select#cod_area option:selected").each(function () {  
			  $.post("cboCargo",{"objUsuario.cod_area":$(this).val(),"objUsuario.cod_cargo":$("#inputCargo").val()},function(data){
			 	$("#cboCargo").html(data);
			  }); 
    	  }); 
		}).trigger('change'); 
	 $("#btnGuardar").click(function(){
// 		 objUsuario.cod_usuario nom_usuario correo_usuario cod_area cod_cargo usu_usuario habilitado
		 var cod_usuario=$("#cod_usuario").val();
		 var nom_usuario=$("#nom_usuario").val();
		 var correo_usuario=$("#correo_usuario").val();
		 var cod_area=$("#cod_area").val();
		 var cod_cargo=$("#cod_cargo").val();
		 var usu_usuario=$("#usu_usuario").val();
		 var pass_usuario=$("#pass_usuario").val();
		 var habilitado=$("#habilitado").val(); 
		 $.post("actuarUsuario",{
			 "objUsuario.cod_usuario":cod_usuario,
			 "objUsuario.nom_usuario":nom_usuario,
			 "objUsuario.correo_usuario":correo_usuario,
			 "objUsuario.cod_area":cod_area,
			 "objUsuario.cod_cargo":cod_cargo,
			 "objUsuario.usu_usuario":usu_usuario,
			 "objUsuario.pass_usuario":pass_usuario,
			 "objUsuario.habilitado":habilitado
		 },function(data){
			 	$("#divMensaje").html(data);
			 	setTimeout(function(){ $('.alert').hide(1000); }, 3000); 
		 }); 
	 });
	 $("#btnModificaPass").click(function(){
		 var cod_usuario=$("#cod_usuario").val();
		 var pass_usuario=$("#pass_usuario").val();
		 $.post("actualizaPassUsuario",{
			 "objUsuario.cod_usuario":cod_usuario, 
			 "objUsuario.pass_usuario":pass_usuario
		 },function(data){
			 	$("#divMensaje").html(data);
			 	setTimeout(function(){ $('.alert').hide(1000); }, 3000); 
		 }); 
	 });
	 
	 
}); 
</script>
</head>
<body>
<c:if test="${requestScope.objUsuario.cod_usuario!=null}"   >
<h3>Modificar Usuario</h3>  
</c:if>
<c:if test="${requestScope.objUsuario.cod_usuario==null}"   >
<h3>Nuevo Usuario</h3>  
</c:if>


<div id="divMensaje">
</div>

<div class="form-horizontal"  >
<s:hidden  name="objUsuario.cod_usuario" id="cod_usuario"     />
<div class="control-group">
<label class="control-label" for="inputNombre">Nombre</label>
<div class="controls">
<s:textfield id="nom_usuario"  name="objUsuario.nom_usuario" placeholder="Nombre"  ></s:textfield> 
</div>
</div>
<div class="control-group">
<label class="control-label" for="inputNombre">Correo</label>
<div class="controls">
<s:textfield id="correo_usuario"  name="objUsuario.correo_usuario" placeholder="Correo"  ></s:textfield> 
</div>
</div> 

<div class="control-group">
<label class="control-label" for="inputNombre">Area</label>
<div class="controls">
<s:select name="objUsuario.cod_area"  list="lstArea" listValue="desc_area" listKey="cod_area" id="cod_area" />
</div>
</div> 

<div class="control-group">
<label class="control-label" for="inputNombre">Cargo</label>
<div class="controls">
<div id="cboCargo"> 
<s:hidden  name="objUsuario.cod_cargo" id="inputCargo"     />
</div> 
</div>
</div> 

<div class="control-group">
<label class="control-label" for="inputNombre">Usuario</label>
<div class="controls">
<s:textfield id="usu_usuario"  name="objUsuario.usu_usuario" placeholder="Usuario"  ></s:textfield> 
</div>
</div>   

<div class="control-group">
<label class="control-label" for="inputNombre">Contraseña</label>
<div class="controls">
<s:password id="pass_usuario"  name="objUsuario.pass_usuario" placeholder="Contraseña"  ></s:password> 
<c:if test="${requestScope.objUsuario.cod_usuario!=null}"   >
<a class="btn btn-primary"  href="javascript:void(0)"  id="btnModificaPass"  >Modificar Contraseña</a>
</c:if>
</div>
</div>   

<div class="control-group">
<label class="control-label" for="inputNombre">Habilitaci&oacute;n</label>
<div class="controls">
<s:select 
	list="#{'Habilitado':'Habilitado', 'Desabilitado':'Desabilitado'}"
	name="objUsuario.habilitado" 
	id="habilitado" /> 
</div>
</div>

 
<div class="control-group"> 
<div class="controls">
<button class="btn btn-primary" id="btnGuardar"  >Guardar</button>
<a class="btn btn-primary"  href="mainUsuario">Listar</a>
</div>
</div>

</div>


 



</body>
</html>