package dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TravelPath {
    public static void main(String[] args) {
        TravelPath sol = new TravelPath();
        String[][] tickets = new String[][]{
                {"ICN", "SFO"}, //
                {"ICN", "ATL"}, //
                {"SFO", "ATL"}, //
                {"ATL", "ICN"}, //
                {"ATL", "SFO"}, //
                {"SFO", "ATL"},
                {"ATL", "ICN"}
        };
        System.out.println(Arrays.toString(sol.solution(tickets)));
    }

    class Ticket {
        private String from;
        private String to;
        private boolean visited;

        public Ticket(String from, String to) {
            this.from = from;
            this.to = to;
        }

        public String getFrom() {
            return from;
        }

        public String getTo() {
            return to;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }
    }

    public void dfs(String from, List<Ticket> tickets, List<String> acc, int n) {
        if (acc.size() == n) {
            return;
        }

        acc.add(from);

        List<Ticket> nexts = tickets.stream()
                .filter(t -> t.getFrom().equals(from) && !t.isVisited())
                .sorted(Comparator.comparing(Ticket::getTo))
                .collect(Collectors.toList());

        for (int i = 0; i < nexts.size(); i++) {
            nexts.get(i).setVisited(true);
            dfs(nexts.get(i).getTo(), tickets, acc, n);

            if (acc.size() != n) {
                acc.remove(acc.size() - 1);
                nexts.get(i).setVisited(false);
//                nexts.get(i + 1).setVisited(true);
//                dfs(nexts.get(i + 1).getTo(), tickets, acc, n);
            }
        }
//        for (Ticket next : nexts) {
//            next.setVisited(true);
//            dfs(next.getTo(), tickets, acc);
//
//            next.setVisited(false);
//            dfs(next.getTo(), tickets, acc);
//        }
//        if (next != null) {
//            next.setVisited(true);
//            dfs(next.getTo(), tickets, acc);
//        }
    }

    public String[] solution(String[][] tickets) {
        List<String> visit = new ArrayList<>();

//        List<Ticket> ticketList = Arrays.stream(tickets)
//                .map(s -> new Ticket(s[0], s[1]))
//                .collect(Collectors.toList());
        List<Ticket> ticketList = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            ticketList.add(new Ticket(tickets[i][0], tickets[i][1]));
        }


        dfs("ICN", ticketList, visit, ticketList.size() + 1);

        return visit.toArray(new String[visit.size()]);
//
//
//        Arrays.stream(tickets)
//                .filter(s -> s[0].equals("ICN"))
//                .sorted()
//                .findFirst().get()
//
//
//        for (int i = 0; i < tickets.length; i++) {
//            if (!visit[i] && tickets[i][0].equals("ICN")) {
//                boolean[] visit2 = new boolean[10_000];
//                visit[i] = true;
//                visit2[i] = true;
//
//                visited.clear();
//                dfs(visit2, i, tickets, tickets[i][1], tickets.length);
//                visited.forEach(x -> System.out.print(Arrays.toString(x)));
//                System.out.println();
//            }
//        }
//        return null;
    }

    List<String[]> visited = new ArrayList<>();

    public void dfs(boolean[] visit, int idx, String[][] tickets, String dest, int n) {
        visited.add(tickets[idx]);
        visit[idx] = true;

        for (int i = 0; i < n; i++) {
            if (!visit[i] && tickets[i][0].equals(dest)) {
                dfs(visit, i, tickets, tickets[i][1], n);
            }
        }
    }
}
