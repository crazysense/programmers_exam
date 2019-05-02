package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Test03 {


    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input);

        try {
            String[] inputs = input.split("\\s+");
            int[] numbers = new int[inputs.length];
            for (int i = 0; i < inputs.length; i++) {
                numbers[i] = Integer.parseInt(inputs[i]);
            }

            String targetInput = br.readLine();
            int targetNumber = Integer.parseInt(targetInput);

            List<int[]> acc = new ArrayList<>();
            int[] comb = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                combination(numbers, comb, 0, i + 1, 0, targetNumber, acc);
            }

            if (acc.size() > 0) {
                int[] res = acc.stream().sorted(Comparator.comparingInt(x -> x.length)).findFirst().get();
                String print = "";
                for (int i = 0; i < res.length; i++) {
                    if (i > 0) print += " ";
                    print += res[i];
                }
                System.out.println(print);
            } else {
                System.out.println("-1");
            }

        } catch (NumberFormatException e) {
            System.err.println("Numbers Only.");
        }
    }

    private static void combination(final int[] numbers, int[] comb, int index, int r, int next, int targetNumber, List<int[]> acc) {
        if (r == 0) {
            if (IntStream.range(0, index).map(i -> comb[i]).sum() == targetNumber) {
                acc.add(Arrays.copyOf(comb, index));
            }
        } else if (next != numbers.length) {
            comb[index] = numbers[next];
            combination(numbers, comb, index + 1, r - 1, next + 1, targetNumber, acc);
            combination(numbers, comb, index, r, next + 1, targetNumber, acc);
        }
    }

}
