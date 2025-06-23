
package Logica;


public class Lote {
    private int numeroLote;
    private Trabajador trabajador;
    private Producto producto;

    public Lote(int numeroLote, Trabajador trabajador, Producto producto) {
        this.numeroLote = numeroLote;
        this.trabajador = trabajador;
        this.producto = producto;
    }

    public void procesarLote() {
        trabajador.trabajar();
        System.out.println("Procesando lote #" + numeroLote);
        System.out.println(producto.describir());
    }
}
