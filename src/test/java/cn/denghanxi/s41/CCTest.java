package cn.denghanxi.s41;

import edu.princeton.cs.algorithms.Bag;
import edu.princeton.cs.introcs.StdOut;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CCTest {

    private Graph tinyGraph;
    private Graph mediumGraph;

    @Before
    public void setUp() throws Exception {
        tinyGraph = TinyG.getTinyG();
        mediumGraph = MediumG.getMediumG();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testPrint() {
        printCC(tinyGraph, new CC(tinyGraph));
        printCC(mediumGraph, new CC(mediumGraph));
    }

    @Test
    public void testConnect() {
        CC cc = new CC(tinyGraph);
        assertTrue(cc.connected(0, 5));
    }

    private void printCC(Graph graph, CC cc) {
        int m = cc.count();
        StdOut.println(m + " components");
        Bag<Integer>[] components = (Bag<Integer>[]) new Bag[m];
        for (int i = 0; i < m; i++)
            components[i] = new Bag<>();
        for (int v = 0; v < graph.V(); v++)
            components[cc.id(v)].add(v);
        for (int i = 0; i < m; i++) {
            for (int v : components[i])
                StdOut.print(v + " ");
            StdOut.println();
        }
    }


}