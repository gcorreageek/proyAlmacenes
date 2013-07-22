<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Mantenimiento Producto</h3>
	<form class="form-search">
	    <input type="text" class="input-medium search-query" placeholder="Producto" >
	    <button type="submit" class="btn">Buscar</button>
    </form>
    <table class="table table-striped table-bordered table-hover">
              <thead>
                <tr>
                  <th>Cod</th>
                  <th>Producto</th>
                  <th>Categoria</th>
                  <th>Marca</th>
                  <th>U.Medida</th>
                  <th>Stock Minimo</th>
                  <th>Stock Maximo</th>
                  <th>Modificar</th>
                  <th>Eliminar</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>Pizarra</td>
                  <td>Utileria</td>
                  <td>Chino</td>
                  <td>Unidad</td>
				  <td>10</td>
				  <td>250</td>
                  <td><a href="#">[Modificar]</a></td>
                  <td><a href="#">[Eliminar]</a></td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>Tizas</td>
                  <td>Utileria</td>
                  <td>Caja</td>
                  <td>Unidad</td>
                  <td>100</td>
				  <td>2500</td>
                  <td><a href="#">[Modificar]</a></td>
                  <td><a href="#">[Eliminar]</a></td>
                </tr>
                <tr>
                  <td>3</td>
                  <td>Lapicero</td>
                  <td>Utileria</td>
                  <td>Faber Castell</td>
                  <td>Unidad</td>
                  <td>100</td>
				  <td>1000</td>
                  <td><a href="#">[Modificar]</a></td>
                  <td><a href="#">[Eliminar]</a></td>
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
            <a class="btn btn-primary"  href="nuevoProducto">Nuevo Producto</a>
            <a class="btn btn-primary"  href="productoStocks">Producto con Stocks</a>

</body>
</html>