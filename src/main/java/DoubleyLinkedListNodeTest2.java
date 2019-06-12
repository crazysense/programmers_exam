public class DoubleyLinkedListNodeTest2 {
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

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
        DoublyLinkedListNode front = head;
        DoublyLinkedListNode rear = head;
        int size = 1;
        while (rear.next != null) {
            rear = rear.next;
            size++;
        }

        for (int i = 0; i < size / 2; i++) {
            int tmp = front.data;
            front.data = rear.data;
            rear.data = tmp;

            front = front.next;
            rear = rear.prev;
        }

        return head;
    }

    static DoublyLinkedListNode reverse2(DoublyLinkedListNode head) {
        DoublyLinkedListNode temp = head;
        DoublyLinkedListNode newHead = head;
        while (temp != null) {
            DoublyLinkedListNode prev = temp.prev;
            temp.prev = temp.next;
            temp.next = prev;
            newHead = temp;
            temp = temp.prev;
        }
        return newHead;
    }

    static void print(DoublyLinkedListNode head) {
        DoublyLinkedListNode node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    static void print2(DoublyLinkedListNode head) {
        DoublyLinkedListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList test = new DoublyLinkedList();
        test.insertNode(1);
        test.insertNode(2);
        test.insertNode(3);
        test.insertNode(4);

        print(test.head);

        print(reverse(test.head));

        print(reverse2(test.head));
    }
}
