<h3>Evaluar Solicitud de Pedido</h3>
<form>

<div class="control-group">
	<div  class="form-inline">
<!-- 		<label class="control-label" for="inputNroPedido">Nro.Pedido</label>	 -->
<!-- 		<input type="text" class="span4" id="inputNroPedido" value="PED201222212" disabled> -->
<!-- 		&nbsp;&nbsp;&nbsp;  -->
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
		<label class="input-medium">Fecha Entrega</label>
		<div class="input-prepend">
		<span class="add-on"><i class="icon-calendar"></i></span>
		<input class="span2 datepicker"  type="text" disabled>
		</div> 
		
	</div>
</div>

<div class="control-group"  id="divFechaDevolucion" >
	<div  class="form-inline "> 
  
		<label class="control-label" for="inputIcon">Fecha Devolucion</label>
		<div class="input-prepend">
		<span class="add-on"><i class="icon-calendar"></i></span>
		<input class="span2 datepicker"  type="text" disabled>
		</div> 
		
	</div>
</div>
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputObservacionPedido">Observacion Pedido</label>
		<textarea rows="1" class="span9"  id="inputObservacionPedido" placeholder="Observacion Pedido"   disabled></textarea>  
	</div>
</div>
    <table class="table table-striped table-bordered table-hover">
              <thead>
                <tr> 
                  <th>Producto</th> 
                  <th>U.Medida</th>
                  <th>Cantidad</th>  
                  <th>Stock</th> 
                </tr>
              </thead>
              <tbody>
                <tr> 
                  <td>Pizarra</td> 
                  <td>Unidad</td>
				  <td>10</td>  
				  <td>20</td> 
                </tr>
                <tr> 
                  <td>Tizas</td> 
                  <td>Unidad</td>
                  <td>100</td> 
                  <td>10</td> 
                </tr>
                <tr> 
                  <td>Lapicero</td> 
                  <td>Unidad</td>
                  <td>100</td> 
				  <td>10</td> 
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
<a class="btn  btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Aprobar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;
<a class="btn  btn-primary"  onclick="javascript:history.back();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Desaprobar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
</div>
</div>
</form>






<jsp:include page="buscar_pedido.jsp" /> 






