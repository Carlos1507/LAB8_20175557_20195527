package Daos;

import Beans.Banda;
import Beans.Cancion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RecomendadasDao {
    private static String user = "root";
    private static String pass = "root";
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1";

    public ArrayList<Cancion> listarRecomendadas() {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<Cancion> listaRecomendadas = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("select cancion_idcancion, nombre_cancion, banda from reproduccion, cancion group by cancion_idcancion having count(*) >2 order by count(*) desc");) {

            while (rs.next()) {
                Cancion cancion = new Cancion();
                cancion.setIdcancion(rs.getInt(1));
                cancion.setNombre_cancion(rs.getString(2));
                cancion.setBanda((Banda) rs.getObject(3));
                listaRecomendadas.add(cancion);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaRecomendadas;
    }


}
