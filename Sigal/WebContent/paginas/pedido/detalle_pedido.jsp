
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<%-- <%@ page import="java.util.ArrayList,com.cibertec.sigal.pedido.beans.DetallePedidoDTO" %>  --%>

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
       				<s:iterator  value="#session.lstDetPed">
						<tr>
							<td><s:property value="desc_producto" /></td>
							<td><s:property value="unidadMedida" /></td>
							<td><s:property value="cantidad" /></td> 
							<td><a  onclick="javascript:eliminarDetallePedido(<s:property value="cod_producto" />);"  >[Eliminar]</a></td>
						</tr>
					</s:iterator>
      </tbody>
    </table>
 