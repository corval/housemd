/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import inventario.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author student6im7
 */
public class Main {

    static PPrincipal principal;
    static Splash splash;
    static AProductos productos;
    static AUsuarios usuarios;
    static Preferencias preferencias;
    static LogIn logIn;
    static String login = "root";
    static String password = "";
    static String url = "jdbc:mysql://localhost/house";
    static Connection conexion;
    static Statement stmt;
    static ResultSet rs;

    static void guardaUsuarios() {
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

    static void cargaUsuarios() {
        try {
            FileInputStream fis = new FileInputStream("usr.tps");
            ObjectInputStream ois = new ObjectInputStream(fis);
            AUsuarios temp = (AUsuarios) (ois.readObject());
            usuarios = temp;
        } catch (Exception e) {
            System.out.println("Es la primera ve que se inicia el programa");

        }
    }

    static void guardaProductos() {
        try {
            FileOutputStream fos = new FileOutputStream("productos.hmd");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            AProductos temp = productos;
            oos.writeObject(temp);
            oos.flush();
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void cargaProductos() {
        try {
            FileInputStream fis = new FileInputStream("productos.hmd");
            ObjectInputStream ois = new ObjectInputStream(fis);
            AProductos temp = (AProductos) (ois.readObject());
            productos = temp;
        } catch (Exception e) {
            System.out.println("No esta el archivo de productos");
        }
    }

    static void guardaPreferencias() {
        try {
            FileOutputStream fos = new FileOutputStream("preferencias.hmd");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(preferencias);
            oos.flush();
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void cargaPreferencias() {
        try {
            FileInputStream fis = new FileInputStream("preferencias.hmd");
            ObjectInputStream ois = new ObjectInputStream(fis);
            preferencias = (Preferencias) (ois.readObject());
        } catch (Exception e) {
            System.out.println("No esta el archivo de productos");
        }
    }


    static void cargaBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:mysql://" + preferencias.urlBD + "/" + preferencias.nombreBD, preferencias.loginBD, preferencias.passBD);
           stmt = conexion.createStatement();
            if (conexion != null) {
                System.out.println("Conexión a base de datos " + preferencias.urlBD + " ... Ok");
               // conexion.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema al intentar conectarse con la base de datos " + preferencias.urlBD, "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + preferencias.urlBD);
            e.printStackTrace();
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
        usuarios = new AUsuarios();
        preferencias = new Preferencias();
        splash = new Splash(null, false);
        splash.setVisible(true);
        //carga archivos
        cargaUsuarios();
        cargaProductos();
        cargaPreferencias();
        cargaBD();
        //pantallas
        splash.dispose();
        principal = new PPrincipal();
        logIn = new LogIn();

        logIn.setVisible(true);

    }
}
