package cn.denghanxi.s41;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MediumGTest {

    private Graph mediumGraph;

    @Before
    public void setUp() throws Exception {
        mediumGraph = MediumG.getMediumG();
    }

    @Test
    public void simpleTest() {
        assertTrue(mediumGraph.E() > 0);
        assertTrue(mediumGraph.V() > 0);
    }
}