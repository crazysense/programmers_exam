public class AlternatingCharacter {
    static int alternatingCharacters(String s) {
        int len = s.length();
        int cnt = 0;
        for (int i = 0; i < len;) {
            int j;
            for (j = i + 1; j < len; j++) {
                if (s.charAt(i) != s.charAt(j)) break;
            }
            cnt += (j - i - 1);
            i = j;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(alternatingCharacters("AAABBB"));
    }
}
