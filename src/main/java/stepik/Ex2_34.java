package stepik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Ex2_34 {
    /**
     * The function accepts a list of mappers and returns an operator that accepts a list of integers
     * and sequentially applies each mapper to each value (perform a transformation)
     */
    public static final Function<List<IntUnaryOperator>, UnaryOperator<List<Integer>>> multifunctionalMapper =
            operators -> elements ->
//                List<Integer> result = new ArrayList<>();
                elements.stream()
                        .map(num -> {
                            for (IntUnaryOperator operator : operators) {
                                num = operator.applyAsInt(num);
                            }
                            return num;
                        })

//                        .map(num -> {
//                            List<Integer> tempList = new ArrayList<>();
//                            operators.forEach(operator -> tempList.add(operator.applyAsInt(num)));
//                            return tempList.get(tempList.size() - 1);
//                        })

//                        .peek(num -> {
//                            List<Integer> tempList = new ArrayList<>();
//                            operators.forEach(operator -> tempList.add(operator.applyAsInt(num)));
//                            result.add(tempList.get(tempList.size() - 1));
//                        })

                        .collect(Collectors.toList());
//                return result;

    /**
     * EXAMPLE: the operator transforms each number to the same number (perform the identity transformation)
     *
     * It returns a list of the same numbers.
     */
    public static final UnaryOperator<List<Integer>> identityTransformation =
            multifunctionalMapper.apply(Arrays.asList(x -> x, x -> x, x -> x));

    /**
     * The operator accepts an integer list.
     * It multiplies by two each integer number and then add one to its.
     *
     * The operator returns transformed integer list.
     */
    public static final UnaryOperator<List<Integer>> multTwoAndThenAddOneTransformation =
            multifunctionalMapper.apply(Arrays.asList(x -> x * 2 + 1));

    /**
     * The operator accepts an integer list.
     * It squares each integer number and then get the next even number following it.
     *
     * The operator returns transformed integer list.
     */
    public static final UnaryOperator<List<Integer>> squareAndThenGetNextEvenNumberTransformation =
            multifunctionalMapper.apply(Arrays.asList(x -> x*x % 2 == 0 ? x*x + 2 : x*x + 1));


    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        List<Integer> idTransformation = identityTransformation.apply(numbers);
        List<Integer> multTwoAndThenAddOneTransformationTest = multTwoAndThenAddOneTransformation.apply(numbers);
        List<Integer> squareAndThenGetNextEvenNumberTransformationTest = squareAndThenGetNextEvenNumberTransformation.apply(numbers);

        System.out.println(idTransformation);
        System.out.println(multTwoAndThenAddOneTransformationTest);
        System.out.println(squareAndThenGetNextEvenNumberTransformationTest);
    }
}
