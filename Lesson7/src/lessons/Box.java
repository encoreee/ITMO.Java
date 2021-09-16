package lessons;
import java.awt.desktop.AboutEvent;
import java.util.ArrayList;

public class Box extends Shape {

    ArrayList<Shape> shapes = new ArrayList<>();
    private double vol  = this.getVolume();

    public void Box()
    {
    }

    public boolean add_sh (Shape s1)
    {
        if (vol>s1.getVolume())
        {
            shapes.add(s1);
            vol = (vol - s1.getVolume());
            return true;
        }
        else
        {
            return false;
        }
    }
}
