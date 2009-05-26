/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Recetas;

import inventario.AProductos;

/**
 *
 * @author student6im7
 */
public class Receta{
    private AProductos medicamentos;
    private String Pre_Arterial;
    private String Fre_Cardiaca;
    private String Fre_Respiratoria;
    private String RFC;
    private String nombre;    
    private String descripcion;
    private String boleta;
    private float Estatura;
    private float Peso;
    private float Temperatura;

    public Receta(float Estatura, float Peso, float Temperatura, String Pre_Arterial, String Fre_Cardiaca, String Fre_Respiratoria, String nombre, String RFC, String descripcion, String boleta){
       this.Estatura = Estatura;
       this.Peso = Peso;
       this.Pre_Arterial = Pre_Arterial;
       this.RFC = RFC;
       this.Fre_Cardiaca = Fre_Cardiaca;
       this.Fre_Respiratoria = Fre_Respiratoria;
       this.Temperatura = Temperatura;
       this.nombre = nombre;       
       this.descripcion = descripcion;
       this.boleta = boleta;
       medicamentos = new AProductos();
    }
   
    public AProductos getMedicamentos() {
        return medicamentos;
    }

    /**
     * @param medicamentos the medicamentos to set
     */
    public void setMedicamentos(AProductos medicamentos) {
        this.medicamentos = medicamentos;
    }
}
