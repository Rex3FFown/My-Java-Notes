package zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animals;

    public Zoo() {
        animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void makeAllAnimalsSound() {
        for (Animal animal : animals) {
            System.out.println(animal.getName() + ": ");
            animal.makeSound();
        }
    }
}
