package Logica;

public class Operario extends Usuario {
    private String nombre;

    public Operario(int idUsuario, String nombreUsuario, String clave, String rol, String nombre) {
        super(idUsuario, nombreUsuario, clave, rol);
        this.nombre = nombre;
    }

    @Override
    public void mostrarRol() {
        System.out.println("Soy Operario: " + nombre);
    }
}

