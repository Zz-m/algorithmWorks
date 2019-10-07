package cn.denghanxi.s44;

import org.junit.Test;

import static org.junit.Assert.*;

public class BellmanFordSPTest {

    //测试带负权重边，无负权重环的情况
    @Test
    public void testEWDn() {
        EdgeWeightedDigraph edgeWeightedDigraph = EdgeWeightedDigraph.tinyEWDn();
        BellmanFordSP bellmanFordSP = new BellmanFordSP(edgeWeightedDigraph, 0);
        assertFalse(bellmanFordSP.hasNegativeCycle());
        assertTrue(bellmanFordSP.hasPathTo(6));
        Iterable<DirectedEdge> pathTo6 = bellmanFordSP.pathTo(6);
        StringBuilder sb = new StringBuilder();
        for (DirectedEdge edge : pathTo6) {
            sb.append(edge.from()).append(edge.to());
        }
        assertEquals(sb.toString(), "02277336");
        assertEquals(0.6, bellmanFordSP.distTo(7), 0.001);
    }

    //测试有负权重环的情况
    @Test
    public void testEWDnc() {
        EdgeWeightedDigraph edgeWeightedDigraph = EdgeWeightedDigraph.tinyEWDnc();
        BellmanFordSP bellmanFordSP = new BellmanFordSP(edgeWeightedDigraph, 0);
        assertTrue(bellmanFordSP.hasNegativeCycle());
        for (DirectedEdge edge : bellmanFordSP.negativeCycle()) {
            System.out.println(edge.from() + " -- " + edge.to());
        }

    }
}