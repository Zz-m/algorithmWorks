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
        File currentDirFile = new File(".");
        String path = (currentDirFile.getAbsolutePath() + "/res/assignment/s42/wordnet/digraph1.txt");
        In in = new In(path);
        Digraph digraph = new Digraph(in);
        SAP sap = new SAP(digraph);
        int length = sap.length(i, j);
        int ancestor = sap.ancestor(i, j);
        StdOut.printf("length = %d, ancestor = %d\n", length, ancestor);
    }

}