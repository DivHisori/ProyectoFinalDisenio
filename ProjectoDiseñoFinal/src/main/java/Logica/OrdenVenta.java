
package Logica;

//asd
public class OrdenVenta {
    private int numeroOrden;
    private Trabajador trabajador;
    private Producto producto;
    private String cliente;
    private String tipoVenta;
    private double precioFinal;

    public OrdenVenta(int numeroOrden, Trabajador trabajador, Producto producto, String cliente, String tipoVenta, double precioFinal) {
        this.numeroOrden = numeroOrden;
        this.trabajador = trabajador;
        this.producto = producto;
        this.cliente = cliente;
        this.tipoVenta = tipoVenta;
        this.precioFinal = precioFinal;
    }

    public String getCliente() {
        return cliente;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }
}
