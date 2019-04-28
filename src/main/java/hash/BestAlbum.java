package hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestAlbum {
    public static void main(String[] args) {
        BestAlbum sol = new BestAlbum();
        String[] genres = new String[]{"classic", "pop", "classic", "classic", "pop"};
        int[] plays = new int[]{500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(sol.solution(genres, plays)));
    }

    public int[] solution(String[] genres, int[] plays) {
        /**
         * matrix[genres][0] => 가장 많이 플레이된 음악의 숫자
         * matrix[genres][1] => 두번째로 가장 많이 플레이된 음악의 숫자 (0인경우 하나만 존재)
         * matrix[genres][2] => 가장 많이 플레이된 음악의 인덱스
         * matrix[genres][3] => 두번째로 가장 많이 플레이된 음악의 인덱스
         * matrix[genres][4] => 플레이된 음악의 합계
         **/
        int[][] matrix = new int[100][5];

        Map<String, Integer> idxMap = new HashMap<>();
        int lastIdx = 0;
        for (int i = 0; i < genres.length; i++) {
            Integer idx = idxMap.get(genres[i]);
            if (idx == null) {
                idx = lastIdx++;
                idxMap.put(genres[i], idx);
            }

            matrix[idx][4] += plays[i]; // 합계
            if (plays[i] > matrix[idx][1]) {
                if (plays[i] > matrix[idx][0]) { // 가장 많이 플레이된 음악 업데이트
                    int tmp = matrix[idx][0];
                    matrix[idx][0] = plays[i];
                    matrix[idx][1] = tmp;
                    tmp = matrix[idx][2];
                    matrix[idx][2] = i;
                    matrix[idx][3] = tmp;
                } else { // 두번째로 가장 많이 플레이된 음악 업데이트
                    matrix[idx][1] = plays[i];
                    matrix[idx][3] = i;
                }
            }
        }

        // 가장 많이 플레이된 음악의 합계 순으로 배열 정렬
        for (int i = 0; i < lastIdx - 1; i++) {
            for (int j = i + 1; j < lastIdx; j++) {
                if (matrix[i][4] < matrix[j][4]) {
                    int[] tmp = matrix[i];
                    matrix[i] = matrix[j];
                    matrix[j] = tmp;
                }
            }
        }

        // 결과 생성
        int[] answer = new int[lastIdx * 2];
        int size = 0;
        for (int i = 0; i < lastIdx; i++, size++) {
            answer[size] = matrix[i][2];
            if (matrix[i][1] > 0) answer[++size] = matrix[i][3];
        }

        return Arrays.copyOf(answer, size);
    }
}
