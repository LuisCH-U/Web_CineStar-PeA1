<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="bean.Cine"%>
<%@page import="java.util.List"%>
S
<br/><h1>Nuestros Cines</h1><br/>

<% List<Cine> lstCine = ( List<Cine> )session.getAttribute( "lstCine" );
    for( Cine Cine : lstCine ){ %>
    
<div class="contenido-cine">
    <img src="img/cine/<%= Cine.getIdCine() %>.1.jpg" width="227" height="170"/>
    <div class="datos-cine">
        <h4><%= Cine.getRazonSocial() %></h4><br/>
        <span><%= Cine.getDireccion()%> - <%= Cine.getDetalle() %><br/><br/>Teléfono: <%= Cine.getTelefonos() %></span>
    </div>
    <br/>
    <a href="svlCine?idCine=<%= Cine.getIdCine() %>">
        <img src="img/varios/ico-info2.png" width="150" height="40"/>
    </a>
</div>
<% } %>
</html>