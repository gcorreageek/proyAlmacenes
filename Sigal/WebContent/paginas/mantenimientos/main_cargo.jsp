<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<script type="text/javascript"> 
$(document).ready(function() { 
	var numeroPaginas = $("#numeroPaginas").val(); 
    var options = {
     currentPage: 1,
     totalPages: numeroPaginas,
     onPageClicked: function(e,originalEvent,type,page){ 
    	if($("#tagTipoListado").val()==1){
    		$.post("listarCargoPag",{inicio:page},function(data){
         		$("#divTablaPag").html(data);
     		}); 	
    	}else{
    		$.post("buscarCargoXDesc_cargoPag",{inicio:page},function(data){
         		$("#divTablaPag").html(data);
     		}); 	
    	}
     	
     } 
 	}

    $('#divPaginador').bootstrapPaginator(options); 
	setTimeout(function(){ $('.alert').hide(1000); }, 3000); 
}); 
</script>

<h3>Mantenimiento Cargo</h3>
<c:if test="${requestScope.rsult!=null}"   >
<c:if test="${requestScope.rsult=='0'}"   >
	<div class="alert alert-success"> 
	<h4>Bien!</h4>
	${requestScope.mensaje}
	</div> 
</c:if>
<c:if test="${requestScope.rsult=='1'}"   >
	<div class="alert alert-error"> 
	<h4>Error!</h4>
	${requestScope.mensaje}
	</div> 
</c:if>

</c:if>
	<form class="form-search"  action="buscarCargoXDesc_cargo" method="post">
	    <input type="text" name="objCargo.desc_cargo" class="input-medium search-query" placeholder="Cargo" >
	    <button type="submit" class="btn">Buscar</button>
    </form>


<div id="divTablaPag">
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Cargo</th>
				<th>Area</th>  
				<th>Modificar</th>
				<th>Eliminar</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${requestScope.lstCargo!=null}">
				<c:forEach items="${requestScope.lstCargo}" var="row">
					<tr>
						<td>${row.desc_cargo}</td> 
						<td>${row.desc_area}</td> 
						<td><a href="accionCargo?codCargo=${row.cod_cargo}">[Modificar]</a></td>
						<td><a href="eliminarCargo?codCargo=${row.cod_cargo}">[Eliminar]</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</div>
<s:hidden id="tagTipoListado" name="tagTipoListado" />
<s:hidden id="numeroPaginas" name="numeroPaginas" />
<div id="divPaginador"></div>

<a class="btn btn-primary" href="accionCargo">Nueva Cargo</a>

























