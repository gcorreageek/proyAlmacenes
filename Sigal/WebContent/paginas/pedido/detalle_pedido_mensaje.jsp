<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<script>
$(document).ready(function() {
// 	setTimeout(function(){ $('.alert').hide(1000); }, 2000); 
});
</script>
<c:if test="${requestScope.rsult!=null}"   >
<c:if test="${requestScope.rsult==1}"   >
<input type="hidden" id="rsultado" val="1" >
	<div class="alert alert-success"> 
	<h4>Bien!</h4>
	${requestScope.mensaje}
	</div> 
</c:if>
<c:if test="${requestScope.rsult==0}"   >
<input type="hidden" id="rsultado" val="0" >
	<div class="alert alert-error"> 
	<h4>Error!</h4>
	${requestScope.mensaje}
	</div> 
</c:if> 
</c:if>