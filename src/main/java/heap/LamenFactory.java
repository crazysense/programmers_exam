package heap;

public class LamenFactory {
    public static void main(String[] args) {
        LamenFactory sol = new LamenFactory();
        int stock = 4;
        int[] dates = new int[]{4,10,15};
        int[] supplies = new int[]{20,5,10};
        int k = 30;
        System.out.println(sol.solution(stock, dates, supplies, k));
    }

    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int i = 0, cnt = 0;
        SupplierHeap heap = new SupplierHeap(dates.length);

        while (stock < k) {
            while (i < dates.length && dates[i] <= stock)
                heap.offer(supplies[i++]);
            stock += heap.poll();
            cnt++;
        }
        return cnt;
    }

    class SupplierHeap {
        int[] heap;
        int p;

        public SupplierHeap(int size) {
            this.heap = new int[size];
            this.p = 0;
        }

        void offer(int schedule) {
            if (p == heap.length) throw new ArrayIndexOutOfBoundsException("Heap is full.");

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

        int poll() {
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

        private void swap(int i1, int i2) {
            int tmp = heap[i1];
            heap[i1] = heap[i2];
            heap[i2] = tmp;
        }
    }
}
