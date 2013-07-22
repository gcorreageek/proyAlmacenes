<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Producto con Stocks</h3>

<form class="form-horizontal">
<!-- Producto -->
<div class="control-group">
<label class="control-label" for="inputNombre">Producto</label>
<div class="controls">
<input type="text" id="inputNombre" placeholder="Producto">
<a class="btn btn-primary" href="#myBuscarProducto" data-toggle="modal" >Buscar Producto</a>
</div>
</div>
<div class="control-group">
<label class="control-label" for="inputCategoria">Categoria</label>
<div class="controls">
<input type="text" id="inputCategoria" placeholder="Categoria">
</div>
</div>
<div class="control-group">
<label class="control-label" for="inputMarca">Marca</label>
<div class="controls">
<input type="text" id="inputMarca" placeholder="Marca">
</div>
</div>
<div class="control-group">
<label class="control-label" for="inputUMedida">U.Medida</label>
<div class="controls">
<input type="text" id="inputUMedida" placeholder="U.Medida">
</div>
</div>
<!-- Stocks -->
<div class="control-group">
<label class="control-label" for="inputStockMinimo">Stock Minimo</label>
<div class="controls">
<input type="text" id="inputStockMinimo" placeholder="Stock Minimo">
</div>
</div>
<div class="control-group">
<label class="control-label" for="inputStockMaximo">Stock Maximo</label>
<div class="controls">
<input type="text" id="inputStockMaximo" placeholder="Stock Maximo">
</div>
</div>

<!-- Proveedor -->
<!-- <div class="control-group"> -->
<!-- <label class="control-label" for="inputProveedor">Proveedor</label> -->
<!-- <div class="controls"> -->
<!-- <input type="text" id="inputProveedor" placeholder="Proveedor"> -->
<!-- <a class="btn btn-primary" href="#myBuscarProveedor" data-toggle="modal">Buscar Proveedor</a> -->
<!-- </div> -->
<!-- </div>  -->

<div class="control-group"> 
<div class="controls">
<a class="btn btn-primary">Registrar</a>
<a class="btn btn-primary"  onclick="javascript:history.back();">Cancelar</a>
</div>
</div>

</form>

 
 
<jsp:include page="buscar_producto.jsp" />
<%-- <jsp:include page="buscar_proveedor.jsp" /> --%>
 
  


</body>
</html>