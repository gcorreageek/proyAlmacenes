<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
 
<table class="table table-striped table-bordered table-hover">
              <thead>
                <tr>
					<th>Cargo</th>
					<th>Area</th>  
					<th>Modificar</th>
					<th>Eliminar</th>
				</tr>
              </thead>
              <tbody>
              <c:if test="${requestScope.lstCargo!=null}"   >
			     <c:forEach  items="${requestScope.lstCargo}"  var="row"  >
			     	<tr> 
	                  <td>${row.desc_cargo}</td> 
	                  <td>${row.desc_area}</td>
	                  <td><a href="accionCargo?codCargo=${row.cod_cargo}">[Modificar]</a></td>
	                  <td><a href="eliminarCargo?codCargo=${row.cod_cargo}">[Eliminar]</a></td>
	                </tr>
			     </c:forEach> 
		      </c:if> 
              </tbody>
</table>

