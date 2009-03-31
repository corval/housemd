/*
 * Usuario.java
 *
 * Created on 25 de septiembre de 2008, 09:43 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Principal;

/**
 *
 * @author student5im7
 */
public class Usuario implements java.io.Serializable{

    //Los tipos son respecto a su numero
    //1: Administrador

    private String nombre;
    private char contrasena [];
    private int tipo;
    
    /** Creates a new instance of Usuario */
    public Usuario(String nl, char [] cl, int tl) {
        setNombre(nl);
        setContrasena(cl);
        setTipo(tl);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char[] getContrasena() {
        return contrasena;
    }

    public void setContrasena(char[] contrasena) {
        this.contrasena = contrasena;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
}
