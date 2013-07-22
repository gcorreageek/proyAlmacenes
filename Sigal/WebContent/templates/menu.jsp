<%@ page language="java" contentType="text/html" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html"  import="com.sigal.seguridad.bean.OpcionesDTO"%>
<%@ page language="java" contentType="text/html"  import="com.sigal.seguridad.bean.DetalleUsuarioDTO"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
  <body>

   <%! List<OpcionesDTO>  lista=null; %>
   <%! DetalleUsuarioDTO  detalleUsuario=null; %>


    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container"> 
          <a class="brand" href="#"><strong style="color:white;">Sigal</strong></a>
          <div class="nav-collapse collapse">
            <ul class="nav">
<!--             <li class="active"><a href="#">Home</a></li> -->
               <% 
               detalleUsuario = (DetalleUsuarioDTO)session.getAttribute("objUsuario");
			   lista=(List<OpcionesDTO>)session.getAttribute("listaMenuOpciones");
			  if(lista!=null){ 
			   		for(int i=0;i<lista.size();i++){
			   			if(lista.get(i).getTipo_opcion()==1 && lista.get(i).getMaster_opcion()==0){ %>
			   				<li><a href="<%=lista.get(i).getUrl_opcion() %>"><%=lista.get(i).getNom_opcion() %></a></li>
			   			<% }else if(lista.get(i).getMaster_opcion()==1){ 
			   				if( lista.get(i).getTipo_opcion()==1 ){ %>
			   				<li class="dropdown">
				                <a href="<%=lista.get(i).getUrl_opcion() %>" class="dropdown-toggle" data-toggle="dropdown"><%=lista.get(i).getNom_opcion() %> <b class="caret"></b></a>
				                <ul class="dropdown-menu">
			   				
			   					
			   				<% }else{ %>
			   					<li><a href="<%=request.getContextPath()%>/<%=lista.get(i).getUrl_opcion() %>"><%=lista.get(i).getNom_opcion() %></a></li>
			   					
			   					
			   				<%}
			   				
			   				if(lista.size()==i+1){%>
			   						   </ul>
			              	</li>	
			   					
			   				<% }else{
			   					if(lista.get(i+1).getTipo_opcion()==1){ %>
			   					   </ul>
			              	</li>	
			   						
			   					<%}
			   					
			   					
			   				}
			   				
			   				
			   				%> 
			   				
			   				
			   				<%
			   				
			   			}
			   		%>
			   			
			   			
			   		<%} 
			  }%>
            
               
              
              
              
              
              
            </ul>
             
            <p class="navbar-text pull-right">
              Bienvenido <a href="#" class="navbar-link"><strong style="color:white;"><%= detalleUsuario.getNom_usuario() %></strong></a>
            </p> 



          </div><!--/.nav-collapse -->
        </div>
      </div>
    </div>

    <div class="container">
 