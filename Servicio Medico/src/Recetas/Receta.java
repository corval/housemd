package Recetas;

import inventario.AProductos;

public class Receta{
    private AProductos medicamentos;
    private String Pre_Arterial;
    private String Fre_Cardiaca;
    private String Fre_Respiratoria;
    private String RFC;
    private String nombre;    
    private String descripcion;
    private String boleta;
    private String alergia;
    private float Estatura;
    private float Peso;
    private float Temperatura;

    public Receta(float Estatura, float Peso, float Temperatura, String Pre_Arterial, String Fre_Cardiaca, String Fre_Respiratoria, String nombre, String RFC, String descripcion, String boleta, String alergia){
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
       this.alergia = alergia;
       medicamentos = new AProductos();
    }
   
    public AProductos getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(AProductos medicamentos) {
        this.medicamentos = medicamentos;
    }
}