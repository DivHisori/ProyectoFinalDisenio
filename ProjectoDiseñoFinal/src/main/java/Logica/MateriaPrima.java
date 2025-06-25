
package Logica;


public class MateriaPrima implements Producto {
    private int idMateria;
    private String nombre;
    private String descripcion;

    public MateriaPrima(int id, String nombre, String descripcion) {
        this.idMateria = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    @Override
    public int getId() {
        return idMateria;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getCosto() {
        return 0; // No tiene costo directo, lo aporta proveedor
    }
}

