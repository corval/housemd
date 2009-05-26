package Alumno;

import java.sql.*;
import javax.swing.JOptionPane;

public class Historial {    
    AgudezaVisual agVis;
    String Nombre;
    String Apellido_Paterno;
    String Apellido_Materno;
    String RFC;
    String Boleta;
    String Sexo;
    int Edad;

    //Varibles, para la Base de Datos
    Connection conexion;
    Statement stmt;
    ResultSet rs;
    String login = "root";
    String password = "pass";
    String url = "jdbc:mysql://192.168.0.48:3306/test";

    public void sacaAlumno(String aBuscar) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection(url, login, password);
            if (conexion != null) {
                System.out.println("Conexión a base de datos " + url + " ... Ok");
                stmt = conexion.createStatement();
                rs = stmt.executeQuery ("select * from historial WHERE (RFC LIKE '"+ aBuscar +"')");
                if(rs.next()){
                    Nombre = rs.getString("Nombre");
                    Apellido_Paterno = rs.getString("Apellido_Paterno");
                    Apellido_Materno = rs.getString("Apellido_Materno");
                    Boleta = rs.getString("Boleta");
                    Sexo = rs.getString("Sexo");
                    Edad = Integer.parseInt(rs.getString("Edad"));
                    rs = stmt.executeQuery ("select * from agudezavisual WHERE (RFC LIKE '"+ aBuscar +"')");
                    agVis.Derecho = Integer.parseInt(rs.getString("Derecho"));
                    agVis.Izquierdo = Integer.parseInt(rs.getString("Izquierdo"));
                }else{
                    JOptionPane.showMessageDialog(null ,"Lo sentimos no existe ese RFC", "Error", JOptionPane.ERROR_MESSAGE);
                    conexion.close();
                }
            }
        }catch (Exception e) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        }
    }

}
