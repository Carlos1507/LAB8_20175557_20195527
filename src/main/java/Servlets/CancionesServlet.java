package Servlets;

import Beans.Cancion;
import Daos.CancionesDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CancionesServlet", value = "/listaCanciones")
public class CancionesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cambio = "no";
        String action = request.getParameter("action")== null? "listar":request.getParameter("action");
        ArrayList<Cancion> listaCanciones = CancionesDao.obtenerListaCanciones();
        System.out.println(action);
        switch (action){
            case "listar":
                request.setAttribute("listaCanciones", listaCanciones);
                request.setAttribute("actualiza", cambio);
                RequestDispatcher viewPrincipal =request.getRequestDispatcher("listaCanciones.jsp");
                viewPrincipal.forward(request,response);
                break;
            case "actualizaVista":
                cambio = "actualiza";
                request.setAttribute("listaCanciones", listaCanciones);
                request.setAttribute("actualiza", cambio);
                RequestDispatcher viewActualizado = request.getRequestDispatcher("listaCanciones.jsp");
                viewActualizado.forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
