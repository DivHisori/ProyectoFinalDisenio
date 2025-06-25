
package Logica;


public class Lote {
    private int idLote;
    private Prenda prenda;
    private int cantidad;
    private String estado;
    private LocalDate fechaCreacion;

    public Lote(int idLote, Prenda prenda, int cantidad, String estado, LocalDate fechaCreacion) {
        this.idLote = idLote;
        this.prenda = prenda;
        this.cantidad = cantidad;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public void mostrarResumen() {
        System.out.println("Lote de " + prenda.getNombre() + ": " + cantidad + " unidades [" + estado + "]");
    }
}

