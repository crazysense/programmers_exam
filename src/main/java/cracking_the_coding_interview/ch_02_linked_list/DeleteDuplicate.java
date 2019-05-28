package cracking_the_coding_interview.ch_02_linked_list;

import java.util.HashSet;
import java.util.Set;

public class DeleteDuplicate {
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
        sol01.deleteDuplicate(n);

        Node.printNode(n);

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
        sol02.deleteDuplicate(n);

        Node.printNode(n);
    }

    // With Buffer
    static class Solution01 {
        void deleteDuplicate(Node head) {
            Node prev = null;
            Node node = head;
            Set<Integer> checker = new HashSet<>();
            while (node != null) {
                if (!checker.contains(node.data)) {
                    checker.add(node.data);
                    prev = node;
                } else {
                    prev.next = node.next;
                }
                node = node.next;
            }
        }
    }

    // Without Buffer.
    static class Solution02 {
        void deleteDuplicate(Node head) {
            Node prev = head;
            Node cur = head;
            while (cur != null) {
                Node runner = head;
                while (runner != cur) {
                    if (runner.data == cur.data) {
                        prev.next = cur.next;
                        cur = cur.next;
                        break;
                    }
                    runner = runner.next;
                }
                if (runner == cur) {
                    prev = cur;
                    cur = cur.next;
                }
            }
        }
    }
}
