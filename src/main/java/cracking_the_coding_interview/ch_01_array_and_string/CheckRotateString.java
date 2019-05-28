package cracking_the_coding_interview.ch_01_array_and_string;

public class CheckRotateString {
    public static void main(String[] args) {
        String s1 = "erbottlewat";
        String s2 = "waterbottle";

        Solution01 sol01 = new Solution01();
        System.out.println(sol01.isRotation(s1, s2));

        Solution02 sol02 = new Solution02();
        System.out.println(sol02.isRotation(s1, s2));
    }

    static class Solution01 {
        boolean isRotation(String s1, String s2) {
            if (s1.length() == s2.length()) {
                return (s1 + s1).contains(s2);
            }
            return false;
        }
    }

    static class Solution02 {
        boolean isRotation(String s1, String s2) {
            if (s1.length() == s2.length()) {
                return isSubstring(s1 + s1, s2);
            }
            return false;
        }

        boolean isSubstring(String s1, String s2) {
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();

            for (int i = 0; i < c1.length && i + c2.length <= c1.length; i++) {
                if (c1[i] == c2[0]) {
                    boolean isMatch = true;
                    for (int j = 1; j < c2.length; j++) {
                        if (c1[i + j] != c2[j]) {
                            isMatch = false;
                            break;
                        }
                    }
                    if (isMatch) return true;
                }
            }
            return false;
        }
    }
}
