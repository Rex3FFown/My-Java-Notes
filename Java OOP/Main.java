package zoo;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Lion lion = new Lion("Leo", 5);
        Elephant elephant = new Elephant("Ella", 10);

        zoo.addAnimal(lion);
        zoo.addAnimal(elephant);

        zoo.makeAllAnimalsSound();
    }
}
