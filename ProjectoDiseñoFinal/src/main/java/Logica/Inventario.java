

package Logica;

import java.time.LocalDateTime;


public interface Inventario<T> {
    T getItem();  // El tipo del producto o materia
    double getCantidadDisponible();
    String getUnidad();
    String getUbicacion();
    LocalDateTime getUltimaActualizacion();
}

