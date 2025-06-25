

package Logica;
// InventarioProductoRefinado.java
import java.time.LocalDateTime;
public class InventarioProductoRefinado implements Inventario<Prenda> {
    private Prenda prenda;
    private String color;
    private String talla;
    private int cantidad;
    private String ubicacion;
    private LocalDateTime ultimaActualizacion;

    public InventarioProductoRefinado(Prenda prenda, String color, String talla, int cantidad, String ubicacion, LocalDateTime ultimaActualizacion) {
        this.prenda = prenda;
        this.color = color;
        this.talla = talla;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
        this.ultimaActualizacion = ultimaActualizacion;
    }

    @Override
    public Prenda getItem() {
        return prenda;
    }

    @Override
    public double getCantidadDisponible() {
        return cantidad;
    }

    @Override
    public String getUnidad() {
        return "unidades"; // siempre en unidades
    }

    @Override
    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }

    public String getColor() {
        return color;
    }

    public String getTalla() {
        return talla;
    }
}

