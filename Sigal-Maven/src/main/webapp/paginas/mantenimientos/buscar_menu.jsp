<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Cargo</th>
				<th>Tipo</th> 
				<th>Menu</th>
				<th>Habilitaci&oacute;n</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${requestScope.lstMenuTabla!=null}">
				<c:forEach items="${requestScope.lstMenuTabla}" var="row">
					<tr>
						<td>${row.desc_cargo}</td> 
						<td>
						<c:if test="${row.tipo_menu==1}">
						Menu
						</c:if>
						<c:if test="${row.tipo_menu==2}">
						SubMenu
						</c:if> 
						</td>  
						<td>${row.nom_menu}</td>  
						<td>
						<a href="javascript:desabilitarMenu(${row.cod_accesomenu})"> 
						[${row.habilitado}]
						</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
            
