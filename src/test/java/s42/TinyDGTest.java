package s42;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TinyDGTest {
    @Test
    public void getTinyDG() throws Exception {
        Digraph digraph = TinyDG.getTinyDG();
        assertTrue(digraph.e() > 0);
        assertTrue(digraph.v() > 0);
    }

}