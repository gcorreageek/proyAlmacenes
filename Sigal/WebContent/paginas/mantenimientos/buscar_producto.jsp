<!-- Modal -->
<div id="myBuscarProducto" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalBuscarProducto" aria-hidden="true">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
<h3 id="myModalBuscarProducto">Buscar Producto</h3>
</div>
<div class="modal-body">

	<form class="form-search">
	    <input type="text" class="input-medium search-query" placeholder="Producto" >
<!-- 	    <input type="text" class="input-medium search-query" placeholder="Categoria" > -->
<!-- 	    <input type="text" class="input-medium search-query" placeholder="Marca" > -->
<!-- 	    <input type="text" class="input-medium search-query" placeholder="U.Medida" > -->
	    <button type="submit" class="btn">Buscar</button>
    </form>
    <a class="btn btn-primary"  href="nuevoProducto">Nuevo Producto</a>
    <table class="table table-striped table-bordered table-hover">
              <thead>
                <tr>
                  <th>Cod</th>
                  <th>Producto</th>
                  <th>Categoria</th>
                  <th>Marca</th>
                  <th>U.Medida</th> 
                  <th>Seleccionar</th> 
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>Pizarra</td>
                  <td>Utileria</td>
                  <td>Chino</td>
                  <td>Unidad</td>  
                  <td align="center"><button type="button" class="btn btn-link" data-dismiss="modal" aria-hidden="true">[Seleccionar]</button></td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>Tizas</td>
                  <td>Utileria</td>
                  <td>Caja</td>
                  <td>Unidad</td> 
                  <td align="center"><button type="button" class="btn btn-link" data-dismiss="modal" aria-hidden="true">[Seleccionar]</button></td>
                </tr>
                <tr>
                  <td>3</td>
                  <td>Lapicero</td>
                  <td>Utileria</td>
                  <td>Faber Castell</td>
                  <td>Unidad</td> 
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
<!-- <div class="modal-footer"> -->
<!-- <button class="btn btn-primary">Aceptar</button> -->
<!-- <button class="btn" data-dismiss="modal" aria-hidden="true">Cancelar</button> -->
<!-- </div> -->
</div>