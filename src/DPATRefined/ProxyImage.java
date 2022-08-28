package DPATRefined;

import java.awt.*;
import java.io.IOException;

public class ProxyImage implements Image {
    private static RealImage image;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display(Graphics g, int x, int y, Color color) throws IOException {
        if(image == null) image = new RealImage(fileName);
        image.display(g, x, y, color);
    }
}
