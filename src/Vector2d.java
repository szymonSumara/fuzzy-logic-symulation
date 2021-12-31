import java.util.Vector;

public class Vector2d {
    public final double x;
    public final double y;

    Vector2d(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x, this.y + other.y);
    }

    public Vector2d scalarMull(double scalar){
        return new Vector2d(this.x * scalar, this.y * scalar);
    }

    static double distanceBetween(Vector2d first, Vector2d second){

        return Math.sqrt((first.x - second.x)*(first.x - second.x) + (first.y - second.y)*(first.y - second.y));

    }

    public double length(){
        return Math.sqrt(x*x + y*y);
    }

    static double dotProduct(Vector2d first, Vector2d second){
        return first.x * second.x + first.y * second.y;
    }

    static double angleBetween(Vector2d first, Vector2d second){

        //double direction = dotProduct(, )
//        System.out.println(dotProduct(first,second));
//        System.out.println(first.length());
//        System.out.println(second.length());
//        System.out.println(dotProduct(first,second)/ (first.length()* second.length()));
        double angle = Math.toDegrees(Math.acos(dotProduct(first,second)/ (first.length()* second.length())));
        return angle;
    }

    static double angleBetween(Vector2d a,Vector2d b,Vector2d c){
        double determinant = a.x * b.y + b.x * c.y + c.x * a.y - a.x*c.y  - b.x*a.y - c.x*b.y;
        double angle = 180 - angleBetween(new Vector2d(a.x - b.x, a.y - b.y),new Vector2d(c.x - b.x , c.y - b.y));
        if(determinant > 0)
            return angle;
        return -1*angle;
    }


    @Override
    public String toString() {
        return "Vector2d{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
