package Servlets;

import Beans.Cancion;
import Daos.CancionesDao;
import Daos.FavoritosDao;

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
        CancionesDao cancionesDao = new CancionesDao();
        FavoritosDao favoritosDao = new FavoritosDao();
        String favorito = request.getParameter("favorito") == null ? "0" : request.getParameter("favorito");
        String nofavorito = request.getParameter("nofavorito")==null? "0" :request.getParameter("nofavorito");
        System.out.println(parametro);
        System.out.println(nofavorito);
        System.out.println(favorito);

        if(favorito.equals("0") && nofavorito.equals("0")){
            if (parametro.equals("listar")){
                ArrayList<Cancion> listaTotalCanciones = cancionesDao.obtenerListaCanciones();
                request.setAttribute("cambio", "listarTodo");
                request.setAttribute("listaCanciones", listaTotalCanciones);
                view = request.getRequestDispatcher("listaCanciones.jsp");
                view.forward(request, response);
            } else if (parametro.equals("listarTodosFav")){
                request.setAttribute("listaFav", favoritosDao.listaFavoritos());
                view = request.getRequestDispatcher("listaCancionesFavoritas.jsp");
                view.forward(request, response);
            }
            else{
                ArrayList<Cancion> listaCancionesPorBanda = cancionesDao.obtenerListaCancionesBanda(parametro);
                request.setAttribute("cambio", parametro);
                request.setAttribute("listaCanciones", listaCancionesPorBanda);
                view = request.getRequestDispatcher("listaCanciones.jsp");
                view.forward(request, response);
            }
            convertirFavorito(favorito);
        }else{
            if (favorito.equals("0")){
                convertirNoFavorito(nofavorito);
            }else{
                convertirFavorito(favorito);
            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void convertirFavorito(String favorito){
        int id = Integer.parseInt(favorito);
        if (id!=0){
            FavoritosDao favoritosDao = new FavoritosDao();
            favoritosDao.addFavoritos(id);
        }
    }
    public void convertirNoFavorito(String nofavorito){
        int id = Integer.parseInt(nofavorito);
        if (id!=0){
            FavoritosDao favoritosDao = new FavoritosDao();
            favoritosDao.quitarFavoritos(id);
        }
    }

}
