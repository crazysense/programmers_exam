package hacker_rank;

// 문자의 중복이 있는지 검사한다.

public class UniqueChar {
    public static void main(String[] args) {
        String v1 = "abcdefghijklmn";
        System.out.println(isUnique(v1));
        System.out.println(isUnique2(v1));

        String v2 = "abcdeabcde";
        System.out.println(isUnique(v2));
        System.out.println(isUnique2(v2));
    }

    static boolean isUnique(String input) {
        boolean[] b = new boolean[256];
        for (int i = 0; i < input.length(); i++) {
            int c = input.charAt(i);
            if (b[c]) {
                return false;
            }
            b[c] = true;
        }
        return true;
    }

    static boolean isUnique2(String input) {
        int checker = 0;
        for (int i = 0; i < input.length(); i++) {
            int c = input.charAt(i) - 'a';
            if ((checker & 1 << c) == 1) {
                return false;
            }
            checker |= 1 << c;
        }
        return true;
    }
}
