package s41;

import org.junit.Test;

import static org.junit.Assert.*;

public class TinyGTest {
    @Test
    public void getTinyG() throws Exception {
        Graph graph = TinyG.getTinyG();
        assertTrue(graph.E() > 0);
        assertTrue(graph.V() > 0);
    }

}