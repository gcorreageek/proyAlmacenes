<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<script type="text/javascript"> 
	var numeroPaginasModalCotizacion = $("#numeroPaginasModalCotizacion").val(); 
    var options = {
     currentPage: 1,
     totalPages: numeroPaginasModalCotizacion,
     onPageClicked: function(e,originalEvent,type,page){ 
    	$.post("listarCotizacionPagModal",{inicio:page},function(data){
 	 		$("#divTablaCotizacionModal").html(data);
 		});
     } 
 	}

    $('#divPaginadorCotizacion').bootstrapPaginator(options); 
</script> 
<s:hidden id="numeroPaginasModalCotizacion" name="numeroPaginasModalCotizacion"      /> 
<div id="divPaginadorCotizacion"></div>   