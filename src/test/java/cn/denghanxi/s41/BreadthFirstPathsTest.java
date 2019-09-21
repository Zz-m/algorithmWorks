package cn.denghanxi.s41;

import edu.princeton.cs.introcs.StdOut;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BreadthFirstPathsTest {

    private Graph mediumG;

    @Before
    public void setUp() throws Exception {
        mediumG = MediumG.getMediumG();
    }

    @Test
    public void simpleTest() {
        int s = 1;
        Paths search = new BreadthFirstPaths(mediumG, s);

        for (int v = 0; v < mediumG.V(); v++) {
            StdOut.print(s + " to " + v + ": ");
            if (search.hasPathTo(v))
                for (int x : search.pathTo(v))
                    if (x == s) StdOut.print(x);
                    else StdOut.print("-" + x);
            StdOut.println();
        }
    }
}