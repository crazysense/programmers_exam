package hacker_rank;

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
    }
}
