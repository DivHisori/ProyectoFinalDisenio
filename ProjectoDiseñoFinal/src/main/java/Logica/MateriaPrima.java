
package Logica;


public class MateriaPrima extends Producto {
    private double precioUnitario;

    public MateriaPrima(String tipo, int cantidad, double precioUnitario) {
        super(tipo, cantidad);
        this.precioUnitario = precioUnitario;
    }

    @Override
    public String describir() {
        return "Materia prima: " + tipo + " - Cantidad: " + cantidad + " - Precio Unitario: $" + precioUnitario;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
}
