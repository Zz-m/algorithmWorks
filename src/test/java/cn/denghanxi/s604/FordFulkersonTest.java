package cn.denghanxi.s604;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FordFulkersonTest {

    private FlowNetWork tinyFN;

    @Before
    public void before() {
        tinyFN = FlowNetWork.tinyFN();
    }

    @Test
    public void simpleTest() {
        int s = 0; int t = tinyFN.v() - 1;
        FordFulkerson maxflow = new FordFulkerson(tinyFN, s, t);
        StdOut.println("Max flow from " + s + " to " + t);
        for (int v = 0; v < tinyFN.v(); v++) {
            for (FlowEdge edge : tinyFN.adj(v)) {
                if ((v == edge.from()) && edge.flow() > 0) {
                    StdOut.println("  " + edge.toString());
                }
            }
        }
        StdOut.println("Max flow value = " + maxflow.value());
        assertEquals(4.0, maxflow.value(), 1e-10);
    }

    @Test
    public void testMinCut() {
        int s = 0; int t = tinyFN.v() - 1;
        FordFulkerson maxflow = new FordFulkerson(tinyFN, s, t);
        assertTrue(maxflow.inCut(0));
        assertFalse(maxflow.inCut(1));
        assertTrue(maxflow.inCut(2));
        assertFalse(maxflow.inCut(3));
        assertFalse(maxflow.inCut(4));
        assertFalse(maxflow.inCut(5));
    }
}