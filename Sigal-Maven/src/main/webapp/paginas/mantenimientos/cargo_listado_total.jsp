<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags"
 %>
<script type="text/javascript"> 
	var numeroPaginasModalCargo = $("#numeroPaginasModalCargo").val(); 
    var options = {
     currentPage: 1,
     totalPages: numeroPaginasModalCargo,
     onPageClicked: function(e,originalEvent,type,page){ 
    	$.post("listarCargoPagModal",{inicio:page},function(data){
 	 		$("#divTablaProveModal").html(data);
 		});
     } 
 	}

    $('#divPaginadorCargo').bootstrapPaginator(options); 
</script> 
<s:hidden id="numeroPaginasModalCargo" name="numeroPaginasModalCargo"      /> 
<div id="divPaginadorCargo"></div>   