package hacker_rank;

import java.util.Arrays;

// 피보나치 수열
public class Fibonacci {
    static long fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static long fibonacci_2(int n) {
        if (n < 2) {
            return n;
        }

        long a = 0, b = 1, tmp;
        while (--n > 0) {
            tmp = b;
            b = a + b;
            a = tmp;
        }
        return b;
    }

    static long fibonacci_3(int n) {
        if (n < 2) {
            return n;
        }

        long[] cache = new long[n + 1];
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    static long fibonacci_4(long[] cache, int n) {
        if (n < 2) {
            return n;
        }
        if (cache == null) {
            cache = new long[n + 1];
            Arrays.fill(cache, -1);
            cache[0] = 0;
            cache[1] = 1;
        }
        if (cache[n] > -1) {
            return cache[n];
        }
        cache[n] = fibonacci_4(cache, n - 1) + fibonacci_4(cache, n - 2);
        return cache[n];
    }

    public static void main(String[] args) {
//        System.out.println(fibonacci(50));
//        System.out.println(fibonacci_2(50));
        System.out.println(fibonacci_3(50));
        System.out.println(fibonacci_4(null, 50));
    }
}
