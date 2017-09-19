package s41;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/**
 * 获取tiny graph
 */
public class TinyG {
    private TinyG(){}

    public static Graph getTinyG() {
        Graph graph = new Graph(13);
        graph.addEdge(0, 5);
        graph.addEdge(4, 3);
        graph.addEdge(0, 1);
        graph.addEdge(9, 12);
        graph.addEdge(6, 4);
        graph.addEdge(5, 4);
        graph.addEdge(0, 2);
        graph.addEdge(11, 12);
        graph.addEdge(9, 10);
        graph.addEdge(0, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 11);
        graph.addEdge(5, 3);
        return graph;
    }

    public static void main(String[] args) {
        String path =  "F:\\mediumG.txt";
        StdOut.println(path);
        In in = new In(path);
//        while (in.hasNextLine()) {
//            StdOut.println(in.readInt());
//        }
        Graph graph = new Graph(in);
        StdOut.println(graph.E());
    }
}