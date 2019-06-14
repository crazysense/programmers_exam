package hacker_rank;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountTriplets {
//    static long countTriplets(List<Long> arr, long r) {
//        HashMap<Long, Long> hash2 = new HashMap<>();
//        HashMap<Long, Long> hash3 = new HashMap<>();
//
//        Long result = 0L;
//
//        for (int i = 0; i < arr.size(); i++) {
//            result += hash3.getOrDefault(arr.get(i), 0L);
//
//            if (hash2.containsKey(arr.get(i))) {
//                hash3.put(arr.get(i) * r, hash3.getOrDefault(arr.get(i) * r, 0L) + hash2.get(arr.get(i)));
//            }
//            hash2.put(arr.get(i) * r, hash2.getOrDefault(arr.get(i) * r, 0L) + 1);
//        }
//        return result;
//
//    }

    static long countTriplets(List<Long> arr, long r) {
        HashMap<Long, Long> map1 = new HashMap<>();
        HashMap<Long, Long> map2 = new HashMap<>();

        long result = 0L;
        for (int i = 0; i < arr.size(); i++) {
            long val = arr.get(i);
            result += map2.getOrDefault(val, 0L);

            if (map1.containsKey(val)) {
                long count1 = map1.get(val);
                long count2 = map2.getOrDefault(val * r, 0L);
                map2.put(val * r, count1 + count2);
            }
            map1.put(val * r, map1.getOrDefault(val * r, 0L) + 1);
        }

        return result;
    }

    static long countTriplets2(List<Long> arr, long r) {
        long ans = 0;
        Long[] array = new Long[arr.size()];
        Map<Long, Long> right = new HashMap<>();
        Map<Long, Long> left = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            array[i] = arr.get(i);
            right.put(array[i], 0l);
            left.put(array[i], 0l);
        }

        for (int i = 0; i < array.length; i++) {
            Long num = array[i];
            right.put(num, right.get(num) + 1);
        }

        for (int i = 0; i < array.length; i++) {
            Long num2 = array[i];
            right.put(num2, right.get(num2) - 1);

            if (num2 % r == 0) {
                Long num1 = num2 / r;
                Long num3 = num2 * r;

                if (left.containsKey(num1) && right.containsKey(num3)) {
                    ans += (left.get(num1) * right.get(num3));
                }
            }

            left.put(num2, left.get(num2) + 1);
        }


        return ans;
    }


    static long countTriplets3(List<Long> arr, long r) {
        HashMap<Long, Long> iMap = new HashMap<>();
        HashMap<Long, Long> kMap = new HashMap<>();

        // init
        for (int i = 0; i < arr.size(); i++) {
            long key = arr.get(i);
            iMap.put(key, 0L);
            kMap.put(key, iMap.getOrDefault(key, 0L) + 1);
        }

        // perform
        long sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            long jValue = arr.get(i);
            kMap.put(jValue, kMap.get(jValue) - 1);

            if (jValue % r == 0) {
                long iValue = jValue / r;
                long kValue = jValue * r;

                if (iMap.containsKey(iValue) && kMap.containsKey(kValue)) {
                    sum += (iMap.get(iValue) * kMap.get(kValue));
                }
            }

            iMap.put(jValue, iMap.get(jValue) + 1);
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
//        List<String> s = Files.readAllLines(Paths.get("/Users/myyuk/Development/github/programmers_exam/src/main/resources/count_triplets_test_case"));

//        List<Long> arr = makeData("1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1");
//        List<Long> arr = makeData(s.get(0));
        List<Long> arr = makeData("1 3 9 9 27 81");
        System.out.println(countTriplets(arr, 3));
        System.out.println(countTriplets2(arr, 3));
        System.out.println(countTriplets3(arr, 3));
    }

    static public String getResourceFileAsString(String fileName) {
        InputStream is = CountTriplets.class.getClassLoader().getResourceAsStream(fileName);
        if (is != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
        return null;
    }

    static List<Long> makeData(String input) {
        List<Long> data = new ArrayList<>();
        for (String s : input.split("\\s+")) {
            if (!s.trim().isEmpty()) {
                data.add(Long.parseLong(s.trim()));
            }
        }
        return data;
    }
}
