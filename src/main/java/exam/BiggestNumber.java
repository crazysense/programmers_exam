package exam;

import java.util.Arrays;

public class BiggestNumber {
    public static void main(String[] args) {
//        System.out.println(solution1(new int[]{6, 10, 2}));
        System.out.println(solution1(new int[]{5, 9, 34, 3, 30}));
    }

    static String solution1(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                String si = String.valueOf(numbers[i]);
                String sj = String.valueOf(numbers[j]);
                if (Integer.parseInt(si + sj) > Integer.parseInt(sj + si)) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = tmp;
                }
            }
            System.out.println(Arrays.toString(numbers));
        }

        System.out.println(Arrays.toString(numbers));

        StringBuilder sb = new StringBuilder();
        for (int i = numbers.length - 1; i >= 0; i--) {
            sb.append(numbers[i]);
        }
        return sb.toString();
    }
}
