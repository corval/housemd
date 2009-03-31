/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Principal;

/**
 *
 * @author Chadan
 */
public class Encriptacion {
    
    static char [][] tabla = new char[300][300];
    
    static void inicializa(){
        for(int i = 0; i<256; i++){
            for(int j = 0; j<256; j++){
                tabla[i][j] = (char)(((i+j)%256));
            }
        }
    }

    static char[] encripta(char []pEnc, String clave){
        inicializa();
        char [] reg = new char[pEnc.length];
        for(int i = 0, ic = 0; i<pEnc.length; i++, ic++){
            if(ic >= clave.length()){
                ic = 0;
            }
            for(int c = 0; c<256; c++){
                if(tabla[0][c] == clave.charAt(ic)){
                    for(int f = 0; f<256; f++){
                        if(tabla[f][0] == pEnc[i]){
                            reg[i] = tabla[f][c];
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return reg;
    }
    
    static char[] descripta(char[] pDnc, String clave){
        inicializa();
        char[] reg = new char[pDnc.length];
        for(int i = 0, ic = 0; i<pDnc.length; i++, ic++){
            if(ic >= clave.length()){
                ic = 0;
            }
            for(int c = 0; c<256; c++){
                if(tabla[0][c] == clave.charAt(ic)){
                    for(int f = 0; f<256; f++){
                        if(tabla[f][c] == pDnc[i]){
                            reg[i] = tabla[f][0];
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return reg;
    }
    
}
