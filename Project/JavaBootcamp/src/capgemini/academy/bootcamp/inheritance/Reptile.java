package capgemini.academy.bootcamp.inheritance;
public abstract class Reptile extends capgemini.academy.bootcamp.inheritance.Animal {
    public Reptile(String name, int children) {
        super(name, children,"Reptile");
    }

    @Override
    protected void GiveBirth()
    {
        System.out.println("The "+Name+" laid "+Integer.toString(Children)+" eggs.");
    }
}
