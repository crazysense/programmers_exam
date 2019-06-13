import java.util.Arrays;

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
