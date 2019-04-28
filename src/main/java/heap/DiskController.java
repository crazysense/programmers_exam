package heap;

import java.util.ArrayList;
import java.util.List;

public class DiskController {
    public static void main(String[] args) {
        int[][] jobs = new int[][]{
                {1, 10},{1, 10},{1,10},{1,10}
//                {0, 30}, {1, 65}, {50, 10}
        };
        DiskController sol = new DiskController();
        System.out.println(sol.solution(jobs));
    }

    public int solution(int[][] jobs) {
        int totalJobCount = jobs.length;
        int processedJobCount = 0;
        int answer = 0;

        JobHeap waitingJobs = new JobHeap(totalJobCount);
        for (int i = 0; i < jobs.length; i++)
            waitingJobs.offer(new Job(jobs[i][0], jobs[i][1]));

        int processingTime = waitingJobs.peek().getRequestTime();
        while (processedJobCount < totalJobCount) {
            List<Job> jobList = new ArrayList<>();
            while (waitingJobs.peek() != null && waitingJobs.peek().getRequestTime() <= processingTime) {
                jobList.add(waitingJobs.poll());
                processedJobCount++;
            }

            if (jobList.isEmpty()) {
                processingTime = waitingJobs.peek().getRequestTime();
                continue;
            }

            int minIdx = 0, processTime = 0, totalTime = Integer.MAX_VALUE;
            for (int i = 0; i < jobList.size(); i++) {
                Job job = jobList.get(i);
                int elapsedTime = processingTime - job.getRequestTime() + job.getProcessTime();
                if (totalTime > elapsedTime) {
                    totalTime = elapsedTime;
                    processTime = job.getProcessTime();
                    minIdx = i;
                }
            }

            for (int i = 0; i < jobList.size(); i++) {
                if (i != minIdx) {
                    waitingJobs.offer(jobList.get(i));
                    processedJobCount--;
                }
            }

            processingTime += processTime;
            answer += totalTime;
        }

        return answer / totalJobCount;
    }

    class Job {
        int requestTime;
        int processTime;

        public Job(int requestTime, int processTime) {
            this.requestTime = requestTime;
            this.processTime = processTime;
        }

        public int getRequestTime() {
            return requestTime;
        }

        public int getProcessTime() {
            return processTime;
        }
    }

    class JobHeap {
        Job[] heap;
        int p;

        public JobHeap(int size) {
            this.heap = new Job[size];
            this.p = 0;
        }

        void offer(Job job) {
            if (p == heap.length) throw new ArrayIndexOutOfBoundsException("Heap is full.");

            heap[p] = job;
            int cur = p, parent = (p - 1) / 2;
            while (cur != parent && parent > -1) {
                if (heap[cur].getRequestTime() < heap[parent].getRequestTime()) swap(cur, parent);
                if (parent == 0) break;
                cur = parent;
                parent = (parent - 1) / 2;
            }
            ++p;
        }

        Job peek() {
            if (p == 0) return null;
            return heap[0];
        }

        Job poll() {
            if (p == 0) return null;

            Job res = heap[0];
            heap[0] = heap[--p];

            int cur = 0;
            while (cur < p) {
                int left = cur * 2 + 1;
                int right = cur * 2 + 2;

                int child = cur;
                if (left < p && heap[cur].getRequestTime() > heap[left].getRequestTime()) child = left;
                if (right < p && heap[cur].getRequestTime() > heap[right].getRequestTime()
                        && heap[child].getRequestTime() > heap[right].getRequestTime()) child = right;
                if (child == cur) break;

                swap(cur, child);
                cur = child;
            }

            return res;
        }

        private void swap(int i1, int i2) {
            Job tmp = heap[i1];
            heap[i1] = heap[i2];
            heap[i2] = tmp;
        }
    }
}
