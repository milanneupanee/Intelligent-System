import java.util.HashMap;
import java.util.LinkedList;
public class Graph{
    HashMap <Node, LinkedList<Node>> adjacencyMap;
    boolean directed;
    public Graph () {
        adjacencyMap = new HashMap<Node, LinkedList<Node>>();
        directed = false;

    }
    public void insertEdge (Node source, Node target) {
        if (!adjacencyMap.keySet().contains(source)) {
            LinkedList<Node> tmp = new LinkedList<Node>();
            tmp.add(target);
            adjacencyMap.put(source, tmp);
        } else {
            LinkedList<Node> tmp = adjacencyMap.get(source);
            tmp.add(target);
            adjacencyMap.put(source, tmp);
        }
    }
    /*public void insertEdge1 (Node target, Node source) {
        if (!adjacencyMap.keySet().contains(target)) {
            LinkedList<Node> tmp = new LinkedList<Node>();
            tmp.add(source);
            adjacencyMap.put(target, tmp);
        } else {
            LinkedList<Node> tmp = adjacencyMap.get(target);
            tmp.add(source);
            adjacencyMap.put(target, tmp);
        }
    }*/
    public LinkedList<Node>getNeighbours(Node n){
        return adjacencyMap.get(n);
    }
}
