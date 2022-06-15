package Daos;

import Beans.Banda;
import Beans.Cancion;
import Beans.Tour;

import java.sql.*;
import java.util.ArrayList;

public class CancionesDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

    public static ArrayList<Cancion> obtenerListaCanciones(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Cancion> listaCanciones = new ArrayList<>();

        String sql = "select * from cancion";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            try(ResultSet rs = preparedStatement.executeQuery();){
                while (rs.next()) {
                    Cancion cancion = new Cancion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                    listaCanciones.add(cancion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCanciones;
    }
    public static ArrayList<Cancion> obtenerListaCancionesBanda(String idBanda){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Cancion> listaCanciones = new ArrayList<>();

        String sql = "select * from cancion where banda = ?";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            preparedStatement.setString(1,idBanda);
            try(ResultSet rs = preparedStatement.executeQuery();){
                while (rs.next()) {
                    Cancion cancion = new Cancion(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                    listaCanciones.add(cancion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCanciones;
    }
}
