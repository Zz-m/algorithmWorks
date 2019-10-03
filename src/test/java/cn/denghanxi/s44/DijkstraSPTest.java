package cn.denghanxi.s44;

import org.junit.Test;

import static org.junit.Assert.*;

public class DijkstraSPTest {

    @Test
    public void test() {
        double d1 = Double.POSITIVE_INFINITY;
        double d2 = Double.POSITIVE_INFINITY;
        System.out.println(d1 + 1 > d2);
        System.out.println(d1 + 1);
    }

    @Test
    public void simpleTest() {
        EdgeWeightedDigraph tinyEWD = EdgeWeightedDigraph.tinyEWD();
        DijkstraSP dijkstraSP = new DijkstraSP(tinyEWD, 0);
        assertTrue(dijkstraSP.hasPathTo(2));
        assertEquals(0.38, dijkstraSP.distTo(4), 0.0);
        Iterable<DirectedEdge> path = dijkstraSP.pathTo(6);
        int i = 0;
        for (DirectedEdge e : path) {
            i++;
        }
        assertEquals(4, i);
    }
}