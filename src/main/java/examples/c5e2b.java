package examples;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class c5e2b {
    public Map<String, Long> count(List<String> words) {  //совпал с ответом
        return words.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
    }

    public static void main(String[] args) {
        Stream<String> names = Stream.of("John", "Paul", "George", "John", "Paul", "John");

        System.out.println(new c5e2b().count(names.collect(Collectors.toList())));
    }
}
