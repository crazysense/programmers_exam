import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        String s1 = "abcde";
        System.out.println(reverse(s1));

        char[] c1 = "abcde".toCharArray();
        reverse(c1);
        System.out.println(Arrays.toString(c1));

    }

    static String reverse(String input) {
        StringBuffer buffer = new StringBuffer();
        for (int i = input.length() - 1; i >= 0; i--) {
            buffer.append(input.charAt(i));
        }
        return buffer.toString();
    }

    static void reverse(char[] input) {
//        for (int i = 0; i < input.length / 2; i++) {
//            char tmp = input[i];
//            input[i] = input[input.length - i - 1];
//            input[input.length - i - 1] = tmp;
//        }

        for (int s = 0, e = input.length - 1; s < e; s++, e--) {
            char tmp = input[s];
            input[s] = input[e];
            input[e] = tmp;
        }
    }
}
