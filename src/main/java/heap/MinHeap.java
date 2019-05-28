package heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    public static class MinHeapStruct {
        List<Integer> heap;

        public MinHeapStruct() {
            this.heap = new ArrayList<>();
        }

        public void insert(int n) {
            this.heap.add(n);
            int p = this.heap.size() - 1;
            while (p > 0) {
                int rootIndex = (p - 1) / 2;
                if (this.heap.get(p) < this.heap.get(rootIndex)) {
                    int tmp = this.heap.get(p);
                    this.heap.set(p, this.heap.get(rootIndex));
                    this.heap.set(rootIndex, tmp);
                } else {
                    break;
                }
                p = rootIndex;
            }
        }

        public int delete() {
            int result = this.heap.get(0);
            int last = this.heap.remove(this.heap.size() - 1);
            this.heap.set(0, last);

            int p = 0;
            while (p * 2 + 1 < this.heap.size()) {
                int smallerIndex = p * 2 + 1;
                int minValue = this.heap.get(smallerIndex);
                if (p * 2 + 2 < this.heap.size() && minValue > this.heap.get(p * 2 + 2)) {
                    smallerIndex = p * 2 + 2;
                    minValue = this.heap.get(smallerIndex);
                }

                int tmp = this.heap.get(p);
                if (tmp < minValue) {
                    break;
                }
                this.heap.set(p, minValue);
                this.heap.set(smallerIndex, tmp);


                p = smallerIndex;
            }

            return result;
        }

        void print() {
            this.heap.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MinHeapStruct minHeap = new MinHeapStruct();

        minHeap.insert(10);

        System.out.printf("Insert %2d : ", 10);
        minHeap.print();

        minHeap.insert(2);

        System.out.printf("Insert %2d : ", 2);
        minHeap.print();

        minHeap.insert(4);

        System.out.printf("Insert %2d : ", 4);
        minHeap.print();

        minHeap.insert(15);

        System.out.printf("Insert %2d : ", 15);
        minHeap.print();

        minHeap.insert(8);

        System.out.printf("Insert %2d : ", 8);
        minHeap.print();

        minHeap.delete();

        System.out.print("Delete    : ");
        minHeap.print();

        minHeap.insert(7);

        System.out.printf("Insert %2d : ", 7);
        minHeap.print();

        minHeap.insert(1);

        System.out.printf("Insert %2d : ", 1);
        minHeap.print();

        minHeap.delete();

        System.out.print("Delete    : ");
        minHeap.print();
    }
}
