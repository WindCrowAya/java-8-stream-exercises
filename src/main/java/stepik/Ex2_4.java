package stepik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex2_4 {
    private static long test() {
        long x = 5L,
             y = 15L;

        List<Long> list = new ArrayList<>();
        for (long i = x; i <= y; i++) {
            list.add(i);
        }

//        long[] arr = new long[(int) (y-x+1)];
//
//        Arrays.stream(arr).


//        Arrays.stream(x.toArray()).distinct().collect(Collectors.toList());

        return list.stream()
                   .reduce(1L, (acc, element) -> acc * element);
    }

//    (x,y) -> {
//        List<Long> list = new ArrayList<>();
//        for (long i = x; i < y; i++) {
//            list.add(i);
//        }
//        return list.stream()
//                .reduce(1L, (acc,element) -> acc * element);
//    };

//    (x,y) -> {
//        long[] arr = new long[(int) (y-x+1)];
//        long temp = x;
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = temp++;
//        }
//        return Arrays.stream(arr)
//                .reduce(1L, (acc,element) -> acc * element);
//    };

//    String x = "aaa".compareTo()

    public static void main(String[] args) {
        System.out.println(test());
    }
}
