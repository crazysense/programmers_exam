package hacker_rank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

// 윈도우
// 1 부터 n 까지의 윈도우를 생성하고 각 윈도우의 최소값을 구하고 그 중에서 최대값을 구하라.

public class MinMaxRiddle {
    public static void main(String[] args) throws IOException {
//        List<String> s = Files.readAllLines(Paths.get("D:\\development\\projects\\programmers-exam\\src\\main\\resources\\minmaxriddle_test"));
//        long[] arr = Arrays.stream(s.get(0).split("\\s+")).mapToLong(Long::valueOf).toArray();
        long[] arr = new long[]{3, 5, 4, 7, 6, 2};
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(riddle(arr)));
        long end = System.currentTimeMillis();
        System.out.println("Duration: " + (end - start));
    }

    static long[] riddle(long[] arr) {
        long[] result = new long[arr.length];

        for (int w = 1; w <= arr.length; w++) {
            MyWindow window = new MyWindow(w);
            for (int i = 1; i <= arr.length; i++) {
                window.add(arr[i - 1]);
                if (i >= w) {
                    result[w - 1] = Math.max(result[w - 1], window.getMin());
                }
            }
        }

        return result;
    }

    static class MyWindow {
        private final int size;
        private Queue<Long> data = new LinkedList<>();
        private Deque<Long> max = new LinkedList<>();

        public MyWindow(int size) {
            this.size = size;
        }

        void add(long value) {
            if (data.size() == this.size) {
                Long remove = data.poll();
                if (max.peekFirst().equals(remove)) {
                    max.pollFirst();
                }
            }
            data.add(value);
            while (!max.isEmpty() && value < max.peekLast()) {
                max.pollLast();
            }
            max.addLast(value);
        }

        Long getMin() {
            return max.peekFirst();
        }

    }
}
