package stepik;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex2_18 {
    public static Stream<String> createBadWordsDetectingStream(String text, List<String> badWords) {
        return Arrays.stream(text.split(" "))
                .filter(word -> {
                    for (String badWord : badWords) {
                        if (word.equals(badWord)) {
                            return true;
                        }
                    }
                    return false;
                })
                .distinct()
                .sorted();
    }

    public static Stream<String> createBadWordsDetectingStreamStepik(String text, List<String> badWords) {
        return Arrays.stream(text.split(" "))  //либо split("\\s")
                .filter(badWords::contains)
                .distinct()
                .sorted();
    }

    void a() {

    }
}
