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

    public Receta(){
        medicamentos = new AProductos();
    }

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
    }


    public void llenarReceta(float Estatura, float Peso, float Temperatura, String Pre_Arterial, String Fre_Cardiaca, String Fre_Respiratoria, String nombre, String RFC, String descripcion, String boleta, String alergia){
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
            calendario = new GregorianCalendar();
            headerPart1.addCell("Fecha: " + calendario.get(Calendar.DAY_OF_MONTH) + "-" + calendario.get(Calendar.MONTH) + "-"  + calendario.get(Calendar.YEAR));
            headerPart1.addCell("Nombre: Este Imbecil");
            headerPart1.addCell("Edad: La de siempre");
            PdfPTable headerPart2 = new PdfPTable(6);
            headerPart2.addCell("Peso: " + this.Peso + "Kg");
            headerPart2.addCell("Talla: " + this.Estatura + "cm");
            headerPart2.addCell("FC: " + this.Fre_Cardiaca + "X'");
            headerPart2.addCell("FR: " +this.Fre_Respiratoria + "X'");
            headerPart2.addCell("Temp.: " + this.Temperatura + "ºC");
            headerPart2.addCell("T/A:" + this.Pre_Arterial);
            header.addCell(headerPart1);
            header.addCell(headerPart2);
            documento.add(header);
            //body
            float anchosBody[] = {0.7f, 0.3f};
            PdfPTable body = new PdfPTable(anchosBody);
            body.setWidthPercentage(100);
            body.addCell("Rp: \n\n" + this.descripcion);
            PdfPTable bodyDer = new PdfPTable(1);
            bodyDer.addCell("Alergias: " + this.alergia);
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

}
