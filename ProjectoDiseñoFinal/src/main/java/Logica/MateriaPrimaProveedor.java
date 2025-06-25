

package Logica;


public class MateriaPrimaProveedor {
    private int id;
    private MateriaPrima materiaPrima;
    private Proveedor proveedor;
    private String unidadCompra;
    private double precioPorUnidad;
    private int diasEntrega;
    private String calidad;

    public MateriaPrimaProveedor(int id, MateriaPrima materiaPrima, Proveedor proveedor, String unidadCompra, double precioPorUnidad, int diasEntrega, String calidad) {
        this.id = id;
        this.materiaPrima = materiaPrima;
        this.proveedor = proveedor;
        this.unidadCompra = unidadCompra;
        this.precioPorUnidad = precioPorUnidad;
        this.diasEntrega = diasEntrega;
        this.calidad = calidad;
    }
}
