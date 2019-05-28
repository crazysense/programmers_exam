package cracking_the_coding_interview.ch_02_linked_list;

public class AddLists {
    public static void main(String[] args) {
        Node n1 = new Node(3);
        n1.add(1).add(5);

        Node n2 = new Node(5);
        n2.add(9).add(4);

        System.out.print("n1: ");
        Node.printNode(n1);
        System.out.print("n2: ");
        Node.printNode(n2);

        Solution01 sol01 = new Solution01();
        Node add = sol01.addLists(n1, n2);
        System.out.print("result: ");
        Node.printNode(add);

        //
        n1 = new Node(5);
        n1.add(1).add(3).add(2);

        n2 = new Node(4);
        n2.add(9).add(5);

        System.out.print("n1: ");
        Node.printNode(n1);
        System.out.print("n2: ");
        Node.printNode(n2);

        Solution02 sol02 = new Solution02();
        add = sol02.addLists(n1, n2);
        System.out.print("result: ");
        Node.printNode(add);
    }

    static class Solution01 {
        // 1의자리부터 들어오는 경우
        Node addLists(Node n1, Node n2) {
            return addListHelper(n1, n2, 0);
        }

        Node addListHelper(Node n1, Node n2, int carry) {
            if (n1 == null && n2 == null && carry == 0) {
                return null;
            }

            int value = carry;
            if (n1 != null) {
                value += n1.data;
            }
            if (n2 != null) {
                value += n2.data;
            }

            Node node = new Node(value % 10);
            node.next = addListHelper(n1 == null ? null : n1.next,
                    n2 == null ? null : n2.next,
                    value / 10);
            return node;
        }
    }

    static class Solution02 {
        // 정상적인 순서로 들어오는 경우
        Node addLists(Node n1, Node n2) {
            int len1 = length(n1);
            int len2 = length(n2);
            if (len1 < len2) {
                n1 = padding(n1, len2 - len1);
            } else {
                n2 = padding(n2, len1 - len2);
            }

            NodeWrapper w = addListHelper(n1, n2);
            if (w.carry > 0) {
                w.node = insertFront(w.node, w.carry);
            }
            return w.node;
        }

        int length(Node node) {
            int len = 0;
            while (node != null) {
                len += 2;
                node = node.next;
            }
            return len;
        }

        Node padding(Node node, int padding) {
            Node head = node;
            for (int i = 0; i < padding; i++) {
                Node pad = new Node(0);
                pad.next = node;
                head = pad;
            }
            return head;
        }

        class NodeWrapper {
            Node node = null;
            int carry = 0;
        }

        NodeWrapper addListHelper(Node n1, Node n2) {
            if (n1 == null && n2 == null) {
                return new NodeWrapper();
            }

            NodeWrapper w = addListHelper(n1.next, n2.next);
            int value = n1.data + n2.data + w.carry;

            w.node = insertFront(w.node, value % 10);
            w.carry = value / 10;

            return w;
        }

        Node insertFront(Node head, int data) {
            Node node = new Node(data);
            node.next = head;
            return node;
        }
    }
}
