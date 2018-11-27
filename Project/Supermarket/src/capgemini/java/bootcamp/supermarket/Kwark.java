package capgemini.java.bootcamp.supermarket;

public class Kwark extends ActionProduct {

    Kwark(String name, double price) {
        super(name, price);
        actionDescription = "On wednesdays only 1 euro!";
        //actionPrice();
    }

    protected double actionPrice() {
        System.out.println("action for kwark");
        return price;
    }

    @Override
    public Product Clone() {
        return new Kwark(name,price);
    }
}
