package hacker_rank;

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
