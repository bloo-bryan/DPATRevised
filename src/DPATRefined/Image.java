package DPATRefined;

import java.awt.*;
import java.io.IOException;

public interface Image {
    void display(Graphics g, int x, int y, Color color) throws IOException;
}
