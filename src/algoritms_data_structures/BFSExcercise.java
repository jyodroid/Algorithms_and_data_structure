package algoritms_data_structures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jyodroid on 1/29/17.
 */
public class BFSExcercise {
    public static class Graph {
        List<Integer>[] graph;

        public Graph(int size) {
            graph = new List[size];
        }

        public void addEdge(int first, int second) {
            if (graph[first] == null) {
                graph[first] = new ArrayList<>();
            }
            graph[first].add(second);
            if (graph[second] == null) {
                graph[second] = new ArrayList<>();
            }
            graph[second].add(first);
        }

        public int[] shortestReach(int startId) {
            return shortestPathsBFS(startId);
        }

        private int[] shortestPathsBFS(int source) {

            final int UNVISITED = 0;
            final int NEXT_TO_VISIT = 1;
            final int VISITED = 2;
            final int WEIGHT = 6;

            int[] colors = new int[graph.length];
            int[] distance = new int[graph.length];
            LinkedList<Integer> queue = new LinkedList<>();

            for (int i = 0; i < graph.length; i++) {
                colors[i] = UNVISITED;
                distance[i] = -1;
            }

            colors[source] = UNVISITED;
            distance[source] = 0;
            queue.add(source);

            while (!queue.isEmpty()) {
                int currentNode = queue.pop();

                for (int neighbour : graph[currentNode]) {
                    if (colors[neighbour] == UNVISITED) {
                        colors[neighbour] = NEXT_TO_VISIT;
                        distance[neighbour] = distance[currentNode] + WEIGHT;
                        queue.add(neighbour);
                    }
                }

                colors[currentNode] = VISITED;
            }

            return distance;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
