package capgemini.academy.bootcamp.inheritance;

public class ReptileChecker implements AnimalChecker {
    public boolean Check(Animal animal) {
        return animal instanceof Reptile;
    }
}
