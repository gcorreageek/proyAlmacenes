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
	var numeroPaginas = $("#numeroPaginas").val(); 
    var options = {
     currentPage: 1,
     totalPages: numeroPaginas,
     onPageClicked: function(e,originalEvent,type,page){ 
    	if($("#tagTipoListado").val()==1){
    		$.post("listarProductoProveedorPag",{inicio:page},function(data){
         		$("#divTablaPag").html(data);
     		}); 	
    	}else{
    		$.post("buscarProductoProveedorXRazonSocialAndDescProdPag",{inicio:page},function(data){
         		$("#divTablaPag").html(data);
     		}); 	
    	}
     	
     } 
 	}

    $('#divPaginador').bootstrapPaginator(options); 
	setTimeout(function(){ $('.alert').hide(1000); }, 3000); 
}); 
</script>
</head>
<body>  
<h3>Mantenimiento Producto Proveedor</h3>
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
	<form class="form-search"  action="buscarProductoProveedorXRazonSocialAndDescProd" method="post">
	    <input type="text" name="objProductoProveedor.desc_producto" class="input-medium search-query" placeholder="Producto" >
	    <input type="text" name="objProductoProveedor.raz_social" class="input-medium search-query" placeholder="Proveedor" >
	    <button type="submit" class="btn">Buscar</button>
    </form>
    
     
		<div id="divTablaPag">
		<table class="table table-striped table-bordered table-hover">
              <thead>
                <tr> 
                  <th>Producto</th>
                  <th>U.Medida</th>
                  <th>Proveedor</th> 
                  <th>Modificar</th>
                  <th>Eliminar</th>
                </tr>
              </thead>
              <tbody>
              <c:if test="${requestScope.lstProductoProveedor!=null}"   >
			     <c:forEach  items="${requestScope.lstProductoProveedor}"  var="row"  >
			     	<tr> 
			     	  <td>${row.desc_producto}</td>
	                  <td>${row.unidadMedida}</td>
	                  <td>${row.raz_social}</td> 
	                  <td><a href="accionProductoProveedor?codProdProvee=${row.cod_producto_proveedor}">[Modificar]</a></td>
	                  <td><a href="eliminarProductoProveedor?codProdProvee=${row.cod_producto_proveedor}">[Eliminar]</a></td>
	                </tr>
			     </c:forEach> 
		      </c:if> 
              </tbody>
		</table>
		</div>	 
		 <s:hidden id="tagTipoListado" name="tagTipoListado"      /> 
         <s:hidden id="numeroPaginas" name="numeroPaginas"      /> 
 	     <div id="divPaginador"></div>    
            
            <a class="btn btn-primary"  href="accionProductoProveedor">Nuevo Producto Proveedor</a>
<!--             <a class="btn btn-primary"  href="productoStocks">Producto con Stocks</a> -->

</body>
</html>