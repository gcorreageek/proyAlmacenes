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
	 setTimeout(function(){ $('.alert').hide(1000); }, 2000); 
}); 
</script>
</head>
<body>
<c:if test="${requestScope.objProducto.cod_producto!=null}"   >
<h3>Modificar Producto</h3>  
</c:if>
<c:if test="${requestScope.objProducto.cod_producto==null}"   >
<h3>Nuevo Producto</h3>  
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

<form class="form-horizontal" action="actuarProducto" method="post"  >
<s:hidden  name="objProducto.cod_producto"      />
<div class="control-group">
<label class="control-label" for="inputNombre">Nombre*</label>
<div class="controls">
<input type="text" id="inputNombre" name="objProducto.desc_producto" value="${objProducto.desc_producto}" placeholder="Nombre">
</div>
</div> 
<div class="control-group">
<label class="control-label" for="inputUMedida">U.Medida</label>
<div class="controls">
<s:select    
		list="#{'Unidad':'Unidad', 'Caja':'Caja', 'Docena':'Docena',  'Millar':'Millar'}"
		name="objProducto.unidadMedida"  value="objProducto.unidadMedida" />
</div>
</div>
<div class="control-group">
<label class="control-label" for="inputUMedida">Habilitaci&oacute;n</label>
<div class="controls">
<s:select    
		list="#{'Habilitado':'Habilitado', 'Desabilitado':'Desabilitado'}"
		name="objProducto.habilitado"  value="objProducto.habilitado" />
</div>
</div> 
 
 
<div class="control-group"> 
<div class="controls">
<button class="btn btn-primary">Guardar</button>
<a class="btn btn-primary"  href="mainProducto">Listar</a>
</div>
</div>

</form>


 



</body>
</html>