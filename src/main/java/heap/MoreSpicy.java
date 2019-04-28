package heap;

public class MoreSpicy {
    public static void main(String[] args) {
        MoreSpicy sol = new MoreSpicy();
//        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int[] scoville = new int[]{0,0,1};
        int K = 2;
        System.out.println(sol.solution(scoville, K));
    }

    class ScovilleHeap {
        int[] heap;
        int p;

        public ScovilleHeap(int size) {
            this.heap = new int[size];
            this.p = 0;
        }

        void offer(int value) {
            if (p == heap.length) throw new ArrayIndexOutOfBoundsException("Heap is full.");

            heap[p] = value;
            int cur = p, parent = (p - 1) / 2;
            while (cur != parent && parent > -1) {
                if (heap[cur] < heap[parent]) swap(cur, parent);
                if (parent == 0) break;
                cur = parent;
                parent = (parent - 1) / 2;
            }
            ++p;
        }

        int peek() {
            if (p == 0) throw new ArrayIndexOutOfBoundsException("Heap is empty.");
            return heap[0];
        }

        int poll() {
            if (p == 0) throw new ArrayIndexOutOfBoundsException("Heap is empty.");

            int pop = heap[0];
            heap[0] = heap[--p];

            int cur = 0;
            while (cur < p) {
                int left = cur * 2 + 1;
                int right = cur * 2 + 2;

                int child = cur;
                if (left < p && heap[cur] > heap[left]) child = left;
                if (right < p && heap[cur] > heap[right] && heap[child] > heap[right]) child = right;
                if (child == cur) break;

                swap(cur, child);
                cur = child;
            }

            return pop;
        }

        private void swap(int i1, int i2) {
            int tmp = heap[i1];
            heap[i1] = heap[i2];
            heap[i2] = tmp;
        }
    }

    public int solution(int[] scoville, int K) {
        ScovilleHeap h = new ScovilleHeap(scoville.length);

        // min heap
        for (int i = 0; i < scoville.length; i++)
            h.offer(scoville[i]);

        try {
            int cnt;
            for(cnt = 0; h.peek() < K; cnt++)
                h.offer(h.poll() + h.poll() * 2);
            return cnt;
        } catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
    }
}
