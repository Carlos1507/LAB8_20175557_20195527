package Beans;

public class Cancion {
    private int idcancion;
    private String nombre_cancion;
    private Banda banda;

    public Cancion(int idcancion, String nombre_cancion, Banda banda) {
        this.idcancion = idcancion;
        this.nombre_cancion = nombre_cancion;
        this.banda = banda;
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

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
}
