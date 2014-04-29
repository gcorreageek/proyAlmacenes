<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
			<table class="table table-striped table-bordered table-hover">
              <thead>
                <tr> 
                  <th>Cargo3</th>
                  <th>Area</th>   
                  <th>Seleccionar</th> 
                </tr>
              </thead>
              <tbody>
              <c:if test="${requestScope.lstCargo!=null}"   > 
			     <c:forEach  items="${requestScope.lstCargo}"  var="row"  >
			     	<tr> 
	                  <td>${row.desc_cargo}</td>
	                  <td>${row.desc_area}</td> 
	                  <td align="center"><button onclick="javascript:seleccionaCargo(${row.cod_cargo},"${row.desc_cargo}");" type="button" class="btn btn-link" data-dismiss="modal" aria-hidden="true">[Seleccionar]</button></td> 
	                </tr>
			     </c:forEach> 
		      </c:if>   
              </tbody>
            </table>
            
