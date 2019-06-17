package cracking_the_coding_interview;

// 시계 각도
// 시간
public class TimeDegree {
    public static void main(String[] args) {
        System.out.println(solution(12, 80));
    }

    static double solution(int hour, int minutes) {
        int minutesAdj = minutes % 60;
        int hourAdj = hour % 12 + minutes / 60;
        double hourDegree = 30.0 * hourAdj + (double) minutesAdj / 2.0;
        double minuteDegree = 6.0 * minutesAdj;
        return Math.abs(minuteDegree - hourDegree);
    }
}
