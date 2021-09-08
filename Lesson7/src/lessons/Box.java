package lessons;

import java.awt.desktop.AboutEvent;

public class Box extends Shape {

    double limit;


    public Box(double volume) {
        limit = volume;
    }

    boolean add(Shape s) {
        if ((volume + s.volume) < limit) {
            return true;
        } else {
            return false;
        }
    }
}
