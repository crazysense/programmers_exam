package graph;

import java.util.*;

// 최단거리 2
public class Dijkstra2 {
    static class Node {
        private final String name;
        private List<Direction> adj;

        private int distance = Integer.MAX_VALUE;
        private boolean visited = false;

        public Node(String name) {
            this.name = name;
            this.adj = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void addAdj(Node node, int cost) {
            this.adj.add(new Direction(node, cost));
        }

        public List<Direction> getAdj() {
            return this.adj;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", distance=" + distance +
                    '}';
        }
    }

    static class Direction {
        private int cost;
        private Node node;

        public Direction(Node node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        public int getCost() {
            return cost;
        }

        public Node getNode() {
            return node;
        }

        @Override
        public String toString() {
            return "Direction{" +
                    "cost=" + cost +
                    ", node=" + node +
                    '}';
        }
    }

    static class Graph {
        private Map<String, Node> nodeMap;

        public Graph() {
            this.nodeMap = new HashMap<>();
        }

        public void addNodes(Node... node) {
            for (Node n : node) {
                this.nodeMap.put(n.getName(), n);
            }
        }

        public void addDirection(Node from, Node to, int cost) {
            Node f = this.getNode(from.getName());
            Node t = this.getNode(to.getName());
            if (f != null && f == from && t != null && t == to) {
                from.addAdj(to, cost);
                to.addAdj(from, cost);
            }
        }

        public Node getNode(String name) {
            return this.nodeMap.get(name);
        }

        public String shortestPath(String from, String to) {
            return shortestPath(this.getNode(from), this.getNode(to));
        }

        public String shortestPath(Node from, Node to) {
            if (from == null || to == null) {
                return "NO WAY!";
            }

            for (Node node : this.nodeMap.values()) {
                node.setDistance(Integer.MAX_VALUE);
            }
            from.setDistance(0);

            Map<String, String> path = new HashMap<>();

            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
            pq.add(from);

            while (!pq.isEmpty()) {
                Node v = pq.poll();
                if (!v.isVisited()) {
                    v.setVisited(true);
                    for (Direction direction : v.getAdj()) {
                        Node u = direction.getNode();
                        if (!u.isVisited()) {
                            int dist = v.getDistance() + direction.getCost();
                            if (u.getDistance() > dist) {
                                u.setDistance(dist);
                                pq.add(u);
                                path.put(u.getName(), v.getName());
                            }
                        }
                    }
                }
            }

            boolean isWayToFind = to.getDistance() < Integer.MAX_VALUE;
            StringBuilder sb = new StringBuilder();
            sb.append("The cost of ")
                    .append(from.getName()).append(" to ").append(to.getName()).append(" is: ")
                    .append(isWayToFind ? to.getDistance() : "NO WAY!").append('\n');

            StringBuilder sbWay = new StringBuilder();
            if (isWayToFind) {
                sbWay.append(" --> ").append(to.getName());

                String p = to.getName();
                while ((p = path.get(p)) != null) {
                    sbWay.insert(0, " --> " + p);
                }
                sbWay.delete(0, 5);
                sbWay.insert(0, "The path is: ");
            }

            return sb.append(sbWay).toString();
        }

        public void print() {
            for (Node node : this.nodeMap.values()) {
                for (Direction d : node.getAdj()) {
                    System.out.println(node.getName() + "--" + d.getCost() + "--" + d.getNode().getName());
                }
            }
        }
    }

    public static void main(String[] args) {
        Node s = new Node("Seoul");
        Node i = new Node("Incheon");
        Node j = new Node("Jeju");
        Node p = new Node("Pusan");
        Node y = new Node("Yeosu");
        Node g = new Node("Guangju");

        Graph graph = new Graph();
        graph.addNodes(s, i, j, p, y, g);
        graph.addDirection(s, i, 1);
        graph.addDirection(s, p, 5);
        graph.addDirection(s, j, 3);
        graph.addDirection(i, y, 3);
        graph.addDirection(i, j, 1);
        graph.addDirection(y, j, 3);
        graph.addDirection(p, j, 2);
        graph.addDirection(p, g, 2);
        graph.addDirection(j, g, 3);

        System.out.println(graph.shortestPath("Seoul", "Guangju"));
    }
}
