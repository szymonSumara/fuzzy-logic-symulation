import javax.swing.*;

public class Simulation {
    Car car;
    Driver driver;
    Vector2d destination;
    SimulationWindow window;

    Simulation(Vector2d carPosition, Vector2d destinationPosition){
        this.destination = destinationPosition;
        this.car = new Car(carPosition);
        this.driver = new Driver();
        this.window = new SimulationWindow(this,car, destinationPosition);

    }

    public void simulationStep(){
        this.driver.setDistance(Vector2d.distanceBetween(this.car.position,this.destination));
        this.driver.setSpeed(this.car.speed);
        this.driver.setAngle(Vector2d.angleBetween(this.car.position,this.car.nextMoveCourse(), this.destination));
        this.driver.evaluate();
        this.car.increaseSpeed(this.driver.getAcceleration());
        this.car.increaseTheta(this.driver.getWellRotation());

        if(this.car.speed < 0)
            this.car.speed = 0;
        this.car.move();
    }


    public void run(){
        for (int i = 0;  ; i++) {
            simulationStep();
            try {
                Thread.sleep(16);
            }catch (InterruptedException e){

            }
        }
    }

    public void updateDestination(Vector2d vector2d){
        this.destination = vector2d;
    }



}
