
package Logica;

// ProduccionDiaria.java
import java.time.LocalDate;
public class ProduccionDiaria {
    private int idProduccion;
    private LocalDate fecha;
    private JefeArea jefe;
    private InventarioProductoRefinado producto;
    private int cantidadGenerada;

    public ProduccionDiaria(int idProduccion, LocalDate fecha, JefeArea jefe, InventarioProductoRefinado producto, int cantidadGenerada) {
        this.idProduccion = idProduccion;
        this.fecha = fecha;
        this.jefe = jefe;
        this.producto = producto;
        this.cantidadGenerada = cantidadGenerada;
    }
}
