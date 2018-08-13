package examples;

public class c3e6 {
    static long countOfLetters(String s) {
        return s.chars()
//                .filter(Character::isLetter)     //в ответах этого не было, видимо он не нужен
                .filter(Character::isLowerCase)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(
                countOfLetters("ab_Xd1w/2q")
        );
    }
}
