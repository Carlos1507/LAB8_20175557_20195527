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

        String sql = "";
        try (Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);) {
            try(ResultSet rs = preparedStatement.executeQuery();){
                while (rs.next()) {
                    Cancion cancion = new Cancion();
              /*      Banda banda = new Banda(rs.getString());
                    cancion.setIdPer(rs.getInt(1));
                    bPersona.setNombre(rs.getString(2));
                    bPersona.setApellido(rs.getString(3));
                    bPersona.setNumCel(rs.getInt(4));
                    bPersona.setFecha_Nc(rs.getString(5));
                    bPersona.setEmail(rs.getString(6));
                    bPersona.setDireccion(rs.getString(7));
                    listaClientes.add(bPersona);*/
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCanciones;
    }




}
