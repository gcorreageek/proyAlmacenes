<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<select    id="cod_submenu" >
			<c:if test="${requestScope.lstMenu!=null}"   >
			     <c:forEach  items="${requestScope.lstMenu}"  var="row"  >
			     	<option  value="${row.cod_menu}" >${row.nom_menu}</option> 
			     </c:forEach> 
		      </c:if> 
</select>