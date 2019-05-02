package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test04 {

    private static boolean isCycle(boolean[] visited, int idx, boolean[] recursive, List<List<Integer>> adj) {
        if (recursive[idx]) return true;
        if (visited[idx]) return false;

        visited[idx] = true;
        recursive[idx] = true;

        for (Integer child : adj.get(idx)) {
            if (isCycle(visited, child, recursive, adj)) {
                return true;
            }
        }
        recursive[idx] = false;

        return false;
    }

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        try {
            int numberOrGraph = Integer.parseInt(input);

            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < numberOrGraph; i++) {
                adj.add(new LinkedList<>());
            }

            int inputs = numberOrGraph;
            while (inputs-- > 0) {
                String[] graphInput = br.readLine().split("\\s+");
                if (graphInput.length != 2) {
                    System.err.println("[EDGE_FROM] [EDGE_TO]");
                    inputs++;
                    continue;
                }

                try {
                    int from = Integer.parseInt(graphInput[0]);
                    int to = Integer.parseInt(graphInput[1]);

                    adj.get(from).add(to);
                } catch (NumberFormatException e) {
                    System.err.println("Number Only.");
                    inputs++;
                }
            }

            boolean[] visit = new boolean[numberOrGraph];
            boolean[] rec = new boolean[numberOrGraph];

            boolean isCycle = false;
            for (int i = 0; i < numberOrGraph; i++) {
                if (isCycle(visit, i, rec, adj)) {
                    isCycle = true;
                    break;
                }
            }
            System.out.println(isCycle);

        } catch (NumberFormatException e) {
            System.err.println("Number Only.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
