<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
 
<table class="table table-striped table-bordered table-hover">
              <thead>
                <tr> 
                  <th>Nombre</th>
                  <th>Correo</th>
                  <th>Area</th>   
                  <th>Cargo</th> 
                  <th>Usuario</th> 
                  <th>Habilitaci&oacute;n</th>  
                  <th>Modificar</th>
                  <th>Eliminar</th>
                </tr>
              </thead>
              <tbody>
              <c:if test="${requestScope.lstUsuario!=null}"   >
			     <c:forEach  items="${requestScope.lstUsuario}"  var="row"  >
			     	<tr> 
	                  <td>${row.nom_usuario}</td>
			     	  <td>${row.correo_usuario}</td>
			     	  <td>${row.desc_area}</td>
			     	  <td>${row.desc_cargo}</td>
			     	  <td>${row.usu_usuario}</td>  
	                  <td>${row.habilitado}</td> 
	                  <td><a href="accionUsuario?codUsuario=${row.cod_usuario}">[Modificar]</a></td>
	                  <td><a href="eliminarUsuario?codUsuario=${row.cod_usuario}">[Eliminar]</a></td>
	                </tr>
			     </c:forEach> 
		      </c:if> 
              </tbody>
</table>

