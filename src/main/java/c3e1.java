import java.util.stream.Stream;

//Функция сложения чисел
public class c3e1 {
    static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (acc, element) -> acc + element);  //identity - начальное значение
    }

    public static void main(String[] args) {
        System.out.println(
                addUp(Stream.of(1,2,3,4))
        );
    }
}
