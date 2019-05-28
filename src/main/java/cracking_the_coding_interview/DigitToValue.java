package cracking_the_coding_interview;

public class DigitToValue {
    public static void main(String[] args) {
        String s1 = "1000";
        String s2 = "1001";

        int i1 = to10(s1, 2);
        int i2 = to10(s2, 2);

        assert i1 == i2;
    }

    static int to10(String input, int base) {
        int value = 0;
        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(input.length() - i - 1) - '0';
            value += digit * pow(base, i);
        }
        System.out.println(value);
        return value;
    }

    static int pow(int base, int exp) {
        int result = 1;
        for (int i = 0; i < exp; i++) {
            result *= base;
        }
        return result;
    }
}
