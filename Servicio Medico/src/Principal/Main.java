/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Principal;


import inventario.*;

/**
 *
 * @author student6im7
 */
public class Main {

    static PPrincipal principal;
    static AProductos productos;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (Exception ex) {

        }
        productos = new AProductos();
        principal = new PPrincipal();
        principal.setVisible(true);

    }

}
