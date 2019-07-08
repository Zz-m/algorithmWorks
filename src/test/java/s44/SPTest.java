package s44;

import edu.princeton.cs.introcs.StdOut;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dhx on 2018/7/4.
 */
public class SPTest {

    @Test
    public void test() {
        EdgeWeightedDigraph G = EdgeWeightedDigraph.tinyEWD();
        int s = 1;
        int v = 2;

        SP sp = new SP(G, s);
        StdOut.printf("%d to %d (%.2f): ", s, v, sp.distTo(v));
        for (DirectedEdge e : sp.pathTo(v))
            StdOut.print(e + "  ");
        StdOut.println();
    }

}