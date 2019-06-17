package cracking_the_coding_interview.ch_01_array_and_string;

import java.util.Arrays;

// 배열바꾸기
// 행열
public class SetZero {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},

        };

        print(matrix);

        Solution01 sol01 = new Solution01();
        sol01.setZero(matrix);

        System.out.println("=======>");
        print(matrix);

        // init
        matrix = new int[][]{
                {0, 1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},

        };

        Solution02 sol02 = new Solution02();
        sol02.setZero(matrix);

        System.out.println("=======>");
        print(matrix);
    }

    static void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    static class Solution01 {
        void setZero(int[][] matrix) {
            boolean[] row = new boolean[matrix.length];
            boolean[] col = new boolean[matrix[0].length];

            for (int i = 0; i < row.length; i++) {
                for (int j = 0; j < col.length; j++) {
                    if (matrix[i][j] == 0) {
                        row[i] = true;
                        col[j] = true;
                    }
                }
            }

            for (int i = 0; i < row.length; i++) {
                for (int j = 0; j < col.length; j++) {
                    if (row[i] || col[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

    static class Solution02 {
        void setZero(int[][] matrix) {
            int row = 0, col = 0;

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        row |= 1 << i;
                        col |= 1 << j;
                    }
                }
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if ((row & 1 << i) > 0 || (col & 1 << j) > 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }
}
