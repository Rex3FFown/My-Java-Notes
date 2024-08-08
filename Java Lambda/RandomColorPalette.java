import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomColorPalette {
    public static void main(String[] args) {
        Supplier<String> randomColor = () -> {
            Random rand = new Random();
            return String.format("#%02X%02X%02X", rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        };

        List<String> colorPalette = Stream.generate(randomColor)
            .limit(5) // 5 renk oluşturalım
            .collect(Collectors.toList());

        colorPalette.forEach(System.out::println);
        // Çıktı: Rastgele 5 renk kodu, örn: #4F1D76, #B2D123, ...
    }
}