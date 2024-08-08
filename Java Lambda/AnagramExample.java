import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnagramExample {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("listen", "silent", "enlist", "rat", "tar", "god", "dog");

        Map<String, List<String>> anagrams = words.stream()
            .collect(Collectors.groupingBy(
                word -> word.chars().sorted()
                    .mapToObj(c -> String.valueOf((char) c))
                    .collect(Collectors.joining())
            ));

        anagrams.forEach((key, value) -> System.out.println(key + ": " + value));
        // Çıktı:
        // eilnst: [listen, silent, enlist]
        // art: [rat, tar]
        // dgo: [god, dog]
    }
}
