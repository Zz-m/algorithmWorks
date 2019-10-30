package cn.denghanxi.s53;

import org.junit.Test;

import static org.junit.Assert.*;

public class KMPTest {

    @Test
    public void search() {
        String pat = "asd";
        String txt18 = "iuhdfgoshubahfbohfasddgjd";
        String txt2 = "asasdiusgiusdhg";
        String txtNone = "asasoiuertiuerhgiudjifbniusgiusdhg";
        KMP kmp = new KMP(pat);
        assertEquals(18, kmp.search(txt18));
        assertEquals(2, kmp.search(txt2));
        assertEquals(txtNone.length(), kmp.search(txtNone));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void exceptionCase() {
        String pat = "asa阿松大d";
        KMP kmp = new KMP(pat);
    }
}