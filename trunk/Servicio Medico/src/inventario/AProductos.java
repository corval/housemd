/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario;

/**
 *
 * @author student6im7
 */
public class AProductos {
    private Producto[] productos;
    private int n;
    private char[] aux = new char[1000];
    private char[] comp = new char[1000];
    private int reg;
    private int max;
    private Producto temp;

    public AProductos(){
        productos = new Producto[10002];
        n = 0;
    }

    public boolean nuevoProducto(String numCodigoBarras, String nombre, int cantidad){
        //regresa
        // true: si se registro correctamente
        // false: si ya existe un registro con el mismo nombre o codigo de barras (no lo agrega)
        for(int i = 1; i<=getN(); i++){
            if(getProductos()[i].getNombre().equalsIgnoreCase(nombre) || getProductos()[i].getNumCodigoBarras().equalsIgnoreCase(numCodigoBarras)){
                getProductos()[i].incrementaCantidad(cantidad);
                return false;
            }
        }
        setN(getN() + 1);
        getProductos()[n] = new Producto(numCodigoBarras, nombre, cantidad);
        return true;
    }

    public boolean eliminarProductoPorNombre(String nombre){
        //regresa
        // true: si se borro correctamente
        // false: si no existe un registro con el mismo nombre
        for(int i = 1; i<=getN(); i++){
            if(getProductos()[i].getNombre().equalsIgnoreCase(nombre)){
                getProductos()[i] = getProductos()[getN()];
                setN(getN() - 1);
                return true;
            }
        }
        return false;
    }

    public boolean eliminarProductoPorCodigoBarras(String numCodigoBarras){
        //regresa
        // true: si se borro correctamente
        // false: si no existe un registro con el mismo codigo de Barras
        for(int i = 1; i<=getN(); i++){
            if(getProductos()[i].getNumCodigoBarras().equalsIgnoreCase(numCodigoBarras)){
                getProductos()[i] = getProductos()[getN()];
                setN(getN() - 1);
                return true;
            }
        }
        return false;
    }

    public void eliminarProducto(int pos){
        getProductos()[pos] = getProductos()[getN()];
        setN(getN() - 1);
    }

    public void modificaProducto(int pos, String numCodigoBarras, String nombre, int cantidad){
        getProductos()[pos] = new Producto(numCodigoBarras, nombre, cantidad);
    }

    public int regresaPosProductoPorNombre(String nombre){
        //regresa
        // >0: si se encontro el producto
        // -1: si no existe un registro con el mismo nombre
        max = 0;
        reg = -1;
        int num;
        int j;
        aux = nombre.toCharArray();
        for(int i = 1; i<=getN(); i++){
            comp = getProductos()[i].getNombre().toCharArray();
            num = 0;
            for(j = 0; j < aux.length && j < comp.length; j ++){
               if(Character.toUpperCase(aux[j]) == Character.toUpperCase(comp[j])){
                  num ++;
               }else{
                  j = comp.length + 2;
               }
            }
            if(num > max || j == comp.length){
               max = num;
               reg = i;
            }
        }
        return reg;
    }

    public int regresaPosUltimoProductoPorNombre(String nombre){
        //regresa
        // >0: si se encontro el producto
        // -1: si no existe un registro con el mismo nombre
        max = 0;
        reg = -1;
        int num;
        int j;
        aux = nombre.toCharArray();
        for(int i = 1; i<=getN(); i++){
            comp = getProductos()[i].getNombre().toCharArray();
            num = 0;
            for(j = 0; j < aux.length && j < comp.length; j ++){
               if(Character.toUpperCase(aux[j]) == Character.toUpperCase(comp[j])){
                  num ++;
               }else{
                  j = aux.length + 2;
               }
            }
            if(num > max || j == aux.length){
               max = num;
               reg = i;
            }
        }
        return reg;
    }

    public int regresaPosProductoPorCodigoBarras(String numCodigoBarras){
        //regresa
        // >0: si se encontro el producto
        // -1: si no existe un registro con el mismo codigo de barras
        max = 0;
        reg = -1;
        int num;
        int j;
        aux = numCodigoBarras.toCharArray();
        for(int i = 1; i<=getN(); i++){
            comp = getProductos()[i].getNumCodigoBarras().toCharArray();
            num = 0;
            for(j = 0; j < aux.length && j < comp.length; j ++){
               if(Character.toUpperCase(aux[j]) == Character.toUpperCase(comp[j])){
                  num ++;
               }else{
                  j = comp.length + 2;
               }
            }
            if(num > max || j == comp.length){
               max = num;
               reg = i;
            }
        }
        return reg;
    }

    public void aniadirCantidad(int pos, int cantidad){
        getProductos()[pos].incrementaCantidad(cantidad);
    }

    public void aniadirCantidadporNombre(String nombre, int cantidad){
        for(int i = 1; i<=getN(); i++){
            if(getProductos()[i].getNombre().equalsIgnoreCase(nombre)){
                getProductos()[i].incrementaCantidad(cantidad);
            }
        }
    }

    public void quitarCantidadporNombre(String nombre, int cantidad){
        for(int i = 1; i<=getN(); i++){
            if(getProductos()[i].getNombre().equalsIgnoreCase(nombre)){
                getProductos()[i].incrementaCantidad(-cantidad);
            }
        }
    }

    /**
     * @return the productos
     */
    public Producto[] getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(int n) {
        this.n = n;
    }

    public void BurbujasoSort(){
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                if(productos[i].getNombre().compareToIgnoreCase(productos[j].getNombre()) < 0){
                    temp = productos[i];
                    productos[i] = productos[j];
                    productos[j] = temp;
                }
            }
        }
    }

}
