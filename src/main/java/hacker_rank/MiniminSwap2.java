package hacker_rank;

// 정렬하기 위한 최소 스왑 횟수 구하기
// 데이터는 순차적으로 모두 있다고 가정한다. (중간에 빠진 데이터는 없음)
public class MiniminSwap2 {
    static int minimumSwaps(int[] arr) {
        int len = arr.length;
        boolean[] visit = new boolean[len];

        int swapCount = 0;
        for (int cur = 0; cur < arr.length; cur++) {
            if (!visit[cur]) {
                for (int next = arr[cur] - 1; next != cur; next = arr[next] - 1) {
                    swapCount++;
                    visit[next] = true;
                }
                visit[cur] = true;
            }
        }
        return swapCount;
    }


    public static void main(String[] args) {
        System.out.println(minimumSwaps(new int[]{1,3,5,2,4,6,7}));
        System.out.println(minimumSwaps(new int[]{2,3,4,1,5}));
        System.out.println(minimumSwaps(new int[]{4,3,1,2}));
        System.out.println(minimumSwaps(new int[]{7,1,3,2,4,5,6}));
    }
}
