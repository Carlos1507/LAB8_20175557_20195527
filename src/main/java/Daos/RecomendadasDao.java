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
    private static String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";

    public RecomendadasDao() {
    }

    public ArrayList<Cancion> obtenerListaRecomendadas() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException var59) {
            var59.printStackTrace();
        }

        ArrayList<Cancion> listaRecomendadas = new ArrayList();

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            Throwable var3 = null;

            try {
                Statement stmt = conn.createStatement();
                Throwable var5 = null;

                try {
                    ResultSet rs = stmt.executeQuery("select cancion_idcancion, nombre_cancion, banda from reproduccion, cancion group by cancion_idcancion having count(*) >2 order by count(*) desc");
                    Throwable var7 = null;

                    try {
                        while(rs.next()) {
                            int idcancion = rs.getInt(1);
                            String nombre_cancion = rs.getString(2);
                            Banda banda = (Banda) rs.getObject(3);
                            listaRecomendadas.add(new Cancion(idcancion, nombre_cancion, banda));
                        }
                    } catch (Throwable var60) {
                        var7 = var60;
                        throw var60;
                    } finally {
                        if (rs != null) {
                            if (var7 != null) {
                                try {
                                    rs.close();
                                } catch (Throwable var58) {
                                    var7.addSuppressed(var58);
                                }
                            } else {
                                rs.close();
                            }
                        }

                    }
                } catch (Throwable var62) {
                    var5 = var62;
                    throw var62;
                } finally {
                    if (stmt != null) {
                        if (var5 != null) {
                            try {
                                stmt.close();
                            } catch (Throwable var57) {
                                var5.addSuppressed(var57);
                            }
                        } else {
                            stmt.close();
                        }
                    }

                }
            } catch (Throwable var64) {
                var3 = var64;
                throw var64;
            } finally {
                if (conn != null) {
                    if (var3 != null) {
                        try {
                            conn.close();
                        } catch (Throwable var56) {
                            var3.addSuppressed(var56);
                        }
                    } else {
                        conn.close();
                    }
                }

            }
        } catch (SQLException var66) {
            System.out.println("No se pudo realizar la busqueda");
        }

        return listaRecomendadas;
    }
}
