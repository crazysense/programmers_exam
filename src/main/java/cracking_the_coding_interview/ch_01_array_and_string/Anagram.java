package cracking_the_coding_interview.ch_01_array_and_string;

import java.util.Arrays;

// 아나그램
public class Anagram {
    public static void main(String[] args) {
        String s = "hellow", t = "elolhw";

        Solution01 sol1 = new Solution01();
        System.out.println(sol1.isAnagram(s, t));

        Solution02 sol2 = new Solution02();
        System.out.println(sol2.isAnagram(s, t));
    }

    static class Solution01 {
        boolean isAnagram(String s, String t) {
            if (s == null || t == null) return false;
            return sort(s).equals(sort(t));
        }

        String sort(String s) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            return new String(c);
        }
    }

    static class Solution02 {
        // Map 을 써도 되고, Array 를 써도 되고..
        boolean isAnagram(String s, String t) {
            if (s == null || t == null) return false;
            if (s.length() != t.length()) return false;

            int[] letters = new int[256]; // ASCII
            for (char c : s.toCharArray()) {
                ++letters[c];
            }

            for (int i = 0; i < t.length(); i++) {
                char c = t.charAt(i);
                if (--letters[c] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
