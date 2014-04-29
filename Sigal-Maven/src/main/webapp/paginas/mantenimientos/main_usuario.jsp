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
    		$.post("listarUsuarioPag",{inicio:page},function(data){
         		$("#divTablaPag").html(data);
     		}); 	
    	}else{
    		$.post("buscarUsuarioXDesc_usuarioPag",{inicio:page},function(data){
         		$("#divTablaPag").html(data);
     		}); 	
    	}
     	
     } 
 	}

    $('#divPaginador').bootstrapPaginator(options); 
	setTimeout(function(){ $('.alert').hide(1000); }, 3000); 
}); 
</script>

<h3>Mantenimiento Usuario</h3>
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
	<form class="form-search"  action="buscarUsuarioXDesc_usuario" method="post">
	    <input type="text" name="objUsuario.nom_usuario" class="input-medium search-query" placeholder="Usuario" >
	    <button type="submit" class="btn">Buscar</button>
    </form>


<div id="divTablaPag">
	<table class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th>Nombre</th>
                <th>Correo</th>
                <th>Area</th>   
                <th>Cargo</th> 
                <th>Usuario</th> 
                <th>Habilitaci&oacute;n</th>  
				<th>Modificar</th>
				<th>Eliminar</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${requestScope.lstUsuario!=null}">
				<c:forEach items="${requestScope.lstUsuario}" var="row">
					<tr>
						<td>${row.nom_usuario}</td>
			     	    <td>${row.correo_usuario}</td>
			     	    <td>${row.desc_area}</td>
			     	    <td>${row.desc_cargo}</td>
			     	    <td>${row.usu_usuario}</td>  
	                    <td>${row.habilitado}</td>
						<td><a href="accionUsuario?codUsuario=${row.cod_usuario}">[Modificar]</a></td>
						<td><a href="eliminarUsuario?codUsuario=${row.cod_usuario}">[Eliminar]</a></td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
</div>
<s:hidden id="tagTipoListado" name="tagTipoListado" />
<s:hidden id="numeroPaginas" name="numeroPaginas" />
<div id="divPaginador"></div>

<a class="btn btn-primary" href="accionUsuario">Nueva Usuario</a>

























