package hacker_rank;

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
