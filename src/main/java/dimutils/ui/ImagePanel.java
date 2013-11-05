package dimutils.ui;

import dimutils.Utils;
import java.io.File;

/**
 *
 * @author Dimitry Kireyenkov <dimitry@languagekings.com>
 */
public class ImagePanel extends javax.swing.JPanel {

    /**
     * Creates new form ImagePanel
     */
    public ImagePanel() {
        initComponents();
        
        jList1.setCellRenderer(new MyListCellRenderer());
        jList1.setModel(new MyListModel());
        jList1.setVisibleRowCount(-1);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    /**
     * Adds images from files.
     * @param imageFiles list of "potential image file candidates", which means that these should be list
     *          of image files you want to load. Of course some of the files may be of unsupported format,
     *          or may be corrupted. In this case the list will show a placeholder for the image.
     */
    public void addImagesFromFiles(File[] imageFiles) {
        // TODO: implement addImagesFromFiles
        MyListModel myListModel = (MyListModel) jList1.getModel();
        myListModel.addImageFiles(imageFiles);
    }
    
    
    
    /**
     * Loads images into the list view.
     * 
     * @param dir 
     */
    public void loadImagesFromDir(File dir) {
        
        File[] imageFiles = Utils.filterImageFiles(dir);
        
        for (File file : imageFiles) {
            System.out.println("Found image: " + file.getAbsolutePath());
        }
        this.addImagesFromFiles(imageFiles);
    }    
}