import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByLetterCount {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");

        Map<Integer, List<String>> groupedByLength = words.stream()
            .collect(Collectors.groupingBy(String::length));

        System.out.println(groupedByLength);
        // Çıktı:
        // {3=[fig], 4=[date], 5=[apple, grape], 6=[banana, cherry], 10=[elderberry]}
    }
}