package cracking_the_coding_interview.ch_02_linked_list;

import java.util.Stack;

public class NthToLast {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.add(2);
        n.add(3);
        n.add(4);
        n.add(2);
        n.add(5);
        n.add(1);
        n.add(6);

        Node.printNode(n);

        Solution01 sol01 = new Solution01();
        System.out.println(sol01.nthToLast(n, 4));

        // init
        n = new Node(1);
        n.add(2);
        n.add(3);
        n.add(4);
        n.add(2);
        n.add(5);
        n.add(1);
        n.add(6);

        Node.printNode(n);

        Solution02 sol02 = new Solution02();
        System.out.println(sol02.nthToLast(n, 4));

        // init
        n = new Node(1);
        n.add(2);
        n.add(3);
        n.add(4);
        n.add(2);
        n.add(5);
        n.add(1);
        n.add(6);

        Node.printNode(n);

        Solution03 sol03 = new Solution03();
        System.out.println(sol03.nthToLast(n, 4));
    }

    static class Solution01 {
        Node nthToLast(Node head, int n) {
            if (head == null || n < 1) return null;

            Node p1 = head;
            Node p2 = head;

            for (int i = 0; i < n - 1; i++) {
                if (p2 == null) return null;
                p2 = p2.next;
            }

            if (p2 == null) return null;

            while (p2.next != null) {
                p1 = p1.next;
                p2 = p2.next;
            }
            return p1;
        }
    }

    static class Solution02 {
        Node nthToLast(Node head, int n) {
            NodeWrapper w = nthToLastHelper(head, n);
            return w.node;
        }

        class NodeWrapper {
            Node node = null;
            int nth = 0;
        }

        NodeWrapper nthToLastHelper(Node node, int n) {
            if (node == null) {
                return new NodeWrapper();
            }
            NodeWrapper w = nthToLastHelper(node.next, n);
            w.nth++;
            if (w.nth == n) {
                w.node = node;
            }
            return w;
        }
    }

    static class Solution03 {
        Node nthToLast(Node head, int n) {
            if (head == null || n < 1) return null;
            Stack<Node> stack = new Stack<>();
            Node node = head;
            while (node != null) {
                stack.push(node);
                node = node.next;
            }

            for (int i = 0; i < n && stack.size() > 0; i++) {
                Node res = stack.pop();
                if (i == n - 1) {
                    return res;
                }
            }
            return null;
        }
    }
}
