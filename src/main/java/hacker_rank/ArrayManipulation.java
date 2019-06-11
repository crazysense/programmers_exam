package hacker_rank;

public class ArrayManipulation {

    static long arrayManipulation(int n, int[][] queries) {
        long[] array = new long[n + 1];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0] - 1;
            int b = queries[i][1];
            int k = queries[i][2];
            array[a] += k;
            array[b] -= k;
        }

        long max = 0;
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(arrayManipulation(5, new int[][]{
                {1, 2, 100}, {2, 5, 100}, {3, 4, 100}
        }));
    }
}
