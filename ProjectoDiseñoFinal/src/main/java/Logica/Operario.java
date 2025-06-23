package Logica;

public class Operario extends Trabajador {

    public Operario(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public void trabajar() {
        System.out.println("El operario " + nombre + " está trabajando.");
    }
}
