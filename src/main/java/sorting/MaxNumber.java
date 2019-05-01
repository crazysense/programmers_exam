package sorting;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class MaxNumber {
    public static void main(String[] args) {
        MaxNumber sol = new MaxNumber();
        int[] numbers = new int[]{0, 2, 1, 100, 100000, 5000, 2355, 1};
        System.out.println(sol.solution(numbers));
    }

    public String solution(int[] numbers) {
        String s = Arrays.stream(numbers)
                .mapToObj(x -> String.valueOf(x))
                .sorted((a, b) -> (int) (Long.parseLong(b + a) - Long.parseLong(a + b)))
                .reduce((a, b) -> a + b).get();

        return s.startsWith("0") ? "0" : s;
//
//        String[] sort = new String[numbers.length];
//        for (int i = 0; i < numbers.length; i++) {
//            sort[i] = String.valueOf(numbers[i]);
//
//            for (int j = i, k = 0; j > 0; j--, k++) {
//                acc.incrementAndGet();
//                long a = Long.parseLong(sort[j] + sort[j - 1]);
//                long b = Long.parseLong(sort[j - 1] + sort[j]);
//                if (a <= b) break;
//
//                String tmp = sort[j];
//                sort[j] = sort[j - 1];
//                sort[j - 1] = tmp;
//            }
//        }
//
//        return sort[0].equals("0") ? "0" : toString(sort);
    }

//    private String toString(String[] arr) {
//        StringBuilder sb = new StringBuilder();
//        for (String s : arr) {
//            sb.append(s);
//        }
//        return sb.toString();
//    }
}
