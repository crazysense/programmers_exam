package hacker_rank;

public class DoubleyLinkedListNodeTest {
    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
        if (head == null) {
            return new DoublyLinkedListNode(data);
        }

        DoublyLinkedListNode cur = head;
        DoublyLinkedListNode prev = head;
        while (cur != null && cur.data < data) {
            prev = cur;
            cur = cur.next;
        }

        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if (prev == cur) {
            newNode.prev = prev.prev;
            newNode.next = prev;
            prev.prev = newNode;
            if (newNode.prev != null) {
                newNode.prev.next = newNode;
            }
        } else {
            newNode.next = prev.next;
            newNode.prev = prev;
            prev.next = newNode;
            if (newNode.next != null) {
                newNode.next.prev = newNode;
            }
        }

        return head;
    }

    static void print(DoublyLinkedListNode head) {
        DoublyLinkedListNode node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList test = new DoublyLinkedList();
        test.insertNode(2);
        test.insertNode(3);
        test.insertNode(4);

        print(test.head);

        sortedInsert(test.head, 1);

        print(test.head);
    }
}
