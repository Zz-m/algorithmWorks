package cn.denghanxi.assignment.s55;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircularSuffixArrayTest {

    CircularSuffixArray circularSuffixArray;

    @Before
    public void before() {
        circularSuffixArray = new CircularSuffixArray("ABRACADABRA!");
    }

    @Test
    public void length() {
        assertEquals(12, circularSuffixArray.length());
    }

    @Test
    public void index() {
        assertEquals(11, circularSuffixArray.index(0));
        assertEquals(10, circularSuffixArray.index(1));
        assertEquals(2, circularSuffixArray.index(11));
    }

    @Test
    public void testMain() {
        CircularSuffixArray.main(null);
    }
}