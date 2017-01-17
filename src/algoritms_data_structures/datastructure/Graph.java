package algoritms_data_structures.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jyodroid on 1/14/17.
 *
 * 1. Is a non - lineal data structure
 * 2. Consist of a set of nodes connected by edges.
 * 2. Different from Tree, there are not always direction for the connections (unless is specified)
 * 3. Contains a set of rules and a set of edges.
 * 4. Mathematical definition: a graph G is an ordered pair of set v of vertices and a set E of edges G = (v, E)
 * 5. Edges can be directed (one way) or undirected which connection is two way
 * 6. To represent a directed edge we use an ordered pair (origin, destination)
 * 7. To represent a un - directed edge we use an unordered pair {origin, destination}
 * 8. A graph with all edges directed is called *** digraph ***
 * 9. Some time edges are weighted and the graph is called *** weighted graph ***
 * 10.
 *
 * this example is an un - weighted graph and is undirected
 */
public class Graph {

    //Allows mapping from node id to the actual node
    private Map<Integer, GraphNode> nodeLookUp = new HashMap<>();

    private int id;
    public Graph(int id){
        this.id = id;
        GraphNode startNode = new GraphNode(id);
        nodeLookUp.put(id, startNode);
    }

    public void addNode(GraphNode node){
        nodeLookUp.put(node.getId(), node);
    }

    public GraphNode getNode(int id){
        return nodeLookUp.get(id);
    }
    public void addEdge(int source, int destination){
        GraphNode s = getNode(source);
        GraphNode d = getNode(destination);
        s.getAdjacent().add(d);
    }
}
