public class CopyOrCloneAdjList{
    public static void main(String[] args){
        Graph g=new Graph(5);
        g.addEdge(0,3);
        g.addEdge(1,0);
        g.addEdge(2,1);
        g.addEdge(3,2);
        g.addEdge(4,3);
        g.addEdge(4,5);
        g.addEdge(5,4);
    }
}