package dimutils.imgpanel;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

/**
 * This worker opens the image and converts it into icon. Remember that this
 * is ONCE OFF object, which is only good for single download.
 * 
 * @author Dimitry Kireyenkov <dimitry@languagekings.com>
 */
public class MySwingWorker extends SwingWorker<Icon, Void>
{
    
    private final File mOriginalFile;
    private final IOnIconReady mOnIconReady;
            

    public MySwingWorker(File imageFileToLoadAsIcon, IOnIconReady callback) {
        mOriginalFile = imageFileToLoadAsIcon;
        if ( callback == null ){
            throw new NullPointerException();
        }
        mOnIconReady = callback;
    }


    
    
    /**
     * This one should actually create icon.
     * @return
     * @throws Exception 
     */
    @Override
    protected Icon doInBackground() throws Exception {
        System.out.println("doInBackground() for file: " + mOriginalFile.getAbsolutePath());
        Icon icon = createImageIconFromFile(mOriginalFile);
        
        if ( icon == null ){
            System.out.println("doInBackground(): couldn't create icon. NUll resulted.");
        }
        else{
            System.out.println("Created icon: height: " + icon.getIconHeight());
        }
        return icon;
    }

    @Override
    protected void done() {
        try {
            mOnIconReady.onIconReady(get());
            
        } catch (InterruptedException ex) {
            Logger.getLogger(MySwingWorker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(MySwingWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    /**
     * Attempts to create ImageIcon from file. Failable. Returns null on error.
     * @param f
     * @return
     * @throws MalformedURLException
     */
    public static ImageIcon createImageIconFromFile(File f) {
        try {
            URL imgURL = f.toURL();
            if (imgURL != null) {
                String descrForIcon = f.getAbsolutePath();
                return new ImageIcon(imgURL, descrForIcon);
            } else {
                System.err.println("Couldn't find file: " + f.getAbsolutePath());
                return null;
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(MySwingWorker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    
    public interface IOnIconReady{
        void onIconReady(Icon icon);
    }
    
}
