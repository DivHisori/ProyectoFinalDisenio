

package Logica;


public class JefeArea extends Usuario {
    private String nombreCompleto;
    private String areaGestionada;

    public JefeArea(int idUsuario, String nombreUsuario, String clave, String rol, String nombreCompleto, String areaGestionada) {
        super(idUsuario, nombreUsuario, clave, rol);
        this.nombreCompleto = nombreCompleto;
        this.areaGestionada = areaGestionada;
    }

    @Override
    public void mostrarRol() {
        System.out.println("Soy Jefe de Área: " + nombreCompleto);
    }
}

