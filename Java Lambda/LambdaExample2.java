import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class AdvancedLambdaExample {
    public static void main(String[] args) {
        // Function örneği (String'i tersine çevirme)
        Function<String, String> reverseString = (str) -> new StringBuilder(str).reverse().toString();
        System.out.println(reverseString.apply("Lambda")); // Çıktı: adbmaL

        // BiFunction örneği (İki sayıyı toplama)
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(5, 3)); // Çıktı: 8

        // UnaryOperator örneği (Bir sayının karesini alma)
        UnaryOperator<Integer> square = x -> x * x;
        System.out.println(square.apply(5)); // Çıktı: 25

        // BinaryOperator örneği (İki stringi birleştirme)
        BinaryOperator<String> concatenate = (s1, s2) -> s1 + s2;
        System.out.println(concatenate.apply("Merhaba", " Dünya")); // Çıktı: Merhaba Dünya

        // Consumer örneği (Bir listeyi tersine çevirme ve yazdırma)
        Consumer<List<Integer>> reverseAndPrint = list -> {
            Collections.reverse(list);
            list.forEach(System.out::println);
        };
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        reverseAndPrint.accept(numbers); // Çıktı: 5 4 3 2 1

        // Supplier örneği (Rastgele bir isim oluşturma)
        Supplier<String> randomNameSupplier = () -> {
            List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill");
            return names.get(new Random().nextInt(names.size()));
        };
        System.out.println(randomNameSupplier.get()); // Çıktı: (Rastgele bir isim)

        // Predicate örneği (Bir sayının çift olup olmadığını kontrol etme)
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(isEven.test(4)); // Çıktı: true
        System.out.println(isEven.test(7)); // Çıktı: false

        // Optional örneği (Boş bir string kontrolü ve alternatif bir değer sağlama)
        Optional<String> optionalString = Optional.ofNullable(null);
        String result = optionalString.orElse("Boş");
        System.out.println(result); // Çıktı: Boş

        // Comparator örneği (İsimleri uzunluğuna göre sıralama)
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill", "Christopher", "Amanda");
        names.sort(Comparator.comparingInt(String::length).reversed());
        System.out.println(names); // Çıktı: [Christopher, Amanda, John, Jane, Jack, Jill]

        // Stream API Gelişmiş Örnekler
        // Harfleri büyük yapma ve sondaki "a" harfini çıkarma
        List<String> transformedNames = names.stream()
            .map(String::toUpperCase)
            .map(name -> name.endsWith("A") ? name.substring(0, name.length() - 1) : name)
            .collect(Collectors.toList());
        System.out.println(transformedNames); // Çıktı: [CHRISTOPHER, AMAND, JOHN, JANE, JACK, JILL]

        // Tüm isimlerin uzunluklarının toplamını hesaplama
        int totalLength = names.stream()
            .mapToInt(String::length)
            .sum();
        System.out.println("Total Length: " + totalLength); // Çıktı: Total Length: 28

        // İsmin uzunluğu 4 olanları toplayıp, geri kalanları baş harfine göre gruplama
        Map<Character, List<String>> groupedNames = names.stream()
            .filter(name -> name.length() != 4)
            .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println(groupedNames); // Çıktı: {C=[Christopher], A=[Amanda]}

        // Parçalı işlem: 5 karakterden uzun olan isimleri ayırıp, ilk 3'ünü alın
        List<String> longNames = names.stream()
            .filter(name -> name.length() > 5)
            .limit(3)
            .collect(Collectors.toList());
        System.out.println(longNames); // Çıktı: [Christopher, Amanda]

        // Paralel Stream kullanarak, sayıların karesini alıp yazdırma
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).parallelStream()
            .map(x -> x * x)
            .forEach(System.out::println); // Çıktı: (Sayıların kareleri, paralel olarak yazdırılır)

        // Stream'de herhangi bir elemanının belirli bir koşulu sağlayıp sağlamadığını kontrol etme
        boolean anyMatch = names.stream().anyMatch(name -> name.startsWith("C"));
        System.out.println("Any name starts with 'C': " + anyMatch); // Çıktı: Any name starts with 'C': true
    }
}
