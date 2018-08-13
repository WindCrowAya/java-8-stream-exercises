package examples;

import classes.Artist;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

// LongestName
public class c5e2a {

    //мой вариант, далеко не самый лучший
    public String byReduce(List<String> artists) {
        return artists.stream()
                .reduce("", (acc, artist) -> artist.length() > acc.length() ? artist : acc);
    }

    //мой вариант, немного получше
    public String byReduce2(List<String> artists) {
        return artists.stream()
                .reduce((acc, artist) -> artist.length() > acc.length() ? artist : acc).get();
    }

    //из ответов
    private static Comparator<Artist> byNameLength = comparing(artist -> artist.getName().length());

    public static Artist byReduceFA(List<Artist> artists) {
        return artists.stream()
                .reduce((acc, artist) -> (byNameLength.compare(acc, artist) >= 0) ? acc : artist)
                .orElseThrow(RuntimeException::new);
    }

    //мой вариант, практически совпал с ответом
    public String byCollector(List<String> artists) {
        Function<String, Integer> length = String::length;
        return artists.stream()
                .collect(Collectors.maxBy(comparing(length))).get();
    }

    //из ответов
    public static Artist byCollecting(List<Artist> artists) {
        return artists.stream()
                .collect(Collectors.maxBy(byNameLength))
                .orElseThrow(RuntimeException::new);
    }

    public static void main(String[] args) {
        Stream<String> names = Stream.of("John  Lennon",  "Paul  McCartney", "George  Harrison",
                                         "Ringo  Starr", "Pete  Best",  "Stuart  Sutcliffe");
        List<String> artists = names.collect(Collectors.toList());

        System.out.println(new c5e2a().byReduce(artists));
        System.out.println(new c5e2a().byReduce2(artists));
        System.out.println(new c5e2a().byCollector(artists));
    }
}
