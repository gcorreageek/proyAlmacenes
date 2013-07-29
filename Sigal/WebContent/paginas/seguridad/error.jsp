<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='http://fonts.googleapis.com/css?family=Pathway+Gothic+One' rel='stylesheet' type='text/css'>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error 404</title>
<script language="JavaScript" type="text/javascript">

var pagina="<%=request.getContextPath()%>"+"/inicio"; 
function redireccionar() 
{
location.href=pagina;
} 
setTimeout ("redireccionar()", 2000);

</script>
</head>
<body  >
<div align="center">
<br><br>
<img align="top" alt="404" src="<%=request.getContextPath()%>/assets/megamix/images/error404.png">
<h2  style="font-family: 'Pathway Gothic One', sans-serif;font-size:70px;">Errar es humano! Perdonar es divino!</h2>
</div>


</body>
</html>