package hacker_rank;

// 이진탐색트리 구현
public class BinarySearchTree<T extends Comparable<T>> {
    private T data;
    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;

    public BinarySearchTree(T data) {
        this.data = data;
    }

    public static <A extends Comparable<A>> BinarySearchTree<A> insert(BinarySearchTree<A> root, A data) {
        if (root == null) {
            return new BinarySearchTree<>(data);
        }
        BinarySearchTree<A> node;
        if (root.data.compareTo(data) > 0) {
            node = insert(root.left, data);
            root.left = node;
        } else {
            node = insert(root.right, data);
            root.right = node;
        }
        return root;
    }

    public static <A extends Comparable<A>> BinarySearchTree<A> delete(BinarySearchTree<A> root, A data) {
        if (root == null) {
            return null;
        }

        BinarySearchTree<A> parent = null;
        BinarySearchTree<A> current = root;
        while (current != null) {
            int diff = current.data.compareTo(data);
            if (diff == 0) break;
            parent = current;
            current = diff > 0 ? parent.left : parent.right;
        }

        if (current != null) {
            if (current.left == null && current.right == null) {
                // 삭제할 노드에 자식이 없을때
                if (parent != null) {
                    if (parent.left == current) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else {
                    // 부모가 없으면 삭제할 노드는 root 노드.
                    root = null;
                }
            } else if (current.left == null || current.right == null) {
                // 삭제할 노드에 자식이 한쪽만 있을때
                BinarySearchTree<A> child = current.left != null ? current.left : current.right;
                if (parent != null) {
                    if (parent.left == current) {
                        parent.left = child;
                    } else {
                        parent.right = child;
                    }
                } else {
                    // 부모가 없으면 삭제할 노드는 root 노드.
                    root = child;
                }
            } else {
                // 삭제할 노드에 양쪽 모두 자식이 있을 때
                // 왼쪽 노드의 가장 큰 값 또는 오른쪽 노드의 가장 작은값으로 대체
                // 여기에서는 오른쪽 노드의 가장 작은값을 사용
                BinarySearchTree<A> successorParent = current;
                BinarySearchTree<A> successor = current.right;
                while (successor.left != null) {
                    successorParent = successor;
                    successor = successor.left;
                }

                current.data = successor.data;
                if (successorParent.left == successor) {
                    // successor 는 오른쪽의 맨 왼쪽 노드
                    successorParent.left = successor.right;
                } else {
                    // successor 는 오른쪽 노드
                    successorParent.right = successor.right;
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> n35 = new BinarySearchTree<>(35);
        BinarySearchTree<Integer> n18 = new BinarySearchTree<>(18);
        BinarySearchTree<Integer> n68 = new BinarySearchTree<>(68);
        BinarySearchTree<Integer> n7 = new BinarySearchTree<>(7);
        BinarySearchTree<Integer> n26 = new BinarySearchTree<>(26);
        BinarySearchTree<Integer> n99 = new BinarySearchTree<>(99);
        BinarySearchTree<Integer> n3 = new BinarySearchTree<>(3);
        BinarySearchTree<Integer> n12 = new BinarySearchTree<>(12);
        BinarySearchTree<Integer> n22 = new BinarySearchTree<>(22);
        BinarySearchTree<Integer> n30 = new BinarySearchTree<>(30);
        BinarySearchTree<Integer> n23 = new BinarySearchTree<>(23);

        n35.left = n18;
        n35.right = n68;
        n18.left = n7;
        n18.right = n26;
        n68.right = n99;
        n7.left = n3;
        n7.right = n12;
        n26.left = n22;
        n26.right = n30;
        n22.right = n23;

        print(n35);

        n35 = BinarySearchTree.delete(n35, 18);

        System.out.println();
        print(n35);
    }

    static void print(BinarySearchTree n) {
        if (n == null) return;
        System.out.println(String.format("[data=%s, left=%s, right=%s] ",
                n.data, n.left != null ? n.left.data : null, n.right != null ? n.right.data : null));
        print(n.left);
        print(n.right);
    }
}
