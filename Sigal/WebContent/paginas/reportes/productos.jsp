<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %> 
<script type="text/javascript"  > 
$(document).ready(function() {
// 	$('#idBuscarProducto').click(function(){
// 		$("#txtProducto").val("");
		$.post("listarProductoTotal",function(data){
	 		$("#divDatosProdTotal").html(data);
		}); 
		$.post("listarProductoPagModal",{inicio:null},function(data){
	 		$("#divTablaProdModal").html(data);
		}); 
// 	});  
	$('#idBotonBuscarProducto').click(function(){
		var txtProd=$("#desc_producto").val();
		var uMedida=$("#idUMedida").val(); 
		
		$.post("buscarProductoTotal",{"objProducto.desc_producto":txtProd,"objProducto.unidadMedida":uMedida},function(data){
	 		$("#divDatosProdTotal").html(data);
		}); 
		$.post("buscarProductosXDescProdPagModal",{inicio:null,"objProducto.desc_producto":txtProd,"objProducto.unidadMedida":uMedida},function(data){
	 		$("#divTablaProdModal").html(data);
		}); 
	});    
});  
</script>
<h3>Reportes de Producto</h3>  
<div id="divMostrarMensaje"> 
</div>
<form action="reporteProductos" method="post" >
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputProducto">Producto</label>
		<input type="text" class="span5" id="desc_producto" name="objProducto.desc_producto"  placeholder="Producto"  >
	</div>
</div>
<div class="control-group">
	<div  class="form-inline ">
	<label class="control-label" for="unidadMedida">U.Medida</label>
	<s:select  id="idUMedida"  
			list="#{'Seleccionar':'Seleccionar','Unidad':'Unidad', 'Caja':'Caja', 'Docena':'Docena',  'Millar':'Millar'}"
			name="objProducto.unidadMedida"   />
	<a class="btn   btn-primary" id="idBotonBuscarProducto" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Consultar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;
	<button type="submit"   class="btn  btn-primary" id="btnExportar" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Exportar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>&nbsp;&nbsp;&nbsp;
	</div> 
</div>
</form>
<div id="divTablaProdModal"></div>
<div id="divDatosProdTotal"></div>
 
 

 
 

  
  
  
<div id="myMensaje" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalBuscarProducto" aria-hidden="true">
<div class="modal-body">
<div id="idMensajeInterno"></div> 
</div> 
</div>