
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

    public void setIdMateriaPrima(int int1) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setIdMateriaPrima'");
    }

    public double getCantidad() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCantidad'");
    }

    public String getTipo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTipo'");
    }

    public int getIdMateriaPrima() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdMateriaPrima'");
    }
}
