/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dimutils;

//import translation.model.TranslationServerException;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ernesto Guevara
 */
public class Utils {
    
    public static String readFile( String file ) throws IOException 
    {
        BufferedReader reader = new BufferedReader( new FileReader (file));
        String line  = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while( ( line = reader.readLine() ) != null ) {
            stringBuilder.append( line );
            stringBuilder.append( ls );
        }
        return stringBuilder.toString();
    }    
    
  public  static String stdin_read()
{
  try {
       java.io.BufferedReader stdin = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
       String line = stdin.readLine();
       return line;
  }
  
  catch (java.io.IOException e) { 
        System.out.println(e); 
  }
       
  return "";
} 
  
  
  
  
  
    /**
     * Translates text (using server) and returns jsonResponse string
     * @param text 
     * @return  jsonResponse text
     * @throws TranslationServerException 
     */
    public static String makeServerGETRequest(String urlStringBeforeQuestionMark, QueryString qs) throws IOException 
   {
        // build request from params
//        QueryString qs = new QueryString("text", text);
        qs.add("client", "t");
        qs.add("hl", "en");
//        qs.add("sl", _params.getSrcLang());
//        qs.add("tl", _params.getDestLang());
        qs.add("multires", "1");        
//        try {
                // send request
                URL url = new URL(urlStringBeforeQuestionMark + "?" + qs.toString());

                    // String getResponseBody = _gtranslateGETRequest();
                URLConnection conn = url.openConnection();
                conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:12.0) Gecko/20100101 Firefox/12.0");
                conn.setRequestProperty("Accept","text/html")   ;
                conn.setRequestProperty("Accept-Encoding", "deflate");
                conn.setRequestProperty("Accept-Language","en-us,en;q=0.5");
                conn.setRequestProperty("Referer","http://translate.google.com/");

                conn.setDoInput(true);
                conn.setDoOutput(false);

                InputStreamReader isr = new InputStreamReader( conn.getInputStream());
                BufferedReader bufread = new BufferedReader(isr);

                String line;
                StringBuilder b=  new StringBuilder();
                while ( (line = bufread.readLine()) != null)
                {
                    b.append(line);
                    System.out.println("readLine()>>>>" + line);
                }

                bufread.close();
                return b.toString();
//        } catch (IOException ex) {
//            Logger.getLogger(GTranslate.class.getName()).log(Level.SEVERE, null, ex);
//            throw new TranslationServerException("error with translating server:", ex);
//        }
        
        
        
    } 
    
    

    
        
    
            public static void throwDialog(String message)
            {

                JFrame jf = new JFrame();
                jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // looks like this is a blocking call
                JOptionPane.showMessageDialog(jf, message);
        //         JDialog dialog = new JDialog();
        //         dialog.setTitle(message);
        //         dialog.setVisible(true);

            }        



}// Utils.class





