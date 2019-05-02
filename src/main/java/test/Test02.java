package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test02 {

    static class FIFO {
        private String[] data;
        private int f, r;

        public FIFO(int maximum) {
            this.data = new String[maximum + 1];
            this.f = 0;
            this.r = 0;
        }

//        public boolean offer(String x) {
//            if (r == data.length) {
//                return false;
//            }
//            data[r++] = x;
//            return true;
//        }

        public boolean offer(String x) {
            if (isFull()) {
                return false;
            }
            r = (r + 1) % data.length;
            data[r] = x;
            return true;
        }

        public String take() {
            if (size() == 0) {
                return "";
            }
            f = (f + 1) % data.length;
            return data[f];
        }

//        public String take() {
//            if (f == r) {
//                return "";
//            }
//            return data[f++];
//        }

        public int size() {
            return Math.abs(r - f);
        }

        public boolean isFull() {
            return ((r + 1) % (data.length) == f);
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String[] firstOrder = input.split("\\s+");
        if (firstOrder.length != 2) {
            throw new IllegalArgumentException("First order must be [Numbers of Order] [Queue Size]");
        }
        try {
            int numberOfOrders = Integer.parseInt(firstOrder[0]);
            int queueSize = Integer.parseInt(firstOrder[1]);

            if (queueSize > 10_000) {
                throw new IllegalArgumentException("Queue Size cannot exceed 10,000");
            }

            FIFO queue = new FIFO(queueSize);

            while (numberOfOrders-- > 0) {
                input = br.readLine();
                String[] order = input.split("\\s+");
                if ("offer".equalsIgnoreCase(order[0])) {
                    if (order.length != 2) {
                        System.err.println("Command: [OFFER] [VALUE]");
                        numberOfOrders++;
                    } else {
                        System.out.println(queue.offer(order[1]));
                    }
                } else if ("take".equalsIgnoreCase(order[0])) {
                    System.out.println(queue.take());
                } else if ("size".equalsIgnoreCase(order[0])) {
                    System.out.println(queue.size());
                } else {
                    System.err.println("Command : [OFFER {VALUE} | TAKE | SIZE]");
                    numberOfOrders++;
                }
            }

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("First order must be [Numbers of Order] [Queue Size]");
        }
    }
}
