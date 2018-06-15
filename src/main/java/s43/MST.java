package s43;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/**
 * Created by dhx on 2018/5/11.
 * minimum spanning tree   最小生成树
 */
public class MST {

    public MST(EdgeWeightedGraph edgeWeightedGraph) {}

    public Iterable<Edge> edges() {
        return null;
    }

    public double weight() {
        return 0;
    }


    public static void main(String[] args) {
        In in = new In("tinyEWG.txt");
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);

        MST mst = new MST(G);
        for (Edge e : mst.edges())
            StdOut.println(e);
        StdOut.println(mst.weight());
    }
}
