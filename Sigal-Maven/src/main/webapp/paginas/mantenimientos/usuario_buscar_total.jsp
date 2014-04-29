<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<script type="text/javascript"> 
	var numeroPaginasModalUsuario = $("#numeroPaginasModalUsuario").val(); 
	var options = {
	 currentPage: 1,
	 totalPages: numeroPaginasModalUsuario,
	 onPageClicked: function(e,originalEvent,type,page){ 
		    var txtProvee=$("#txtUsuario").val();
			$.post("buscarUsuarioXDesc_usuarioPagModal",{inicio:page,"objUsuario.desc_usuario":txtProvee},function(data){
		 		$("#divTablaProdModal").html(data);
			}); 
	 	} 
	 }
	
	$('#divPaginadorUsuario').bootstrapPaginator(options);  
</script> 
<s:hidden id="numeroPaginasModalUsuario" name="numeroPaginasModalUsuario"      /> 
<div id="divPaginadorUsuario"></div>   