package hacker_rank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// 모든 문자가 동일하거나
// 가운데 하나만 제외하고 모든 문자와 길이가 동일한 문자 (미러) 의 출현 횟수를 구하라

public class SpecialStringAgain {
    public static void main(String[] args) throws IOException {
        List<String> s = Files.readAllLines(Paths.get("/Users/myyuk/Development/github/programmers_exam/src/main/resources/specialstringagain_test"));
        long res = subStringCount(s.get(1), Integer.parseInt(s.get(0)));
        System.out.print(res + " : ");
        System.out.println(1272919L == res);

        System.out.println(subStringCount("mnonopoo", 7));
    }

    static long subStringCount(String s, int n) {
        long count = n;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length - 1; i++) {
            int diff = 0, same = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (diff > 0) {
                    if (j + same <= arr.length && isSame(arr, arr[i], j, j + same)) {
                        count++;
                    }
                    break;
                }

                if (arr[i] == arr[j]) {
                    ++same;
                    ++count;
                } else {
                    ++diff;
                }
            }
        }

//        long count2 = n;
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (isSame(s.substring(i, j + 1))) count2++;
//            }
//        }
//        return count2;

        return count;
    }

    static boolean isSame(char[] arr, char c, int start, int end) {
        for (int k = start; k < end; k++) {
            if (c != arr[k]) {
                return false;
            }
        }
        return true;
    }

    static boolean isSame(String s) {
        char c = s.charAt(0);
        for (int i = 0; i < s.length() / 2; i++) {
            if (c != s.charAt(i) || c != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
}
