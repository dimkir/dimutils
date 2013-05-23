/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dimutils;

//import dimitry.java.utils.Utils.QueryString;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ernesto Guevara
 */
public class BackgroundGETRequest  implements Runnable
{
    QueryString _qs;
    String _urlStringBeforeQuestionMark;

    public BackgroundGETRequest(String urlStringBeforeQuestionMark, QueryString qs)
    {
        _urlStringBeforeQuestionMark = urlStringBeforeQuestionMark;
        _qs = qs;
    }

    
    
    
    @Override
    public void run() {
        try {
            Utils.makeServerGETRequest(_urlStringBeforeQuestionMark, _qs);
        } catch (IOException ex) {
            Logger.getLogger(BackgroundGETRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    
    
    public static void launchGETRequestBGTread(String urlStringBeforeQuestionMark, QueryString qs)
    {
        BackgroundGETRequest bgreq = new BackgroundGETRequest(urlStringBeforeQuestionMark, qs);
        Thread t = new Thread(bgreq);
        t.start();
    }
    
}
