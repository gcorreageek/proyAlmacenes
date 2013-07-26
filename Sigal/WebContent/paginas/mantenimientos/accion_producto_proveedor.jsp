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
// cod_producto desc_producto unidadMedida cod_proveedor  raz_social
function seleccionaProd(codProd,descProd,uMedida){  
	$("#cod_producto").val(codProd);
	$("#desc_producto").val(descProd);
	$("#unidadMedida").val(uMedida); 
}
function seleccionaProvee(codProvee,descProvee){ 
	$("cod_proveedor").val(codProvee);
	$("raz_social").val(descProvee); 
}

$(document).ready(function() { 
	$('#idBuscarProducto').click(function(){
		$("#txtProducto").val("");
		$.post("listarProductoTotal",function(data){
	 		$("#divDatosProdTotal").html(data);
		}); 
		$.post("listarProductoPagModal",{inicio:null},function(data){
	 		$("#divTablaProdModal").html(data);
		}); 
	});  
	$('#idBotonBuscarProducto').click(function(){
		var txtProd=$("#txtProducto").val();
		$.post("buscarProductoTotal",{"objProducto.desc_producto":txtProd},function(data){
	 		$("#divDatosProdTotal").html(data);
		}); 
		$.post("buscarProductosXDescProdPagModal",{inicio:null,"objProducto.desc_producto":txtProd},function(data){
	 		$("#divTablaProdModal").html(data);
		}); 
	}); 
	
	$('#idBuscarProveedor').click(function(){
		$("#txtProveedor").val("");
		$.post("listarProveedorTotal",function(data){
	 		$("#divDatosProveTotal").html(data);
		}); 
		$.post("listarProveedorPagModal",{inicio:null},function(data){
	 		$("#divTablaProveModal").html(data);
		}); 
	});  
	$('#idBotonBuscarProveedor').click(function(){
		var txtProve=$("#txtProveedor").val();
		$.post("buscarProveedorTotal",{"objProveedor.raz_social":txtProve},function(data){
	 		$("#divDatosProveTotal").html(data);
		}); 
		$.post("buscarProveedorXRazonSocialPagModal",{inicio:null,"objProveedor.raz_social":txtProve},function(data){
	 		$("#divTablaProveModal").html(data);
		}); 
	}); 


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
<s:hidden  name="objProductoProveedor.cod_producto"  id="cod_producto"    />
<div class="control-group">
<label class="control-label" for="desc_producto">Nombre</label>
<div class="controls">
<input type="text" id="desc_producto" name="objProductoProveedor.desc_producto" value="${objProductoProveedor.desc_producto}" placeholder="Nombre"  disabled>
<a class="btn btn-primary" id="idBuscarProducto" href="#myBuscarProducto" data-toggle="modal" >Buscar Producto</a>
</div>
</div> 
<div class="control-group">
<label class="control-label" for="unidadMedida">U.Medida</label>
<div class="controls">
<input type="text" id="unidadMedida"  name="objProductoProveedor.unidadMedida" value="${objProductoProveedor.unidadMedida}" placeholder="U.Medida"  disabled>
</div>
</div>
<s:hidden  name="objProductoProveedor.cod_proveedor" id="cod_proveedor"     />
<div class="control-group">
<label class="control-label" for="raz_social">Proveedor</label>
<div class="controls">
<input type="text" id="raz_social"  name="objProductoProveedor.raz_social" value="${objProductoProveedor.raz_social}" placeholder="Proveedor" disabled>
<a class="btn btn-primary" id="idBuscarProveedor" href="#myBuscarProveedor" data-toggle="modal">Buscar Proveedor</a>
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



<!-- Modal -->
<div id="myBuscarProducto" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalBuscarProducto" aria-hidden="true">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
<h3 id="myModalBuscarProducto">Buscar Producto</h3>
</div>
<div class="modal-body">
	<div class="form-search"   >
	    <input type="text" id="txtProducto" name="objProducto.desc_producto" class="input-medium search-query" placeholder="Producto" >
	    <button type="submit" class="btn" id="idBotonBuscarProducto" >Buscar</button>
    </div> 
      <div id="divTablaProdModal">
      </div>
      <div id="divDatosProdTotal"></div>  
</div> 
</div>

<!-- Modal -->
<div id="myBuscarProveedor" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalBuscarProveedor" aria-hidden="true">
<div class="modal-header">
<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
<h3 id="myModalBuscarProveedor">Buscar Proveedor</h3>
</div>
<div class="modal-body">
	<div class="form-search"   >
	    <input type="text" id="txtProveedor" name="objProveedor.raz_social" class="input-medium search-query" placeholder="Proveedor" >
	    <button type="submit" class="btn" id="idBotonBuscarProveedor" >Buscar</button>
    </div> 
      <div id="divTablaProdModal">
      </div>
      <div id="divDatosTotal"></div>  
</div> 
</div>
  