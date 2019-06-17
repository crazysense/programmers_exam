package hacker_rank;

import java.util.Arrays;

// 소문자는 대문자로 변경 가능
// 소문자는 삭제 가능
// a 를 변형한 값이 b 와 같을 수 있는가
public class Abbreviation {
    static String abbreviation(String a, String b) {
//        boolean[][] isValid = new boolean[a.length() + 1][b.length() + 1];
        int[][] isValid = new int[a.length() + 1][b.length() + 1];
        // initializing the first raw to all false; ie. if b is
        // not empty, isValid will always be false
//        isValid[0][0] = true;
        isValid[0][0] = 1;
        // array initialization - if a is non-empty but b is empty,
        // then isValid == true iff remaining(a) != contain uppercase
        boolean containsUppercase = false;
        for (int k = 1; k <= a.length(); k++) {
            int i = k - 1;
            // if the pointer at string a is uppercase
            if (a.charAt(i) <= 90 && a.charAt(i) >= 65 || containsUppercase) {
                containsUppercase = true;
//                isValid[k][0] = false;
                isValid[k][0] = 0;
            } else {
//                isValid[k][0] = true;
                isValid[k][0] = 1;
            }
        }
        // tabulation from start of string
        for (int k = 1; k <= a.length(); k++) {
            for (int l = 1; l <= b.length(); l++) {
                int i = k - 1;
                int j = l - 1;
                // when the characters are equal, set = previous character bool.
                if (a.charAt(i) == b.charAt(j)) {
                    isValid[k][l] = isValid[k - 1][l - 1];
                    continue;
                }
                // elif uppercase a == b, set = prev character bool. or just eat a.
                else if ((int) a.charAt(i) - 32 == (int) b.charAt(j)) {
//                    isValid[k][l] = isValid[k - 1][l - 1] || isValid[k - 1][l];
                    isValid[k][l] = isValid[k - 1][l - 1] == 1 || isValid[k - 1][l] == 1 ? 1 : 0;
                    continue;
                }
                // elif a is uppercase and no more b, or uppercase a is not b, then false
                else if (a.charAt(i) <= 90 && a.charAt(i) >= 65) {
//                    isValid[k][l] = false;
                    isValid[k][l] = 0;
                    continue;
                }
                //else just eat a
                else {
                    isValid[k][l] = isValid[k - 1][l];
                    continue;
                }
            }
//            print(isValid);
        }
        return isValid[a.length()][b.length()] == 1 ? "YES" : "NO";
    }

    static String abbreviation2(String a, String b) {
        int n = a.length();
        int m = b.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                if (!dp[i][j]) continue;
                char c = a.charAt(i);
                if (j < m && (int) c - 32 == (int) b.charAt(j)) {
                    dp[i + 1][j + 1] = true;
                }
                if (c >= 'a' && c <= 'z') {
                    dp[i + 1][j] = true;
                }
            }

            print(dp);
        }
        return dp[n][m] ? "YES" : "NO";
    }

    static void print(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(abbreviation("daBcd", "ABC"));
        System.out.println(abbreviation2("daBcd", "ABC"));
    }
}
