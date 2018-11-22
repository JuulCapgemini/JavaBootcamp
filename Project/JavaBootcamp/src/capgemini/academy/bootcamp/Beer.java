package capgemini.academy.bootcamp;

public class Beer {

    private int maxBeers = 99;
    private int beer = maxBeers;

    public Beer() {
        while (beer >= 0) {

            if (beer < 1) {
                System.out.println("No more bottles of beer on the wall, no more bottles of beer.");
                System.out.println("Go to the store and buy some more, 99 bottles of beer on the wall.");
                beer--;
            } else {
                if (beer == 1)
                    System.out.println(Integer.toString(beer) + " bottle of beer on the wall, " + Integer.toString(beer) + " bottle of beer.");
                else
                    System.out.println(Integer.toString(beer) + " bottles of beer on the wall, " + Integer.toString(beer) + " bottles of beer.");
                beer--;
                if (beer == 1)
                    System.out.println("Take one down and pass it around, " + Integer.toString(beer) + " bottle of beer on the wall");
                else if (beer < 1)
                    System.out.println("Take one down and pass it around, " + "No more bottles of beer on the wall");
                else
                    System.out.println("Take one down and pass it around, " + Integer.toString(beer) + " bottles of beer on the wall");
            }
        }
    }

}
