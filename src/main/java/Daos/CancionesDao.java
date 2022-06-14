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


    public ArrayList<Cancion> obtenerListaCanciones(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Cancion> listaCanciones = new ArrayList<>();

        String sql = "select c.idcancion, c.nombre_cancion, b.idbanda, b.nombre_banda, b.artista_lider from cancion c\n" +
                "inner join banda b on c.banda = b.idbanda";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            try(ResultSet rs = preparedStatement.executeQuery();){
                while (rs.next()) {
                    Banda banda = new Banda(rs.getString(3), rs.getString(4), rs.getInt(5));
                    Cancion cancion = new Cancion(rs.getInt(1), rs.getString(2), banda);
                    listaCanciones.add(cancion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCanciones;
    }
}
