

package Logica;


public class MaterialUtilizado {
    private int id;
    private Prenda prenda;
    private MateriaPrima materiaPrima;
    private double cantidadRequerida;
    private String unidad;
    private double costoEstimado;

    public MaterialUtilizado(int id, Prenda prenda, MateriaPrima materiaPrima, double cantidadRequerida, String unidad, double costoEstimado) {
        this.id = id;
        this.prenda = prenda;
        this.materiaPrima = materiaPrima;
        this.cantidadRequerida = cantidadRequerida;
        this.unidad = unidad;
        this.costoEstimado = costoEstimado;
    }
}
