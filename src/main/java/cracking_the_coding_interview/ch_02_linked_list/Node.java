package cracking_the_coding_interview.ch_02_linked_list;

public class Node {
    Node next = null;
    int data;

    public Node(int d) {
        this.data = d;
    }

    Node add(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
        return end;
    }

    Node delete(Node head, int d) {
        Node n = head;
        if (n.data == d) {
            return head.next;
        }
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                break;
            }
            n = n.next;
        }
        return head;
    }

    static void printNode(Node head) {
        Node n = head;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; n != null; i++) {
            if (i > 0) {
                sb.append(" -> ");
            }
            sb.append(n.data);
            n = n.next;
        }
        System.out.println(sb.toString());
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
