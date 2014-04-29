<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<script type="text/javascript"> 
	var numeroPaginasModalProducto = $("#numeroPaginasModalProducto").val(); 
    var options = {
     currentPage: 1,
     totalPages: numeroPaginasModalProducto,
     onPageClicked: function(e,originalEvent,type,page){ 
    	var idProvee = $('#cod_proveedor').val(); 
    	$.post("listarProductoPagModalidProve",{idProve:idProvee,inicio:page},function(data){
 	 		$("#divTablaProdModal").html(data);
 		});
     } 
 	}

    $('#divPaginadorProducto').bootstrapPaginator(options); 
</script> 
<s:hidden id="numeroPaginasModalProducto" name="numeroPaginasModalProducto"      /> 
<div id="divPaginadorProducto"></div>   