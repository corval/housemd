/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Principal;


import inventario.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author student6im7
 */
public class Main {

    static PPrincipal principal;
    static AProductos productos;
    static AUsuarios usuarios;


        static void guardaUsuarios(){
         try {
            FileOutputStream fos = new FileOutputStream("usr.tps");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            AUsuarios temp = usuarios;
            oos.writeObject(temp);
            oos.flush();
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

            static void cargaUsuarios(){
        try {
            FileInputStream fis = new FileInputStream("usr.tps");
            ObjectInputStream ois = new ObjectInputStream(fis);
            AUsuarios temp = (AUsuarios)(ois.readObject());
            usuarios = temp;
        } catch (Exception e) {
            System.out.println("Es la primera ve que se inicia el programa");

        }
    }


    /**
     * Para los que no sepan esto es el main
     */
    public static void main(String[] args) {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

        }
        productos = new AProductos();
        principal = new PPrincipal();
        usuarios = new AUsuarios();
        principal.setVisible(true);

    }

}
