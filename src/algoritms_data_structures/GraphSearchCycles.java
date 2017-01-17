package algoritms_data_structures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jyodroid on 1/16/17.
 */
public class GraphSearchCycles {

    private static void isAcyclic(List<Integer>[] graph, int vertex) {
        for (int iv = 1; iv <= vertex; iv++) {
            for (Integer edge : graph[iv]) {
                boolean[] visited = new boolean[graph.length];
                boolean[] onCycle = new boolean[graph.length];
                if (iv == edge || checkForCycleOnEdge(edge, graph, visited, onCycle)) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(1);
    }

    private static boolean checkForCycleOnEdge(int edge, List<Integer>[] graph, boolean[] visited, boolean[] onCycle) {
        boolean isCycle = false;
        visited[edge] = true;
        onCycle[edge] = true;
        for (Integer newEdge : graph[edge]) {
            if (visited[newEdge]) {
                if (onCycle[newEdge]){
                    return true;
                }
                continue;
            } else {
                isCycle |= checkForCycleOnEdge(newEdge, graph, visited, onCycle);
            }
        }
        onCycle[edge] = false;
        return isCycle;
    }

    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new File("/home/jyodroid/Documents/Algorithms_and_data_structure/src/algoritms_data_structures/in.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int k = in.nextInt();
        for (int i = 0; i < k; i++) {
            List<Integer>[] graph = new List[1001];
            int vertex = in.nextInt();
            int edges = in.nextInt();
            for (int iv = 1; iv <= vertex; iv++) {
                graph[iv] = new ArrayList<>();
            }
            for (int ie = 0; ie < edges; ie++) {
                graph[in.nextInt()].add(in.nextInt());
            }
            isAcyclic(graph, vertex);
        }
    }
}
