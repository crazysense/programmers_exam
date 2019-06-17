package exam;

import java.util.Arrays;

// 마라톤 완주한 사람
public class Marathon {
    public static void main(String[] args) {
        String[] participant = new String[]{
                "marina", "josipa", "nikola", "vinko", "zilipa", "marina"
        };
        String[] completion = new String[]{
                "marina", "josipa", "nikola", "vinko", "marina"
        };

        System.out.println(solution1(participant, completion));
    }

    static String solution1(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        int i;
        for (i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[i];
    }
}
