<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
			<table class="table table-striped table-bordered table-hover">
              <thead>
                <tr> 
                  <th>Responsable</th> 
                  <th>Fecha</th>  
                  <th>Seleccionar</th>
                </tr>
              </thead>
              <tbody>
              <c:if test="${requestScope.lstOrdenCompra!=null}"   > 
			     <c:forEach  items="${requestScope.lstOrdenCompra}"  var="row"  >
			     	<tr>  
	                  <td>${row.nom_usuario}</td>  
	                  <td>${row.fecharegistro_ordencompra}</td>  
	                  <td align="center"><button onclick="javascript:seleccionaOrdenCompra(${row.cod_OrdenCompra},'${row.nom_usuario}','${row.fecharegistro_ordencompra}','${row.raz_social}')" type="button" class="btn btn-link" data-dismiss="modal" aria-hidden="true">[Seleccionar]</button></td> 
	                </tr>
			     </c:forEach> 
		      </c:if>   
              </tbody>
            </table>
            
