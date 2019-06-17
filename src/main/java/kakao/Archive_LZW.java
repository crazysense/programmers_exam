package kakao;

import java.util.*;

// LZW 압축
public class Archive_LZW {
    public static void main(String[] args) {
        Map<Integer, Integer> m = null;

        System.out.println(Arrays.toString(archive("KAKAO")));
        System.out.println(Arrays.toString(archive("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(archive("ABABABABABABABAB")));
    }


    static int[] archive(String input) {
        Map<String, Integer> dict = new HashMap<>();
        int idx = 1;
        for (int c = 'A'; c <= 'Z'; c++) {
            dict.put(Character.toString((char) c), idx++);
        }


        int[] index = new int[500];
        int z = 0, begin = 0;
        int length = 1;
        while (begin < input.length()) {
            int until;
            String s = "";
            for (until = length; until > 0; until--) {
                if (begin + until > input.length()) continue;
                s = input.substring(begin, begin + until);
                if (dict.containsKey(s)) {
                    index[z++] = dict.get(s);
                    if (until == length) {
                        length++;
                    }
                    break;
                }
            }

            int end = begin + s.length() + 1;
            if (end <= input.length()) {
                String k = input.substring(begin, end);
                dict.put(k, dict.getOrDefault(k, idx++));
            }

            begin += until;
        }

        return Arrays.copyOf(index, z);
    }
}
