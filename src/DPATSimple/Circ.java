package DPATSimple;

import java.awt.*;

public class Circ {
    private Color color = Color.black;
    private int x, y, x2, y2;

    public Circ(Color color, int upperX, int upperY, int lowerX, int lowerY) {
        this.color = color;
        this.x = upperX;
        this.y = upperY;
        this.x2 = lowerX;
        this.y2 = lowerY;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, x2, y2);
    }
}
