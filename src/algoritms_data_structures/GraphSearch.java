package algoritms_data_structures;

import algoritms_data_structures.datastructure.Graph;
import algoritms_data_structures.datastructure.GraphNode;
import algoritms_data_structures.datastructure.LinearStructuresNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jyodroid on 1/14/17.
 */
public class GraphSearch {

    /**
     * https://en.wikipedia.org/wiki/Cycle_detection
     * Floyd's cycle-finding algorithm
     * The algorithm uses O(λ + μ) operations of these types, and O(1) storage space
     * where λ is the length of the loop to be found and μ is the index of the first element of the cycle
     *
     * @param head
     * @return
     */
    boolean hasCycle(LinearStructuresNode head) {
        if (head == null) {
            return false;
        }
        LinearStructuresNode tortoise = head;
        LinearStructuresNode hare = head.getNext();
        while (tortoise != hare) {
            if (hare == null || hare.getNext() == null) {
                return false;
            }
            tortoise = tortoise.getNext();
            hare = hare.getNext().getNext();
        }

        return true;
    }

    /**
     * DFS -> Depth first search.
     * Go deeper to one node before ask to any of his children
     * be aware of cycles (remember hare and turtle algorithm )
     * Use flags to prevent infinite loops
     * Implemented with a recursive algorithm
     */
    public boolean hasPathDFS(int source, int destination, Graph graph) {
        GraphNode s = graph.getNode(source);
        GraphNode d = graph.getNode(destination);
        //all ids for nodes visited
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(s, d, graph, visited);
    }

    //Helper recursive DFS method
    private boolean  hasPathDFS(GraphNode source, GraphNode destination, Graph graph, HashSet<Integer> visited){

        if (visited.contains(source.getId())){
            return false;
        }
        visited.add(source.getId());
        if (source == destination){
            return true;
        }
        for (GraphNode child: source.getAdjacent()) {
            if (hasPathDFS(child, destination, graph, visited)){
                return true;
            }
        }
        return false;
    }

    /**
     * BFS -> Breadth first search
     * goes broad to neighbors before going deep. go level to level
     * Implemented with iterative algorithm and a queue.
     */
    public boolean hasPathBFS(int source, int destination, Graph graph){
        return hasPathBFS(graph.getNode(source), graph.getNode(destination));
    }


    // Helper recursive BFS method
    private boolean hasPathBFS(GraphNode source, GraphNode destination){
        LinkedList<GraphNode> nextToVisit = new LinkedList<>();
        //all ids for nodes visited
        HashSet<Integer> visited = new HashSet<>();
        nextToVisit.add(source);
        while (!nextToVisit.isEmpty()){
            GraphNode nextNode = nextToVisit.remove();
            if (nextNode == destination){
                return true;
            }

            if (visited.contains(nextNode.getId())){
                continue;
            }
            visited.add(nextNode.getId());

            for (GraphNode child: nextNode.getAdjacent()) {
                nextToVisit.add(child);
            }
        }
        return false;
    }

    //Problem
    public static int getBiggestRegion(int[][] matrix, int rows, int columns) {
        HashSet<Integer> visited = new HashSet<>(rows*columns);
        return getMax(matrix, rows, columns, visited);
    }

    private static int getMax(int[][] matrix, int rows, int columns, HashSet<Integer> visited){
        int max = 0;
        for(int i = 0; i < rows ; i++){
            for(int j = 0; j < columns; j++){
                //Already visited
                int id;
                if (rows >= columns){
                    id = (rows*i) + j;
                }else {
                    id = (columns*i) + j;
                }
                if(visited.contains(id)){
                    continue;
                }
                visited.add(id);
                if(matrix[i][j] == 1){
                    int count = 1 + countChildValuesWithDFS(i, j, matrix, rows, columns, visited);
                    if(count > max){
                        max = count;
                    }
                }
            }
        }
        return max;
    }

    //Helper recursive DFS method
    private static int countChildValuesWithDFS(int indexRow, int indexColumn, int[][] matrix, int rows, int columns, HashSet<Integer> visited){
        int counter = 0;
        for(int i = - 1; i <= 1; i++){
            int childI = indexRow + i;
            if(childI < 0 || childI >= rows){
                continue;
            }
            for(int j = -1; j <= 1; j++){
                int childJ = indexColumn + j;
                //Already visited or is original vertex value
                int id;
                if (rows >= columns){
                    id = (rows*childI) + childJ;
                }else {
                   id = (columns*childI) + childJ;
                }
                if(childJ < 0 || childJ >= columns){
                    continue;
                }
                if(visited.contains(id)){
                    continue;
                }
                visited.add(id);
                // Is not out of the matrix
                    if ((matrix[childI][childJ]) == 1){
                        counter += 1 + countChildValuesWithDFS(childI, childJ, matrix, rows, columns, visited);
                    }
            }
        }
        return counter;
    }

    /**
     * Input example
     5
     5
     0 1 1 1 1
     1 0 0 0 1
     1 1 0 1 0
     0 1 0 1 1
     0 1 1 1 0
     expected output 15

     0 1 1
     1 0 1
     0 1 0
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for(int grid_i=0; grid_i < n; grid_i++){
            for(int grid_j=0; grid_j < m; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid, n, m));
    }
}
