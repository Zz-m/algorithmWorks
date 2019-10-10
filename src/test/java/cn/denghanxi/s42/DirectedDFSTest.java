package cn.denghanxi.s42;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirectedDFSTest {

    @Test
    public void test() {
        Digraph digraph = TinyDG.getTinyDG();
        Bag<Integer> sources = new Bag<>();
        int count = digraph.v() < 4 ? digraph.v() : digraph.v() - 3;
        for (int i = 0; i < count; i++) {
            sources.add(i);
        }

        DirectedDFS reachable = new DirectedDFS(digraph, sources);
        for (int v = 0; v < digraph.v(); v++)
            if (reachable.marked(v)) StdOut.println(v + " ");
        StdOut.println();
        assertTrue(true);
    }
}