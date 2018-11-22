package capgemini.academy.bootcamp.shape;

public class Circle implements Shape {
    double diameter;

    public Circle() {
        diameter = 10;
        System.out.println("This circle's area is: ");
        System.out.println(Double.toString(GetArea()));
    }

    @Override
    public double GetArea() {

        return Math.pow(diameter,2)*Math.PI/4;
    }
}
