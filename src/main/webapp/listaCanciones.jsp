<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="listaCanciones"/>
<jsp:useBean id="actualiza" scope="request" type="java.lang.String"/>

<html>
<jsp:include page="/static/head.jsp">
  <jsp:param name="title" value="Lista de Canciones"/>
</jsp:include>
<body>
<div class='container'>
  <jsp:include page="/includes/navbar.jsp">
    <jsp:param name="page" value="canciones"/>
  </jsp:include>
  <div class="pb-5 pt-4 px-3 titlecolor">
    <div class="col-lg-6">
      <% if (actualiza.equals("actualiza")) {%>
      <h1 class='text-light'>Lista de Canciones</h1>
      <%}else{%>
      <h1 class='text-light'>Lista de Canciones por<BR>banda</h1>
      <a class="btn btn-warning" href="<%=request.getContextPath()%>/listaCanciones?action=actualizaVista">Mostrar todas las canciones</a>
      <%}%>
    </div>
  </div>
  <div class="tabla">
    <table class="table table-dark table-transparent table-hover">
      <thead>
      <th>ID</th>
      <th>TOUR</th>
      <th>BANDA</th>
      </thead>
      <%
        for (Cancion cancion : listaCanciones) {
      %>
      <tr>
        <td><%=cancion.getIdcancion()%>
        </td>
        <td><%=cancion.getNombre_cancion()%>
        </td>
        <td><%=cancion.getBanda().getNombre_banda()%>
        </td>
      </tr>
      <%
        }
      %>
    </table>
  </div>

</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
