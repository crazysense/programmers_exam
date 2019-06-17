package hacker_rank;

import java.util.*;

// 그래프
// 경우의 수
// 하나의 국가에서 한명의 우주비행사씩 두명을 뽑고 싶다
public class JourneyToTheMoon {

    static class Group {
        private int id;
        private Set<Group> astronauts;
        private boolean visited = false;

        public Group(int id) {
            this.id = id;
            this.astronauts = new HashSet<>();
        }

        public Set<Group> getAstronauts() {
            return astronauts;
        }

        public void addAstronauts(Group astronaut) {
            this.astronauts.add(astronaut);
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public boolean isVisited() {
            return visited;
        }
    }

    static int countHelper(Group g, int sum) {
        if (g.getAstronauts().size() == 0) {
            return 1;
        }

        for (Group astronaut : g.getAstronauts()) {
            if (!astronaut.isVisited()) {
                astronaut.setVisited(true);
                sum = countHelper(astronaut, sum + 1);
            }
        }
        return sum;
    }

    static int count(Map<Integer, Group> groupMap) {
        int result = 0;
        int sum = 0;

        for (Group group : groupMap.values()) {
            int count = countHelper(group, 0);
            result += sum * count;
            sum += count;
        }

        return result;
    }

    static int journeyToMoon(int n, int[][] astronaut) {
        Map<Integer, Group> groupMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Group ast = new Group(i);
            groupMap.put(i, ast);
        }

        for (int i = 0; i < astronaut.length; i++) {
            Group a1 = groupMap.get(astronaut[i][0]);
            Group a2 = groupMap.get(astronaut[i][1]);
            a1.addAstronauts(a2);
            a2.addAstronauts(a1);
        }

        return count(groupMap);
    }

    public static void main(String[] args) {
        int n = 10;
        int arr[][] = new int[][]{
                {0,2},{1,8},{1,4},{2,8},{2,6},{3,5},{6,9}
        };
        System.out.println(journeyToMoon(n, arr));
    }
}
