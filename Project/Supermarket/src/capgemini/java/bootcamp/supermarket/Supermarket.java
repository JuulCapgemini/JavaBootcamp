package capgemini.java.bootcamp.supermarket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Supermarket {
    private ArrayList<Product> products = new ArrayList<>();

    public Supermarket() {
        products.add(new Product("Robijn", 3.00));//(31% korting bij aanschaf van 2x flacons)
        products.add(new Product("Brinta", 2.50));
        products.add(new Product("Chinese Groenten", 5.00));
        products.add(new Kwark("Kwark", 2.00));//(op woensdagen in de aanbieding voor 1 euro)
        products.add(new Luier("Luier", 10.00));//(4 halen, 3 betalen)
    }

    public Product addProduct(int productNr) {
        Product stockProduct = products.get(productNr);

        return products.get(productNr).Clone();
        //return new Product(stockProduct.getName(), stockProduct.getPrice());
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(products);
    }

    public double Checkout(List<Product> cart) {
        double price = 0;
        for (Product product : cart) {
            price+=product.getPrice();
        }
        return price;
    }
}
