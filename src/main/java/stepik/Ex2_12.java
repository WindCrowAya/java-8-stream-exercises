package stepik;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.IntPredicate;

public class Ex2_12 {
    public static IntPredicate disjunctAll(List<IntPredicate> predicates) {
        IntPredicate result = predicates.get(0);
        for (int i = 1; i < predicates.size(); i++) {
            result = result.or(predicates.get(i));
        }
        return result;
    }

    public static void main(String[] args) {
        List<IntPredicate> predicates = new ArrayList<>();
        predicates.add(x -> x % 2 == 0);
        predicates.add(x -> x % 3 == 0);
        predicates.add(x -> x % 5 == 0);
        IntPredicate ip = disjunctAll(predicates);
        boolean result = ip.test(7);
        System.out.println(result);
    }

}
