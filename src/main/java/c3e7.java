import java.util.*;

public class c3e7 {
    static Optional<String> stringWithMaxNumberOfLetters(List<String> list) {
        return list.stream()
                .max(Comparator.comparing(c3e6::countOfLetters));
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("aBc");
        list.add("w1w23e");
        list.add("1Q22r42");
        list.add("123Y");

        System.out.println(
                stringWithMaxNumberOfLetters(list)
        );
    }
}
