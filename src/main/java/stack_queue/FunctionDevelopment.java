package stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelopment {
    public static void main(String[] args) {
        FunctionDevelopment sol = new FunctionDevelopment();
        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};
        System.out.println(Arrays.toString(sol.solution(progresses, speeds)));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Progress> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.add(new Progress(progresses[i], speeds[i]));
        }

        int idx = 0, deployCnt = 0;
        int[] deploys = new int[100];
        while (q.size() > 0) {
            Progress j = q.peek();
            if (j.isComplete()) {
                q.poll();
                deployCnt++;
            } else {
                if (deployCnt > 0) deploys[idx++] = deployCnt;
                for (Progress inComplete : q) inComplete.progressing();
                deployCnt = 0;
            }
        }
        if (deployCnt > 0) deploys[idx++] = deployCnt;
        return Arrays.copyOf(deploys, idx);
    }

    class Progress {
        int progress;
        int speed;

        public Progress(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }

        public void progressing() {
            int progressed = this.progress + this.speed;
            this.progress = progressed > 100 ? 100 : progressed;
        }

        public boolean isComplete() {
            return this.progress == 100;
        }
    }
}
