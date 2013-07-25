<script type="text/javascript"  >

$(document).ready(function() { 
	$('#checkNroPedido').click(function(){
		if($("#checkNroPedido").is(':checked')){
			$("#inputNroPedido").prop('disabled', true);
		}else{
			$("#inputNroPedido").prop('disabled', false);
		} 
	});
	
});  
</script>

<h3>Informe Externo de Entrada</h3>
<form>
<div class="control-group">
	<div  class="form-inline"> 
		<label class="control-label" for="inputFecha">Fecha</label>
		<input type="text" id="inputFecha" value="12/12/2012" disabled> 
	</div>
</div>
<h5>Datos de la Orden Compra</h5> 
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputResponsable">Responsable</label>
		<input type="text" id="inputResponsable" class="span5" placeholder="Responsable" disabled>
		<a class="btn btn-primary" href="#myBuscarOrdenCompra" data-toggle="modal">Buscar Orden de Compra</a>
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
		<label class="control-label" for="inputObservacionPedido">Observaci&oacute;n de la Orden de Compra</label>
		<textarea rows="1" class="span9"  id="inputObservacionPedido" placeholder="Observaci&oacute;n de la Orden de Compra"   disabled></textarea>  
	</div>
</div>  
    <table class="table table-striped table-bordered table-hover">
              <thead>
                <tr> 
                  <th>Producto</th> 
                  <th>U.Medida</th>
                  <th>Cantidad</th>  
                </tr>
              </thead>
              <tbody>
                <tr> 
                  <td>Pizarra</td> 
                  <td>Unidad</td>
				  <td>10</td>  
                </tr>
                <tr> 
                  <td>Tizas</td> 
                  <td>Unidad</td>
                  <td>100</td>  
                </tr>
                <tr> 
                  <td>Lapicero</td> 
                  <td>Unidad</td>
                  <td>100</td>  
                </tr>
              </tbody>
            </table> 
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputObservacion">Observaci&oacute;n</label>
		<textarea rows="1" class="span11"  id="inputObservacion" placeholder="Observaci&oacute;n"   ></textarea>  
	</div>
</div>


<div class="control-group"> 
<div class="controls"  align="center">
<a class="btn  btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Guardar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;
<a class="btn  btn-primary"  onclick="javascript:history.back();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cancelar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
</div>
</div>
</form>






<jsp:include page="../orden_compra/buscar_orden_compra.jsp" /> 