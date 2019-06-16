package hacker_rank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Candies {
    static long candies(int n, int[] arr) {
        if (arr.length == 0) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = arr[i] > arr[i - 1] ? dp[i - 1] + 1 : 1;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1] && dp[i] <= dp[i + 1]) {
                dp[i] = dp[i + 1] + 1;
            } else if (dp[i] == dp[i+1]) {
                dp[i] = dp[i + 1] + 1;
            }
        }

        int a = 0;
        for (int i = 0; i < dp.length; i++) {
            a += dp[i];
        }

        return a;
    }

    public static void main(String[] args) throws IOException {
        List<String> s = Files.readAllLines(Paths.get("D:\\development\\projects\\programmers-exam\\src\\main\\resources\\candies_testcase"));
        int n = Integer.parseInt(s.get(0));
        int[] scores = new int[s.size() - 1];
        for (int i = 1; i < s.size(); i++) {
            scores[i - 1] = Integer.parseInt(s.get(i));
        }
//
        System.out.println(candies(10, new int[]{1,3,2,4,4,4,4,1,3,2}));
        System.out.println(candies(n, scores));
    }
}
