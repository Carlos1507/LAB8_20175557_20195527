package Daos;
import Beans.Cancion;
import java.sql.*;
import java.util.ArrayList;
public class FavoritosDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
    public static ArrayList<Cancion> obtenerListaFavoritos(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Cancion> listaFavoritos = new ArrayList<>();

        String sql = "update listas set listas_idLista = 1 where idCancion = ?";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            try(ResultSet rs = preparedStatement.executeQuery();){
                while (rs.next()) {
                    Cancion cancion = new Cancion(rs.getInt(1), rs.getString(2), rs.getString(3));
                    listaFavoritos.add(cancion);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaFavoritos;
    }

}
