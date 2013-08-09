<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<script type="text/javascript"> 
	var numeroPaginasModalOrdenCompra = $("#numeroPaginasModalOrdenCompra").val(); 
	var options = {
	 currentPage: 1,
	 totalPages: numeroPaginasModalOrdenCompra,
	 onPageClicked: function(e,originalEvent,type,page){ 
		    var txtNombreRespo=$("#txtNombreResponsable").val(); 
			var txtFechaInicio=$("#txtFechaInicio").val();
			var txtFechaFin=$("#txtFechaFin").val(); 
				
			$.post("buscarOrdenCompraPagModalEntregada",{   
				inicio:page,
				"objOrdenCompra.nom_usuario":txtNombreRespo, 
				"objOrdenCompra.fechaInicio":txtFechaInicio,
				"objOrdenCompra.fechaFin":txtFechaFin
				},function(data){
		 		$("#divTablaOrdenCompraModal").html(data);
			}); 
	 	} 
	 }
	
	$('#divPaginadorOrdenCompra').bootstrapPaginator(options);  
</script>  
<s:hidden id="numeroPaginasModalOrdenCompra" name="numeroPaginasModalOrdenCompra"      /> 
<div id="divPaginadorOrdenCompra"></div>   