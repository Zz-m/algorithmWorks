package cn.denghanxi.s43;

import edu.princeton.cs.introcs.StdOut;
import org.junit.Test;

/**
 * Created by dhx on 2018/6/21.
 */
public class LazyPrimMSTTest {

    @Test
    public void test() {
        EdgeWeightedGraph edgeWeightedGraph = EdgeWeightedGraph.tinyEWG();
        LazyPrimMST lazyPrimMST = new LazyPrimMST(edgeWeightedGraph);
        for (Edge e : lazyPrimMST.edges())
            StdOut.println(e);
        StdOut.println("weight: " + lazyPrimMST.weight());
    }
}