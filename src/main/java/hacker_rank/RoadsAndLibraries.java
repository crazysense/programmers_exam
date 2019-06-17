package hacker_rank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

// DFS
// 각 도시에 도서관을 짓거나 도로를 짓거나 해야 하는데
// 모든 도시에서 도서관을 이용할 수 있는 최소한의 비용을 구하라

// 도서관을 짓는 비용 : c_lib
// 도로를 짓는 비용 : c_road
// n : 도시의 개수
// m : 도로의 개수

public class RoadsAndLibraries {

    static class Graph {
        private final int v;
        private final Set<Integer> adj;
        private boolean visited;

        public Graph(int v) {
            this.v = v;
            this.adj = new HashSet<>();
            this.visited = false;
        }

        void addAdj(int u) {
            this.adj.add(u);
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public boolean isVisited() {
            return visited;
        }

        public int getV() {
            return v;
        }

        public Set<Integer> getAdj() {
            return adj;
        }
    }

    static long roadsAndLibraries(int n, int c_lib, int c_road, int[][] cities) {
        if (c_lib <= c_road) {
            return c_lib * n;
        }

        // init
        Map<Integer, Graph> nodes = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            nodes.put(i, new Graph(i));
        }

        // direction
        for (int i = 0; i < cities.length; i++) {
            nodes.get(cities[i][0]).addAdj(cities[i][1]);
            nodes.get(cities[i][1]).addAdj(cities[i][0]);
        }

        // cost
        long cost = 0;
        for (Integer node : nodes.keySet()) {
            Graph g = nodes.get(node);
            if (!g.isVisited()) {
                Stack<Graph> dfs = new Stack<>();
                dfs.push(g);
                g.setVisited(true);

                int tmpCost = c_lib;
                while (!dfs.isEmpty()) {
                    Graph u = dfs.pop();
                    for (Integer adjNode : u.getAdj()) {
                        Graph adj = nodes.get(adjNode);
                        if (!adj.isVisited()) {
                            dfs.push(adj);
                            adj.setVisited(true);
                            tmpCost += c_road;
                        }
                    }
                }
                cost += tmpCost;
            }
        }

        return cost;
    }

    public static void main(String[] args) throws IOException {
//        long cost = roadsAndLibraries(5, 6, 1, new int[][]{
//                {1, 2}, {1, 3}, {1, 4}
//        });
//        System.out.println(cost);

        long cost = roadsAndLibraries(96295, 81523, 98351, testcase1());
        System.out.println(cost);
    }

    static int[][] testcase1() throws IOException {
//        List<String> list = Files.readAllLines(Paths.get("D:\\development\\projects\\programmers-exam\\src\\main\\resources\\roadsandlibraries_test"));
        List<String> list = Files.readAllLines(Paths.get("/Users/myyuk/Development/github/programmers_exam/src/main/resources/roadsandlibraries_test"));
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            String[] s = list.get(i).split("\\s+");
            res[i] = new int[2];
            res[i][0] = Integer.parseInt(s[0]);
            res[i][1] = Integer.parseInt(s[1]);
        }
        return res;
    }
}
