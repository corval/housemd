package Recetas;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import inventario.AProductos;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

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
    private Calendar calendario;
    private int edad;

    public Receta(){
        medicamentos = new AProductos();
    }

    public Receta(float Estatura, float Peso, float Temperatura, String Pre_Arterial, String Fre_Cardiaca, String Fre_Respiratoria, String nombre, String RFC, String descripcion, String boleta, String alergia, int edad){
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
       this.edad = edad;
    }


    public void llenarReceta(float Estatura, float Peso, float Temperatura, String Pre_Arterial, String Fre_Cardiaca, String Fre_Respiratoria, String nombre, String RFC, String descripcion, String boleta, String alergia, int edad){
        this.setEstatura(Estatura);
        this.setPeso(Peso);
        this.setPre_Arterial(Pre_Arterial);
        this.setRFC(RFC);
        this.setFre_Cardiaca(Fre_Cardiaca);
        this.setFre_Respiratoria(Fre_Respiratoria);
        this.setTemperatura(Temperatura);
        this.setNombre(nombre);
        this.setDescripcion(descripcion);
        this.setBoleta(boleta);
        this.setAlergia(alergia);
        this.setEdad(edad);
    }

    public AProductos getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(AProductos medicamentos) {
        this.medicamentos = medicamentos;
    }

    public void generaPDF(){
        Document documento = new Document(PageSize.HALFLETTER.rotate());

        try {
            PdfWriter.getInstance(documento, new FileOutputStream("receta.pdf"));
        } catch (Exception ex) {
  
        }

        documento.open();

        try {
            Image hyperHeader = Image.getInstance( new ImageIcon(getClass().getResource("/Imagenes/recetaHeader.jpg")).getImage(), null);
            hyperHeader.scalePercent(68);
            documento.add(hyperHeader);
            //header
            PdfPTable header = new PdfPTable(1);
            header.setWidthPercentage(100);
            float anchosHeaderPart1[] = {0.3f, 0.5f, 0.2f};
            PdfPTable headerPart1 = new PdfPTable(anchosHeaderPart1);
            setCalendario(new GregorianCalendar());
            headerPart1.addCell("Fecha: " + getCalendario().get(Calendar.DAY_OF_MONTH) + "-" + getCalendario().get(Calendar.MONTH) + "-"  + getCalendario().get(Calendar.YEAR));
            headerPart1.addCell("Nombre: " + this.getNombre());
            headerPart1.addCell("Edad: " + this.getEdad() + " años");
            PdfPTable headerPart2 = new PdfPTable(6);
            headerPart2.addCell("Peso: " + this.getPeso() + "Kg");
            headerPart2.addCell("Talla: " + this.getEstatura() + "cm");
            headerPart2.addCell("FC: " + this.getFre_Cardiaca() + "X'");
            headerPart2.addCell("FR: " +this.getFre_Respiratoria() + "X'");
            headerPart2.addCell("Temp.: " + this.getTemperatura() + "ºC");
            headerPart2.addCell("T/A:" + this.getPre_Arterial());
            header.addCell(headerPart1);
            header.addCell(headerPart2);
            documento.add(header);
            //body
            float anchosBody[] = {0.7f, 0.3f};
            PdfPTable body = new PdfPTable(anchosBody);
            body.setWidthPercentage(100);
            body.addCell("Rp: \n\n" + this.getDescripcion());
            PdfPTable bodyDer = new PdfPTable(1);
            bodyDer.addCell("Alergias: " + this.getAlergia());
            PdfPTable medicinas = new PdfPTable(1);
            medicinas.addCell("Medicamentos");
            for(int i = 1; i<=this.medicamentos.getN(); i++){
                medicinas.addCell(this.medicamentos.getProductos()[i].getNombre());
            }
            bodyDer.addCell(medicinas);
            body.addCell(bodyDer);
            documento.add(body);
            //footer
            Image footer = Image.getInstance( new ImageIcon(getClass().getResource("/Imagenes/recetaFooter.jpg")).getImage(), null);
            footer.scalePercent(68);
            documento.add(footer);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        documento.close();
    }

    /**
     * @return the Pre_Arterial
     */
    public String getPre_Arterial() {
        return Pre_Arterial;
    }

    /**
     * @param Pre_Arterial the Pre_Arterial to set
     */
    public void setPre_Arterial(String Pre_Arterial) {
        this.Pre_Arterial = Pre_Arterial;
    }

    /**
     * @return the Fre_Cardiaca
     */
    public String getFre_Cardiaca() {
        return Fre_Cardiaca;
    }

    /**
     * @param Fre_Cardiaca the Fre_Cardiaca to set
     */
    public void setFre_Cardiaca(String Fre_Cardiaca) {
        this.Fre_Cardiaca = Fre_Cardiaca;
    }

    /**
     * @return the Fre_Respiratoria
     */
    public String getFre_Respiratoria() {
        return Fre_Respiratoria;
    }

    /**
     * @param Fre_Respiratoria the Fre_Respiratoria to set
     */
    public void setFre_Respiratoria(String Fre_Respiratoria) {
        this.Fre_Respiratoria = Fre_Respiratoria;
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
    public String getBoleta() {
        return boleta;
    }

    /**
     * @param boleta the boleta to set
     */
    public void setBoleta(String boleta) {
        this.boleta = boleta;
    }

    /**
     * @return the alergia
     */
    public String getAlergia() {
        return alergia;
    }

    /**
     * @param alergia the alergia to set
     */
    public void setAlergia(String alergia) {
        this.alergia = alergia;
    }

    /**
     * @return the Estatura
     */
    public float getEstatura() {
        return Estatura;
    }

    /**
     * @param Estatura the Estatura to set
     */
    public void setEstatura(float Estatura) {
        this.Estatura = Estatura;
    }

    /**
     * @return the Peso
     */
    public float getPeso() {
        return Peso;
    }

    /**
     * @param Peso the Peso to set
     */
    public void setPeso(float Peso) {
        this.Peso = Peso;
    }

    /**
     * @return the Temperatura
     */
    public float getTemperatura() {
        return Temperatura;
    }

    /**
     * @param Temperatura the Temperatura to set
     */
    public void setTemperatura(float Temperatura) {
        this.Temperatura = Temperatura;
    }

    /**
     * @return the calendario
     */
    public Calendar getCalendario() {
        return calendario;
    }

    /**
     * @param calendario the calendario to set
     */
    public void setCalendario(Calendar calendario) {
        this.calendario = calendario;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

}
