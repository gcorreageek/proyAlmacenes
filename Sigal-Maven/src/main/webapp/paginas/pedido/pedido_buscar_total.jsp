<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<script type="text/javascript"> 
	var numeroPaginasModalPedido = $("#numeroPaginasModalPedido").val(); 
	var options = {
	 currentPage: 1,
	 totalPages: numeroPaginasModalPedido,
	 onPageClicked: function(e,originalEvent,type,page){ 
		    var txtNombreRespo=$("#txtNombreResponsable").val();
			var cboArea=$("#cboArea").val();
			var txtFechaInicio=$("#txtFechaInicio").val();
			var txtFechaFin=$("#txtFechaFin").val();
			var cboTipo=$("#cboTipo").val();
				
			$.post("buscarPedidoPagModal",{   
				inicio:page,
				"objPedido.nom_usuario":txtNombreRespo,
				"objPedido.cod_area":cboArea,
				"objPedido.fechaInicio":txtFechaInicio,
				"objPedido.fechaFin":txtFechaFin,
				"objPedido.tipo_pedido":cboTipo 
				},function(data){
		 		$("#divTablaPedidoModal").html(data);
			}); 
	 	} 
	 }
	
	$('#divPaginadorPedido').bootstrapPaginator(options);  
</script>  
<s:hidden id="numeroPaginasModalPedido" name="numeroPaginasModalPedido"      /> 
<div id="divPaginadorPedido"></div>   