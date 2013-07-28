<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
			<table class="table table-striped table-bordered table-hover">
              <thead>
                <tr> 
                  <th>Responsable</th>
                  <th>Area</th>
                  <th>Fecha</th> 
                  <th>T.Pedido</th>
                  <th>Seleccionar</th>
                </tr>
              </thead>
              <tbody>
              <c:if test="${requestScope.lstPedido!=null}"   > 
			     <c:forEach  items="${requestScope.lstPedido}"  var="row"  >
			     	<tr> 
	                  <td>${row.nom_usuario}</td> 
	                  <td>${row.desc_area}</td> 
	                  <td>${row.fechaRegistro_pedido}</td> 
	                  <td>${row.tipo_pedido}</td> 
	                  <td align="center"><button onclick="javascript:seleccionaPedido(${row.cod_solicitudPedido},'${row.nom_usuario}','${row.desc_area}','${row.desc_cargo}','${row.fechaRegistro_pedido}','${row.fechaDevolucion_pedido}','${row.fechaEntrega_pedido}','${row.tipo_pedido}','${row.comentario_pedido}')" type="button" class="btn btn-link" data-dismiss="modal" aria-hidden="true">[Seleccionar]</button></td> 
	                </tr>
			     </c:forEach> 
		      </c:if>   
              </tbody>
            </table>
            
