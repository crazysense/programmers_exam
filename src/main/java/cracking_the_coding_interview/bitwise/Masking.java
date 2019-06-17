package cracking_the_coding_interview.bitwise;

// 비트채우기
public class Masking {
    public static void main(String[] args) {
        updateBits(toNum("1111011110"), toNum("10011"), 2, 6);
    }

    static void updateBits(int n, int m, int i, int j) {
        int allOnes = ~0;
        System.out.println(Integer.toBinaryString(allOnes));
        int left = allOnes << (j + 1);
        System.out.println(Integer.toBinaryString(left));
        int right = ((1 << i)) - 1;
        System.out.println(Integer.toBinaryString(right));
        int mask = left | right;
        System.out.println(Integer.toBinaryString(mask));
        System.out.println(Integer.toBinaryString(n));
        int n_cleared = n & mask;
        System.out.println(Integer.toBinaryString(n_cleared));
        int m_shifted = m << i;
        System.out.println(Integer.toBinaryString(m_shifted));
        System.out.println(Integer.toBinaryString(n_cleared | m_shifted));

    }

    static int toNum(String binary) {
        char[] arr = binary.toCharArray();
        int n = 2;
        int res = Character.getNumericValue(arr[arr.length - 1]);
        for (int i = arr.length - 2; i >= 0; i--) {
            res += Character.getNumericValue(arr[i]) * n;
            n *= 2;
        }
        return res;
    }
}
