import java.util.stream.IntStream;

public class PrimeNumbersExample {
    public static void main(String[] args) {
        int limit = 10; // İlk 10 asal sayıyı bulalım

        IntStream.iterate(2, i -> i + 1)
            .filter(PrimeNumbersExample::isPrime)
            .limit(limit)
            .forEach(System.out::println); // Çıktı: 2, 3, 5, 7, 11, 13, 17, 19, 23, 29
    }

    public static boolean isPrime(int number) {
        return number > 1 && IntStream.range(2, number)
            .noneMatch(n -> number % n == 0);
    }
}
