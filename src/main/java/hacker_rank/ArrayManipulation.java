package hacker_rank;

import java.util.Stack;

// 배열 조작
// a 와 b 사이에 k 를 채우고 최대값을 반환
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

    static long arrayManipulation2(int n, int[][] queries) {
        Stack<Long> st = new Stack<>();

        long[] array = new long[n];

        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0] - 1;
            int b = queries[i][1];
            int k = queries[i][2];
            for (int j = a; j < b; j++) {
                if (!st.isEmpty() && st.peek() == array[j]) {
                    st.pop();
                }
                array[j] += k;
                if (st.isEmpty() || array[j] >= st.peek()) {
                    st.push(array[j]);
                }
            }
        }
        return st.isEmpty() ? 0 : st.pop();
    }

    public static void main(String[] args) {
        System.out.println(arrayManipulation(5, new int[][]{
                {1, 2, 100}, {2, 5, 100}, {3, 4, 100}
        }));

        System.out.println(arrayManipulation2(5, new int[][]{
                {1, 2, 100}, {2, 5, -100}, {3, 4, -100}
        }));
    }
}
