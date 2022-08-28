package DPATRefined;

import java.awt.*;

public class Rect {
    private Color color = Color.black;

    public Rect(Color color) {
        this.color = color;
    }

    public void draw(Graphics g, int upperX, int upperY, int lowerX, int lowerY) {
        g.setColor(color);
        g.fillRect(upperX, upperY, lowerX, lowerY);
    }
}
