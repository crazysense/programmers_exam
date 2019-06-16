package hacker_rank;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(fact(6));
        System.out.println(sum(100000));
    }

    static int fact(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i - 1] = i * dp[i - 2];
        }
        return dp[n - 1];
    }

    static int sum(int n) {
        if (n <= 1) return n;

        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum += i;
        }
        return sum;
    }
}
