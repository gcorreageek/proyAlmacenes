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
                  <th>Stock</th>
                  <th>Habilitado</th>  
                </tr>
              </thead>
              <tbody>
              <c:if test="${requestScope.lstProducto!=null}"   > 
			     <c:forEach  items="${requestScope.lstProducto}"  var="row"  >
			     	<tr> 
	                  <td>${row.desc_producto}</td> 
	                  <td>${row.unidadMedida}</td> 
	                  <td>${row.stock_producto}</td>
	                  <td>${row.habilitado}</td>  
	                </tr>
			     </c:forEach> 
		      </c:if>   
              </tbody>
            </table>
            
