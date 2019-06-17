package hacker_rank;

// 순환큐
// 순환 연결리스트
public class MyCircleQueue {
    private Object[] q;
    private int front = 0, rear = 0;

    public MyCircleQueue(int capacity) {
        this.q = new Object[capacity + 1];
    }

    public void add(int data) {
        if (isFull()) {
            System.out.println("Queue is Full!");
            return;
        }
        q[rear] = data;
        rear = (rear + 1) % q.length;
    }

    public <T> T peek() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return null;
        }
        return (T) q[front];
    }

    public <T> T poll() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return null;
        }
        T res = peek();
        front = (front + 1) % q.length;
        return res;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == q.length - 1;
    }

    public int size() {
        return Math.abs(rear - front);
    }

    public boolean isAvaliable() {
        return q.length - 1 - size() > 0;
    }

    public void print() {
        for (int i = front; i != rear; i = (i + 1) % q.length) {
            System.out.print(q[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        MyCircleQueue q = new MyCircleQueue(3);
        System.out.println("size: " + q.size());
        q.print();
        q.add(1);
        q.print();
        System.out.println("size: " + q.size());
        System.out.println("isAvailable: " + q.isAvaliable());
        q.add(2);
        q.print();
        System.out.println("size: " + q.size());
        System.out.println("isAvailable: " + q.isAvaliable());
        q.add(3);
        q.print();
        System.out.println("size: " + q.size());
        System.out.println("peek: " + q.peek());
        System.out.println("isAvailable: " + q.isAvaliable());
        q.add(4);
        q.print();
        System.out.println("size: " + q.size());
        System.out.println("poll: " + q.poll());
        System.out.println("isAvailable: " + q.isAvaliable());
        q.print();
        System.out.println("size: " + q.size());
        q.add(5);
        q.print();
        System.out.println("poll: " + q.poll());
        System.out.println("poll: " + q.poll());
        System.out.println("poll: " + q.poll());
        System.out.println("poll: " + q.poll());
        q.print();
        q.add(1);
        q.print();
        System.out.println("size: " + q.size());
        System.out.println("poll: " + q.poll());
        System.out.println("size: " + q.size());
    }
}
