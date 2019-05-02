package brute_force;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class PrimeNumber {
    public static void main(String[] args) {
        PrimeNumber sol = new PrimeNumber();
        String numbers = "011";
        System.out.println(sol.solution(numbers));
    }

    public int solution(String numbers) {
        Set<Long> acc = new HashSet<>();
        combine("", numbers, acc);

        long[] arr = acc.stream().mapToLong(x -> x).sorted().toArray();
        boolean[] b = new boolean[arr.length];

        for (int i = 2; i < arr[arr.length - 1]; i++) {
            for (int j = 0; j < b.length; j++) {
                if (b[j]) continue;
                if (arr[j] != i && arr[j] % i == 0) b[j] = true;
            }
        }

        return (int) IntStream.range(0, b.length)
                .mapToObj(i -> b[i]).filter(x -> !x).count();
    }

    void combine(String s, String number, Set<Long> acc) {
        if (number.length() == 0) {
            if (!"".equals(s)) {
                long val = Long.parseLong(s);
                if (val > 1) acc.add(val);
            }
        } else {
            for (int i = 0; i < number.length(); i++)
                combine(s + number.charAt(i), number.substring(0, i) + number.substring(i + 1), acc);
            for (int i = 0; i < number.length(); i++)
                combine(s, number.substring(0, i) + number.substring(i + 1), acc);
        }
    }
}
