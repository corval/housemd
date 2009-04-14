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


    static void cargaBD(){
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
        principal = new PPrincipal();
        usuarios = new AUsuarios();
        logIn = new LogIn();
        cargaUsuarios();
        logIn.setVisible(true);

    }
}
