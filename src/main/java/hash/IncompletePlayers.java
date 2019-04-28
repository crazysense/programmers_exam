package hash;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class IncompletePlayers {
    public static void main(String[] args) {
        IncompletePlayers sol = new IncompletePlayers();
        String[] participant = new String[]{"leo", "kiki", "eden"};
        String[] completion = new String[]{"eden", "kiki"};
        System.out.println(sol.solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new LinkedHashMap<>();
        Arrays.stream(participant).forEach(s ->
                map.compute(s, (k, v) -> v == null ? 1 : v + 1));
        for (String c : completion) {
            Integer nums = map.computeIfPresent(c, (k, v) -> v - 1);
            if (nums != null && nums < 1) map.remove(c);
        }
        StringBuilder answer = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                if (answer.length() > 0) answer.append(", ");
                answer.append(entry.getKey());
            }
        }
        return answer.toString();
    }
}
