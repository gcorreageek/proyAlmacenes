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
<c:if test="${requestScope.objProductoProveedor.cod_producto_proveedor!=null}"   >
<h3>Modificar Producto Proveedor</h3>  
</c:if>
<c:if test="${requestScope.objProductoProveedor.cod_producto_proveedor==null}"   >
<h3>Nuevo Producto Proveedor</h3>  
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

<form class="form-horizontal" action="actuarProductoProveedor" method="post"  >
<s:hidden  name="objProductoProveedor.cod_producto_proveedor"      />
<s:hidden  name="objProductoProveedor.cod_producto"      />
<div class="control-group">
<label class="control-label" for="inputNombre">Nombre</label>
<div class="controls">
<input type="text" id="inputNombre" name="objProductoProveedor.desc_producto" value="${objProductoProveedor.desc_producto}" placeholder="Nombre">
<a class="btn btn-primary" href="#myBuscarProducto" data-toggle="modal" >Buscar Producto</a>
</div>
</div> 
<div class="control-group">
<label class="control-label" for="inputUMedida">U.Medida</label>
<div class="controls">
<input type="text" id="inputUMedida"  name="objProductoProveedor.unidadMedida" value="${objProductoProveedor.unidadMedida}" placeholder="U.Medida">
</div>
</div>
<s:hidden  name="objProductoProveedor.cod_proveedor"      />
<div class="control-group">
<label class="control-label" for="inputProveedor">Proveedor</label>
<div class="controls">
<input type="text" id="inputProveedor"  name="objProductoProveedor.raz_social" value="${objProductoProveedor.raz_social}" placeholder="Proveedor">
<a class="btn btn-primary" href="#myBuscarProveedor" data-toggle="modal">Buscar Proveedor</a>
</div>
</div>
 
<div class="control-group"> 
<div class="controls">
<button class="btn btn-primary">Guardar</button>
<a class="btn btn-primary"  href="mainProductoProveedor">Listar</a>
</div>
</div>

</form> 
</body>
</html>


<jsp:include page="../mantenimientos/buscar_producto.jsp" />
<jsp:include page="../mantenimientos/buscar_proveedor.jsp" />