package frameLab;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Олег on 12.10.2014.
 */

public class ImagePanel extends JPanel {

    private Image formulaImage;

    public Image getImage() {
        return formulaImage;
    }

    public void setImage(Image image) {
        this.formulaImage = image;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(formulaImage != null){
            g.drawImage(formulaImage, 0, 0, getWidth(), getHeight(), null);
        }
    }
}