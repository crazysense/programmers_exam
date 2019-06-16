package cracking_the_coding_interview.bitwise;

import java.util.Arrays;

public class BitSwapRequired {
    public static void main(String[] args) {
        System.out.println(bitSwapRequited(6, 1));

    }

    static int bitSwapRequited(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c >> 1) {
            count += c & 1;
        }
        return count;
    }
}
