package binary_search;

import java.util.Arrays;

public class Immigration {
    public static void main(String[] args) {
        int n = 6;
        int[] times = new int[]{1, 1, 2};
        Immigration sol = new Immigration();
        System.out.println(sol.solution(n, times));
    }

    public long solution(int n, int[] times) {
        int[] timeArr = Arrays.stream(times).sorted().toArray();
        long max = timeArr[timeArr.length - 1] * n;
        long min = timeArr[0];
        long answer = 0;

        while (min < max) {
            long mid = (min + max) / 2;
            int num = 0;
            for (int i = 0; i < timeArr.length; i++)
                num += (mid / timeArr[i]);

            if (num < n) min = mid + 1;
            else {
                answer = mid;
                max = mid;
            }
        }

        return answer;
    }
}
