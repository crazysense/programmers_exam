package hacker_rank;

// 이진탐색트리인지 확인하기
// BST
public class IsThisABST {
    static boolean checkBST(HeightsOfBinaryTree.Node root) {
        return checkBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean checkBSTHelper(HeightsOfBinaryTree.Node n, int min, int max) {
        if (n == null) return true;
        if (n.data <= min || n.data >= max) {
            return false;
        }
        return checkBSTHelper(n.left, min, n.data) && checkBSTHelper(n.right, n.data, max);
    }

    static boolean checkBST2(HeightsOfBinaryTree.Node n) {
        if (n == null) return true;
        if ((n.left != null && n.left.data > n.data) || (n.right != null && n.right.data < n.data)) return false;
        return checkBST2(n.left) && checkBST2(n.right);
    }

    static volatile boolean toggle = true;

    public static HeightsOfBinaryTree.Node insert(HeightsOfBinaryTree.Node root, int data) {
        if (root == null) {
            return new HeightsOfBinaryTree.Node(data);
        } else {
            HeightsOfBinaryTree.Node cur;
            if (toggle) {
                cur = insert(root.left, data);
                root.left = cur;
                toggle = !toggle;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
                toggle = !toggle;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        HeightsOfBinaryTree.Node n = new HeightsOfBinaryTree.Node(5);
        n = insert(n, 4);
        n = insert(n, 6);
        n = insert(n, 3);
        n = insert(n, 1);
        n = insert(n, 7);
        n = insert(n, 8);

        System.out.println(checkBST(n));
        System.out.println(checkBST2(n));
    }
}
