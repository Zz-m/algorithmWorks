package cn.denghanxi.s44;

import org.junit.Test;

import static org.junit.Assert.*;

public class AcyclicSPTest {

    @Test
    public void testSource5() {
        EdgeWeightedDigraph edgeWeightedDAG = EdgeWeightedDigraph.tinyEWDAG();

        AcyclicSP acyclicSP = new AcyclicSP(edgeWeightedDAG, 5);
        assertTrue(acyclicSP.hasPathTo(0));
        assertTrue(acyclicSP.hasPathTo(1));
        assertTrue(acyclicSP.hasPathTo(2));
        assertTrue(acyclicSP.hasPathTo(3));
        assertTrue(acyclicSP.hasPathTo(4));
        assertTrue(acyclicSP.hasPathTo(5));
        assertTrue(acyclicSP.hasPathTo(6));
        assertTrue(acyclicSP.hasPathTo(7));

        assertEquals(0.61, acyclicSP.distTo(3), 0.0);

        Iterable<DirectedEdge> pathTo6 = acyclicSP.pathTo(6);

        StringBuilder sb = new StringBuilder();

        for (DirectedEdge edge : pathTo6) {
            sb.append(edge.from()).append(edge.to());
            System.out.println(edge.from() + " --- " + edge.to());
        }

        assertEquals(sb.toString(), "511336");


    }

    @Test
    public void testSource2() {
        EdgeWeightedDigraph edgeWeightedDAG = EdgeWeightedDigraph.tinyEWDAG();

        AcyclicSP acyclicSP = new AcyclicSP(edgeWeightedDAG, 2);
        assertFalse(acyclicSP.hasPathTo(0));
        assertFalse(acyclicSP.hasPathTo(1));
        assertTrue(acyclicSP.hasPathTo(2));
        assertFalse(acyclicSP.hasPathTo(3));
        assertFalse(acyclicSP.hasPathTo(4));
        assertFalse(acyclicSP.hasPathTo(5));
        assertFalse(acyclicSP.hasPathTo(6));
        assertFalse(acyclicSP.hasPathTo(7));
    }

    @Test
    public void testSource0() {
        EdgeWeightedDigraph edgeWeightedDAG = EdgeWeightedDigraph.tinyEWDAG();

        AcyclicSP acyclicSP = new AcyclicSP(edgeWeightedDAG, 0);
        assertTrue(acyclicSP.hasPathTo(0));
        assertFalse(acyclicSP.hasPathTo(1));
        assertTrue(acyclicSP.hasPathTo(2));
        assertFalse(acyclicSP.hasPathTo(3));
        assertFalse(acyclicSP.hasPathTo(4));
        assertFalse(acyclicSP.hasPathTo(5));
        assertFalse(acyclicSP.hasPathTo(6));
        assertFalse(acyclicSP.hasPathTo(7));

        assertEquals(0.26, acyclicSP.distTo(2), 0.0);
    }
}