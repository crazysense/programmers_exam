package exam;

public class KthNumber {
    public static void main(String[] args) {
        System.out.println(ktnNumber(new int[]{1, 5, 2, 6, 3, 7, 4}, 2, 5, 3));
        System.out.println(ktnNumber(new int[]{1, 5, 2, 6, 3, 7, 4}, 4, 4, 1));
        System.out.println(ktnNumber(new int[]{1, 5, 2, 6, 3, 7, 4}, 1, 7, 3));
    }

    static int ktnNumber(int[] array, int i, int j, int k) {
        for (int a = i; a < j; a++) {
            int temp = array[a];
            int b;
            for (b = a - 1; b >= i - 1 && temp < array[b]; b--) {
                array[b + 1] = array[b];
            }
            array[b + 1] = temp;
        }

        return array[i - 1 + k - 1];
    }
}
