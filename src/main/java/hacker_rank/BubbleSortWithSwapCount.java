package hacker_rank;

// 버블정렬
// 버블소트
public class BubbleSortWithSwapCount {
    static void countSwaps(int[] a) {
        int cnt = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(j, j + 1, a);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    private static void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        countSwaps(new int[]{3, 2, 1,4,5,1,7,8,3,});
    }
}
