package cn.denghanxi.assignment.s42;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class SAPTest {
    @Test
    public void length() throws Exception {
    }

    @Test
    public void ancestor() throws Exception {
    }

    @Test
    public void length1() throws Exception {
    }

    @Test
    public void ancestor1() throws Exception {
    }

    @Test
    public void test() throws Exception {
        int i = 7;
        int j = 2;
        In in = new In(SAPTest.class.getResource("/assignment/s42/wordnet/digraph1.txt"));
        Digraph digraph = new Digraph(in);
        SAP sap = new SAP(digraph);
        int length = sap.length(i, j);
        int ancestor = sap.ancestor(i, j);
        StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
    }

}