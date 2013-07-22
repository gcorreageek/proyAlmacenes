<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Mantenimiento Proveedor</h3>
	<form class="form-search">
	    <input type="text" class="input-medium search-query" placeholder="Proveedor" >
	    <button type="submit" class="btn">Buscar</button>
    </form>
    <table class="table table-striped table-bordered table-hover">
              <thead>
                <tr>
                  <th>Cod</th>
                  <th>Proveedor</th>
                  <th>TipoDoc</th>
                  <th>NumDoc</th>
                  <th>Telefono</th> 
                  <th>Modificar</th>
                  <th>Eliminar</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>3M</td>
                  <td>RUC</td>
                  <td>10457205550</td>
                  <td>54026206</td> 
                  <td><a href="#">[Modificar]</a></td>
                  <td><a href="#">[Eliminar]</a></td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>LimpiaTodo SAC</td>
                  <td>DNI</td>
                  <td>45720555</td>
                  <td>5526296</td> 
                  <td><a href="#">[Modificar]</a></td>
                  <td><a href="#">[Eliminar]</a></td>
                </tr>
                <tr>
                  <td>3</td>
                  <td>Lau-Chun</td>
                  <td>RUC</td>
                  <td>107290122330</td>
                  <td>#994333</td> 
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
            <a class="btn btn-primary"  href="nuevoProveedor">Nuevo Proveedor</a>

</body>
</html>