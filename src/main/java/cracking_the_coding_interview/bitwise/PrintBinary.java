package cracking_the_coding_interview.bitwise;

// 2진수변환
public class PrintBinary {
    public static void main(String[] args) {
        System.out.println(printBinary(0.625));
        System.out.println(printBinary2(0.625));
    }

    static String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        binary.append('.');

        while (num > 0) {
            if (binary.length() > 32) {
                return "ERROR";
            }

            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }

        return binary.toString();
    }

    static String printBinary2(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        binary.append('.');

        double frac = 0.5;
        while (num > 0) {
            if (binary.length() >= 32) {
                return "ERROR";
            }

            if (num >= frac) {
                binary.append(1);
                num -= frac;
            } else {
                binary.append(0);
            }

            frac /= 2;
        }

        return binary.toString();
    }
}
