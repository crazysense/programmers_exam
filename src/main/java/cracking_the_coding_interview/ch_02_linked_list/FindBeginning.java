package cracking_the_coding_interview.ch_02_linked_list;

// 두개의 순환리스트가 만나는곳
// 서클
public class FindBeginning {
    public static void main(String[] args) {
        Node n = new Node(1);
        n.add(2);
        n.add(3);
        Node start = n.add(4);
        n.add(5);
        n.add(6);
        n.add(7);
        n.add(8);
        n.add(9);
        n.add(10);
        Node last = n.add(11);
        last.next = start;

        Solution01 sol01 = new Solution01();
        System.out.println(sol01.findBeginning(n));
    }

    static class Solution01 {
        Node findBeginning(Node head) {
            Node slow = head;
            Node fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    break;
                }
            }

            if (fast != slow) {
                return null;
            }

            slow = head;
            while (fast != slow) {
                slow = slow.next;
                fast = fast.next;
            }

            return fast;
        }
    }
}
