<%@ page language="java" contentType="text/html" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page language="java" contentType="text/html"  import="com.sigal.mantenimiento.bean.ProductoDTO"%>

<h3>Informe Interno</h3>
<c:if test="${requestScope.rsult!=null}"   >
<c:if test="${requestScope.rsult==0}"   > 
	${requestScope.mensaje} 
</c:if>
<c:if test="${requestScope.rsult==1}"   > 
	${requestScope.mensaje} 
</c:if> 
	${requestScope.mensaje} 
 

</c:if>
<form  action="informeInterno"  method="post" >
<s:hidden  name="objProducto.cod_producto"      />
<input type="text" id="inputNombre" name="objProducto.desc_producto" value="${objProducto.desc_producto}" placeholder="Nombre">
<s:select   
		headerKey="Selecciona" headerValue="Selecciona"
		list="#{'Unidad':'Unidad', 'Caja':'Caja', 'Docena':'Docena',  'Millar':'Millar'}"
		name="objProducto.unidadMedida"  value="objProducto.unidadMedida" />
<s:select   
headerKey="Selecciona" headerValue="Selecciona"
list="#{'Salida':'Salida', 'Entrada':'Entrada'}"
name="tipo"    />
		
<input type="text" id="inputCodigoII" name="codigoII"   placeholder="CodigoII">
		
		
		
<input type="submit"    />
</form>


