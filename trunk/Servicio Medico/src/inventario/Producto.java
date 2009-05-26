package inventario;

public class Producto implements java.io.Serializable{
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

    public String getNumCodigoBarras() {
        return numCodigoBarras;
    }

    public void setNumCodigoBarras(String numCodigoBarras) {
        this.numCodigoBarras = numCodigoBarras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
