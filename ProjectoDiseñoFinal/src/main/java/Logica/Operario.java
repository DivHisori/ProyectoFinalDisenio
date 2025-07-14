package Logica;

public class Operario extends Trabajador {

private String nombre;
public Operario(int id, String nombre) {
        super(id, nombre);
    }

    @Override
    public void trabajar() {
        System.out.println("El operario " + nombre + " está trabajando.");
    }

    public String getNombre() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNombre'");
    }

    public void setId(int int1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }

    public int getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
}
