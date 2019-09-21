package cn.denghanxi.s42;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KosarajuSCCTest {

    private Digraph tinyDG;

    @Before
    public void setUp() throws Exception {
        tinyDG = TinyDG.getTinyDG();
    }

    @Test
    public void simpleTest() {
        KosarajuSCC kosarajuSCC = new KosarajuSCC(tinyDG);
        assertEquals(kosarajuSCC.count(), 5);
        assertTrue(kosarajuSCC.stronglyConnected(4, 2));
        assertFalse(kosarajuSCC.stronglyConnected(6, 0));
    }
}