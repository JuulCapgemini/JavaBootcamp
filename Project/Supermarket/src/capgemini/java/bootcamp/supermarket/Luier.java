package capgemini.java.bootcamp.supermarket;

public class Luier extends ActionProduct {
    private static int luierTotal;

    Luier(String name, double price) {
        super(name, price);
        luierTotal++;
        actionDescription = "4 halen, 3 betalen!";
        //actionPrice();
    }

    protected double actionPrice() {
        //FREE!?
        //System.out.println("action for luier");
        if (luierTotal == 4) {
            //System.out.println("You got a free luier!");
            discount = price;
            price = 0;
            luierTotal = 0;
        }
        return price;
    }

    @Override
    public Product Clone() {
        return new Luier(name, price);
    }
}
