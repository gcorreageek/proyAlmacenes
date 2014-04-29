<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<script type="text/javascript"> 
function desabilitarMenu(codAcceso){
	var cod_cargo=$("#cod_cargo").val();
	$.post("cambiarEstadoAcceso",{"objAcceso.cod_accesomenu":codAcceso},function(data){
		$("#divMensaje").html(data);
		$.post("listaTablaMenu",{"objAcceso.cod_cargo":cod_cargo},function(data){
		 	$("#divTablaPag").html(data);
		});
	 	setTimeout(function(){ $('.alert').hide(1000); }, 3000); 
	  });
}
$(document).ready(function() {
	$("#cod_area").change(function () { 
		  $("select#cod_area option:selected").each(function () {  
			  $.post("cboCargo",{"objUsuario.cod_area":$(this).val(),"objUsuario.cod_cargo":$("#inputCargo").val()},function(data){
			 	$("#cboCargo").html(data);
			  }); 
  	  }); 
		}).trigger('change'); 
	$("#cod_menu").change(function () { 
		  $("select#cod_menu option:selected").each(function () {  
			  $.post("cboSubMenu",{"objAcceso.cod_menu":$(this).val()},function(data){
			 	$("#cboSubMenu").html(data);
			  }); 
	  }); 
		  
		}).trigger('change'); 
	  
	
	$("#btnGuardar").click(function(){
		var mensaje="<div class='alert alert-error'><h4>Error!</h4>";
		var cod_menu=$("#cod_menu").val();
		var cod_submenu=$("#cod_submenu").val();
		var cod_cargo=$("#cod_cargo").val();
		if(cod_cargo!=null){
			var codmenu = cod_menu;
			if(cod_submenu!=null){
				codmenu=cod_submenu;
			} 
			$.post("guardarAcceso",{"objAcceso.cod_menu":codmenu,"objAcceso.cod_cargo":cod_cargo},function(data){
			 	$("#divMensaje").html(data);
			 	$.post("listaTablaMenu",{"objAcceso.cod_cargo":cod_cargo},function(data){
				 	$("#divTablaPag").html(data);
				});
			 	setTimeout(function(){ $('.alert').hide(1000); }, 3000); 
			}); 
		}else{
			$("#divMensaje").html(mensaje+" Seleccione un Cargo "+"</div>");
		 	setTimeout(function(){ $('.alert').hide(1000); }, 3000); 
		}
		
		
	});
	
}); 
</script>

<h3>Registrar Acceso</h3>
<div id="divMensaje">

</div>
<div class="form-horizontal"  >
<div class="control-group">
<label class="control-label" for="inputNombre">Menu</label>
<div class="controls">
<s:select name="objAcceso.cod_area"  list="lstMenu" listValue="nom_menu" listKey="cod_menu" id="cod_menu" />
</div>
</div> 

<div class="control-group">
<label class="control-label" for="inputNombre">SubMenu</label>
<div class="controls"> 
<div id="cboSubMenu"> </div>
</div>
</div>

<div class="control-group">
<label class="control-label" for="inputNombre">Area</label>
<div class="controls">
<s:select name="objAcceso.cod_area"  list="lstArea" listValue="desc_area" listKey="cod_area" id="cod_area" />
</div>
</div> 

<div class="control-group">
<label class="control-label" for="inputNombre">Cargo</label>
<div class="controls">
<div id="cboCargo"><s:hidden  name="objAcceso.cod_cargo" id="inputCargo"     /></div> 
</div>
</div> 

<div class="control-group">
<div class="controls">
<button class="btn btn-primary" id="btnGuardar"  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Registrar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>
</div>
</div> 
</div>

<div id="divTablaPag">
</div>  

























