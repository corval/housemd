/*
 * MetoUtil.java
 *
 * Created on 25 de septiembre de 2008, 03:39 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Principal;

import java.io.File;

/**
 *
 * @author student5im7
 */
public class Utiles {

    public final static String wav = "wav";
    public final static String au = "au";
    public final static String aif = "aif";

    static boolean validaContr(char[] a, char [] b){
        if(a.length != b.length){
            return false;
        }
        int igual = 0;
        for(int i = 0; i<a.length; i++){
            if(a[i] == b[i]){
                igual++;
                
            }
            else{
                break;
            }
        }
        if(igual == a.length){
            return true;
        }
        return false;
    }


    /*
     * Get the extension of a file.
     */
    public static String getExtension(File f) {
        String ext = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');

        if (i > 0 &&  i < s.length() - 1) {
            ext = s.substring(i+1).toLowerCase();
        }
        return ext;
    }
    
    /** Creates a new instance of MetoUtil */
    public Utiles() {
    }
    
}
