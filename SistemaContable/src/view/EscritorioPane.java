package view;

import java.awt.*;
import javax.swing.*;

public class EscritorioPane extends JDesktopPane {

    private Image backgroundImage;

    public EscritorioPane(Image backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        } else {
            // Display a message or handle the case when the image is not found
            g.drawString("Background image not found", getWidth() / 2 - 50, getHeight() / 2);
        }
    }

    public boolean isBackgroundImageLoaded() {
        return backgroundImage != null;
    }
}
