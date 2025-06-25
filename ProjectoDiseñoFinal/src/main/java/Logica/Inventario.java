

package Logica;


public interface Inventario<T> {
    T getItem();  // El tipo del producto o materia
    double getCantidadDisponible();
    String getUnidad();
    String getUbicacion();
    LocalDateTime getUltimaActualizacion();
}

