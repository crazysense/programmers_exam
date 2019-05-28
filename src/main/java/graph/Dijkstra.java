package graph;

import javafx.util.Pair;

import java.util.*;

public class Dijkstra {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.addSimple(1, 2, 3);
        g.addSimple(1, 5, 4);
        g.addSimple(1, 4, 4);
        g.addSimple(2, 3, 2);
        g.addSimple(3, 4, 1);
        g.addSimple(4, 5, 2);
        g.addSimple(5, 6, 4);
        g.addSimple(4, 7, 6);
        g.addSimple(7, 6, 3);
        g.addSimple(3, 8, 3);
        g.addSimple(6, 8, 2);

//        System.out.println(g.dijkstra(1, 8));
        System.out.println(g.shortestPath(1, 8));

        System.out.println("===============");

//        Graph2 g2 = new Graph2(8);
//        g2.input(1, 2, 3);
//        g2.input(1, 5, 4);
//        g2.input(1, 4, 4);
//        g2.input(2, 3, 2);
//        g2.input(3, 4, 1);
//        g2.input(4, 5, 2);
//        g2.input(5, 6, 4);
//        g2.input(4, 7, 6);
//        g2.input(7, 6, 3);
//        g2.input(3, 8, 3);
//        g2.input(6, 8, 2);
//
//        System.out.println(g2.dijkstra(8, 1));
    }

    static class Graph {
        List<Node> nodes;

        public Graph() {
            this.nodes = new ArrayList<>();
            this.nodes.add(0, null);
        }

        void addSimple(int from, int to, int cost) {
            Node fromNode;
            while (from >= this.nodes.size()) {
                int i = this.nodes.size();
                this.nodes.add(new Node(i));
            }
            fromNode = this.nodes.get(from);

            Node toNode;
            while (to >= this.nodes.size()) {
                int i = this.nodes.size();
                this.nodes.add(new Node(i));
            }
            toNode = this.nodes.get(to);

            fromNode.addEdge(to, cost);
            toNode.addEdge(from, cost);
        }

        void addNode(Node n) {
            this.nodes.add(n);
        }

        int dijkstra(int from, int to) {
            return dijkstra(from).getKey()[to];
        }

        String shortestPath(int from, int to) {
            int[] track = dijkstra(from).getValue();

            Stack<Integer> stack = new Stack<>();
            stack.push(to);

            int u = track[to];
            while (u != from) {
                stack.push(u);
                u = track[u];
            }

            stack.push(from);

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
            return sb.toString();
        }

        Pair<int[], int[]> dijkstra(int startNode) {
            int[] dist = new int[nodes.size()];
            int[] track = new int[nodes.size()];
            Arrays.fill(dist, Integer.MAX_VALUE);
            Arrays.fill(track, Integer.MAX_VALUE);

            PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>(Comparator.comparingInt(Pair::getValue));
            q.add(new Pair<>(startNode, 0));

            dist[startNode] = 0;

            while (!q.isEmpty()) {
                Pair<Integer, Integer> pair = q.poll();

                Node nodeFrom = nodes.get(pair.getKey());
                if (!nodeFrom.isVisited()) {
                    List<Edge> edges = nodeFrom.getAdj();
                    for (Edge edge : edges) {
                        int next = edge.getTo();
                        if (!nodes.get(next).isVisited()) {
                            if (dist[next] > edge.getCost() + pair.getValue()) {
                                dist[next] = edge.getCost() + pair.getValue();
                                track[next] = nodeFrom.getId();
                            }
                            q.add(new Pair<>(next, dist[next]));
                        }
                    }
//                    System.out.print("dist : ");
//                    for (int i = 1; i < dist.length; i++) {
//                        System.out.print(dist[i] + " ");
//                    }
//                    System.out.print("\ntrack : ");
//                    for (int i = 1; i < track.length; i++) {
//                        System.out.print(track[i] + " ");
//                    }
//                    System.out.println();
                    nodeFrom.setVisited(true);
                }
            }

            return new Pair<>(dist, track);
        }

        @Override
        public String toString() {
            return "Graph{" +
                    "nodes=" + nodes +
                    '}';
        }
    }

    static class Graph2 {
        private int n;           //노드들의 수
        private int maps[][];    //노드들간의 가중치 저장할 변수

        public Graph2(int n) {
            this.n = n;
            maps = new int[n + 1][n + 1];

        }

        public void input(int i, int j, int w) {
            maps[i][j] = w;
            maps[j][i] = w;
        }

        public int dijkstra(int from, int to) {
            int distance[] = new int[n + 1];          //최단 거리를 저장할 변수
            boolean[] check = new boolean[n + 1];     //해당 노드를 방문했는지 체크할 변수

            //distance값 초기화.
            for (int i = 1; i < n + 1; i++) {
                distance[i] = Integer.MAX_VALUE;
            }

            //시작노드값 초기화.
            distance[from] = 0;
            check[from] = true;

            //연결노드 distance갱신
            for (int i = 1; i < n + 1; i++) {
                if (!check[i] && maps[from][i] != 0) {
                    distance[i] = maps[from][i];
                }
            }


            for (int a = 0; a < n - 1; a++) {
                //원래는 모든 노드가 true될때까지 인데
                //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
                //원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
                int min = Integer.MAX_VALUE;
                int min_index = -1;

                //최소값 찾기
                for (int i = 1; i < n + 1; i++) {
                    if (!check[i] && distance[i] != Integer.MAX_VALUE) {
                        if (distance[i] < min) {
                            min = distance[i];
                            min_index = i;
                        }
                    }
                }

                check[min_index] = true;
                for (int i = 1; i < n + 1; i++) {
                    if (!check[i] && maps[min_index][i] != 0) {
                        if (distance[i] > distance[min_index] + maps[min_index][i]) {
                            distance[i] = distance[min_index] + maps[min_index][i];
                        }
                    }
                }
                //결과값 출력
                for (int i = 1; i < n + 1; i++) {
                    System.out.print(distance[i] + " ");
                }
                System.out.println();

            }

            return distance[to];
        }
    }

    static class Node {
        int id;
        List<Edge> adj;
        boolean visited;

        public Node(int id) {
            this.id = id;
            this.adj = new ArrayList<>();
            this.visited = false;
        }

        public int getId() {
            return id;
        }

        void addEdge(int to, int cost) {
            Edge e = new Edge(this.id, to, cost);
            this.adj.add(e);
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public List<Edge> getAdj() {
            return adj;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "id=" + id +
                    ", adj=" + adj +
                    '}';
        }
    }

    static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int getFrom() {
            return from;
        }

        public int getTo() {
            return to;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", cost=" + cost +
                    '}';
        }
    }
}
