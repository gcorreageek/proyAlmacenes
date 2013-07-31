<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<script type="text/javascript"> 
$(document).ready(function() {
	$("#cod_cargo").change(function () { 
		  $("select#cod_cargo option:selected").each(function () {  
// 			  alert('codcargo:'+$(this).val());
			  $.post("listaTablaMenu",{"objAcceso.cod_cargo":$(this).val()},function(data){
			 	$("#divTablaPag").html(data);
			  }); 
	  }); 
		}).trigger('change');	
});
</script>



<select name="objUsuario.cod_cargo"  id="cod_cargo" >
			<c:if test="${requestScope.lstCargo!=null}"   >
			     <c:forEach  items="${requestScope.lstCargo}"  var="row"  >
			     	<option  value="${row.cod_cargo}" 
			     	<c:if test="${requestScope.objUsuario.cod_cargo==row.cod_cargo}"   >
			     		selected="selected"
			     	 </c:if>  
			     	>${row.desc_cargo}</option> 
			     </c:forEach> 
		      </c:if> 
</select>