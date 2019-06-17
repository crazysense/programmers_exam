package exam;

// 이진검색트리
// 최소 레벨로
public class MinimumLevelBST {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode node = createMinimalBST(arr, 0, arr.length - 1);
        //System.out.println(node);
        System.out.println(inOrder(node));
    }

    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    "}";
        }
    }

    static TreeNode createMinimalBST(int[] arr, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = createMinimalBST(arr, start, mid - 1);
        node.right = createMinimalBST(arr, mid + 1, end);
        return node;
    }

    static String inOrder(TreeNode root) {
        if (root == null) {
            return "NUL";
        }
        return inOrder(root.left) + root.data + inOrder(root.right);
    }
}
