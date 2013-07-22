<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Nuevo Proveedor</h3>

<form class="form-horizontal">
<div class="control-group">
<label class="control-label" for="inputRazonSocial">Razon Social</label>
<div class="controls">
<input type="text" id="inputRazonSocial" placeholder="Razon Social">
</div>
</div>
<div class="control-group">
<label class="control-label" for="inputTipo">Tipo Doc.</label>
<div class="controls">
<!-- <input type="text" id="inputTipo" placeholder="Tipo"> -->
<select>
<option>Seleccionar</option>
<option>RUC</option>
<option>DNI</option> 
</select>


</div>
</div>
<div class="control-group">
<label class="control-label" for="inputNumero">Numero Doc.</label>
<div class="controls">
<input type="text" id="inputNumero" placeholder="Numero Doc.">
</div>
</div>
<div class="control-group">
<label class="control-label" for="inputTelefonos">Telefonos</label>
<div class="controls">
<input type="text" id="inputTelefonos" placeholder="Telefonos">
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