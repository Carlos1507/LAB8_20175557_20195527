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
        String parametro = request.getParameter("action")== null? "listar":request.getParameter("action");
        RequestDispatcher view;
        System.out.println(parametro);
        CancionesDao cancionesDao = new CancionesDao();
        if (parametro.equals("listar")){
            ArrayList<Cancion> listaTotalCanciones = cancionesDao.obtenerListaCanciones();
            request.setAttribute("cambio", "listarTodo");
            request.setAttribute("listaCanciones", listaTotalCanciones);
            view = request.getRequestDispatcher("listaCanciones.jsp");
            view.forward(request, response);
        }else{
            ArrayList<Cancion> listaCancionesPorBanda = cancionesDao.obtenerListaCancionesBanda(parametro);
            request.setAttribute("cambio", parametro);
            request.setAttribute("listaCanciones", listaCancionesPorBanda);
            view = request.getRequestDispatcher("listaCanciones.jsp");
            view.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
