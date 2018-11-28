package capgemini.java.bootcamp.supermarket;

public class Product implements Cloneable {
    protected String name;
    protected double price;
    protected double discount = 0;

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public double getDiscount() {
        return this.discount;
    }

    public Product Clone() {
        return new Product(name, price);
    }
}
