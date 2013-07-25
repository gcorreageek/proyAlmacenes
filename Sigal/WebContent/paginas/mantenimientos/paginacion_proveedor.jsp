<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
 
<table class="table table-striped table-bordered table-hover">
              <thead>
                <tr> 
                  <th>Razon Social</th>
                  <th>Tipo Doc</th>
                  <th>Numero Doc</th>
                  <th>Telefono</th> 
                  <th>Modificar</th>
                  <th>Eliminar</th>
                </tr>
              </thead>
              <tbody>
              <c:if test="${requestScope.lstProveedor!=null}"   >
			     <c:forEach  items="${requestScope.lstProveedor}"  var="row"  >
			     	<tr> 
	                  <td>${row.raz_social}</td>
	                  <td>${row.tipo}</td> 
	                  <td>${row.ruc}</td> 
	                  <td>${row.telefono}</td> 
	                  <td><a href="accionProveedor?codProvee=${row.cod_proveedor}">[Modificar]</a></td>
	                  <td><a href="eliminarProveedor?codProvee=${row.cod_proveedor}">[Eliminar]</a></td>
	                </tr>
			     </c:forEach> 
		      </c:if> 
              </tbody>
</table>

