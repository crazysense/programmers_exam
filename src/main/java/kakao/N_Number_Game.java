package kakao;

public class N_Number_Game {
    public static void main(String[] args) {
        System.out.println(nNumberGame(2, 4, 2, 1));
        System.out.println(nNumberGame(16, 16, 2, 1));
        System.out.println(nNumberGame(16, 16, 2, 2));
        System.out.println(nNumberGame(12, 10, 3, 3));
    }

    static String nNumberGame(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (sb.length() < t * m) {
            sb.append(toNumber2(n, num++));
        }

        char[] arr = new char[t];
        for (int i = 0, j = p; i < arr.length; i++, j += m) {
            arr[i] = sb.charAt(j - 1);
        }
        return new String(arr);
    }

    static String toNumber2(int n, int number) {
        int a = number / n;
        int b = number % n;
        String s = b > 9 ? Character.toString((char) ('A' + b - 10)) : String.valueOf(b);
        if (a == 0) return s;
        return toNumber2(n, a) + s;
    }
}
