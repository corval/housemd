/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Recetas;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.tools.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Administrator
 */
public class GeneradorPDF {


    public GeneradorPDF(){

    }

    public void genera(){
        Document documento = new Document(PageSize.HALFLETTER.rotate());

        try {
            PdfWriter.getInstance(documento, new FileOutputStream("receta.pdf"));
        } catch (Exception ex) {
            Logger.getLogger(GeneradorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }

        documento.open();
       
        try {
            Image fondo = Image.getInstance( new ImageIcon(getClass().getResource("/Imagenes/receta.jpg")).getImage(), null);
            fondo.scalePercent(65);
            documento.add(fondo);
        } catch (Exception ex) {
            Logger.getLogger(GeneradorPDF.class.getName()).log(Level.SEVERE, null, ex);
        }

        documento.close();
    }
}
