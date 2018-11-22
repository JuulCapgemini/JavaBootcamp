package capgemini.academy.bootcamp.shape;

public class Rectangle implements Shape {

    double sides[] = new double[2];

    public Rectangle() {

        sides[0] = 10;
        sides[1]=5;
        System.out.println("This rectangle's area is: ");
        System.out.println(Double.toString(GetArea()));
    }

    @Override
    public double GetArea() {
        return sides[0]*sides[1];
    }
}
