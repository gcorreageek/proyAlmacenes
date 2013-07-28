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

<h3>Informe Interno de Salida</h3>
<form>
<div class="control-group">
	<div  class="form-inline"> 
		<label class="control-label" for="inputFecha">Fecha</label>
		<input type="text" id="inputFecha" value="12/12/2012" disabled> 
	</div>
</div>
<h5>Datos del Pedido</h5>
<div class="control-group">
	<div  class="form-inline"> 
		<label class="control-label" for="inputFecha">Fecha</label>
		<input type="text" id="inputFecha" value="12/12/2012" disabled>
		<a class="btn btn-primary" href="#myBuscarPedido" data-toggle="modal" >Buscar Pedido</a> 
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
		<input type="radio" name="optionsRadios" id="optionAbastecimiento" value="option2" disabled  >Abastecimiento
		</label>	 
		<label class="radio">
		<input type="radio" name="optionsRadios" id="optionPrestamo" value="option1" disabled  checked>Prestamo
		</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<label class="control-label" for="inputIcon">Fecha Entrega</label>
		<div class="input-prepend">
		<span class="add-on"><i class="icon-calendar"></i></span>
		<input class="span2 datepicker"   type="text" disabled>
		</div> 
		
	</div>
</div>

<div class="control-group"  id="divFechaDevolucion" >
	<div  class="form-inline "> 
  
		<label class="control-label" for="inputIcon">Fecha Devolucion</label>
		<div class="input-prepend">
		<span class="add-on"><i class="icon-calendar"></i></span>
		<input class="span2 datepicker"   type="text" disabled>
		</div> 
		
	</div>
</div>
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputObservacionPedido">Observaci&oacute;n Pedido</label>
		<textarea rows="1" class="span9"  id="inputObservacionPedido" placeholder="Observaci&oacute;n Pedido"   disabled></textarea>  
	</div>
</div> 
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputObservacionEvaluacion">Observaci&oacute;n Evaluaci&oacute;n</label>
		<textarea rows="1" class="span9"  id="inputObservacionEvaluacion" placeholder="Observaci&oacute;n Evaluaci&oacute;n"   disabled></textarea>  
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






<%-- <jsp:include page="../pedido/buscar_pedido.jsp" />  --%>