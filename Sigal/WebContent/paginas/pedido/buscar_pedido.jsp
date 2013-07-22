<!-- <style type="text/css"> -->
<!-- /* 	max-height: 800px; */ -->
<!-- /* 	width: 900px; /* SET THE WIDTH OF THE MODAL */ */ -->
<!-- /* 	margin: -250px 0 0 -450px; /* CHANGE MARGINS TO ACCOMODATE THE NEW WIDTH (original = margin: -250px 0 0 -280px;) */ */ -->
<!-- </style> -->



<!-- Modal -->
<div id="myBuscarPedido" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalBuscarPedido" aria-hidden="true">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
<h3 id="myModalBuscarPedido">Buscar Solicitud de Pedido</h3>
</div>
<div class="modal-body">

	<form class="form-search">  
	    <input type="text" class="input-medium search-query" placeholder="Nro.Pedido" >
	    <input type="text" class="input-medium search-query" placeholder="Responsable" >
	    <input type="text" class="input-medium search-query" placeholder="Fecha Inicio" >
	    <input type="text" class="input-medium search-query" placeholder="Fecha Fin" >
	    <select>
		<option>Seleccionar</option>
		<option>RRHH</option>
		<option>VENTAS</option> 
		</select>
		<select>
		<option>Seleccionar</option>
		<option>Abastecimiento</option>
		<option>Prestamo</option> 
		</select>
		<select>
		<option>Seleccionar</option>
		<option>Sin Evaluar</option>
		<option>Aprobadas</option>
		<option>Desaprobadas</option> 
		</select>
	    <button type="submit" class="btn">Buscar</button>
	    
	    
	    
	    
	    
	    
	    
    </form> 
    <table class="table table-striped table-bordered table-hover">
              <thead>
                <tr>
                  <th>NroPedido</th>
                  <th>Area</th>
                  <th>Responsable</th>
                  <th>T.Pedido</th>
                  <th>Fecha</th>
                  <th>Estado</th>   
                  <th>Seleccionar</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>PED200121</td>
                  <td>RRHH</td>
                  <td>Luz Campos</td>
                  <td>Abastecimiento</td>
                  <td>20/12/2012</td>  
                  <td>Sin Atender</td> 
                  <td align="center"><button type="button" class="btn btn-link" data-dismiss="modal" aria-hidden="true">[Seleccionar]</button></td>
                </tr>
                <tr>
                  <td>PED200121</td>
                  <td>RRHH</td>
                  <td>Luz Campos</td>
                  <td>Abastecimiento</td>
                  <td>20/12/2012</td>  
                  <td>Sin Atender</td> 
                  <td align="center"><button type="button" class="btn btn-link" data-dismiss="modal" aria-hidden="true">[Seleccionar]</button></td>
                </tr>
                <tr>
                  <td>PED200121</td>
                  <td>RRHH</td>
                  <td>Luz Campos</td>
                  <td>Abastecimiento</td>
                  <td>20/12/2012</td>  
                  <td>Sin Atender</td> 
                  <td align="center"><button type="button" class="btn btn-link" data-dismiss="modal" aria-hidden="true">[Seleccionar]</button></td>
                </tr>
              </tbody>
            </table>
                <div class="pagination">
			    <ul>
			    <li><a href="#">Anterior</a></li>
			    <li><a href="#">1</a></li>
			    <li><a href="#">2</a></li>
			    <li><a href="#">3</a></li>
			    <li><a href="#">4</a></li>
			    <li><a href="#">5</a></li>
			    <li><a href="#">Siguiente</a></li>
			    </ul>
			    </div>


</div> 
</div>