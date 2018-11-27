import capgemini.java.bootcamp.supermarket.Product;
import capgemini.java.bootcamp.supermarket.Supermarket;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        intro();
        Supermarket superMarket = createSupermarket();
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> shoppingCart = CartAdding(superMarket, sc);
        System.out.println("----------");
        checkout(superMarket, shoppingCart);
    }


    static private void intro() {
        System.out.println("---------");
        System.out.println("-WELCOME-");
        System.out.println("---------");
        System.out.println("To the supermarket!\n");
    }


    static private Supermarket createSupermarket() {
        Supermarket supermarket = new Supermarket();
        return supermarket;
    }

    private static ArrayList<Product> CartAdding(Supermarket superMarket, Scanner sc) {
        ArrayList<Product> shoppingCart = new ArrayList<>();
        boolean addToCart = true;
        while (addToCart) {
            System.out.println("  | Type the NR of the product you want to ADD|");
            System.out.println("These are the products:");
            printSupermarket(superMarket);

            int input = InputMinMax(sc, 1, superMarket.getProductList().size());
            String productName = superMarket.getProductList().get(input - 1).getName();
            System.out.println("How many " + productName + " do you want to add?");
            int repeat = sc.nextInt();
            System.out.println("-Entered: " + Integer.toString(repeat) + "-");
            for (int i = 0; i < repeat; i++)
                shoppingCart.add(superMarket.addProduct(input - 1));
            System.out.println("--" + Integer.toString(repeat) + " " + productName + " added to cart!--");
            System.out.println("Do you want to add more? (Y/N)");
            addToCart = yesNo(sc);
        }
        return shoppingCart;
    }

    private static void printSupermarket(Supermarket supermarket) {
        int i = 1;
        for (Product product : supermarket.getProductList()) {
            //TODO: Table formatting stringbuilder append length
            System.out.println("  " + Integer.toString(i) + " " + product.getName() + "  -  " + doubleToCurrency(product.getPrice()));
            i++;
        }
    }

    private static void checkout(Supermarket superMarket, ArrayList<Product> shoppingCart) {
        System.out.println("-CHECKOUT-");
        System.out.println("----------");
        double toPay = superMarket.Checkout(shoppingCart);
        System.out.println("You have to pay: " + doubleToCurrency(toPay));
    }


    private static int InputMinMax(Scanner sc, int min, int max) {
        boolean correctInput = false;
        int input = 0;
        while (!correctInput && sc.hasNextInt()) {
            //while (sc.hasNextInt()) {
            input = sc.nextInt();
            System.out.println("-Entered: " + Integer.toString(input) + "-");
            //}
            if (input < min) {
                correctInput = false;
                System.out.println("Entered number is too low!");
            } else if (input > max) {
                correctInput = false;
                System.out.println("Entered number is too high!");
            } else {
                correctInput = true;
            }
        }

        return input;
    }

    static private boolean yesNo(Scanner sc) {
        boolean yesNo = false;
        boolean wrongInput = true;
        String input = sc.nextLine();
        while (wrongInput) {
            input = sc.nextLine();
            if (input.equalsIgnoreCase("y")) {
                wrongInput = false;
                yesNo = true;
            } else if (input.equalsIgnoreCase("n")) {
                wrongInput = false;
                yesNo = false;
            } else {
                wrongInput = true;
                System.out.println("I don't know that input");
            }
        }
        return yesNo;
    }

    private static String doubleToCurrency(double price) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(price);
    }

}
