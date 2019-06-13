package cracking_the_coding_interview.ch_01_array_and_string;

import java.util.Arrays;

public class ReverseMatrix {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'0', '1', '2', '3', '4'},
                {'5', '6', '7', '8', '9'},
                {'A', 'B', 'C', 'D', 'E'},
                {'F', 'G', 'H', 'I', 'J'},
                {'K', 'L', 'M', 'N', 'O'}
        };

        print(matrix);

        reverse(matrix, 0);

        print(matrix);
    }

    static void print(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        System.out.println();
    }

    static void reverse(char[][] matrix, int row) {
        int end = matrix.length / 2;
        if (row > end) {
            return;
        } else if (row == end) {
            for (int col = 0; col < matrix.length / 2; col++) {
                swap(matrix, row, col, row, matrix.length - col - 1);
            }
        } else {
            int targetRow = matrix.length - row - 1;
            for (int col = 0; col < matrix.length; col++) {
                swap(matrix, row, col, targetRow, matrix.length - col - 1);
            }
            reverse(matrix, row + 1);
        }
    }

    static void swap(char[][] matrix, int fromRow, int fromCol, int toRow, int toCol) {
        char tmp = matrix[fromRow][fromCol];
        matrix[fromRow][fromCol] = matrix[toRow][toCol];
        matrix[toRow][toCol] = tmp;
    }
}
