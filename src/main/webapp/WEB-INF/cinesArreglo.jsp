<%@ page pageEncoding="ISO-8859-1"%>

<br/><h1>Nuestros Cines</h1><br/>

<% String[][] mCines = (String[][])session.getAttribute( "data" );
    for( String[] aCine : mCines ){ %>
    
<div class="contenido-cine">
    <img src="img/cine/<%= aCine[0] %>.1.jpg" width="227" height="170"/>
    <div class="datos-cine">
        <h4><%= aCine[1] %></h4><br/>
        <span><%= aCine[4] %> - <%= aCine[7] %><br/><br/>Tel�fono: <%= aCine[5] %></span>
    </div>
    <br/>
    <a href="svlCine?idCine=<%= aCine[0] %>">
        <img src="img/varios/ico-info2.png" width="150" height="40"/>
    </a>
</div>
<% } %>
</html>