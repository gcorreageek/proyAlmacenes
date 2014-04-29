<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
 
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

