package cn.denghanxi.s44;

import org.junit.Test;

import static org.junit.Assert.*;

public class EdgeWeightedDigraphTest {

    @Test
    public void simpleTest() {
        EdgeWeightedDigraph edgeWeightedDigraph = EdgeWeightedDigraph.tinyEWD();
        assertEquals(edgeWeightedDigraph.e(), 15);
        assertEquals(edgeWeightedDigraph.v(), 8);
    }
}