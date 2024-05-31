public class Node {
    String name;
    int nodeID;
    boolean visited;
    public Node(int id, String str){
        name=str;
        nodeID=id;
        visited=false;
    }
    public void visited(){
        visited=true;
        System.out.println(name);
    }
    public boolean isVisited(){

        return visited;
    }
}
