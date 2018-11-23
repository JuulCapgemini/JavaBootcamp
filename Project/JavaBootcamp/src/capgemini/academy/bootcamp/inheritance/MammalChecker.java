package capgemini.academy.bootcamp.inheritance;

public class MammalChecker implements AnimalChecker {
    public boolean Check(Animal animal) {
        return animal instanceof Mammal;
    }
}
