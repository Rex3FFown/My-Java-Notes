import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExample {
    public static void main(String[] args) {
        // Function örneği
        Function<Integer, String> intToString = (num) -> "Sayı: " + num;
        System.out.println(intToString.apply(10)); // Çıktı: Sayı: 10

        // Consumer örneği
        Consumer<String> printMessage = (message) -> System.out.println(message);
        printMessage.accept("Merhaba, Lambda!"); // Çıktı: Merhaba, Lambda!

        // Supplier örneği
        Supplier<Double> randomValue = () -> Math.random();
        System.out.println(randomValue.get()); // Çıktı: (0.0 ile 1.0 arasında rastgele bir sayı)

        // Predicate örneği
        Predicate<String> isNotEmpty = (str) -> !str.isEmpty();
        System.out.println(isNotEmpty.test("Merhaba")); // Çıktı: true
        System.out.println(isNotEmpty.test(""));        // Çıktı: false

        // Stream API örneği
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill");

        // Filtreleme
        names.stream()
            .filter(name -> name.startsWith("J"))
            .forEach(System.out::println); // Çıktı: John, Jane, Jack, Jill

        // Dönüştürme
        List<Integer> nameLengths = names.stream()
            .map(String::length)
            .toList();
        System.out.println(nameLengths); // Çıktı: [4, 4, 4, 4]
    }
}
