package stack_queue;

import java.util.Arrays;

public class StockPrice {
    public static void main(String[] args) {
        StockPrice sol = new StockPrice();
        int[] prices = new int[]{1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(sol.solution(prices)));
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length - 1; i++) {
            int time = 0;
            for (int j = i + 1; j < prices.length; j++) {
                time++;
                if (prices[i] > prices[j]) break;
            }
            answer[i] = time;
        }
        return answer;
    }
}
