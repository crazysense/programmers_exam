package heap;

import java.util.Arrays;

public class DurablePriorityQueue {
    public static void main(String[] args) {
        DurablePriorityQueue sol = new DurablePriorityQueue();
        String[] oper = new String[]{
//                "I 5", "I 7", "I -5", "D -1"
//                "I 16", "D 1"
                "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"
        };
        System.out.println(Arrays.toString(sol.solution(oper)));
    }

    public int[] solution(String[] operations) {
        Queue q = new Queue(operations.length);

        for (String operation : operations) {
            String[] oper = operation.split("\\s+");
            int data = Integer.parseInt(oper[1]);

            if (oper[0].equals("I")) q.offer(data);
            else if (data == 1) q.deleteMax();
            else q.deleteMin();
        }

        return new int[]{q.deleteMax(), q.deleteMin()};
    }

    class Queue {
        int[] heap;
        int p;

        public Queue(int size) {
            this.heap = new int[size];
            this.p = 0;
        }

        void offer(int schedule) {
            if (p == heap.length) return;

            heap[p] = schedule;
            int cur = p, parent = (p - 1) / 2;
            while (cur != parent && parent > -1) {
                if (heap[cur] > heap[parent]) swap(cur, parent);
                if (parent == 0) break;
                cur = parent;
                parent = (parent - 1) / 2;
            }
            ++p;
        }

        int deleteMax() {
            if (p == 0) return 0;

            int pop = heap[0];
            heap[0] = heap[--p];

            int cur = 0;
            while (cur < p) {
                int left = cur * 2 + 1;
                int right = cur * 2 + 2;

                int child = cur;
                if (left < p && heap[cur] < heap[left]) child = left;
                if (right < p && heap[cur] < heap[right] && heap[child] < heap[right]) child = right;
                if (child == cur) break;

                swap(cur, child);
                cur = child;
            }

            return pop;
        }

        int deleteMin() {
            if (p == 0) return 0;
//            int parent = 0;
//            int left = p * 2 + 1;
//            int rifht = p * 2 + 2;
//
//            int idx
//            if(left < p)
//
            return heap[--p];
        }

        private void swap(int i1, int i2) {
            int tmp = heap[i1];
            heap[i1] = heap[i2];
            heap[i2] = tmp;
        }
    }
}
