package cn.denghanxi.s42;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirectedCycleTest {
    @Test
    public void hasCycle() throws Exception {
        Digraph dag = TinyDAG.getTinyDAG();
        DirectedCycle directedCycle = new DirectedCycle(dag);
        assertTrue(!directedCycle.hasCycle());
        Digraph digraph = new Digraph(3);
        digraph.addEdge(0, 1);
        digraph.addEdge(1, 2);
        digraph.addEdge(2, 0);
        directedCycle = new DirectedCycle(digraph);
        assertTrue(directedCycle.hasCycle());
    }

    @Test
    public void cycle() throws Exception {
        Digraph digraph = new Digraph(3);
        digraph.addEdge(0, 1);
        digraph.addEdge(1, 2);
        digraph.addEdge(2, 0);
        DirectedCycle directedCycle = new DirectedCycle(digraph);
        assertTrue(directedCycle.cycle() != null);

        Digraph dag = TinyDAG.getTinyDAG();
        directedCycle = new DirectedCycle(dag);
        assertTrue(directedCycle.cycle() == null);
    }

}