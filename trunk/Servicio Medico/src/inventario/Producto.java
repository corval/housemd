/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario;

/**
 *
 * @author student6im7
 */


public class Producto {
    private String numCodigoBarras;
    private String nombre;
    private int cantidad;


    Producto(String numCodigoBarras, String nombre, int cantidad){
        this.numCodigoBarras = numCodigoBarras;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public void incrementaCantidad(int cantidad){
        this.cantidad+=cantidad;
    }

    /**
     * @return the numCodigoBarras
     */
    public String getNumCodigoBarras() {
        return numCodigoBarras;
    }

    /**
     * @param numCodigoBarras the numCodigoBarras to set
     */
    public void setNumCodigoBarras(String numCodigoBarras) {
        this.numCodigoBarras = numCodigoBarras;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
