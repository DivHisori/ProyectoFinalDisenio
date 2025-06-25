

package Logica;


// HistorialUsoMateriaPrima.java
import java.time.LocalDate;

public class HistorialUsoMateriaPrima {
    private int idUso;
    private MateriaPrima materiaPrima;
    private double cantidadUsada;
    private String unidadUso;
    private LocalDate fechaUso;
    private JefeArea jefeArea;

    public HistorialUsoMateriaPrima(int idUso, MateriaPrima materiaPrima, double cantidadUsada, String unidadUso, LocalDate fechaUso, JefeArea jefeArea) {
        this.idUso = idUso;
        this.materiaPrima = materiaPrima;
        this.cantidadUsada = cantidadUsada;
        this.unidadUso = unidadUso;
        this.fechaUso = fechaUso;
        this.jefeArea = jefeArea;
    }
}
