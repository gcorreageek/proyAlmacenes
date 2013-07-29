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
                  <th>Modificar</th>
                  <th>Eliminar</th>
                  <th>Ver QR</th>
                </tr>
              </thead>
              <tbody>
              <c:if test="${requestScope.lstProducto!=null}"   >
			     <c:forEach  items="${requestScope.lstProducto}"  var="row"  >
			     	<tr> 
	                  <td>${row.desc_producto}</td> 
	                  <td>${row.unidadMedida}</td> 
	                  <td><a href="accionProducto?codProd=${row.cod_producto}">[Modificar]</a></td>
	                  <td><a href="eliminarProducto?codProd=${row.cod_producto}">[Eliminar]</a></td>
	                  <td><a href="#" onclick="javascript:generarQR(${row.cod_producto});">[Ver QR]</a></td>
	                </tr>
			     </c:forEach> 
		      </c:if> 
              </tbody>
</table>

