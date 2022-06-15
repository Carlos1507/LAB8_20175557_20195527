package Beans;

public class Cancion {
    private int idcancion;
    private String nombre_cancion;
    private String banda;
    private int Listas_idListas;

    public Cancion(int idcancion, String nombre_cancion, String banda) {
        this.idcancion = idcancion;
        this.nombre_cancion = nombre_cancion;
        this.banda = banda;
    }
    public Cancion(int idcancion, String nombre_cancion, String banda, int idLista) {
        this.idcancion = idcancion;
        this.nombre_cancion = nombre_cancion;
        this.banda = banda;
        this.Listas_idListas = idLista;
    }

    public int getIdcancion() {
        return idcancion;
    }

    public void setIdcancion(int idcancion) {
        this.idcancion = idcancion;
    }

    public String getNombre_cancion() {
        return nombre_cancion;
    }

    public void setNombre_cancion(String nombre_cancion) {
        this.nombre_cancion = nombre_cancion;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }

    public int getListas_idListas() {
        return Listas_idListas;
    }

    public void setListas_idListas(int listas_idListas) {
        Listas_idListas = listas_idListas;
    }
}
