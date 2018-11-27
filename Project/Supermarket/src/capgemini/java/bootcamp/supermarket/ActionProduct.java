package capgemini.java.bootcamp.supermarket;

public abstract class ActionProduct extends Product {
    protected String actionDescription;

    ActionProduct(String name, double price) {
        super(name, price);
        actionPrice();
    }

    protected double actionPrice() {
        return price;
    }
}
