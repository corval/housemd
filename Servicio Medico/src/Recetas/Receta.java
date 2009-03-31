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
public class Receta {
    private float estatura;
    private float peso;
    private String presion;
    private String nombre;
    private String RFC;
    private String descripcion;
    private int boleta;
    private AProductos medicamentos;

    public Receta(float estatura, float peso, String presion, String nombre, String RFC, String descripcion, int boleta){
       this.estatura = estatura;
       this.peso = peso;
       this.presion = presion;
       this.nombre = nombre;
       this.RFC = RFC;
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
