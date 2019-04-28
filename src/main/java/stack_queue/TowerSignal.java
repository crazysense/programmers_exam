package stack_queue;

import java.util.Arrays;

public class TowerSignal {
    public static void main(String[] args) {
        TowerSignal sol = new TowerSignal();
        int[] heights = new int[]{3, 9, 9, 3, 5, 7, 2};
        System.out.println(Arrays.toString(sol.solution(heights)));
    }

    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        for (int i = heights.length - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (heights[i] < heights[j]) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }
        return answer;
    }
}
