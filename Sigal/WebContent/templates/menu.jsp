<%@ page language="java" contentType="text/html" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html"  import="com.sigal.seguridad.bean.MenuDTO"%>
<%@ page language="java" contentType="text/html"  import="com.sigal.seguridad.bean.UsuarioDTO"%>
<%@ taglib   prefix="c"  uri="http://java.sun.com/jsp/jstl/core"  %>
  <body>

   <%! List<MenuDTO>  lista=null; %>
   <%! UsuarioDTO  detalleUsuario=null; %>


    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container"> 
          <a class="brand" href="#"><strong style="color:white;">Sigal</strong></a>
          <div class="nav-collapse collapse">
            <ul class="nav">
<!--             <li class="active"><a href="#">Home</a></li> -->
               <% 
               detalleUsuario = (UsuarioDTO)session.getAttribute("objUsuario");
			   lista=(List<MenuDTO>)session.getAttribute("listaMenu");
			  if(lista!=null){ 
			   		for(int i=0;i<lista.size();i++){
			   			if(lista.get(i).getTipo_menu()==1 && lista.get(i).getMaster_menu()==0){ %>
			   				<li><a href="<%=lista.get(i).getUrl_menu() %>"><%=lista.get(i).getNom_menu()%></a></li>
			   			<% }else if(lista.get(i).getMaster_menu()==1){ 
			   				if( lista.get(i).getTipo_menu()==1 ){ %>
			   				<li class="dropdown">
				                <a href="<%=lista.get(i).getUrl_menu() %>" class="dropdown-toggle" data-toggle="dropdown"><%=lista.get(i).getNom_menu() %> <b class="caret"></b></a>
				                <ul class="dropdown-menu">
			   				
			   					
			   				<% }else{ %>
			   					<li><a href="<%=request.getContextPath()%>/<%=lista.get(i).getUrl_menu() %>"><%=lista.get(i).getNom_menu() %></a></li>
			   					
			   					
			   				<%}
			   				
			   				if(lista.size()==i+1){%>
			   						   </ul>
			              	</li>	
			   					
			   				<% }else{
			   					if(lista.get(i+1).getTipo_menu()==1){ %>
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
 