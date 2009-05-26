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

    /**
     * @return the estatura
     */
    public float getEstatura() {
        return estatura;
    }

    /**
     * @param estatura the estatura to set
     */
    public void setEstatura(float estatura) {
        this.estatura = estatura;
    }

    /**
     * @return the peso
     */
    public float getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * @return the presion
     */
    public String getPresion() {
        return presion;
    }

    /**
     * @param presion the presion to set
     */
    public void setPresion(String presion) {
        this.presion = presion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the RFC
     */
    public String getRFC() {
        return RFC;
    }

    /**
     * @param RFC the RFC to set
     */
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the boleta
     */
    public int getBoleta() {
        return boleta;
    }

    /**
     * @param boleta the boleta to set
     */
    public void setBoleta(int boleta) {
        this.boleta = boleta;
    }

    /**
     * @return the medicamentos
     */
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
