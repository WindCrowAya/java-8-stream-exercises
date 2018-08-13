package examples;

import java.util.HashMap;
import java.util.Map;

//из ответов; мне кажется, что ответ выдает неверный, но может я неправильно понял задание
public class c5e3 {

    private Map<Integer, Long> cache;

    public c5e3() {
        cache = new HashMap<>();
        cache.put(0, 0L);
        cache.put(1, 1L);
    }

    public long fibonacci(int x) {
        return cache.computeIfAbsent(x, n -> fibonacci(n-1) + fibonacci(n-2));
    }

    public void print() {
        for (Map.Entry<Integer, Long> cache : cache.entrySet()) {
            System.out.println(cache.getKey() + " и " + cache.getValue());
        }
    }

    public static void main(String[] args) {
        System.out.println(new c5e3().fibonacci(13));
        new c5e3().print();
    }
}
