import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.List;

public class Car {
    public Vector2d position;
    public double speed;
    public double wellTurn;
    public double r = 1;
    public double theta;
    LocalDateTime lastUpdate = LocalDateTime.now();

    Car(Vector2d startPosition){
        this.position = startPosition;
        this.r = 1;
        this.theta = Math.toRadians(179);
        this.speed = 0;
        this.wellTurn = 0;
    }

    public void increaseSpeed(double acceleration){
        LocalDateTime now = LocalDateTime.now();
        long diff = ChronoUnit.MILLIS.between(lastUpdate,now);
        this.speed += acceleration*((float)diff/1000);

    }

    public void increaseTheta(double turn){
        LocalDateTime now = LocalDateTime.now();
        long diff = ChronoUnit.MILLIS.between(lastUpdate,now);
        this.theta +=  Math.toRadians(turn*((float)diff/1000));
        if(theta > Math.PI) this.theta -= 2*Math.PI;
        if(theta < -1*Math.PI) this.theta += 2*Math.PI;

    }

    public void move(){

        LocalDateTime now = LocalDateTime.now();
        long diff = ChronoUnit.MILLIS.between(lastUpdate,now);
        lastUpdate = now;
        Vector2d course = new Vector2d(Math.cos(theta)*r,Math.sin(theta)*r);

        this.position = this.position.add(course.scalarMull(this.speed*((float)diff/1000)));
    }

    public Vector2d nextMoveCourse(){
        Vector2d course = new Vector2d(Math.cos(theta)*r,Math.sin(theta)*r);
        return this.position.add(course.scalarMull(this.speed + 1));
    }


    @Override
    public String toString() {
        return this.speed + " ";
    }
}
