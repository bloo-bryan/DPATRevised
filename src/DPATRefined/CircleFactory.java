package DPATRefined;

import java.awt.*;
import java.util.HashMap;

public class CircleFactory {
    private static final HashMap<Color, Circ> circlesByColor = new HashMap<>();

    public static Circ getCirc(Color color) {
        Circ circ = circlesByColor.get(color);
        if(circ == null) {
            circ = new Circ(color);
            circlesByColor.put(color, circ);
        }
        return circ;
    }
}