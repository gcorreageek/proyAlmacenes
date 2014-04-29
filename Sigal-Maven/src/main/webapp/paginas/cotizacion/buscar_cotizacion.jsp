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
              <c:if test="${requestScope.lstCotizacion!=null}"   > 
			     <c:forEach  items="${requestScope.lstCotizacion}"  var="row"  >
			     	<tr> 
	                  <td>${row.nom_usuario}</td>  
	                  <td>${row.fecharegistro_cotizacion}</td>  
	                  <td align="center"><button onclick="javascript:seleccionaCotizacion(${row.cod_cotizacion},'${row.nom_usuario}','${row.fecharegistro_cotizacion}','${row.cod_proveedor}','${row.raz_social}')" type="button" class="btn btn-link" data-dismiss="modal" aria-hidden="true">[Seleccionar]</button></td> 
	                </tr>
			     </c:forEach> 
		      </c:if>   
              </tbody>
            </table>
            
