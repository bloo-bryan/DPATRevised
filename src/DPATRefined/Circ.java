package DPATRefined;

import java.awt.*;

public class Circ {
    private Color color = Color.black;

    public Circ(Color color) {
        this.color = color;
    }

    public void draw(Graphics g, int upperX, int upperY, int lowerX, int lowerY) {
        g.setColor(color);
        g.fillOval(upperX, upperY, lowerX, lowerY);
    }
}
