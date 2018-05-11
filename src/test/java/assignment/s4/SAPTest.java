package assignment.s4;

import edu.princeton.cs.algorithms.Digraph;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

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