
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

    public void setNumeroLote(int int1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNumeroLote'");
    }

    public String getNumeroLote() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNumeroLote'");
    }

    public int getCantidadAProducir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCantidadAProducir'");
    }

    public Object getPrenda() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPrenda'");
    }


}
