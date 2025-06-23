package Logica;

public abstract class Trabajador {

    int id;
    String nombre;

    public Trabajador(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public abstract void trabajar();

    @Override
    public String toString() {
        return "Trabajador{" + "id=" + id + ", nombre='" + nombre + '\'' + '}';
    }
}
