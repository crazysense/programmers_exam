package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FarNode {
    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = new int[][]{
                {3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
        };

        FarNode sol = new FarNode();
        System.out.println(sol.solution(n, vertex));
    }

    public int solution(int n, int[][] edge) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            nodes.add(new Node(i));

        for (int i = 0; i < edge.length; i++) {
            nodes.get(edge[i][0] - 1).addAdjacent(nodes.get(edge[i][1] - 1));
            nodes.get(edge[i][1] - 1).addAdjacent(nodes.get(edge[i][0] - 1));
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Node> queue = new LinkedList<>();
        visit(visited, nodes.get(0), queue, 0);
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for (Node adjacent : node.adjacent) {
                if(!visited[adjacent.vertex]) {
                    visit(visited, adjacent, queue, node.count + 1);
                }
            }
        }

        int max = nodes.stream().mapToInt(node -> node.count).max().getAsInt();
        return (int) nodes.stream().filter(node -> node.count == max).count();
    }

    public void visit(boolean[] visited, Node node, Queue<Node> queue, int count) {
        visited[node.vertex] = true;
        node.count = count;
        queue.add(node);

    }

    public class Node {
        private int vertex;
        private List<Node> adjacent = new ArrayList<>();
        private int count = Integer.MAX_VALUE;

        public Node(int vertex) {
            this.vertex = vertex;
        }

        public void addAdjacent(Node other) {
            this.adjacent.add(other);
        }
    }
}
