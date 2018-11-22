package capgemini.academy.bootcamp.inheritance;

public abstract class Animal {
    int Children = 0;
    String Name = "Animal";
    String animalKind = "Unknown";
    public static int animalCount = 0;

    public Animal(String name, int children, String kind) {
        Name = name;
        Children = children;
        animalKind = kind;
        animalCount++;
    }

    public void Breed() {
        System.out.println("Two " + Name + "s are breeding...");
        for (int i = 0; i < 4; i++) {

            int ranNr = capgemini.academy.bootcamp.RandomFunctions.RandomRangeInt(0, 100);
            if (ranNr < 10) {
                System.out.println("This may take a while...");
            } else {
                System.out.println("...");
            }

            //Delay
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                System.out.println("Caught an error sleep interrupted");
            }
        }
        GiveBirth();
    }

    protected abstract void GiveBirth();

    public String GetAnimalKind() {
        return animalKind;
    }

    public String GetName() {
        return Name;
    }

}
