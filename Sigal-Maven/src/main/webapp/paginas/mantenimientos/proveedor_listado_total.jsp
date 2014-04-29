<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags"
 %>
<script type="text/javascript"> 
	var numeroPaginasModalProveedor = $("#numeroPaginasModalProveedor").val(); 
    var options = {
     currentPage: 1,
     totalPages: numeroPaginasModalProveedor,
     onPageClicked: function(e,originalEvent,type,page){ 
    	$.post("listarProveedorPagModal",{inicio:page},function(data){
 	 		$("#divTablaProveModal").html(data);
 		});
     } 
 	}

    $('#divPaginadorProveedor').bootstrapPaginator(options); 
</script> 
<s:hidden id="numeroPaginasModalProveedor" name="numeroPaginasModalProveedor"      /> 
<div id="divPaginadorProveedor"></div>   