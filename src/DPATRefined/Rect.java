package DPATRefined;

import java.awt.*;

public class Rect extends ShapeStrategy {
    private Color color = Color.black;
    private int x, y, x2, y2;

    public Rect(Color color) {
        this.color = color;
    }

    public void draw(Graphics g, int upperX, int upperY, int lowerX, int lowerY) {
        g.setColor(color);
        g.fillRect(upperX, upperY, lowerX, lowerY);
    }
}
