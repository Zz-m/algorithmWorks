package cn.denghanxi.s42;

import org.junit.Test;

import static org.junit.Assert.*;

public class DigraphTest {

    @Test
    public void testReverse() {
        Digraph digraph = TinyDG.getTinyDG();
        Digraph reverse = digraph.reverse();

        assertEquals(digraph.v(), reverse.v());
        assertEquals(digraph.e(), reverse.e());

    }
}