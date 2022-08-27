package DPATRefined;

import java.util.HashMap;
import java.awt.Color;
public class RectangleFactory {
    private static final HashMap<Color, Rect> rectanglesByColor = new HashMap<>();

    public static Rect getRect(Color color) {
        Rect rect = (Rect)rectanglesByColor.get(color);
        if(rect == null) {
            rect = new Rect(color);
            rectanglesByColor.put(color, rect);
        }
        return rect;
    }
}
