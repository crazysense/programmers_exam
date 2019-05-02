package test;

import java.util.ArrayList;
import java.util.List;

public class Mock01 {
    public static void main(String[] args) {
        int[][] v = new int[][]{
                {1, 4}, {3, 4}, {3, 10}
//                {1, 1}, {2, 2}, {1, 2}
        };
        Mock01 mock = new Mock01();
        mock.solution(v);
    }

    boolean[] check = new boolean[3];

    public int[] solution(int[][] v) {
        find(v, 0, 1, v[0][1]);
        return null;
    }

    private int find(int[][] v, int idx, int xy, int val) {
        check[idx] = true;
        int res = 0;
        for (int i = idx + 1; i < v.length; i++) {
            if (!check[i] && v[i][xy % 2] == val) {
                res = find(v, idx + 1, xy + 1, v[i][(xy + 1) % 2]);
            }
        }
        return v[idx][xy % 2];
    }

}
