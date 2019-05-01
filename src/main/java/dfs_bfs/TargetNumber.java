package dfs_bfs;

public class TargetNumber {
    public static void main(String[] args) {
        TargetNumber sol = new TargetNumber();
        int[] numbers = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(sol.solution(numbers, target));
    }

    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0);
    }

    private int dfs(int[] numbers, int target, int idx) {
        int answer = 0;
        if (idx == numbers.length) {
            int sum = 0;
            for (int i = 0; i < numbers.length; i++)
                sum += numbers[i];
            if (sum == target)
                return 1;
        } else {
            answer += dfs(numbers, target, idx + 1);

            numbers[idx] *= -1;
            answer += dfs(numbers, target, idx+1);
        }
        return answer;
    }
}
