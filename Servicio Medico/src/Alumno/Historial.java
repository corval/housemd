package Alumno;

import java.sql.*;
import javax.swing.JOptionPane;

public class Historial {    
    AgudezaVisual agVis;
    AntSexFem antSF;
    AntSexMas antSM;
    Antecedentes antecedentes;
    Aparatos aparatos;
    Habitos habitos;
    Nutricional nutricional;
    SignosVitales sigVit;
    Somatometria somato;
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
                    if(Sexo.charAt(0) == 'm'){
                        rs = stmt.executeQuery ("select * from ant_sexmas WHERE (RFC LIKE '"+ aBuscar +"')");
                        antSM.Espermaquia = Integer.parseInt(rs.getString("Espermaquia"));
                        antSM.VSA = rs.getString("VSA");
                        antSM.NumParSex = Integer.parseInt(rs.getString("NumParSex"));
                        antSM.PFam = rs.getString("PFam");
                    }else{
                        rs = stmt.executeQuery ("select * from ant_sexfem WHERE (RFC LIKE '"+ aBuscar +"')");
                        antSF.Menarquia = Integer.parseInt(rs.getString("Menarquia"));
                        antSF.Menstruacion = rs.getString("Menstruacion");
                        antSF.SexPreMen = rs.getString("SexPreMen");
                        antSF.Dismonerrea = rs.getString("Disminorrea");
                        antSF.Oligomenorrea = rs.getString("Oligomenorrea");
                        antSF.Amenorrea = rs.getString("Amenorrea");
                        antSF.Metrorragia = rs.getString("Metrorragia");
                        antSF.Pseudomenorrea = rs.getString("Pseudomenorrea");
                        antSF.VSA = rs.getString("VSA");
                        antSF.NumParSex = Integer.parseInt(rs.getString("NumParSex"));
                        antSF.Embarazos = rs.getString("Embarazos");
                        antSF.Cesares = rs.getString("Cesares");
                        antSF.Abortos = rs.getString(rs.getString("Abortos"));
                        antSF.PFam = rs.getString("PFam");
                        antSF.Ritmo = rs.getString("Ritmo");
                        antSF.DIU = rs.getString("DIU");
                        antSF.Preservativo = rs.getString("Preservativo");
                        antSF.Hormonal = rs.getString("Hormonal");
                        antSF.Oral = rs.getString("Oral");
                        antSF.Inyectable = rs.getString("Inyectable");
                    }
                    rs = stmt.executeQuery ("select * from antecedentes WHERE (RFC LIKE '"+ aBuscar +"')");
                    antecedentes.Alcoholismo = Integer.parseInt(rs.getString("Alcoholismo"));
                    antecedentes.Alcoholismo = Integer.parseInt(rs.getString("Alcoholismo"));
                    
                }else{
                    JOptionPane.showMessageDialog(null ,"Lo sentimos no existe ese RFC", "Error", JOptionPane.ERROR_MESSAGE);
                   // conexion.close();
                }
            }
        }catch (Exception e) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
        }
    }

}
