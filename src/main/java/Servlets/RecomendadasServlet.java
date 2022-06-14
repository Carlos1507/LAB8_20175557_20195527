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
        value = {"/listaRecomendadas"}
)
public class RecomendadasServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RecomendadasDao recomendadasDao = new RecomendadasDao();
        String cambio = "no";
        String action = request.getParameter("action")==null? "listarRecomendadas":request.getParameter("action");
        //Arraylist<Cancion> listaRecomendada = RecomendadasDao.listarRecomendadas;
        System.out.println(action);

        switch (action){
            case "listarRecomendados":
                request.setAttribute("actualiza", cambio);
                request.setAttribute("listaRecomendadas", recomendadasDao.listarRecomendadas());
                RequestDispatcher view = request.getRequestDispatcher("listaRecomendadas.jsp");
                view.forward(request, response);
                break;
            case "ActualizaVistaRecomendados":
                cambio = "actualiza";
                request.setAttribute("actualiza", cambio);
                request.setAttribute("listaRecomendadas", recomendadasDao.listarRecomendadas());
                RequestDispatcher viewActualizadoRecomendadas = request.getRequestDispatcher("listaRecomendadas.jsp");
                viewActualizadoRecomendadas.forward(request, response);
                break;
        }


    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}