package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Test05 {
    static class Window {
        private Queue<Long> q = new LinkedList<>();
        private long windowSize;

        public Window(long windowSize) {
            this.windowSize = windowSize;
        }

        public void add(Long value) {
            if (q.size() == windowSize) q.poll();
            q.add(value);
        }

        public int size() {
            return q.size();
        }

        public long getMax() {
            long max = Long.MIN_VALUE;
            for (Long item : q)
                if (item > max) max = item;
            return max;
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        try {
            long windowSize = Long.parseLong(input);
            Window w = new Window(windowSize);

            while (true) {
                try {
                    input = br.readLine();
                    if (input.equals("")) {
                        break;
                    }
                    long value = Long.parseLong(input);
                    w.add(value);
                    if (windowSize == w.size()) {
                        System.out.println(w.getMax());
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Number Only");
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Number Only");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
