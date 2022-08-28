package DPATRefined;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RealImage implements Image {
    private String fileName;
    private BufferedImage image = null;

    public RealImage(String fileName) throws IOException {
        this.fileName = fileName;
        getFile(fileName);
    }

    private void getFile(String fileName) throws IOException {
        File path = new File(System.getProperty("user.dir"));
        image = ImageIO.read(new File(path, fileName));
    }

    public void display(Graphics g, int x, int y, Color color) {
        g.drawImage(image, x, y, color, null);
    }
}
