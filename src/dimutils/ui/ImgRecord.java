/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dimutils.ui;

import java.io.File;
import javax.swing.Icon;

/**
 * This structure should only be added to the model, when it's initialized with VALID icon.
 * 
 * @author Dimitry Kireyenkov <dimitry@languagekings.com>
 */
public class ImgRecord {

    
    /**
     * Important to initialize it with VALID icon.
     * 
     * @param validIcon 
     * @param originalFilepath just for information, filepath of the original icon. ??
     *          NOT NULL!
     */
    ImgRecord(Icon validIcon, File originalFilepath){
        this(validIcon);
        throw new UnsupportedOperationException("not implementd yet");
    }
    private Icon Icon;

    ImgRecord(Icon icon) {
        Icon = icon;
    }

    /**
     * Get the value of Icon
     *
     * @return the value of Icon
     */
    public Icon getIcon() {
        return Icon;
    }
}
