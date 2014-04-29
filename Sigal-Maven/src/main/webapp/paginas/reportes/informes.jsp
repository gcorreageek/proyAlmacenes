<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %> 
<script type="text/javascript"  > 
$(document).ready(function() {
// 		$.post("listarProductoTotal",function(data){
// 	 		$("#divDatosProdTotal").html(data);
// 		}); 
// 		$.post("listarProductoPagModal",{inicio:null},function(data){
// 	 		$("#divTablaProdModal").html(data);
// 		}); 

		$("#idInforme").change(function () { 
			  $("select#idInforme option:selected").each(function () {  
// 				  alert('Cogiste:'+$(this).val());
				  if($(this).val()=='Interno'){
					  $('#idForm').attr('action','reporteInformeInterno'); 
				  }else{
					  $('#idForm').attr('action','reporteInformeExterno'); 
				  } 
	    	  }); 
			}).trigger('change'); 
// 	$('#idBotonBuscarProducto').click(function(){
// 		var txtProd=$("#desc_producto").val();
// 		var uMedida=$("#idUMedida").val(); 
		
// 		$.post("buscarProductoTotal",{"objProducto.desc_producto":txtProd,"objProducto.unidadMedida":uMedida},function(data){
// 	 		$("#divDatosProdTotal").html(data);
// 		}); 
// 		$.post("buscarProductosXDescProdPagModal",{inicio:null,"objProducto.desc_producto":txtProd,"objProducto.unidadMedida":uMedida},function(data){
// 	 		$("#divTablaProdModal").html(data);
// 		}); 
// 	});    
});  
</script>
<h3>Reportes de Informes</h3>  
<div id="divMostrarMensaje"> 
</div>
<form id="idForm"  method="post" >
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputProducto"  >Informe</label>
		<s:select  id="idInforme"  
			list="#{ 'Interno':'Interno', 'Externo':'Externo'}"
			name="informe"  />
	</div>
</div>
<div class="control-group">
	<div  class="form-inline ">
	<label class="control-label" for="unidadMedida" class="span4">Tipo</label>
	<s:select  id="idTipo"  
			list="#{'Seleccionar':'Seleccionar','Entrada':'Entrada', 'Salida':'Salida' }"
			name="tipo"   />
<!-- 	<a class="btn   btn-primary" id="idBotonBuscarProducto" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Consultar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp; -->
	<button type="submit"   class="btn  btn-primary" id="btnExportar" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Exportar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</button>&nbsp;&nbsp;&nbsp;
	</div> 
</div>
</form>
<div id="divTablaProdModal"></div>
<div id="divDatosProdTotal"></div>
 
 

 
 

  
   