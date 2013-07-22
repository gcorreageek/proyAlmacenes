<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Nuevo Producto</h3>

<form class="form-horizontal">
<div class="control-group">
<label class="control-label" for="inputNombre">Nombre</label>
<div class="controls">
<input type="text" id="inputNombre" placeholder="Nombre">
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
 
 
<div class="control-group"> 
<div class="controls">
<a class="btn btn-primary">Registrar</a>
<a class="btn btn-primary"  onclick="javascript:history.back();">Cancelar</a>
</div>
</div>

</form>


 



</body>
</html>