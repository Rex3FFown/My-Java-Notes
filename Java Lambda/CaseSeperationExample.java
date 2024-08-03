import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CaseSeparationExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("HELLO", "world", "JAVA", "programming", "LAMBDA", "example");

        Map<Boolean, List<String>> partitioned = words.stream()
            .collect(Collectors.partitioningBy(word -> word.equals(word.toUpperCase())));

        System.out.println("Uppercase words: " + partitioned.get(true));  // Çıktı: Uppercase words: [HELLO, JAVA, LAMBDA]
        System.out.println("Lowercase words: " + partitioned.get(false)); // Çıktı: Lowercase words: [world, programming, example]
    }
}
