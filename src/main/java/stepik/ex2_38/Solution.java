package stepik.ex2_38;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Solution {
    private static final Set<User> users = new HashSet<>();

    public static Optional<User> findUserByLogin(String login) {
        return users.stream()
                .filter(user -> user.getLogin().equals(login))
                .findAny();
    }

    public static void printBalanceIfNotEmpty(String userLogin) {
        findUserByLogin(userLogin)
                .ifPresent(user -> {
                    if (user.getAccount() != null && user.getAccount().getBalance() > 0) {
                        System.out.println(user.getLogin() + ": " + user.getAccount().getBalance());
                    }
                });

//        User user = Optional.ofNullable(findUserByLogin(userLogin)).get().get();
//        if (user.getAccount() != null && user.getAccount().getBalance() < 0) {
//            System.out.println(user.getLogin() + ": " + user.getAccount().getBalance());
//        }

//                .ifPresent(user -> {
//                    if (user.getAccount() != null && user.getAccount().getBalance() > 0) {
//                        System.out.println(user.getLogin() + ": " + user.getAccount().getBalance());
//                    }
//                });
    }
}
