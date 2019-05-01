package sorting;

import java.util.Arrays;

public class KthNumber {
    public static void main(String[] args) {
        KthNumber sol = new KthNumber();
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{
                {2, 5, 3}, {4, 4, 1}, {1, 7, 3}
        };
        System.out.println(Arrays.toString(sol.solution(array, commands)));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1;
            int end = commands[i][1] - 1;
            int k = commands[i][2] - 1;

            int[] sortArray = new int[end - start + 1];
            for (int j = start, n = 0; j <= end; j++, n++) {
                int val = array[j];
                int m = n - 1;
                for (; m >= 0 && sortArray[m] > val; m--) {
                    sortArray[m + 1] = sortArray[m];
                }
                sortArray[m + 1] = val;
            }

            answer[i] = sortArray[k];
        }

        return answer;
    }
}
