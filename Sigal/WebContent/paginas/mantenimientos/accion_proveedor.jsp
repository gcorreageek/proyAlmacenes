<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function() { 
	 setTimeout(function(){ $('.alert').hide(1000); }, 3000); 
}); 
</script>
</head>
<body>
<c:if test="${requestScope.objProveedor.cod_proveedor!=null}"   >
<h3>Modificar Proveedor</h3>  
</c:if>
<c:if test="${requestScope.objProveedor.cod_proveedor==null}"   >
<h3>Nuevo Proveedor</h3>  
</c:if>


<c:if test="${requestScope.rsult!=null}"   >
<c:if test="${requestScope.rsult=='0'}"   >
	<div class="alert alert-success"> 
	<h4>Bien!</h4>
	${requestScope.mensaje}
	</div> 
</c:if>
<c:if test="${requestScope.rsult=='1'}"   >
	<div class="alert alert-error"> 
	<h4>Error!</h4>
	${requestScope.mensaje}
	</div> 
</c:if>

</c:if>

<form class="form-horizontal" action="actuarProveedor" method="post"  >
<s:hidden  name="objProveedor.cod_proveedor"      />
<div class="control-group">
<label class="control-label" for="inputNombre">Rason Social</label>
<div class="controls">
<input type="text" id="inputRazonSocial" name="objProveedor.raz_social" value="${objProveedor.raz_social}" placeholder="Rason Social">
</div>
</div>
<div class="control-group">
<label class="control-label" for="inputTipo">Tipo</label>
<div class="controls">
<input type="text" id="inputTipo"  name="objProveedor.tipo" value="${objProveedor.tipo}" placeholder="Tipo">
</div>
</div>
<div class="control-group">
<label class="control-label" for="inputMarca">Numero Doc</label>
<div class="controls">
<input type="text" id="inputMarca"  name="objProveedor.ruc" value="${objProveedor.ruc}" placeholder="Numero Doc">
</div>
</div>
<div class="control-group">
<label class="control-label" for="inputTelefono">Telefono</label>
<div class="controls">
<input type="text" id="inputTelefono"  name="objProveedor.telefono" value="${objProveedor.telefono}" placeholder="Telefono">
</div>
</div>
 
 
<div class="control-group"> 
<div class="controls">
<button class="btn btn-primary">Guardar</button>
<a class="btn btn-primary"  href="mainProveedor">Listar</a>
</div>
</div>

</form>


 



</body>
</html>