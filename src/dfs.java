import java.util.LinkedList;
public class dfs {
    public static void main(String[] args){
        Node n1 =new Node(1,"Arad");
        Node n2 =new Node(2,"Zerind");
        Node n3 =new Node(3,"Oredea");
        Node n4 =new Node(4,"Timisoara");
        Node n5 =new Node(5,"Lugoj");
        Node n6 =new Node(6,"Mehadia");
        Node n7 =new Node(7,"Dobetra");
        Node n8 =new Node(8,"Criova");
        Node n9 =new Node(9,"Rimnicu Vilcea");
        Node n10 =new Node(10,"Sibiu");
        Node n11 =new Node(11,"Fagaras");
        Node n12 =new Node(12,"Pitesti");
        Node n13 =new Node(13,"Bucharest");
        Node n14 =new Node(14,"Glurgiu");
        Node n15 =new Node(15,"Urziceni");
        Node n16 =new Node(16,"Neamt");
        Node n17 =new Node(17,"Lasi");
        Node n18 =new Node(18,"Vaslui");
        Node n19 =new Node(19,"Hirsova");
        Node n20 =new Node(20,"Eforie");
        Graph g=new Graph();
        g.insertEdge(n1,n2);
        g.insertEdge(n2,n3);
        g.insertEdge(n1,n4);
        g.insertEdge(n4,n5);
        g.insertEdge(n5,n6);
        g.insertEdge(n6,n7);
        g.insertEdge(n7,n8);
        g.insertEdge(n8,n9);
        g.insertEdge(n9,n10);
        g.insertEdge(n10,n1);
        g.insertEdge(n10,n3);
        g.insertEdge(n10,n11);
        g.insertEdge(n9,n12);
        g.insertEdge(n8,n12);
        g.insertEdge(n11,n13);
        g.insertEdge(n12,n13);
        g.insertEdge(n13,n14);
        g.insertEdge(n13,n15);
        g.insertEdge(n15,n18);
        g.insertEdge(n18,n17);
        g.insertEdge(n17,n16);
        g.insertEdge(n15,n19);
        g.insertEdge(n19,n20);
        g.insertEdge(n2, n1);
        g.insertEdge(n3, n2);
        g.insertEdge(n4, n1);
        g.insertEdge(n5, n4);
        g.insertEdge(n6, n5);
        g.insertEdge(n7, n6);
        g.insertEdge(n8, n7);
        g.insertEdge(n9, n8);
        g.insertEdge(n10, n9);
        g.insertEdge(n1, n10);
        g.insertEdge(n3, n10);
        g.insertEdge(n11, n10);
        g.insertEdge(n12, n9);
        g.insertEdge(n12, n8);
        g.insertEdge(n13, n11);
        g.insertEdge(n13, n12);
        g.insertEdge(n14, n13);
        g.insertEdge(n15, n13);
        g.insertEdge(n18, n15);
        g.insertEdge(n17, n18);
        g.insertEdge(n16, n17);
        g.insertEdge(n19, n15);
        g.insertEdge(n20, n19);

        //dfsSearch(n1,g);
        dfsSearch(n20,g);
    }
    public static void dfsSearch(Node n, Graph g){
        n.visited();
        LinkedList<Node>neighbours=g.getNeighbours(n);
        for(Node ng:neighbours){
            if(!n.isVisited()) dfsSearch(ng,g);
        }

    }
}
