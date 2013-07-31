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
        padding-top: 60px;
        padding-bottom: 40px;
      }
    </style>
    <link href="<%=request.getContextPath()%>/assets/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<%-- 	<link href="<%=request.getContextPath()%>/assets/bootstrap/css/bootstrap-datetimepicker.min.css" rel="stylesheet"> --%>
<%-- 	<link href="<%=request.getContextPath()%>/assets/bootstrap/css/jquery.ui.all.css" rel="stylesheet"> --%>
	<link href="<%=request.getContextPath()%>/assets/bootstrap/css/datepicker.css" rel="stylesheet"> 
<!-- 	<link rel="stylesheet" href="../../themes/base/jquery.ui.all.css"> -->
	
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->
    <script src="<%=request.getContextPath()%>/assets/bootstrap/js/jquery.js"></script> 
    <script src="<%=request.getContextPath()%>/assets/bootstrap/js/bootstrap.js"></script> 

<%-- 	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/bootstrap/js/bootstrap-datepicker-entrefechas.js"></script> --%>
	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/bootstrap/js/bootstrap-datepicker.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/assets/bootstrap/js/bootstrap-datepicker.es.js" charset="UTF-8"></script>
 	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/bootstrap/js/bootstrap-paginator.min.js"></script>
<%--  	<script type="text/javascript" src="<%=request.getContextPath()%>/assets/bootstrap/js/jquery.PrintArea.js" ></script> --%>
 	
 	<script type="text/javascript"  >

		$(document).ready(function() {   
		    $('.datepicker').datepicker({
		    	format: 'dd/mm/yyyy',
		        language: 'es' 
			});
// 		    idFechaEntrega idFechaDevolucion
	        // disabling dates
		    
		 
		});  
	</script>

  </head>