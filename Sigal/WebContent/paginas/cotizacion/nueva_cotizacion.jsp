<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %> 
<script type="text/javascript">
// cod_producto desc_producto unidadMedida cod_proveedor  raz_social
function seleccionaProd(codProd,descProd,uMedida){  
	$("#cod_producto").val(codProd);
	$("#desc_producto").val(descProd);
	$("#unidadMedida").val(uMedida); 
}
function seleccionaProvee(codProvee,descProvee){  
	$("#cod_proveedor").val(codProvee);
	$("#raz_social").val(descProvee); 
}
function eliminarDetalleCotizacion(idProd){ 
	$.post("eliminarDetalleCotizacion",{"idProd":idProd},function(data){
 		$("#divDetallePedido").html(data);
	});
}
$(document).ready(function() { 
	/**PRODCUTO**/
	$('#idBuscarProducto').click(function(){
		$("#txtProducto").val("");
		var idProvee = $('#cod_proveedor').val();
		$.post("listarProductoTotalidProve",{idProve:idProvee},function(data){
	 		$("#divDatosProdTotal").html(data);
		}); 
		$.post("listarProductoPagModalidProve",{idProve:idProvee,inicio:null},function(data){
	 		$("#divTablaProdModal").html(data);
		}); 
	});  
	$('#idBotonBuscarProducto').click(function(){
		var txtProd=$("#txtProducto").val();
		var idProvee = $('#cod_proveedor').val();
		$.post("buscarProductoTotalidProve",{idProve:idProvee,"objProducto.desc_producto":txtProd},function(data){
	 		$("#divDatosProdTotal").html(data);
		}); 
		$.post("buscarProductosXDescProdPagModalidProve",{inicio:null,idProve:idProvee,"objProducto.desc_producto":txtProd},function(data){
	 		$("#divTablaProdModal").html(data);
		}); 
	}); 
	/**PROVEEDOR**/
	$('#idBuscarProveedor').click(function(){
		$("#txtProveedor").val("");
		$.post("listarProveedorTotal",function(data){
	 		$("#divDatosProveTotal").html(data);
		}); 
		$.post("listarProveedorPagModal",{inicio:null},function(data){
	 		$("#divTablaProveModal").html(data);
		}); 
	});  
	$('#idBotonBuscarProveedor').click(function(){
		var txtProve=$("#txtProveedor").val();
		$.post("buscarProveedorTotal",{"objProveedor.raz_social":txtProve},function(data){
	 		$("#divDatosProveTotal").html(data);
		}); 
		$.post("buscarProveedorXRazonSocialPagModal",{inicio:null,"objProveedor.raz_social":txtProve},function(data){
	 		$("#divTablaProveModal").html(data);
		}); 
	}); 
	$('#btnAgregarDetallePedido').click(function(){
		var idProd= $("#cod_producto").val();
		var cantidad= $("#inputCantidad").val();
		var codprove = $('#cod_proveedor').val();
		console.log('ddddd:'+idProd+'|'+cantidad);
		$.post("agregarDetalleCotizacion",{"objCotizacion.cod_proveedor":codprove,"idProd":idProd,cantidad:cantidad},function(data){
	 		$("#divDetallePedido").html(data);
		}); 
	});

	$('#btnGuardar').click(function(){ 
		var codprove = $('#cod_proveedor').val();
// 		var observacion = $('#inputObservacion').val();  
		$.post("guardarCotizacion",
			{ 
		"objCotizacion.cod_proveedor":codprove 
			}
		,
		function(data){
			$("#divMostrarMensaje").html(data);
	 		$('#myCotizacion').modal({
			  keyboard: false
			}); 
// 	 		setTimeout(function(){ $(location).attr('href','inicio'); }, 4000); 
		});
	});
	
	 setTimeout(function(){ $('.alert').hide(1000); }, 3000); 
}); 
</script>
<h3>Registrar Solicitud de Cotizacion</h3>
<form>
<!-- Proveedor -->
<h5>Datos del Proveedor</h5>  
<s:hidden  name="objCotizacion.cod_proveedor" id="cod_proveedor"     />
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputProveedor">Proveedor</label>
		<input type="text" id="raz_social" class="input-xxlarge" name="raz_social" placeholder="Proveedor" disabled>
		<a class="btn btn-primary" id="idBuscarProveedor" href="#myBuscarProveedor" data-toggle="modal">Buscar Proveedor</a>
	</div> 
</div> 

 

<!-- Producto -->
<h5>Datos del Producto</h5>
<div class="control-group">
	<div  class="form-inline ">
		<s:hidden  name="cod_producto"  id="cod_producto"    />
		<label class="control-label" for="inputProducto">Producto</label>
		<input type="text" class="input-xxlarge" id="desc_producto" placeholder="Producto" disabled>
		<label class="control-label" for="inputUMedida">U.Medida</label>
		<input type="text" class="input-large" id="unidadMedida"   placeholder="U.Medida" disabled>
		<a class="btn btn-primary"  id="idBuscarProducto" href="#myBuscarProducto" data-toggle="modal" >Buscar Producto</a>
	</div> 
</div> 
<br>
<br>
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputCantidad">Cantidad</label>
		<input type="text" class="input-large" id="inputCantidad" placeholder="Cantidad"> 
		<a class="btn btn-primary"   id="btnAgregarDetallePedido"  >Agregar</a>
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
<div class="controls"  align="center">
<a class="btn  btn-primary" id="btnGuardar">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Guardar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;
<a class="btn  btn-primary"  onclick="javascript:history.back();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cancelar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
</div>
</div>

</form>

 
<!-- Modal -->
<div id="myBuscarProveedor" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalBuscarProveedor" aria-hidden="true">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
<h3 id="myModalBuscarProveedor">Buscar Proveedor</h3>
</div>
<div class="modal-body">
	<div class="form-search"   >
	    <input type="text" id="txtProveedor" name="objProveedor.raz_social" class="input-medium search-query" placeholder="Proveedor" >
	    <button type="submit" class="btn" id="idBotonBuscarProveedor" >Buscar</button>
    </div> 
      <div id="divTablaProveModal">
      </div>
      <div id="divDatosProveTotal"></div>  
</div> 
</div>

<!-- Modal -->
<div id="myBuscarProducto" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalBuscarProducto" aria-hidden="true">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
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
<div id="myCotizacion" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalCotizacion" aria-hidden="true">
<div class="modal-header"> 
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
<h3 id="myModalCotizacion">Resultado Cotizacion</h3>
</div>
<div class="modal-body"> 
      <div id="divMostrarMensaje">
      </div> 
</div> 
</div>