package stepik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.LongStream;

public class Ex2_17 {
    public static boolean isPrime(final long number) {
        return LongStream.range(2, number).noneMatch(x -> number % x == 0);
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Введите число: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean result = isPrime(Long.parseLong(reader.readLine()));
        System.out.println(result);
    }
}
