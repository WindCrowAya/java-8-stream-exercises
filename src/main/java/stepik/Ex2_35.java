package stepik;

import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;

public class Ex2_35 {
    /**
     * The operator combines all values in the given range into one value
     * using combiner and initial value (seed)
     */
    public static final BiFunction<Integer, IntBinaryOperator, IntBinaryOperator> reduceIntOperator =
            (seed, operation) -> (leftBorder, rightBorder) -> {
                int acc = seed;
                for (int i = leftBorder; i <= rightBorder; i++) {
                    acc = operation.applyAsInt(acc, i);
                }
                return acc;
            };

    /**
     * The operator calculates the sum in the given range (inclusively)
     */
    public static final IntBinaryOperator sumOperator =
            reduceIntOperator.apply(0, (x, y) -> x + y);

    /**
     * The operator calculates the product in the given range (inclusively)
     */
    public static final IntBinaryOperator productOperator =
            reduceIntOperator.apply(1, (x, y) -> x * y);


    public static void main(String[] args) {
        int left = 5,
            right = 6;

        System.out.println(sumOperator.applyAsInt(left, right));
        System.out.println(productOperator.applyAsInt(left, right));
    }
}
