package Daos;

import Beans.Banda;
import Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;

public class RecomendadasDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

    public static ArrayList<Cancion> obtenerListaRecomendadas() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Cancion> listaRecomendadas = new ArrayList<>();
        String sql = "SELECT c.idcancion, c.nombre_cancion, c.banda\n" +
                "from cancion c\n" +
                "INNER JOIN reproduccion r ON r.cancion_idcancion = c.idcancion\n" +
                "group by cancion_idcancion having count(*) >2 order by count(*) desc";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);){
             try (ResultSet rs = preparedStatement.executeQuery();){
                  while(rs.next()) {
                      Cancion cancion = new Cancion(rs.getInt(1), rs.getString(2), rs.getString(3));
                      listaRecomendadas.add(cancion);
                  }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaRecomendadas;
    }
}
