<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib   prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="s"  uri="/struts-tags" %>
<!-- --------------------------------------------------------------- -->
<!-- --------------------------------------------------------------- -->
<!-- --------------------------------------------------------------- -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Leer QR</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/assets/bootstrap/img/sigal_logo.ico" />
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="<%=request.getContextPath()%>/assets/bootstrap/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style> 
 	<link href="<%=request.getContextPath()%>/assets/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">

  </head>

  <body>

    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">  
          <a class="brand" href="#"><strong style="color:white;">Sigal</strong></a>
        </div>
      </div>
    </div>

    <div class="container">
			<h3>Leer QR</h3>  
			<form class="form-horizontal" action="guardaSessionQR" method="post"  >
			<input type="hidden"  name="codProd" value="${objProducto.cod_producto}" id="codProd"     />
			<div class="control-group">
			<label class="control-label" for="inputNombre">Nombre</label>
			<div class="controls">
			<input type="text" id="inputNombre" name="objProducto.desc_producto" value="${objProducto.desc_producto}" placeholder="Nombre" disabled>
			</div>
			</div> 
			<div class="control-group">
			<label class="control-label" for="inputUMedida">U.Medida</label>
			<div class="controls"> 
			 <input type="text" id="inputNombre" name="objProducto.unidadMedida" value="${objProducto.unidadMedida}" placeholder="U.Medida" disabled>
			</div>
			</div>
			<div class="control-group">
			<label class="control-label" for="inputUMedida">Tipo:</label>
			<div class="controls">
			<s:select   id="tipo" name="tipo"
					list="#{'Salida':'Salida', 'Entrada':'Entrada'}"
					  />
			</div>
			</div>
			 
			<div class="control-group"> 
			<div class="controls">
			<button class="btn btn-primary" id="btnEntrar"  type="submit">Entrar</button> 
			</div>
			</div>
			
			</form>

      <hr> 
       <footer>
        <p>&copy;Copyright Proyecto SIGAL. Todos los derechos reservados.
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
        <a href="https://github.com/gcorreageek/" target="_blank"  >@gcorreageek&nbsp;&nbsp;<img src="<%=request.getContextPath()%>/assets/megamix/images/gcorreageek.jpg" class="img-polaroid"></a>    </p>
      </footer>

    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="<%=request.getContextPath()%>/assets/bootstrap/js/jquery.js"></script> 
    <script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootstrap.js"></script> 
  </body>
</html>




















