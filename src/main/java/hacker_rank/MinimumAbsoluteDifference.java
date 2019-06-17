package hacker_rank;

import java.util.Arrays;

// 배열 요소의 차이중 최소값을 구하라 (절대값으로 계산)
public class MinimumAbsoluteDifference {
    static int minimumAbsoluteDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, Math.abs(arr[i] - arr[i + 1]));
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minimumAbsoluteDifference(new int[]{3, -7, 0}));
    }
}
