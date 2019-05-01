package dfs_bfs;

public class WordConverter {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = new String[]{
                "hot", "dot", "dog", "lot", "log"
        };

        WordConverter sol = new WordConverter();
        System.out.println(sol.solution(begin, target, words));
    }

    public int solution(String begin, String target, String[] words) {
        for (String word : words) {
            if (word.equals(target)) {
                return dfs(0, begin, target, words, 0);
            }
        }
        return 0;
    }

    private int dfs(int idx, String begin, String target, String[] words, int answer) {
        if (idx == words.length) return 0;

        if (begin.equals(target) || find(begin, target)) {
            return answer + 1;
        }
        if (find(begin, words[idx])) {
            answer += 1;
            begin = words[idx];
        }

        return dfs(idx + 1, begin, target, words, answer);
    }

    private boolean find(String cur, String tar) {
        int wrong = 0;
        for (int i = 0; i < tar.length(); i++) {
            if (cur.charAt(i) != tar.charAt(i)) wrong++;
            if (wrong > 1) break;
        }
        return wrong == 1;
    }
}
