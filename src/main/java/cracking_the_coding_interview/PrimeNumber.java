package cracking_the_coding_interview;

import java.util.Arrays;

// 소수 구하기
public class PrimeNumber {
    public static void main(String[] args) {
        int n = 239847329;
        System.out.println(n + " : " + solution01(n));
        System.out.println(n + " : " + solution02(n));
        System.out.println(n + " : " + solution03(n));
    }

    static boolean solution01(int n) {
        if (n < 2) return false;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static boolean solution02(int n) {
        if (n < 2) return false;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static boolean solution03(int n) {
        if (n % 2 == 0) return false;
        return sieveOfEratosthenes(n)[n];
    }

    static boolean[] sieveOfEratosthenes(int max) {
        boolean[] flags = new boolean[max + 1];

        Arrays.fill(flags, 2, flags.length, true);
        int prime = 2;

        while (prime <= max) {
            crossOff(flags, prime);
            prime = getNextPrime(flags, prime);
            if (prime >= flags.length) {
                break;
            }
        }

        return flags;
    }

    static int getNextPrime(boolean[] flags, int prime) {
        int next = prime + 1;
        while (next < flags.length && !flags[next]) {
            next++;
        }
        return next;
    }

    static void crossOff(boolean[] flags, int prime) {
        for (int i = prime * prime; i > 0 && i < flags.length; i += prime) {
            flags[i] = false;
        }
    }
}
