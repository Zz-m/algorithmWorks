package cn.denghanxi.s53;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoyerMooreTest {

    @Test
    public void search() {
        String pat = "asd";
        String txt18 = "iuhdfgoshubahfbohfasddgjd";
        String txt2 = "asasdiusgiusdhg";
        String txtNone = "asasoiuertiuerhgiudjifbniusgiusdhg";
        BoyerMoore boyerMoore = new BoyerMoore(pat);
        assertEquals(18, boyerMoore.search(txt18));
        assertEquals(2, boyerMoore.search(txt2));
        assertEquals(txtNone.length(), boyerMoore.search(txtNone));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void exceptionCase() {
        String pat = "阿松大";
        new BoyerMoore(pat);
    }
}