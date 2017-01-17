package algoritms_data_structures.datastructure;

import java.util.LinkedList;

/**
 * Created by jyodroid on 1/14/17.
 */
public class GraphNode {
    private int id;
    private LinkedList<GraphNode> adjacent = new LinkedList<>();

    public GraphNode(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LinkedList<GraphNode> getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(LinkedList<GraphNode> adjacent) {
        this.adjacent = adjacent;
    }
}
