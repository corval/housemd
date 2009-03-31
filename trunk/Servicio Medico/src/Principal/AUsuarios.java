/*
 * AUsuarios.java
 *
 * Created on 25 de septiembre de 2008, 09:48 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Principal;

import javax.swing.JOptionPane;

/**
 *
 * @author student5im7
 */

public class AUsuarios implements java.io.Serializable{
    
    private Usuario usuarios[];
    private int n, ultimo;
    private boolean registrados[];
    boolean res;
    
    /** Creates a new instance of AUsuarios */
    public AUsuarios() {
        setUsuarios(new Usuario[202]);
        setN(0);
        setRegistrados(new boolean[202]);
    }
    
    boolean nuevo(String nl, char [] cl, int tl){
        for(int i = 1; i<=getN(); i++){
            if(getUsuarios()[i].getNombre().compareToIgnoreCase(nl) == 0){
                JOptionPane.showMessageDialog(null, "El usuario ya existe", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        setN(getN() + 1);
        getUsuarios()[getN()] = new Usuario(nl, cl, tl);
        registrados[n] = true;
        return true;
    }
    
    boolean baja(String nl, char [] cl){
        res = false;
        for(int i = 1; i<=getN(); i++){
            if(getUsuarios()[i].getNombre().compareToIgnoreCase(nl) == 0){
                res = true;
                if(getUsuarios()[i].getContrasena().equals(cl)){
                    Usuario temp = getUsuarios()[getN()];
                    getUsuarios()[i] = temp;
                    setN(getN() - 1);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Contrase�a Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }
        if(!res){
        JOptionPane.showMessageDialog(null, "El usuario"  + " no existe", "Error", JOptionPane.WARNING_MESSAGE);
        }
        return res;
    }
    
    public int valida(String nl, char[] cl){
        if(getN() == 0){
            return -2;
        }
        for(int i = 1; i<=getN(); i++){
            if(getUsuarios()[i].getNombre().compareToIgnoreCase(nl) == 0){                
                if(Utiles.validaContr(Encriptacion.descripta(getUsuarios()[i].getContrasena(), getUsuarios()[i].getNombre()), cl)){
                    return getUsuarios()[i].getTipo();
                }
                else{
                    return -1;
                }
            }
        }
        return 0;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getUltimo() {
        return ultimo;
    }

    public void setUltimo(int ultimo) {
        this.ultimo = ultimo;
    }

    public boolean[] getRegistrados() {
        return registrados;
    }

    public void setRegistrados(boolean[] registrados) {
        this.registrados = registrados;
    }
    
}



