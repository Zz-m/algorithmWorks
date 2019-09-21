package cn.denghanxi.s43;

/**
 * Created by dhx on 2018/5/11.
 * minimum spanning tree   最小生成树
 */
public interface MST {

    Iterable<Edge> edges();

    double weight();

//    public static void main(String[] args) {
//        In in = new In("tinyEWG.txt");
//        EdgeWeightedGraph G = new EdgeWeightedGraph(in);
//
//        MST mst = new MST(G);
//        for (Edge e : mst.edges())
//            StdOut.println(e);
//        StdOut.println("weight: " + mst.weight());
//    }
}
