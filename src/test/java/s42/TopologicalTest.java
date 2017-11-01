package s42;

import org.junit.Test;

import static org.junit.Assert.*;

public class TopologicalTest {
    @Test
    public void getOrder() throws Exception {
        Topological topological = new Topological(TinyDAG.getTinyDAG());
        assertTrue(topological.getOrder() != null);
    }

    @Test
    public void isDAG() throws Exception {
        Topological topological = new Topological(TinyDAG.getTinyDAG());
        assertTrue(topological.isDAG());
    }

}