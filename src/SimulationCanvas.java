import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

public class SimulationCanvas extends JPanel implements  MouseListener {

    private Car car;
    private  Vector2d destination;
    private SimulationWindow parent;
    private Vector2d nextCourse;
    public SimulationCanvas(SimulationWindow parent, Car car, Vector2d destination){
        super();
        this.parent = parent;
        this.car = car;
        this.destination =destination;

        System.out.println("Canvas");
        Timer timer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // mouseEntered(new MouseEvent(parent, 0,0, 0, 0, 0, 0, true));
                repaint();
            }
        });
        timer.start();
        addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        this.nextCourse = this.car.nextMoveCourse();

        Graphics2D g2d = (Graphics2D) g.create();
        super.paint(g2d);
        // draw a string
        g2d.setColor(Color.CYAN);

        g2d.drawString("Car parameters: ", 10, 20);
        String speed =       String.format("%.2f", this.car.speed);
        String theta =       String.format("%.2f", this.car.theta);


        g2d.drawString("Speed: " + speed, 10, 40);
        g2d.drawString("Theta: " + theta, 10, 60);

        g2d.drawOval((int)this.car.position.x - 10, (int)this.car.position.y - 10, 20, 20);
        g2d.drawLine((int)this.car.position.x , (int)this.car.position.y , (int)this.nextCourse.x , (int)this.nextCourse.y );
        g2d.drawOval((int)this.destination.x - 10, (int)this.destination.y - 10, 20, 20);
        //g2d.dispose();


        // set Font

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        this.destination = new Vector2d(e.getX(), e.getY());
        parent.updateDestination(new Vector2d(e.getX(), e.getY()));
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getX() + " : " +e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println(e.getX() + " : " +e.getY());
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println(e.getX() + " : " +e.getY());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println(e.getX() + " : " +e.getY());
    }
}
