<%--
  Created by IntelliJ IDEA.
  User: caleb
  Date: 13/06/2022
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="listaRecomendadas"/>
<html>
<jsp:include page="/static/head.jsp">
    <jsp:param name="title" value="Lista de recomendadas"/>
</jsp:include>
<jsp:useBean id="actualiza" scope="request" type="java.lang.String"/>

<body>
<div class='container'>
    <jsp:include page="/includes/navbar.jsp">
        <jsp:param name="page" value="recomendadas"/>
    </jsp:include>
    <div class="pb-5 pt-4 px-3 titlecolor">
        <div class="col-lg-6">
            <% if (actualiza.equals("actualiza")) {%>
            <h1 class='text-light'>Lista de Canciones Recomendadas</h1>
            <%}else{%>
        </div>
    </div>
    <div class="tabla">
        <table class="table table-dark table-transparent table-hover">
            <thead>
            <th>ID</th>
            <th>CANCION</th>
            <th>BANDA</th>
            <th>Ver</th>
            </thead>
            <%
                for (Cancion recomendadas : listaRecomendadas) {
            %>
            <tr>
                <td><%=recomendadas.getIdcancion()%>
                </td>
                <td><%=recomendadas.getNombre_cancion()%>
                </td>
                <td><%=recomendadas.getBanda()%>
                </td>
                <td><a class="btn btn-success" href="<%=request.getContextPath()%>/listaCanciones" type=button>Más de la banda</a>
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
