<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
			<table class="table table-striped table-bordered table-hover">
              <thead>
                <tr> 
                  <th>Area</th>  
                  <th>Seleccionar</th> 
                </tr>
              </thead>
              <tbody>
              <c:if test="${requestScope.lstArea!=null}"   > 
			     <c:forEach  items="${requestScope.lstArea}"  var="row"  >
			     	<tr> 
	                  <td>${row.desc_area}</td>  
	                  <td align="center"><button onclick="javascript:seleccionaArea(${row.cod_area},"${row.desc_area}");" type="button" class="btn btn-link" data-dismiss="modal" aria-hidden="true">[Seleccionar]</button></td> 
	                </tr>
			     </c:forEach> 
		      </c:if>   
              </tbody>
            </table>
            
