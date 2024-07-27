import java.util.function.Supplier;
import java.util.stream.Stream;

public class FibonacciExample {
    public static void main(String[] args) {
        // İlk 10 Fibonacci sayısını hesaplayalım
        Supplier<Stream<Long>> fibonacci = () -> Stream.iterate(new long[]{0, 1},
                f -> new long[]{f[1], f[0] + f[1]})
                .map(f -> f[0]);

        fibonacci.get()
                .limit(10)
                .forEach(System.out::println); // Çıktı: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
    }
}