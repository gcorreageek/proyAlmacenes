<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %> 
<script type="text/javascript"> 
// seleccionaCotizacion(${row.cod_cotizacion},'${row.nom_usuario}','${row.fecharegistro_cotizacion}','${row.cod_proveedor}','${row.raz_social}'
function seleccionaCotizacion(codCotizacion,nomUsuario,fechaCotizacion,codProvee,razonSocial){  
	$("#cod_cotizacion").val(codCotizacion);
	$("#inputResponsable").val(nomUsuario);
	$("#inputFecha").val(fechaCotizacion);
	$("#cod_proveedor").val(codProvee);
	$("#inputProveedor").val(razonSocial);
	 
	$.post("getDetalleCotizacion",{"objCotizacion.cod_cotizacion":codCotizacion},function(data){
 		$("#idTableDetalleCotizacion").html(data);
	});  	
} 
function seleccionaProd(codProd,descProd,uMedida){  
	$("#cod_producto").val(codProd);
	$("#desc_producto").val(descProd);
	$("#unidadMedida").val(uMedida); 
} 
function eliminarDetalleCotizacion(idProd){ 
	$.post("eliminarDetalleCotizacion",{"idProd":idProd},function(data){
 		$("#idTableDetalleCotizacion").html(data);
	});
}
$(document).ready(function() {  
	var mensaje="<div class='alert alert-error'><h4>Error!</h4>";
	$('#idBuscarCotizacion').click(function(){ 
		$.post("listarCotizacionTotal",function(data){
	 		$("#divDatosCotizacionTotal").html(data);
		}); 
		$.post("listarCotizacionPagModal",{inicio:null},function(data){
	 		$("#divTablaCotizacionModal").html(data);
		}); 
	});  
	/**PRODUCTO**/
	$('#idBuscarProducto').click(function(){ 
		var idProvee = $('#cod_proveedor').val(); 
		if(idProvee==null || idProvee=='' ){ 
			$("#divMostrarMensaje").html(mensaje+" Ingrese Proveedor correcto"+ "</div>");
			setTimeout(function(){ $('.alert').hide(1000); }, 2000); 
			return;
		} 
		$('#myBuscarProducto').modal({  keyboard: false });  
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
	/**COTIZACION**/
	$('#idBotonBuscarCotizacion').click(function(){ 
		var txtNombreRespo=$("#txtNombreResponsable").val(); 
		var txtFechaInicio=$("#txtFechaInicio").val();
		var txtFechaFin=$("#txtFechaFin").val(); 
		$.post("buscarCotizacionTotal",{
			"objCotizacion.nom_usuario":txtNombreRespo, 
			"fechaComienzaInicio":txtFechaInicio,
			"fechaTerminaFin":txtFechaFin
			},function(data){
	 		$("#divDatosCotizacionTotal").html(data);
		}); 
		$.post("buscarCotizacionPagModal",{
			"objCotizacion.nom_usuario":txtNombreRespo, 
			"fechaComienzaInicio":txtFechaInicio,
			"fechaTerminaFin":txtFechaFin
			},function(data){
	 		$("#divTablaCotizacionModal").html(data);
		}); 
	});  
	$('#btnAgregarDetalleOC').click(function(){
		var idProd= $("#cod_producto").val();
		var cantidad= $("#inputCantidad").val();
		var idProvee = $('#cod_proveedor').val();
		if(idProvee==null || idProvee=='' ){ 
			$("#divMostrarMensaje").html(mensaje+" Ingrese Proveedor correcto"+ "</div>");
			setTimeout(function(){ $('.alert').hide(1000); }, 2000); 
			return;
		}
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
		
		$.post("agregarDetalleCotizacion",{"objCotizacion.cod_proveedor":idProvee,"idProd":idProd,cantidad:cantidad},function(data){
	 		$("#idTableDetalleCotizacion").html(data);
		}); 
	});

	$('#btnGuardar').click(function(){ 
		var codProve = $('#cod_proveedor').val(); 
		var codcotizacion = $('#cod_cotizacion').val();
		if(codcotizacion==null || codcotizacion=='' ){ 
			$("#divMostrarMensaje").html(mensaje+" Ingrese Cotizacion correcto"+ "</div>");
			setTimeout(function(){ $('.alert').hide(1000); }, 2000); 
			return;
		} 
		
		$.post("guardarOrdenCompra",{ 
		"objOrdenCompra.cod_cotizacion":codcotizacion ,
		"objOrdenCompra.cod_proveedor":codProve
		},
		function(data){
			var bien = data.indexOf("Error");  
			if(bien<0){
				$("#divMostrarMensajeInterno").html(data);
		 		$('#myOrdenCompra').modal({  keyboard: false });  
		 		setTimeout(function(){ $(location).attr('href','mainOrdenCompra'); }, 4000);
			}else{
				$("#divMostrarMensajeInterno").html(data);
		 		$('#myOrdenCompra').modal({  keyboard: false });  
			}  
			
// 			$("#divMostrarMensaje").html(data);
// 	 		$('#myOrdenCompra').modal({
// 			  keyboard: false
// 			}); 
// 	 		setTimeout(function(){ $(location).attr('href','inicio'); }, 4000); 
		});
	});

// 	 setTimeout(function(){ $('.alert').hide(1000); }, 3000); 
}); 
</script>
<h3>Registro Orden de Compra</h3>
<div id="divMostrarMensaje"> 
</div>
<form>
<!-- Proveedor -->
<h5>Datos de la Cotizacion</h5>
<s:hidden  name="objCotizacion.cod_cotizacion"  id="cod_cotizacion"    />
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputResponsable">Responsable</label>
		<input type="text" id="inputResponsable" class="input-xxlarge" placeholder="Responsable" disabled>
		<a class="btn btn-primary"  id="idBuscarCotizacion" href="#myBuscarCotizacion" data-toggle="modal">Buscar Cotizacion</a>
	</div>
</div> 
<div class="control-group">
	<div  class="form-inline "> 
		<label class="control-label" for="inputFecha">Fecha</label>
		<input type="text" id="inputFecha" placeholder="Fecha" disabled>
	</div> 
</div>  
<s:hidden  name="objCotizacion.cod_proveedor"  id="cod_proveedor"    />
<h5>Datos del Proveedor</h5>
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputProveedor">Proveedor</label>
		<input type="text" id="inputProveedor" class="input-xxlarge" placeholder="Proveedor" disabled> 
	</div> 
</div>  

<!-- Producto -->
<h5>Datos del Producto</h5>
<s:hidden  name="objCotizacion.cod_producto"  id="cod_producto"    />
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputProducto">Producto</label>
		<input type="text" id="desc_producto" class="input-xxlarge" id="inputProducto" placeholder="Producto" disabled>
		<label class="control-label" for="inputUMedida">U.Medida</label>
		<input type="text"  id="unidadMedida" class="input-large" id="inputUMedida" placeholder="U.Medida" disabled>
		<a class="btn btn-primary" id="idBuscarProducto" data-toggle="modal" >Buscar Producto</a>
	</div>
	
</div> 
<br>
<br>
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputCantidad">Cantidad</label>
		<input type="text" class="input-large" id="inputCantidad" placeholder="Cantidad"> 
		<a class="btn btn-primary"  id="btnAgregarDetalleOC"   >Agregar</a>
	</div>
</div>
<div id="idTableDetalleCotizacion">
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
<a class="btn  btn-primary"  href="mainOrdenCompra">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cancelar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
</div>
</div>

</form>



<!-- Modal -->
<div id="myBuscarCotizacion" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalBuscarCotizacion" aria-hidden="true">
<div class="modal-header"> 
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
<h3 id="myModalBuscarCotizacion">Buscar Cotizacion</h3>
</div>
<div class="modal-body">
	<div class="form-search"   >
		<input type="text" id="txtFechaInicio" class="input-medium search-query datepicker" placeholder="Fecha Inicio" >
	    <input type="text" id="txtFechaFin" class="input-medium search-query datepicker" placeholder="Fecha Fin" >
	    <input type="text" id="txtNombreResponsable" name="objOrdenCompra.nom_usuario" class="input-medium search-query" placeholder="Nombre de Responsable" >
		
	    <button type="submit" class="btn" id="idBotonBuscarCotizacion" >Buscar</button>
    </div> 
      <div id="divTablaCotizacionModal">
      </div>
      <div id="divDatosCotizacionTotal"></div>  
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
<div id="myOrdenCompra" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalCotizacion" aria-hidden="true">
<div class="modal-body"> 
      <div id="divMostrarMensajeInterno">
      </div> 
</div> 
</div>