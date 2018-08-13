package stepik;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex2_19 {
    public static IntStream createFilteringStream(IntStream evenStream, IntStream oddStream) {
        Stream<Integer> evenStreamNew = evenStream.boxed();
        Stream<Integer> oddStreamNew = oddStream.boxed();


        return Stream.concat(evenStreamNew, oddStreamNew)
                .filter(x -> x % 3 == 0 && x % 5 == 0)
                .sorted()
                .skip(2)
                .mapToInt(x -> x);
    }

    public static IntStream createFilteringStreamStepik(IntStream evenStream, IntStream oddStream) {
        return IntStream.concat(evenStream, oddStream)
                .filter(x -> x % 3 == 0 && x % 5 == 0)
                .sorted()
                .skip(2);
    }
}
