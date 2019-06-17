package heap;

import java.util.ArrayList;
import java.util.List;

// 최대 힙 구현
// (삭제시) 왼쪽 자식 = p * 2 + 1
// (삭제시) 오른쪽 자식 = p * 2 + 1
// (삽입시) 부모 = (p - 1) / 2
public class MaxHeap {
    static class MaxHeapStruct {
        List<Integer> heap;

        public MaxHeapStruct() {
            this.heap = new ArrayList<>();
        }

        void insert(int d) {
            this.heap.add(d);
            int p = this.heap.size() - 1;
            while (p > 0) {
                int rootIndex = (p - 1) / 2;
                int rootValue = this.heap.get(rootIndex);
                if (d > rootValue) {
                    this.heap.set(rootIndex, d);
                    this.heap.set(p, rootValue);
                } else {
                    break;
                }
                p = rootIndex;
            }
        }

        void delete() {
            int lastValue = this.heap.remove(this.heap.size() - 1);
            this.heap.set(0, lastValue);

            int p = 0;
            while (p * 2 + 1 < this.heap.size()) {
                int maxIndex = p * 2 + 1;
                int maxValue = this.heap.get(maxIndex);
                if (maxIndex + 1 < this.heap.size() && maxValue < this.heap.get(maxIndex + 1)) {
                    maxIndex += 1;
                    maxValue = this.heap.get(maxIndex);
                }

                if (lastValue > maxValue) {
                    break;
                }

                this.heap.set(p, maxValue);
                this.heap.set(maxIndex, lastValue);

                p = maxIndex;
            }
        }

        void print() {
            this.heap.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MaxHeapStruct maxHeap = new MaxHeapStruct();

        maxHeap.insert(10);

        System.out.printf("Insert %2d : ", 10);
        maxHeap.print();

        maxHeap.insert(2);

        System.out.printf("Insert %2d : ", 2);
        maxHeap.print();

        maxHeap.insert(4);

        System.out.printf("Insert %2d : ", 4);
        maxHeap.print();

        maxHeap.insert(15);

        System.out.printf("Insert %2d : ", 15);
        maxHeap.print();

        maxHeap.insert(8);

        System.out.printf("Insert %2d : ", 8);
        maxHeap.print();

        maxHeap.delete();

        System.out.print("Delete    : ");
        maxHeap.print();

        maxHeap.insert(7);

        System.out.printf("Insert %2d : ", 7);
        maxHeap.print();

        maxHeap.insert(1);

        System.out.printf("Insert %2d : ", 1);
        maxHeap.print();

        maxHeap.delete();

        System.out.print("Delete    : ");
        maxHeap.print();
    }
}
