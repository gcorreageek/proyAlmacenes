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
		$.post("listarProductoTotalHabilitados",function(data){
	 		$("#divDatosProdTotal").html(data);
		}); 
		$.post("listarProductoPagModalHabilitados",{inicio:null},function(data){
	 		$("#divTablaProdModal").html(data);
		}); 
	});  
	$('#idBotonBuscarProducto').click(function(){
		var txtProd=$("#txtProducto").val();
		$.post("buscarProductoTotalHabilitados",{"objProducto.desc_producto":txtProd},function(data){
	 		$("#divDatosProdTotal").html(data);
		}); 
		$.post("buscarProductosXDescProdPagModalHabilitados",{inicio:null,"objProducto.desc_producto":txtProd},function(data){
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
<h3>Registrar Solicitud de Pedido</h3>  
<div id="divMostrarMensaje"> 
</div>
<div class="control-group">
	<div  class="form-inline"> 
		<label class="control-label" for="inputFecha">Fecha</label>
		<input type="text" id="inputFecha" value="<%=UtilSigal.fechaActual() %>" disabled> 
	</div>
</div>

<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputResponsable">Responsable</label>	
		<input type="text" class="span4" id="inputResp
		onsable" value="<%=  detalleUsuario.getNom_usuario() %>"   disabled>
		<label class="control-label" for="inputArea">Area</label>
		<input type="text" id="inputArea" value="<%=areaUsuario.getDesc_area() %>" disabled> 
		<label class="control-label" for="inputCargo">Cargo</label>
		<input type="text" id="inputCargo" value="<%=cargoUsuario.getDesc_cargo() %>" disabled> 
	</div>
</div>

<div class="control-group">
	<div  class="form-inline ">
		<label class="input-small">Tipo Pedido</label>
		<label class="radio">
		<input type="radio" name="optionsRadios" id="optionAbastecimiento" value="Abastecimiento" checked>Abastecimiento
		</label>&nbsp;&nbsp;&nbsp;
		<label class="radio">
		<input type="radio" name="optionsRadios" id="optionPrestamo" value="Prestamo" >Prestamo
		</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<label class="input-medium">Fecha Entrega</label>
		<div class="input-prepend">
		<span class="add-on"><i class="icon-calendar"></i></span>
		<input class="span2 datepicker" id="idFechaEntrega"  type="text"  readonly>
		</div> 
		
	</div>
</div>

<div class="control-group"  id="divFechaDevolucion" >
	<div  class="form-inline "> 
  
		<label class="control-label" for="inputIcon">Fecha Devoluci&oacute;n</label>
		<div class="input-prepend">
		<span class="add-on"><i class="icon-calendar"></i></span>
		<input class="span2 datepicker" id="idFechaDevolucion"  type="text" readonly>
		</div> 
		
	</div>
</div>

<!-- Producto -->
<h5>Datos del Producto</h5>
<div class="control-group">
	<div  class="form-inline ">
	    <s:hidden  name="objProductoProveedor.cod_producto"  id="cod_producto"    />
		<label class="control-label" for="inputProducto">Producto</label>
		<input type="text" id="desc_producto" name="objProductoProveedor.desc_producto" value="${objProductoProveedor.desc_producto}" placeholder="Nombre"  disabled>
		
		<label class="control-label" for="unidadMedida">U.Medida</label>
		<input type="text" id="unidadMedida"  name="objProductoProveedor.unidadMedida" value="${objProductoProveedor.unidadMedida}" placeholder="U.Medida"  disabled>
		<a class="btn btn-primary" id="idBuscarProducto" href="#myBuscarProducto" data-toggle="modal" >Buscar Producto</a>
	</div>
	
</div> 
 



<br>
<br>
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputCantidad"  >Cantidad</label>
		<input type="text" class="input-large" id="inputCantidad" placeholder="Cantidad"> 
		<a class="btn btn-primary" id="btnAgregarDetallePedido"  >Agregar</a>
	</div>
</div>
<div id="divDetallePedido"> 
    <table class="table table-striped table-bordered table-hover">
      <thead>
        <tr> 
          <th>Producto</th>  
          <th>U.Medida</th>
          <th>Cantidad</th> 
          <th>Eliminar</th>
        </tr>
      </thead>
      <tbody> 
      </tbody>
    </table>
</div>
 
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputObservacion">Observacion</label>
		<textarea rows="1" class="span11"  id="inputObservacion" placeholder="Observacion"   ></textarea>  
	</div>
</div>


<div class="control-group"> 
<div class="controls"  align="center">
<a class="btn  btn-primary" id="btnGuardar" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Guardar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;
<a class="btn  btn-primary"  onclick="javascript:history.back();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cancelar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
</div>
</div>
 

 
 
<!-- Modal -->
<div id="myBuscarProducto" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalBuscarProducto" aria-hidden="true">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">�</button>
<h3 id="myModalBuscarProducto">Buscar Producto</h3>
</div>
<div class="modal-body">
	<div class="form-search"   >
	    <input type="text" id="txtProducto" name="objProducto.desc_producto" class="input-medium search-query" placeholder="Producto" >
	    <button type="submit" class="btn" id="idBotonBuscarProducto" >Buscar</button>
    </div> 
      <div id="divTablaProdModal">
      </div>
      <div id="divDatosProdTotal"></div>  
</div> 
</div>
 
  
  
<div id="myMensaje" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalBuscarProducto" aria-hidden="true">
<div class="modal-body">
<div id="idMensajeInterno"></div> 
</div> 
</div>

 