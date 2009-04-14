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
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student6im7
 */
public class Main {

    static PPrincipal principal;
    static AProductos productos;
    static AUsuarios usuarios;
    static LogIn logIn;
    static String login = "root";
    static String password = "pass";
    static String url = "jdbc:mysql://localhost:3306/HOUSE";
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

    static void cargaBD() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(url, login, password);
            if (conexion != null) {
                System.out.println("Conexión a base de datos " + url + " ... Ok");
                conexion.close();
            }
        } catch (Exception e) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        }
        try {
            stmt = conexion.createStatement();
        } catch (SQLException ex) {
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
        cargaBD();
        productos = new AProductos();
        usuarios = new AUsuarios();
        //carga archivos
        cargaUsuarios();
        cargaProductos();

        //pantallas
        principal = new PPrincipal();
        logIn = new LogIn();

        logIn.setVisible(true);

    }
}
