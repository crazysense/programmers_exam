import java.io.BufferedWriter;
import java.io.IOException;

public class FindMergePointTwoList {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode p1 = head1, p2 = head2;
        while (p1 != p2) {
            p1 = p1.next == null ? head1 : p1.next;
            p2 = p2.next == null ? head2.next :
                    p2.next.next == null ? head2 : p2.next.next;
        }

        p1 = head1;
        while (p1 != p2) {
            p1 = p1.next == null ? head1 : p1.next;
            p2 = p2.next == null ? head2 : p2.next;
        }

        return p1.data;
    }

    public static void main(String[] args) {
        SinglyLinkedListNode h1 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode h1_2 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode mergeNode = new SinglyLinkedListNode(3);
        SinglyLinkedListNode h1_4 = new SinglyLinkedListNode(4);
        SinglyLinkedListNode h1_5 = new SinglyLinkedListNode(5);

        h1.next = h1_2;
        h1_2.next = mergeNode;
        mergeNode.next = h1_4;
        h1_4.next = h1_5;

        SinglyLinkedListNode h2 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode h2_2 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode h2_4 = new SinglyLinkedListNode(4);
        SinglyLinkedListNode h2_5 = new SinglyLinkedListNode(5);
        SinglyLinkedListNode h2_6 = new SinglyLinkedListNode(6);

        h2.next = h2_2;
        h2_2.next = h2_4;
        h2_4.next = h2_5;
        h2_5.next = h2_6;
        h2_6.next = mergeNode;

        System.out.println(findMergeNode(h1, h2));
    }
}
