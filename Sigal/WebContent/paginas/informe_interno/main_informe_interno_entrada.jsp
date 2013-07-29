<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %> 
<%@ page language="java"   import="com.sigal.util.UtilSigal"%>
<script type="text/javascript"> 
// seleccionaPedido(${row.cod_solicitudPedido},'${row.nom_usuario}','${row.desc_area}','${row.desc_cargo}','${row.fechaRegistro_pedido}','${row.fechaDevolucion_pedido}','${row.fechaEntrega_pedido}','${row.tipo_pedido}','${row.comentario_pedido}')
function seleccionaPedido(codPedido,nomUsuario,area,cargo,fechaRegistro,fechaDevolucion,fechaEntrega,tipo,obs){  
// 	inputFecha  inputResponsable inputArea inputCargo optionsRadios(optionAbastecimiento,optionPrestamo) inputFechaEntrega inputFechaDevolucion inputObservacionPedido
	$("#cod_pedido").val(codPedido);
	$("#inputFecha").val(fechaRegistro);
	$("#inputResponsable").val(nomUsuario);
	$("#inputArea").val(area);
	$("#inputCargo").val(cargo);
	$("#inputFechaEntrega").val(fechaEntrega);
	$("#inputFechaDevolucion").val(fechaDevolucion);
	$("#inputObservacionPedido").val(obs);  
	if('Abastecimiento'==tipo){
		var $radios = $('input:radio[name=optionsRadios]');
		$radios.filter('[value=Abastecimiento]').prop('checked', true);	
		$('#divFechaDevolucion').hide();
	}else if('Prestamo'==tipo){
		var $radios = $('input:radio[name=optionsRadios]');
		$radios.filter('[value=Prestamo]').prop('checked', true); 
	} 
	$.post("getDetallePedido",{"objPedido.cod_solicitudPedido":codPedido},function(data){
 		$("#idTableDetallePedido").html(data);
	});  	
} 
function guardarIIS(){//objInformeInterno.cod_pedido  obs_informeinterno
	var codPedido=$("#cod_pedido").val(); 
	var obs=$("#inputObservacion").val(); 
	$.post("guardarIIE",{"objInformeInterno.cod_pedido":codPedido,"objInformeInterno.obs_informeinterno":obs},function(data){
 		$("#divMensaje").html(data);
 		$('#myIIE').modal({  keyboard: false }); 
 		setTimeout(function(){ $(location).attr('href','inicio'); }, 4000); 
	}); 
}

$(document).ready(function() {  
	var idProd= $('#cod_producto').val();
	if(idProd!=null){ 
		alert('Tienes un producto para darle entrada:'+idProd);
	}
	$('#idBuscarPedido').click(function(){
// 		$("#txtPedido").val("");
		$.post("listarPedidoTotal",function(data){
	 		$("#divDatosPedidoTotal").html(data);
		}); 
		$.post("listarPedidoPagModal",{inicio:null},function(data){
	 		$("#divTablaPedidoModal").html(data);
		}); 
	});  
	$('#idBotonBuscarPedido').click(function(){
// 		txtNombreResponsable cboArea txtFechaInicio txtFechaFin cboTipo 
		var txtNombreRespo=$("#txtNombreResponsable").val();
		var cboArea=$("#cboArea").val();
		var txtFechaInicio=$("#txtFechaInicio").val();
		var txtFechaFin=$("#txtFechaFin").val();
		var cboTipo=$("#cboTipo").val();
// 		objPedido.fechaRegistro_pedido objPedido.cod_area objPedido.nom_usuario objPedido.tipo_pedido
		$.post("buscarPedidoTotal",{
			"objPedido.nom_usuario":txtNombreRespo,
			"objPedido.cod_area":cboArea,
			"objPedido.fechaInicio":txtFechaInicio,
			"objPedido.fechaFin":txtFechaFin,
			"objPedido.tipo_pedido":cboTipo
			},function(data){
	 		$("#divDatosPedidoTotal").html(data);
		}); 
		$.post("buscarPedidoPagModal",{
			"objPedido.nom_usuario":txtNombreRespo,
			"objPedido.cod_area":cboArea,
			"objPedido.fechaInicio":txtFechaInicio,
			"objPedido.fechaFin":txtFechaFin,
			"objPedido.tipo_pedido":cboTipo
			},function(data){
	 		$("#divTablaPedidoModal").html(data);
		}); 
	});  


// 	 setTimeout(function(){ $('.alert').hide(1000); }, 3000); 
}); 
</script>
<h3>Informe Interno de Entrada</h3>
<form>
<%-- <s:hidden  name="objPed"  id="cod_pedido"    /> --%>
<s:hidden  name="codProd"  id="cod_producto"    />
<s:hidden  name="objPedido.cod_solicitudPedido"  id="cod_pedido"    />
<div class="control-group">
	<div  class="form-inline"> 
		<label class="control-label" for="inputFecha">Fecha</label>
		<input type="text" id="inputFechaActual" value="<%=UtilSigal.fechaActual() %>"   disabled> 
	</div>
