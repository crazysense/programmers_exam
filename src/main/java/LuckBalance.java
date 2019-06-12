public class LuckBalance {
    static int luckBalance(int k, int[][] contests) {
        int luck = 0;
        for (int i = 0; i < contests.length; i++) {
            if (i < k) {
                for (int j = contests.length - 1; j > i; j--) {
                    int[] target = contests[j];
                    int[] diff = contests[j - 1];
                    if ((target[1] == 1 && diff[1] == 0) || (target[1] == 1 && target[0] > diff[0])) {
                        int[] tmp = contests[j];
                        contests[j] = contests[j - 1];
                        contests[j - 1] = tmp;
                    }
                }
                luck += contests[i][0];
            } else if (contests[i][1] == 1) {
                luck -= contests[i][0];
            } else {
                luck += contests[i][0];
            }

        }
        return luck;
    }

    public static void main(String[] args) {
        System.out.println(luckBalance(3, new int[][]{
                {5, 1}, {2, 1}, {1, 1}, {8, 1}, {10, 0}, {5, 0}
        }));
    }
}
