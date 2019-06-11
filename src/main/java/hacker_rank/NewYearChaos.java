package hacker_rank;

public class NewYearChaos {
    public static int solve(int arr[])
    {
        int ans = 0;
        for (int i = arr.length - 1 ; i >= 0 ; i--)
        {
            if (arr[i] - (i + 1) > 2)
            {
                return 0;
            }
            for (int j = Math.max(0, arr[i] - 2) ; j < i ; j++)
            {
                if (arr[j] > arr[i]) ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(solve(new int[]{2,1,5,3,4}));
//        System.out.println(solve(new int[]{2,5,1,3,4}));
        System.out.println(solve(new int[]{1,2,5,3,7,8,6,4}));
    }
}
