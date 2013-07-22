<script type="text/javascript"  >

$(document).ready(function() {
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
	
});  
</script>
<h3>Registrar Solicitud de Pedido</h3> 
<form>

<div class="control-group">
	<div  class="form-inline">
		<label class="control-label" for="inputNroPedido">Nro.Pedido</label>	
		<input type="text" class="span4" id="inputNroPedido" value="PED201222212" disabled>
		<label class="checkbox">
		<input type="checkbox" id="checkNroPedido" checked>&nbsp;&nbsp;&nbsp; 
		</label>
		<label class="control-label" for="inputFecha">Fecha</label>
		<input type="text" id="inputFecha" value="12/12/2012" disabled> 
	</div>
</div>

<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputResponsable">Responsable</label>	
		<input type="text" class="span4" id="inputResponsable" value="David Lopez"   disabled>
		<label class="control-label" for="inputArea">Area</label>
		<input type="text" id="inputArea" value="RRHH" disabled> 
		<label class="control-label" for="inputCargo">Cargo</label>
		<input type="text" id="inputCargo" value="Jefe de RRHH" disabled> 
	</div>
</div>

<div class="control-group">
	<div  class="form-inline ">
		<label class="input-small">Tipo Pedido</label>
		<label class="radio">
		<input type="radio" name="optionsRadios" id="optionAbastecimiento" value="option2" checked>Abastecimiento
		</label>	 
		<label class="radio">
		<input type="radio" name="optionsRadios" id="optionPrestamo" value="option1" >Prestamo
		</label>
		
	</div>
</div>

<div class="control-group"  id="divFechaDevolucion" >
	<div  class="form-inline "> 
  
		<label class="control-label" for="inputIcon">Fecha Devolucion</label>
		<div class="input-prepend">
		<span class="add-on"><i class="icon-calendar"></i></span>
		<input class="span4 datepicker" id="inputIcon" type="text">
		</div> 
		
	</div>
</div>

<!-- Producto -->
<h5>Datos del Producto</h5>
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputProducto">Producto</label>
		<input type="text" class="input-xxlarge" id="inputProducto" placeholder="Producto" disabled>
		<label class="control-label" for="inputCategoria">Categoria</label>
		<input type="text" class="input-medium" id="inputCategoria" placeholder="Categoria" disabled>
	</div>
	
</div>
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputMarca">Marca</label>
		<input type="text" class="input-large" id="inputMarca" placeholder="Marca" disabled>
		<label class="control-label" for="inputUMedida">U.Medida</label>
		<input type="text" class="input-large" id="inputUMedida" placeholder="U.Medida" disabled>
		<a class="btn btn-primary" href="#myBuscarProducto" data-toggle="modal" >Buscar Producto</a>
	</div>
</div>

<br>
<br>
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputCantidad">Cantidad</label>
		<input type="text" class="input-large" id="inputCantidad" placeholder="Cantidad"> 
		<a class="btn btn-primary"   >Agregar</a>
	</div>
</div>
    <table class="table table-striped table-bordered table-hover">
              <thead>
                <tr> 
                  <th>Producto</th>
                  <th>Categoria</th>
                  <th>Marca</th>
                  <th>U.Medida</th>
                  <th>Cantidad</th> 
                  <th>Eliminar</th>
                </tr>
              </thead>
              <tbody>
                <tr> 
                  <td>Pizarra</td>
                  <td>Utileria</td>
                  <td>Chino</td>
                  <td>Unidad</td>
				  <td>10</td> 
                  <td><a href="#">[Eliminar]</a></td>
                </tr>
                <tr> 
                  <td>Tizas</td>
                  <td>Utileria</td>
                  <td>Caja</td>
                  <td>Unidad</td>
                  <td>100</td> 
                  <td><a href="#">[Eliminar]</a></td>
                </tr>
                <tr> 
                  <td>Lapicero</td>
                  <td>Utileria</td>
                  <td>Faber Castell</td>
                  <td>Unidad</td>
                  <td>100</td> 
                  <td><a href="#">[Eliminar]</a></td>
                </tr>
              </tbody>
            </table> 
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputObservacion">Observacion</label>
		<textarea rows="1" class="span11"  id="inputObservacion" placeholder="Observacion"   ></textarea>  
	</div>
</div>


<div class="control-group"> 
<div class="controls"  align="center">
<a class="btn  btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Guardar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;
<a class="btn  btn-primary"  onclick="javascript:history.back();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cancelar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
</div>
</div>

</form>

 
 
<jsp:include page="../mantenimientos/buscar_producto.jsp" /> 
 
  

 