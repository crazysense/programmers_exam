package cracking_the_coding_interview;

import java.util.HashMap;
import java.util.Map;

public class CountSubsets {
    public static void main(String[] args) {
        Map<String, Integer> memo = new HashMap<>();
//        System.out.println(countSubsets(new int[]{4, 10, 2, 1, 2, 1}, 16, 5, memo));

        memo.clear();
//        System.out.println(countSubsets2(new int[]{4, 10, 2, 1, 2, 1}, 16, 0, 0, memo));
        System.out.println(countSubsets2(new int[]{4,2}, 6, 0, 0, memo));
        System.out.println();
    }

    static int countSubsets(int[] arr, int total, int i, Map<String, Integer> mem) {
        String key = total + ":" + i;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }

        int m;
        if (total == 0) {
            return 1;
        } else if (total < 0 || i < 0) {
            return 0;
        } else if (total < arr[i]) {
            m = countSubsets(arr, total, i - 1, mem);
        } else {
            m = countSubsets(arr, total - arr[i], i - 1, mem)
                    + countSubsets(arr, total, i - 1, mem);
        }
        mem.put(key, m);
        return m;
    }

    static int countSubsets2(int[] arr, int total, int val, int i, Map<String, Integer> mem) {
        if (val == total) {
            return 1;
        }
        if (i >= arr.length || val > total) {
            return 0;
        }
        String key = total + ":" + i;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }

        int m = countSubsets2(arr, total, val + arr[i], i + 1, mem)
                + countSubsets2(arr, total, arr[i], i + 1, mem);
        mem.put(key, m);

        return m;
    }
}
