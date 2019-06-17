package hacker_rank;

import java.util.Arrays;

// 아나그램
// 문자열을 자르고 서로 다른 문자가 쌍이 되는지 찾아야 한다.

public class SherlockAndAnagrams {
    static int sherlockAndAnagrams(String s) {
        int count = 0;
        int len = s.length();
        for (int i = 0; i < len - 1; i++) {
            for (int j = 1; j < len - i; j++) {
                String target = s.substring(i, i + j);
                for (int k = i + 1; k <= len - j; k++) {
                    String diff = s.substring(k, k + j);
                    if (isAnagram(target, diff)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static boolean isAnagram(String s1, String s2) {
        return sort(s1).equals(sort(s2));
    }

    static String sort(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
    }
}
