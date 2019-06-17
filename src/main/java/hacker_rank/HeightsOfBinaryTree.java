package hacker_rank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 이진트리의 높이 (레벨) 구하기
// BST
public class HeightsOfBinaryTree {
    public static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static int height(Node root) {
        if (root == null) return 0;
        return heightHelper(root, 0);
    }

    public static int heightHelper(Node n, int level) {
        if (n == null) return level - 1;
        int left = heightHelper(n.left, level + 1);
        int right = heightHelper(n.right, level + 1);
        return left > right ? left : right;
    }

    public static int height2(Node n, int depth) {
        if (n == null) {
            return depth;
        }
        int left = height2(n.left, depth + 1);
        int right = height2(n.right, depth + 1);
        return Math.max(left, right);
    }

    public static int height3(Node n, int depth) {
        if (n == null) {
            return depth;
        }
        return Math.max(height2(n.left, depth + 1), height2(n.right, depth + 1));
    }

    public static int heightWithDFS(Node n) {
        int depth = 0;
        if (n == null) {
            return depth;
        }

        Stack<Node> st = new Stack<>();
        Stack<Node> path = new Stack<>();
        st.push(n);

        while (!st.isEmpty()) {
            Node r = st.peek();
            if (!path.isEmpty() && r == path.peek()) {
                if (path.size() > depth) {
                    depth = path.size();
                }
                path.pop();
                st.pop();
            } else {
                path.push(r);
                if (r.left != null) st.push(r.left);
                if (r.right != null) st.push(r.right);
            }
        }

        return depth;
    }

    public static int heightWithBFS(Node n) {
        int count = 0;
        if (n == null) {
            return count;
        }

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(n);
        while (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                Node r = q1.poll();
                if (r.left != null) q2.add(r.left);
                if (r.right != null) q2.add(r.right);
            }
            count++;
            q1 = q2;
            q2 = new LinkedList<>();
        }

        return count;
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Node n = insert(null, 3);
        n = insert(n, 2);
        n = insert(n, 5);
        n = insert(n, 1);
        n = insert(n, 4);
        n = insert(n, 6);
        n = insert(n, 7);

        System.out.println(height(n));
        System.out.println(height2(n, 0));
        System.out.println(height3(n, 0));
        System.out.println(heightWithDFS(n));
        System.out.println(heightWithBFS(n));
    }
}
