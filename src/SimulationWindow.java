import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SimulationWindow extends JFrame  {
    SimulationCanvas canvas;
    Simulation parent;
    SimulationWindow(Simulation parent, Car car , Vector2d destination){
        super();
        this.parent = parent;
        canvas = new SimulationCanvas(this, car, destination);

        add(canvas);
        canvas.setBackground(Color.black);
        setSize(1376,720);
        setVisible(true);//making the frame visible

    }

    public void updateDestination(Vector2d vector2d){
        parent.updateDestination(vector2d);
    }
}

