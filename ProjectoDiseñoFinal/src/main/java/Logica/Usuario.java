
package Logica;


public abstract class Usuario {
    protected int idUsuario;
    protected String nombreUsuario;
    protected String clave;
    protected String rol;

    public Usuario(int idUsuario, String nombreUsuario, String clave, String rol) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.rol = rol;
    }

    public abstract void mostrarRol();
}

