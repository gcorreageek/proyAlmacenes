<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-jquery-tags"  prefix="sj"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Sigal</title>
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/assets/bootstrap/img/sigal_logo.ico" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Le styles -->
    <link href="<%=request.getContextPath()%>/assets/bootstrap/css/bootstrap.css" rel="stylesheet">
    <style type="text/css">
      body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }

      .form-signin {
        max-width: 500px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
/*       .form-signin .form-signin-heading, */
/*       .form-signin .checkbox { */
/*         margin-bottom: 10px; */
/*       } */
/*       .form-signin input[type="text"], */
/*       .form-signin input[type="password"] { */
/*         font-size: 16px; */
/*         height: auto; */
/*         margin-bottom: 15px; */
/*         padding: 7px 9px; */
/*       } */

    </style>
    <link href="<%=request.getContextPath()%>/assets/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]--> 
  </head>

  <body> 
    <div class="container">

      <form class="form-signin"  action="passOlvidado"  method="post"  >
        <h2 class="form-signin-heading">Olvidates tu Contraseña</h2>
        <div class="control-group">
		<label class="control-label" for="inputNombre">Correo*</label>
		<div class="controls">
		<input type="email" id="correo_usuario" class="span5" value="${objUsuario.correo_usuario}" name="objUsuario.correo_usuario" placeholder="Correo"  required>
		</div>
		</div> 
        <button class="btn btn-large btn-primary" type="submit">Enviar</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a class="btn btn-large btn-primary"  type="submit" href="javascript:history.go(-1)">Cancelar</a>
      </form>

    </div> <!-- /container -->

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<!--     <script src="js/bootstrap.js"></script>  -->

  </body>
</html>