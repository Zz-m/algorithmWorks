package cn.denghanxi.s54;

import org.junit.Test;

import static org.junit.Assert.*;

public class NFATest {

    @Test
    public void recognizes() {
        NFA nfa = new NFA("(A*|(A*BA*BA*)*)");
//        edu.princeton.cs.algs4.NFA nfa2 = new edu.princeton.cs.algs4.NFA("(A*|(A*BA*BA*)*)");
        assertTrue(nfa.recognizes("AAA"));
        assertTrue(nfa.recognizes("BBAABB"));
        assertTrue(nfa.recognizes("BABAAA"));

        assertFalse(nfa.recognizes("ABA"));
        assertFalse(nfa.recognizes("BBB"));
        assertFalse(nfa.recognizes("BABBAAA"));
    }

    @Test
    public void grep() {

    }
}