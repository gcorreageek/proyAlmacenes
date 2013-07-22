<h3>Registro Orden de Compra</h3>
<form>
<!-- Proveedor -->
<h5>Datos de la Cotizacion</h5>
<div class="control-group">
	<div  class="form-inline ">
		<label class="control-label" for="inputResponsable">Responsable</label>
		<input type="text" id="inputResponsable" class="input-xxlarge" placeholder="Responsable" disabled>
		<a class="btn btn-primary" href="#myBuscarCotizacion" data-toggle="modal">Buscar Cotizacion</a>
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
		<a class="btn btn-primary" href="#"   >Agregar</a>
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
<div class="controls"  align="center">
<a class="btn  btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Guardar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>&nbsp;&nbsp;&nbsp;
<a class="btn  btn-primary"  onclick="javascript:history.back();">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Cancelar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
</div>
</div>

</form>



<jsp:include page="../mantenimientos/buscar_producto.jsp" />
<jsp:include page="../cotizacion/buscar_cotizacion.jsp" />