package hash;

import java.util.HashMap;
import java.util.Map;

public class Undercover {
    public static void main(String[] args) {
        Undercover sol = new Undercover();
        String[][] clothes = new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"},
        };
        System.out.println(sol.solution(clothes));
    }

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes)
            map.merge(clothe[1], 1, (a, b) -> a + b);
        return map.values().stream().reduce((a, b) -> (a + b) + (a * b)).orElse(0);
    }
}
