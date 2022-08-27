package DPATRefined;

import java.awt.*;

public abstract class ShapeStrategy {
    abstract void draw(Graphics g, int upperX, int upperY, int lowerX, int lowerY);
}
