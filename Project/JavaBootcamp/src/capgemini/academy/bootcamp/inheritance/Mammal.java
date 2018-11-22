package capgemini.academy.bootcamp.inheritance;

public abstract class Mammal extends capgemini.academy.bootcamp.inheritance.Animal {
    public Mammal(String name, int children) {
        super(name, children,"Mammal");
    }

    @Override
    protected void GiveBirth() {
        System.out.println("The " + Name + " gave birth to " + Integer.toString(Children)+" "+Name+"s.");
    }
}
