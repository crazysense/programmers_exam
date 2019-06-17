package hacker_rank;

import java.util.HashMap;
import java.util.Map;

// 아나그램을 만들기 위해서 삭제해야 할 문자의 개수 (최소)
public class MakeAnagram {
    static int makeAnagram(String a, String b) {
        HashMap<Character, Integer> aMap = new HashMap<>();
        HashMap<Character, Integer> bMap = new HashMap<>();

        for (int i = 0; i < a.length(); i++) {
            aMap.put(a.charAt(i), aMap.getOrDefault(a.charAt(i), 0) + 1);
        }
        for (int i = 0; i < b.length(); i++) {
            bMap.put(b.charAt(i), bMap.getOrDefault(b.charAt(i), 0) + 1);
        }

        HashMap<Character, Integer> bigMap = aMap.size() > bMap.size() ? aMap : bMap;
        HashMap<Character, Integer> smallMap = aMap.size() > bMap.size() ? bMap : aMap;
        for (Map.Entry<Character, Integer> se : smallMap.entrySet()) {
            Character c = se.getKey();
            Integer i = se.getValue();
            if (bigMap.containsKey(c)) {
                int cnt = bigMap.get(c);
                bigMap.put(c, cnt - i);
                smallMap.put(c, i - cnt);
            }
        }

        int cnt = 0;
        for (Integer value : aMap.values()) {
            if (value > 0) cnt += value;
        }
        for (Integer value : bMap.values()) {
            if (value > 0) cnt += value;
        }
        return cnt;
    }

    static int makeAnagram2(String a, String b) {
        int[] counter = new int[26];

        for (int i = 0; i < a.length(); i++) {
            ++counter[a.charAt(i) - 'a'];
        }
        for (int i = 0; i < b.length(); i++) {
            --counter[b.charAt(i) - 'a'];
        }

        int sum = 0;
        for (int i = 0; i < counter.length; i++) {
            sum += Math.abs(counter[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(makeAnagram("ccde", "abcf"));
        System.out.println(makeAnagram2("ccde", "abcf"));
    }
}
