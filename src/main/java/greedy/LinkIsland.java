package greedy;

import java.util.ArrayList;
import java.util.List;

public class LinkIsland {
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = new int[][]{
                {0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}
        };
        LinkIsland sol = new LinkIsland();
        System.out.println(sol.solution(n, costs));
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[][] link = new int[n][n];
        int minCost = costs[0][2];
        int minIsland1 = costs[0][0];
        int minIsland2 = costs[0][1];

        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < n; i++)
            visited.add(false);

        for (int i = 0; i < costs.length; i++) {
            link[costs[i][0]][costs[i][1]] = costs[i][2];
            link[costs[i][1]][costs[i][0]] = costs[i][2];

            if (costs[i][2] < minCost) { // select first island
                minCost = costs[i][2];
                minIsland1 = costs[i][0];
                minIsland2 = costs[i][1];
            }
        }

        while (visited.contains(false)) {
            answer += minCost;
            visited.set(minIsland1, true);
            visited.set(minIsland2, true);
            minCost = (int) 1e9;

            for (int i = 0; i < n; i++) {
                if (visited.get(i)) {
                    for (int j = 0; j < n; j++) {
                        if (link[i][j] != 0 && !visited.get(j) && minCost > link[i][j]) {
                            minCost = link[i][j];
                            minIsland1 = i;
                            minIsland2 = j;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
