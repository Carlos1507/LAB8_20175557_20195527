package Daos;
import Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;

public class FavoritosDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
    public void addFavoritos(int id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "update cancion set Listas_idListas = 1 where idCancion = ?";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void quitarFavoritos(int id){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String sql = "update cancion set Listas_idListas = ? where idCancion = ?";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setInt(1, 2);
            preparedStatement.setInt(2,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Cancion> listaFavoritos(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Cancion> listaCancionesFav = new ArrayList<>();
        String sql = "select * from cancion where Listas_idListas = 1";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            try(ResultSet rs = preparedStatement.executeQuery();){
                while (rs.next()) {
                    Cancion cancion = new Cancion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                    listaCancionesFav.add(cancion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCancionesFav;
    }
}
