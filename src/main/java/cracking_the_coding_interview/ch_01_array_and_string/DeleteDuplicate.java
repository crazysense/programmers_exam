package cracking_the_coding_interview.ch_01_array_and_string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeleteDuplicate {

    public static void main(String[] args) {
        char[] str = new char[]{'a', 'b', 'c', 'a', 'c', 'd'};

        System.out.println(Arrays.toString(str));

        char[] arr1 = Arrays.copyOf(str, str.length);
        removeDuplicates01(arr1);
        System.out.println("=======>");
        System.out.println(Arrays.toString(arr1));

        char[] arr2 = Arrays.copyOf(str, str.length);
        removeDuplicates02(arr2);
        System.out.println("=======>");
        System.out.println(Arrays.toString(arr2));

        char[] arr3 = Arrays.copyOf(str, str.length);
        removeDuplicates03(arr3);
        System.out.println("=======>");
        System.out.println(Arrays.toString(arr3));

        char[] arr4 = Arrays.copyOf(str, str.length);
        removeDuplicates04(arr4);
        System.out.println("=======>");
        System.out.println(Arrays.toString(arr4));
    }

    // No (Large) Additional Memory.
    static void removeDuplicates01(char[] str) {
        if (str == null) return;
        int len = str.length;
        if (len < 2) return;

        int tail = 1;

        for (int i = 0; i < len; i++) {
            int j;
            for (j = 0; j < tail; j++) {
                if (str[i] == str[j]) break;
            }
            if (j == tail) {
                str[tail] = str[i];
                ++tail;
            }
        }
//        str[tail] = 0;
        while (tail < len) {
            str[tail++] = 0;
        }
    }

    // No (Large) Additional Memory. (Bitwise)
    static void removeDuplicates02(char[] str) {
        if (str == null) return;
        int len = str.length;
        if (len < 2) return;

        int bitChecker = 0;
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if ((bitChecker & 1 << str[i]) == 0) {
                str[idx++] = str[i];
                bitChecker |= 1 << str[i];
            }
        }
        while (idx < len) {
            str[idx++] = 0;
        }
    }

    // Additional Memory
    static void removeDuplicates03(char[] str) {
        if (str == null) return;
        int len = str.length;
        if (len < 2) return;

        boolean[] hit = new boolean[256];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (!hit[str[i]]) {
                str[idx++] = str[i];
                hit[str[i]] = true;
            }
        }
        while (idx < len) {
            str[idx++] = 0;
        }
    }

    // Additional Memory (HashTable)
    static void removeDuplicates04(char[] str) {
        if (str == null) return;
        int len = str.length;
        if (len < 2) return;

        Map<Character, Boolean> exists = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (!exists.containsKey(str[i])) {
                str[idx++] = str[i];
                exists.put(str[i], true);
            }
        }
        while (idx < len) {
            str[idx++] = 0;
        }
    }
}
