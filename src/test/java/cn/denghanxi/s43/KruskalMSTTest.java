package cn.denghanxi.s43;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

/**
 * Created by dhx on 2018/6/20.
 */
public class KruskalMSTTest {

    @Test
    public void test() {
        EdgeWeightedGraph edgeWeightedGraph = EdgeWeightedGraph.tinyEWG();
        KruskalMST kruskalMST = new KruskalMST(edgeWeightedGraph);
        for (Edge e : kruskalMST.edges())
            StdOut.println(e);
        StdOut.println("weight: " + kruskalMST.weight());
    }
}