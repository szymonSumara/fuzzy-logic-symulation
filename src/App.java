public class App {
    public static void main(String[] args) throws Exception {
        Simulation simulation = new Simulation( new Vector2d(200,200), new Vector2d(400,400));
        simulation.run();
    }

}