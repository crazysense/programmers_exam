package cracking_the_coding_interview.ch_01_array_and_string;

import java.util.Arrays;

public class Rotate_NxN_Matrix {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'0', '1', '2', '3'},
                {'4', '5', '6', '7'},
                {'8', '9', 'A', 'B'},
                {'C', 'D', 'E', 'F'}
        };

        print(matrix);

        Solution01 sol01 = new Solution01();
        sol01.rotate(matrix, 4);
        System.out.println("======>");
        print(matrix);

        // init
        matrix = new char[][]{
                {'0', '1', '2', '3'},
                {'4', '5', '6', '7'},
                {'8', '9', 'A', 'B'},
                {'C', 'D', 'E', 'F'}
        };

        Solution02 sol02 = new Solution02();
        char[][] res = sol02.rotate(matrix, 4);
        System.out.println("======>");
        print(res);

        // init
        matrix = new char[][]{
                {'0', '1', '2', '3'},
                {'4', '5', '6', '7'},
                {'8', '9', 'A', 'B'},
                {'C', 'D', 'E', 'F'}
        };

        Test sol03 = new Test();
        sol03.rotate(matrix, 4);
        System.out.println("======>");
        print(matrix);
    }

    static void print(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    static class Solution01 {
        void rotate(char[][] matrix, int n) {
            for (int i = 0; i < n / 2; i++) {
                int target = n - i - 1;
                for (int j = i, k = 0; j < target; j++, k++) {
                    char tmp = matrix[i][j];
                    matrix[i][j] = matrix[target - k][i];
                    matrix[target - k][i] = matrix[target][target - k];
                    matrix[target][target - k] = matrix[j][target];
                    matrix[j][target] = tmp;
                }
            }
        }
    }

    static class Solution02 {
        char[][] rotate(char[][] matrix, int n) {
            char[][] copy = new char[n][n];
            for (int i = 0; i < n; i++) {
                int targetCol = n - i - 1;
                for (int j = 0; j < n; j++) {
                    copy[j][targetCol] = matrix[i][j];
                }
            }
            return copy;
        }
    }

    static class Test {
        void rotate(char[][] matrix, int n) {
            for (int x = 0; x < n / 2; x++) {
                int target = n - x - 1;
                for (int y = x, z = 0; y < target; y++, z++) {
                    char tmp = matrix[x][y];
                    matrix[x][y] = matrix[target - y][x];
                    matrix[target - y][x] = matrix[target][target - z];
                    matrix[target][target - z] = matrix[y][target];
                    matrix[y][target] = tmp;
                }
                System.out.println();
            }
        }
    }
}
