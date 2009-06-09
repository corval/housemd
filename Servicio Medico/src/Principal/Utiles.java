
package Principal;

import java.io.File;
import java.lang.reflect.Method;
import javax.swing.JOptionPane;

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

    private static final String errMsg = "Error attempting to launch web browser";

    public static void openURL(String url) {
        String osName = System.getProperty("os.name");
       System.out.println("OS NAME! "+osName);
        try {
            if (osName.startsWith("Mac OS")) {
                Class fileMgr = Class.forName("com.apple.eio.FileManager");
                Method openURL = fileMgr.getDeclaredMethod("openURL",
                new Class[] {String.class});
                openURL.invoke(null, new Object[] {url});
            }
            else if (osName.startsWith("Windows"))
            {
                  System.out.println("guindows! yay!");
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            }else { //assume Unix or Linux
                String[] browsers = {
                "firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape" };
                String browser = null;
                for (int count = 0; count < browsers.length && browser == null; count++)
                    if (Runtime.getRuntime().exec(
                        new String[] {"which", browsers[count]}).waitFor() == 0)
                        browser = browsers[count];
                    if (browser == null)
                        throw new Exception("Could not find web browser");
                    else
                        Runtime.getRuntime().exec(new String[] {browser, url});
                    }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, errMsg + ":\n" + e.getLocalizedMessage());
        }
    }

}
