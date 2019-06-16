package hacker_rank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class MaxArraySum {
    public static void main(String[] args) throws IOException {
        List<String> s = Files.readAllLines(Paths.get("D:\\development\\projects\\programmers-exam\\src\\main\\resources\\maxarraysum_test"));
        int[] arr = Arrays.stream(s.get(0).split("\\s+")).mapToInt(Integer::valueOf).toArray();


        arr = new int[] {-1,-2,-3,-5,10};
        int res = maxArraySum(arr);
        System.out.println(res);
//        System.out.println(res == 76497274);

        System.out.println(maxArraySum2(arr));
    }

    static int maxArraySum(int[] arr) {
        if (arr.length <= 2) return 0;

        int[] dp = new int[arr.length];
        dp[0] = Math.max(0, arr[0]);
        dp[1] = Math.max(dp[0], arr[1]);

        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);
        }
        return dp[dp.length-1];
    }

    static int maxArraySum2(int[] arr) {
        if (arr.length == 0) return 0;
        arr[0] = Math.max(0, arr[0]);
        if (arr.length == 1) return arr[0];
        arr[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++)
            arr[i] = Math.max(arr[i - 1], arr[i] + arr[i - 2]);
        return arr[arr.length - 1];
    }

}
