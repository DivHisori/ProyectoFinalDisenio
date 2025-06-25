

package Logica;

// InventarioMateriaPrima.java
import java.time.LocalDateTime;
public class InventarioMateriaPrima implements Inventario<MateriaPrima> {
    private MateriaPrima materiaPrima;
    private double cantidad;
    private String unidad;
    private String ubicacion;
    private LocalDateTime ultimaActualizacion;

    public InventarioMateriaPrima(MateriaPrima materiaPrima, double cantidad, String unidad, String ubicacion, LocalDateTime ultimaActualizacion) {
        this.materiaPrima = materiaPrima;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.ubicacion = ubicacion;
        this.ultimaActualizacion = ultimaActualizacion;
    }

    @Override
    public MateriaPrima getItem() {
        return materiaPrima;
    }

    @Override
    public double getCantidadDisponible() {
        return cantidad;
    }

    @Override
    public String getUnidad() {
        return unidad;
    }

    @Override
    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public LocalDateTime getUltimaActualizacion() {
        return ultimaActualizacion;
    }
}

