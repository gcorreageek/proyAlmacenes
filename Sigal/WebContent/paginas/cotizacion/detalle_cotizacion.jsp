
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<%-- <%@ page import="java.util.ArrayList,com.cibertec.sigal.pedido.beans.DetallePedidoDTO" %>  --%>
<script>
$(document).ready(function() {
	setTimeout(function(){ $('.alert').hide(1000); }, 2000); 
});
</script>
<c:if test="${requestScope.rsult!=null}"   >
<c:if test="${requestScope.rsult==1}"   >
<input type="hidden" id="rsultado" val="1" >
	<div class="alert alert-success"> 
	<h4>Bien!</h4>
	${requestScope.mensaje}
	</div> 
</c:if>
<c:if test="${requestScope.rsult==0}"   >
<input type="hidden" id="rsultado" val="0" >
	<div class="alert alert-error"> 
	<h4>Error!</h4>
	${requestScope.mensaje}
	</div> 
</c:if> 
</c:if>
<table class="table table-striped table-bordered table-hover">
      <thead>
        <tr> 
          <th>Producto</th>  
          <th>U.Medida</th>
          <th>Cantidad</th> 
          <th>Eliminar</th>
        </tr>
      </thead>
      <tbody>
       				<s:iterator  value="#session.lstDetCoti">
						<tr>
							<td><s:property value="desc_producto" /></td>
							<td><s:property value="unidadMedida" /></td>
							<td><s:property value="cant_detallecotizacion" /></td> 
							<td><a  onclick="javascript:eliminarDetalleCotizacion(<s:property value="cod_producto" />);"  >[Eliminar]</a></td>
						</tr>
					</s:iterator>
      </tbody>
    </table>
 