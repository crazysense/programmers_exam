package binary_search;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Budgets {
    public static void main(String[] args) {
        int[] budgets = new int[]{120, 110, 140, 150};
        int M = 485;
        Budgets sol = new Budgets();
        System.out.println(sol.solution(budgets, M));
    }

    public int solution(int[] b, int M) {
        int sum = 0;
        int temp = 0;
        int min;
        int max;
        int mid = 0;
        int n = b.length;

        int[] budgets = IntStream.range(0, b.length)
                .map(x -> b[x])
                .sorted()
                .toArray();

        min = 0;
        max = 100000;

        for (int i = 0; i < n; i++) {
            sum += budgets[i];
        }
        if (sum < M)
            return budgets[n - 1];

        while (mid == temp) {
            sum = 0;
            mid = (max + min) / 2;
            for (int i = 0; i < n; i++) {
                if (budgets[i] < mid)
                    sum += budgets[i];
                else {
                    sum += mid * (n - 1 - (i - 1));
                    break;
                }

            }

            if (mid == temp)
                return mid;
            if (sum > M)
                max = mid;
            else
                min = mid;

            temp = mid;
        }

        return 0;
    }
}
