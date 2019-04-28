package stack_queue;

import java.util.function.Predicate;

public class Printer {
    public static void main(String[] args) {
        Printer sol = new Printer();
        int[] priorities = new int[]{1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(sol.solution(priorities, location));
    }

    public int solution(int[] priorities, int location) {
        PrinterQueue q = new PrinterQueue();
        for (int i = 0; i < priorities.length; i++) {
            int p = priorities[i];
            q.put(p, i);
        }

        int[] res = new int[q.size()];
        int idx = 0;
        while (q.size() > 0) {
            PrintNode node = q.poll();
            if (q.find(n -> n.getData() > node.getData()) != null)
                q.put(node.getData(), node.getLoc());
            else res[idx++] = node.getLoc();
        }

        for (int i = 0; i < res.length; i++)
            if (res[i] == location) return i + 1;

        return 0;
    }

    class PrintNode {
        private int data;
        private int loc;
        private PrintNode next;

        PrintNode(int data, int loc) {
            this.data = data;
            this.loc = loc;
            this.next = null;
        }

        public int getData() {
            return data;
        }

        public int getLoc() {
            return loc;
        }

        public PrintNode getNext() {
            return next;
        }

        public void setNext(PrintNode next) {
            this.next = next;
        }
    }

    class PrinterQueue {
        private PrintNode front;
        private PrintNode rear;
        private int size;

        public PrinterQueue() {
            this.front = this.rear = null;
            this.size = 0;
        }

        public void put(int data, int loc) {
            PrintNode n = new PrintNode(data, loc);
            if (front == null) {
                front = rear = n;
            } else {
                rear.setNext(n);
                rear = n;
            }
            ++size;
        }

        public PrintNode poll() {
            if (front == null) {
                throw new RuntimeException("Queue is empty.");
            }
            PrintNode res = front;
            front = front.getNext();
            if (front == null) rear = null;
            --size;
            return res;
        }

        public PrintNode find(Predicate<PrintNode> p) {
            PrintNode n = front;
            while (n != null) {
                if (p.test(n)) return n;
                n = n.getNext();
            }
            return null;
        }

        public int size() {
            return size;
        }
    }
}