</div>
<h5>Datos del Pedido</h5>
<div class="control-group">
	<div  class="form-inline"> 
		<label class="control-label" for="inputFecha">Fecha</label>
		<input type="text" id="inputFecha"  disabled>
		<a class="btn btn-primary" href="#myBuscarPedido"  id="idBuscarPedido" data-toggle="modal" >Buscar Pedido</a> 
	</div>
</div>

<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputResponsable">Responsable</label>	
		<input type="text" class="span4" id="inputResponsable"    disabled>
		<label class="control-label" for="inputArea">Area</label>
		<input type="text" id="inputArea"   disabled> 
		<label class="control-label" for="inputCargo">Cargo</label>
		<input type="text" id="inputCargo"  disabled> 
	</div>
</div>

<div class="control-group">
	<div  class="form-inline ">
		<label class="input-small">Tipo Pedido</label>
		<label class="radio">
		<input type="radio" name="optionsRadios" id="optionAbastecimiento" value="Abastecimiento" disabled  >Abastecimiento
		</label>	 
		<label class="radio">
		<input type="radio" name="optionsRadios" id="optionPrestamo" value="Prestamo" disabled  checked>Prestamo
		</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<label class="input-medium">Fecha Entrega</label>
		<div class="input-prepend">
		<span class="add-on"><i class="icon-calendar"></i></span>
		<input class="span2 datepicker" id="inputFechaEntrega"  type="text" disabled>
		</div> 
		
	</div>
</div>

<div class="control-group"  id="divFechaDevolucion" >
	<div  class="form-inline "> 
  
		<label class="control-label" for="inputIcon">Fecha Devolucion</label>
		<div class="input-prepend">
		<span class="add-on"><i class="icon-calendar"></i></span>
		<input class="span2 datepicker" id="inputFechaDevolucion" type="text" disabled>
		</div> 
		
	</div>
</div>
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputObservacionPedido">Observaci&oacute;n Pedido</label>
		<textarea rows="1" class="span9"  id="inputObservacionPedido" placeholder="Observaci&oacute;n Pedido"   disabled></textarea>  
	</div>
</div> 
<!-- <div class="control-group"> -->
<!-- 	<div  class="form-inline "> -->
<!-- 		<label class="control-label" for="inputObservacionEvaluacion">Observaci&oacute;n Evaluaci&oacute;n</label> -->
<!-- 		<textarea rows="1" class="span9"  id="inputObservacionEvaluacion" placeholder="Observaci&oacute;n Evaluaci&oacute;n"   disabled></textarea>   -->
<!-- 	</div> -->
<!-- </div> -->
<div id="idTableDetallePedido" > </div>  <!-- No se tiene que mostrar stock -->

<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputObservacion">Observaci&oacute;n</label>
		<textarea rows="1" class="span11"  id="inputObservacion" placeholder="Observaci&oacute;n"   ></textarea>  
	</div>
</div>


<div class="control-group"> 
<div class="controls"  align="center">
<a class="btn  btn-primary" onclick="javascript:guardarIIS();" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Guardar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;
<a class="btn  btn-primary"  href="inicio">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cancelar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
</div>
</div>
</form>




 

<!-- Modal -->
<div id="myBuscarPedido" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalBuscarPedido" aria-hidden="true">
<div class="modal-header"> 
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
<h3 id="myModalBuscarPedido">Buscar Pedido</h3>
</div>
<div class="modal-body">
	<div class="form-search"   >
	    <input type="text" id="txtNombreResponsable" name="objPedido.nom_usuario" class="input-medium search-query" placeholder="Nombre de Responsable" >
		  
		<s:select headerKey="0" headerValue="Seleccionar"  list="lstArea" listValue="desc_area" listKey="cod_area" id="cboArea" />  
    
		<input type="text" id="txtFechaInicio" class="input-medium search-query" placeholder="Fecha Inicio" >
	    <input type="text" id="txtFechaFin" class="input-medium search-query" placeholder="Fecha Fin" >
	    <s:select   headerKey="0" headerValue="Seleccionar" 
		list="#{'Abastecimiento':'Abastecimiento', 'Prestamo':'Prestamo'}"
		name="objPedido.tipo_pedido"  value="objPedido.tipo_pedido" 
		id="cboTipo"
		 />
	    <button type="submit" class="btn" id="idBotonBuscarPedido" >Buscar</button>
    </div> 
      <div id="divTablaPedidoModal"></div>
      <div id="divDatosPedidoTotal"></div>  
</div> 
</div> 



<div id="myIIE" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalIIE" aria-hidden="true">
<div class="modal-header"> 
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
<h3 id="myModalIIE">Resultado Informe Interno de Entrada</h3>
</div>
<div class="modal-body"> 
      <div id="divMensaje">
      </div> 
</div> 
</div>
 