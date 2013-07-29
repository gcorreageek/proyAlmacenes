<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %> 
<%@ page language="java"   import="com.sigal.util.UtilSigal"%>
<script type="text/javascript"> 
// ${row.cod_OrdenCompra},'${row.nom_usuario}','${row.fecharegistro_ordencompra}','${row.raz_social}'
function seleccionaOrdenCompra(codOrdenCompra,nomUsuario,fechaOrdenCompra,razonSocial){  
	$("#cod_OrdenCompra").val(codOrdenCompra);
	$("#inputResponsable").val(nomUsuario);
	$("#inputFecha").val(fechaOrdenCompra); 
	$("#inputProveedor").val(razonSocial);
	$.post("getDetalleOrdenCompra",{"objOrdenCompra.cod_OrdenCompra":codOrdenCompra},function(data){
 		$("#idTableDetalleOrdenCompra").html(data);
	});  	
} 
function guardarIEE(){//objInformeInterno.cod_pedido  obs_informeinterno
	var codOrdenCompra=$("#cod_OrdenCompra").val(); 
	var obs=$("#inputObservacion").val(); 
	$.post("guardarIEE",{"objInformeExterno.cod_ordencompra":codOrdenCompra,"objInformeExterno.obs_informeexterno":obs},function(data){
 		$("#divMensaje").html(data);
 		$('#myIE').modal({  keyboard: false }); 
 		setTimeout(function(){ $(location).attr('href','inicio'); }, 4000); 
	}); 
}
$(document).ready(function() {  
	$('#idBuscarOrdenCompra').click(function(){
// 		$("#txtPedido").val("");
		$.post("listarOrdenCompraTotal",function(data){
	 		$("#divDatosOrdenCompraTotal").html(data);
		}); 
		$.post("listarOrdenCompraPagModal",{inicio:null},function(data){
	 		$("#divTablaOrdenCompraModal").html(data);
		}); 
	});   
	/**COTIZACION**/
	$('#idBotonBuscarOrdenCompra').click(function(){ 
		var txtNombreRespo=$("#txtNombreResponsable").val(); 
		var txtFechaInicio=$("#txtFechaInicio").val();
		var txtFechaFin=$("#txtFechaFin").val();  
		$.post("buscarPedidoTotal",{
			"objOrdenCompra.nom_usuario":txtNombreRespo, 
			"objOrdenCompra.fechaInicio":txtFechaInicio,
			"objOrdenCompra.fechaFin":txtFechaFin
			},function(data){
	 		$("#divDatosOrdenCompraTotal").html(data);
		}); 
		$.post("buscarOrdenCompraPagModal",{
			"objOrdenCompra.nom_usuario":txtNombreRespo, 
			"objOrdenCompra.fechaInicio":txtFechaInicio,
			"objOrdenCompra.fechaFin":txtFechaFin
			},function(data){
	 		$("#divTablaOrdenCompraModal").html(data);
		}); 
	});    

// 	 setTimeout(function(){ $('.alert').hide(1000); }, 3000); 
}); 
</script>
<h3>Informe Externo de Salida</h3>
<form>
<s:hidden  name="objOrdenCompra.cod_OrdenCompra"  id="cod_OrdenCompra"    />
<div class="control-group">
	<div  class="form-inline"> 
		<label class="control-label" for="inputFecha"  >Fecha</label>
		<input type="text" id="inputFechaActual"   value="<%=UtilSigal.fechaActual() %>"   disabled> 
	</div>
</div>
<h5>Datos de la Orden Compra</h5> 
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputResponsable">Responsable</label>
		<input type="text" id="inputResponsable" class="span5" placeholder="Responsable" disabled>
		<a class="btn btn-primary"  id="idBuscarOrdenCompra" href="#myBuscarOrdenCompra" data-toggle="modal">Buscar Orden de Compra</a>
	</div>
</div> 
<div class="control-group">
	<div  class="form-inline "> 
		<label class="control-label" for="inputFecha">Fecha</label>
		<input type="text" id="inputFecha" placeholder="Fecha" disabled>
	</div> 
</div>  
<h5>Datos del Proveedor</h5>
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputProveedor">Proveedor</label>
		<input type="text" id="inputProveedor" class="input-xxlarge" placeholder="Proveedor" disabled> 
	</div> 
</div>  
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputObservacionOrdenCompra">Observaci&oacute;n de la Orden de Compra</label>
		<textarea rows="1" class="span9"  id="inputObservacionOrdenCompra" placeholder="Observaci&oacute;n de la Orden de Compra"   disabled></textarea>  
	</div>
</div>  
<div id="idTableDetalleOrdenCompra">
    <table class="table table-striped table-bordered table-hover">
      <thead>
        <tr> 
          <th>Producto</th> 
          <th>U.Medida</th>
          <th>Cantidad</th>  
        </tr>
      </thead>
      <tbody> 
      </tbody>
    </table> 
</div>

<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputObservacion">Observaci&oacute;n</label>
		<textarea rows="1" class="span11"  id="inputObservacion" placeholder="Observaci&oacute;n"   ></textarea>  
	</div>
</div>


<div class="control-group"> 
<div class="controls"  align="center">
<a class="btn  btn-primary"  onclick="javascript:guardarIEE();" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Guardar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;
<a class="btn  btn-primary"  href="inicio">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cancelar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
</div>
</div>
</form>








<!-- Modal -->
<div id="myBuscarOrdenCompra" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalBuscarOrdenCompra" aria-hidden="true">
<div class="modal-header"> 
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
<h3 id="myModalBuscarOrdenCompra">Buscar OrdenCompra</h3>
</div>
<div class="modal-body">
	<div class="form-search"   >
		<input type="text" id="txtFechaInicio" class="input-medium search-query" placeholder="Fecha Inicio" >
	    <input type="text" id="txtFechaFin" class="input-medium search-query" placeholder="Fecha Fin" >
	    <input type="text" id="txtNombreResponsable" name="objOrdenCompra.nom_usuario" class="input-medium search-query" placeholder="Nombre de Responsable" >
		
	    <button type="submit" class="btn" id="idBotonBuscarOrdenCompra" >Buscar</button>
    </div> 
      <div id="divTablaOrdenCompraModal">
      </div>
      <div id="divDatosOrdenCompraTotal"></div>  
</div> 
</div> 

 
<div id="myIE" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalIE" aria-hidden="true">
<div class="modal-header"> 
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
<h3 id="myModalIE">Resultado Informe Externo de Salida</h3>
</div>
<div class="modal-body"> 
      <div id="divMensaje">
      </div> 
</div> 
</div>