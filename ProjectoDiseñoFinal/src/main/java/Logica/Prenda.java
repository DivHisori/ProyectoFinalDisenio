
package Logica;


public class Prenda implements Producto {
    private int idPrenda;
    private String tipo;
    private String genero;
    private String temporada;
    private String estilo;
    private double costoBase;

    public Prenda(int id, String tipo, String genero, String temporada, String estilo, double costoBase) {
        this.idPrenda = id;
        this.tipo = tipo;
        this.genero = genero;
        this.temporada = temporada;
        this.estilo = estilo;
        this.costoBase = costoBase;
    }

    @Override
    public int getId() {
        return idPrenda;
    }

    @Override
    public String getNombre() {
        return tipo;
    }

    @Override
    public double getCosto() {
        return costoBase;
    }
}

