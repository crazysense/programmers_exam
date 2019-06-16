package hacker_rank;

import java.util.HashMap;

public class SherlockAndTheValidString {
    static String isValid(String s) {
        int[] word = new int[26];
        for (int i = 0; i < s.length(); i++) {
            ++word[s.charAt(i) - 'a'];
        }

        String result = "NO";
        int key1 = 0, key2 = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length; i++) {
            if (word[i] == 0) continue;
            if (!map.containsKey(word[i])) {
                if (map.size() > 1) return result;
                else if (map.size() == 1) key1 = word[i];
                else key2 = word[i];
                map.put(word[i], 1);
            } else {
                map.put(word[i], map.get(word[i]) + 1);
            }
        }

        int minKey = key1 < key2 ? key1 : key2;
        int maxKey = key1 > key2 ? key1 : key2;
        if (map.size() == 1
                || (minKey == 1 && map.get(minKey) == 1)
                || (maxKey - minKey == 1 && map.get(maxKey) == 1)) {
            result = "YES";
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(isValid("aabbcd"));
    }
}
