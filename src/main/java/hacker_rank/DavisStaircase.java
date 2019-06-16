package hacker_rank;

import java.util.Arrays;

public class DavisStaircase {
    static int stepPerms(int n) {
        return stepPerms(null, n);
    }

    static int stepPerms(int[] cache, int n) {
        if (cache == null) {
            cache = new int[n + 1];
            Arrays.fill(cache, -1);
            cache[0] = 0;
            cache[1] = 1;
            cache[2] = 2;
            cache[3] = 4;
        }
        if (cache[n] > -1) {
            return cache[n];
        }

//        for (int i = 4; i <= n; i++) {
//            cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
//        }
//        return cache[n];
        return stepPerms(cache, n - 1) + stepPerms(cache, n - 2) + stepPerms(cache, n - 3);
    }

    public static void main(String[] args) {
        System.out.println(stepPerms(6));
    }
}
