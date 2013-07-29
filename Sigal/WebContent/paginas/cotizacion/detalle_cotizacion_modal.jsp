
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %> 

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
      		  <c:if test="${requestScope.lstDetCoti!=null}"   > 
			     <c:forEach  items="${requestScope.lstDetCoti}"  var="row"  >
			     	<tr> 
	                  <td>${row.desc_producto}</td> 
	                  <td>${row.unidadMedida}</td> 
	                  <td>${row.cant_detallecotizacion}</td> 
	                  <td><a  onclick="javascript:eliminarDetalleCotizacion(${row.cod_producto})"  >[Eliminar]</a></td> 
	                </tr>
			     </c:forEach> 
		      </c:if>  
      </tbody>
    </table>
 