package brute_force;

import java.util.*;

public class MockExam {
    public static void main(String[] args) {
//        int[] answer = new int[]{1, 3, 2, 4, 2, };
        int[] answer = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        MockExam sol = new MockExam();
        System.out.println(Arrays.toString(sol.solution(answer)));
    }

    class Student {
        private int id;
        private int[] number;
        private int score = 0;

        public Student(int id, int... number) {
            this.id = id;
            this.number = number;
        }

        public int getId() {
            return id;
        }

        public int getScore() {
            return score;
        }

        public void scoring(int answer, int numberOfQuestion) {
            if (answer == number[numberOfQuestion % number.length]) {
                this.score += 1;
            }
        }
    }

    public int[] solution(int[] answers) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, 1, 2, 3, 4, 5));
        students.add(new Student(2, 2, 1, 2, 3, 2, 4, 2, 5));
        students.add(new Student(3, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5));

        int maxScoreTmp = 0;
        for (int i = 0; i < answers.length; i++) {
            for (Student student : students) {
                student.scoring(answers[i], i);
                if (student.getScore() > maxScoreTmp) {
                    maxScoreTmp = student.getScore();
                }
            }
        }

        final int maxScore = maxScoreTmp;
        return maxScore == 0 ? new int[]{1, 2, 3}
                : students.stream()
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .filter(s -> s.getScore() >= maxScore)
                .mapToInt(Student::getId)
                .toArray();
    }
}
