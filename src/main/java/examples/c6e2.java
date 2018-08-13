package examples;

import java.util.LinkedList;
import java.util.List;

public class c6e2 {
    public static int multiplyThrough(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.stream()
                .reduce(5, (acc, x) -> x * acc);
    }

    public static int multiplyThroughParallel(List<Integer> linkedListOfNumbers) {  //совпал с ответом
        return 5 * linkedListOfNumbers.stream().parallel()
                .reduce(1, (acc, x) -> x * acc);
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i < 7; i++) {
            list.add(i);
        }

        list.forEach(System.out::println);

        int result1 = multiplyThrough(list);
        int result2 = multiplyThroughParallel(list);

        System.out.println("\n" + result1);
        System.out.println("\n" + result2);
    }
}