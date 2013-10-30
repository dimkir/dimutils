package dimutils.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.Icon;

/**
 * This will be a funny model, which knows how to load images.
 * 
 * @author Dimitry Kireyenkov <dimitry@languagekings.com>
 */
public class MyListModel extends AbstractListModel<ImgRecord>  
                        implements MySwingWorker.IOnIconReady
                           
{
    private final List<ImgRecord> mImageRecords = new ArrayList<ImgRecord>();

    

    /**
     * Adds image files to the model.s
     * @param imageFiles 
     */
    void addImageFiles(File[] imageFiles) {
        // TODO: implement addImageFiles
        for (File img : imageFiles) {
            System.out.println("Starting worker thread for file: " + img.getAbsolutePath());
            (new MySwingWorker(img, this)).execute();
        }
    }


    void addIcon(Icon icon){
        System.out.println("Receiving icon: "+  icon.getIconHeight() );
        mImageRecords.add(new ImgRecord(icon));
        fireIntervalAdded(this, getSize()-2, getSize() -1);
    }


    @Override
    public void onIconReady(Icon icon) {
        addIcon(icon);
    }

    @Override
    public int getSize() {
        return mImageRecords.size();
    }

    @Override
    public ImgRecord getElementAt(int index) {
        return mImageRecords.get(index);
    }
    
}
