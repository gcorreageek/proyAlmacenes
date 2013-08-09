<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<%@ page language="java" contentType="text/html"  import="com.sigal.util.UtilSigal"%>
<%@ page language="java" contentType="text/html"  import="com.sigal.seguridad.bean.UsuarioDTO"%>
<%@ page language="java" contentType="text/html"  import="com.sigal.seguridad.bean.CargoDTO"%>
<%@ page language="java" contentType="text/html"  import="com.sigal.seguridad.bean.AreaDTO"%>
<%! UsuarioDTO  detalleUsuario=null; 
	CargoDTO  cargoUsuario=null;
	AreaDTO  areaUsuario=null;
%>
<% 	detalleUsuario = (UsuarioDTO)session.getAttribute("objUsuario"); 
	cargoUsuario = (CargoDTO)session.getAttribute("objCargo"); 
	areaUsuario = (AreaDTO)session.getAttribute("objArea"); 
%>
<script type="text/javascript"  >
function seleccionaProd(codProd,descProd,uMedida){  
	$("#cod_producto").val(codProd);
	$("#desc_producto").val(descProd);
	$("#unidadMedida").val(uMedida); 
}
function eliminarDetallePedido(idProd){ 
	$.post("eliminarDetallePedido",{"idProd":idProd},function(data){
 		$("#divDetallePedido").html(data);
	});
} 
$(document).ready(function() {
	var mensaje="<div class='alert alert-error'><h4>Error!</h4>";
// 	$('.alert').hide(); 
	$('#idBuscarProducto').click(function(){
		$("#txtProducto").val("");
		$.post("listarProductoTotal",function(data){
	 		$("#divDatosProdTotal").html(data);
		}); 
		$.post("listarProductoPagModal",{inicio:null},function(data){
	 		$("#divTablaProdModal").html(data);
		}); 
	});  
	$('#idBotonBuscarProducto').click(function(){
		var txtProd=$("#txtProducto").val();
		$.post("buscarProductoTotal",{"objProducto.desc_producto":txtProd},function(data){
	 		$("#divDatosProdTotal").html(data);
		}); 
		$.post("buscarProductosXDescProdPagModal",{inicio:null,"objProducto.desc_producto":txtProd},function(data){
	 		$("#divTablaProdModal").html(data);
		}); 
	}); 
	$('#divFechaDevolucion').hide();
	$('#optionPrestamo').click(function(){
		$('#divFechaDevolucion').show('slow');
	});
	$('#optionAbastecimiento').click(function(){
		$('#divFechaDevolucion').hide(1000);
	});
	$('#checkNroPedido').click(function(){
		if($("#checkNroPedido").is(':checked')){
			$("#inputNroPedido").prop('disabled', true);
		}else{
			$("#inputNroPedido").prop('disabled', false);
		} 
	}); 
	$('#btnAgregarDetallePedido').click(function(){ 
		var idProd= $("#cod_producto").val();
		var cantidad= $("#inputCantidad").val();  
		var str = '<h4>Error!</h4>';
		if(idProd==null || idProd=='' ){ 
			$("#divMostrarMensaje").html(mensaje+" Ingrese Producto correcto"+ "</div>");
			setTimeout(function(){ $('.alert').hide(1000); }, 2000); 
			return;
		}
		if(!/^([0-9])*$/.test(cantidad) || cantidad=='' || cantidad==0){  
			$("#divMostrarMensaje").html(mensaje+" Ingrese Cantidad Valida"+ "</div>");
			setTimeout(function(){ $('.alert').hide(1000); }, 2000); 
			return;
		}  
		$.post("agregarDetallePedido",{"idProd":idProd,cantidad:cantidad},function(data){
	 		$("#divDetallePedido").html(data);
		}); 
	});
	$('#btnGuardar').click(function(){
		var radioSelecionado=$('input:radio[name=optionsRadios]:checked').val();
		var fechaEntrega = $('#idFechaEntrega').val();
		var fechaDevolucion = $('#idFechaDevolucion').val();
		var observacion = $('#inputObservacion').val();  
		var iChars = "#$%^&*()+=-[]\\'/{}|\"<>"; 
		for (var i = 0; i < observacion.length; i++) {
		    if (iChars.indexOf(observacion.charAt(i)) != -1) {
		    	$("#divMostrarMensaje").html(mensaje+" Ingrese una Observacion valida"+ "</div>");
	 			setTimeout(function(){ $('.alert').hide(1000); }, 2000); 
	 			return;
		    }
		} 
		//validar fechas 
		if(fechaEntrega=='' || fechaEntrega==null){
			$("#divMostrarMensaje").html(mensaje+" Ingrese una Fecha de Entrega valida"+ "</div>");
 			setTimeout(function(){ $('.alert').hide(1000); }, 2000); 
 			return;
		}
		if(radioSelecionado=='Prestamo'){
			if(fechaDevolucion=='' || fechaDevolucion==null){
				$("#divMostrarMensaje").html(mensaje+" Ingrese una Fecha de Devolucion valida"+ "</div>");
	 			setTimeout(function(){ $('.alert').hide(1000); }, 2000); 
	 			return;
			}
		}
		 
		
		$.post("guardarPedido",
			{
			"tipoPedido":radioSelecionado,
			"fechaEntrega":fechaEntrega,
			"fechaDevolucion":fechaDevolucion,
			"obsDevolucion":observacion
			}
		,
		function(data){ 
			var bien = data.indexOf("Error");  
			if(bien<0){
				$("#idMensajeInterno").html(data);
		 		$('#myMensaje').modal({  keyboard: false });  
		 		setTimeout(function(){ $(location).attr('href','nuevoPedido'); }, 4000);
			}else{
				$("#idMensajeInterno").html(data);
		 		$('#myMensaje').modal({  keyboard: false });  
			} 
		});  
	});
	
	$('#idFechaEntrega').datepicker('setStartDate', $('#inputFecha').val()).on('changeDate', function(ev){  
		$('#idFechaDevolucion').datepicker('setStartDate',$('#idFechaEntrega').val() );
	});  
	
});  
</script>
<h3>Reportes de Producto</h3>  
<div id="divMostrarMensaje"> 
</div>  
<div class="control-group">
	<div  class="form-inline ">
	    <s:hidden  name="objProductoProveedor.cod_producto"  id="cod_producto"    />
		<label class="control-label" for="inputProducto">Producto</label>
		<input type="text" class="span5" id="desc_producto" name="objProductoProveedor.desc_producto" value="${objProductoProveedor.desc_producto}" placeholder="Nombre"  >
		
		<label class="control-label" for="unidadMedida">U.Medida</label>
		<s:select    
		list="#{'Unidad':'Unidad', 'Caja':'Caja', 'Docena':'Docena',  'Millar':'Millar'}"
		name="objProducto.unidadMedida"  value="objProducto.unidadMedida" />
		<a class="btn btn-primary" id="idBuscarProducto" href="#myBuscarProducto" data-toggle="modal" >Buscar Producto</a>
	</div>
	
</div>
 

<div class="control-group"> 
<div class="controls"  align="center">
<a class="btn  btn-primary" id="btnExportar" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Exportar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;

</div>
</div>
 

 
 
 
  
  
<div id="myMensaje" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalBuscarProducto" aria-hidden="true">
<div class="modal-body">
<div id="idMensajeInterno"></div> 
</div> 
</div>

 