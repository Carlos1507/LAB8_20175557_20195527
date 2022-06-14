package Servlets;

import Beans.Cancion;
import Daos.RecomendadasDao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "RecomendadasServlet",
        urlPatterns = {"/listaRecomendadas"}
)
public class RecomendadasServlet extends HttpServlet {
    public RecomendadasServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RecomendadasDao recomendadasDao = new RecomendadasDao();
        ArrayList<Cancion> listaRecomendadas = recomendadasDao.obtenerListaRecomendadas();
        request.setAttribute("listaRecomendadas", listaRecomendadas);
        RequestDispatcher view = request.getRequestDispatcher("listaRecomendadas.jsp");
        view.forward(request, response);
    }
}