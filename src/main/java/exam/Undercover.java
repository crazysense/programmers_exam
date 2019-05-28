package exam;

import java.util.HashMap;
import java.util.Map;

public class Undercover {
    public static void main(String[] args) {
        String[][] clothes = new String[][]{
                {"yellow_hat", "headgear" },
                {"yellow_hat2", "headgear" },
                {"yellow_hat3", "headgear" },
                {"blue_sunglasses", "eyewear" },
                {"blue_sunglasses2", "eyewear" },
                {"green_turban", "headgear2" },
                {"green_turban2", "headgear2" },
                {"green_turban3", "headgear2" },
        };
        System.out.println(solution1(clothes));
        System.out.println(solution2(clothes));
    }

    static int solution1(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String kind = clothes[i][1];
            Integer num = clothesMap.get(kind);
            if (num == null) {
                clothesMap.put(kind, 1);
            } else {
                clothesMap.put(kind, num + 1);
            }
        }

        int sum = 0;
        for (Integer num : clothesMap.values()) {
            int tmp = sum;
            sum += num;
            sum += tmp * num;
            System.out.println(sum);
        }

        return sum;
    }

    static int solution2(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes)
            map.merge(clothe[1], 1, (a, b) -> a + b);
        return map.values().stream().reduce((a, b) -> (a + b) + (a * b)).orElse(0);
    }

}
