package dfs_bfs;

public class Network {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = new int[][]{
                {1, 1, 0}, {1, 1, 0}, {0, 0, 1}
        };
        Network sol = new Network();
        System.out.println(sol.solution(n, computers));
    }

    public int solution(int n, int[][] computers) {
        boolean[] visit = new boolean[200];
        int net = 0;
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                net++;
                dfs(visit, i, computers, n);
            }
        }
        return net;
    }

    private void dfs(boolean[] check, int idx, int[][] computers, int k) {
        check[idx] = true;
        for (int i = 0; i < k; i++) {
            if (!check[i] && 1 == computers[idx][i])
                dfs(check, i, computers, k);
        }
    }
}
