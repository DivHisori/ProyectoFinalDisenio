
package Logica;


public abstract class Producto {
    protected String tipo;
    protected int cantidad;

    public Producto(String tipo, int cantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public abstract String describir();
}
