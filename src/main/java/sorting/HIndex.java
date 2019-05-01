package sorting;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        HIndex sol = new HIndex();
        int[] citations = new int[]{300,0,600,0,500};
        System.out.println(sol.solution(citations));
    }

    public int solution(int[] citations) {
        int min, answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            min = citations[i] < citations.length - i ? citations[i] : citations.length - i;
            answer = answer > min ? answer : min;
        }
        return answer;
    }
}
