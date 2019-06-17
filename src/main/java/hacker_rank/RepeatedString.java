package hacker_rank;

// 무한히 반복되는 길이 n 의 문자에서 'a' 가 몇 번 나오는지 구하라.

public class RepeatedString {
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int len = s.length();

        long result = count('a', s, len) * n / len;
        result += count('a', s, (int)(n % len));

        return result;
    }

    static long count(char c, String s, int len) {
        long cnt = 0;
        for (int i = 0; i < len; i++) {
            if (c == s.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        long res = repeatedString("epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq", 549382313570L);
        System.out.println(res);
    }
}
