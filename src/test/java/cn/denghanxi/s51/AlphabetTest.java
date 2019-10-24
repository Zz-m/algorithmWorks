package cn.denghanxi.s51;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlphabetTest {

    @Test
    public void toChar() {
        Alphabet alphabet = new Alphabet("12223asd");
        assertEquals('3', alphabet.toChar(2));
    }

    @Test
    public void toIndex() {
        Alphabet alphabet = new Alphabet("12223asd");
        assertEquals(2, alphabet.toIndex('3'));
    }

    @Test
    public void contains() {
        Alphabet alphabet = new Alphabet("12223asd");
        assertTrue(alphabet.contains('1'));
        assertTrue(alphabet.contains('2'));
        assertTrue(alphabet.contains('3'));
        assertTrue(alphabet.contains('a'));
        assertTrue(alphabet.contains('s'));
        assertTrue(alphabet.contains('d'));
        assertFalse(alphabet.contains('f'));
    }

    @Test
    public void r() {
        Alphabet alphabet = new Alphabet("12223asd");
        assertEquals(6, alphabet.r());
    }

    @Test
    public void lgR() {
        Alphabet alphabet = new Alphabet("12223asd");
        assertEquals(3, alphabet.lgR());
    }

    @Test
    public void toIndices() {
        Alphabet alphabet = new Alphabet("12223asd");
        int[] result = alphabet.toIndices("aaass33221");
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i);
        }
        assertEquals("3334422110", sb.toString());
    }

    @Test
    public void toChars() {
        Alphabet alphabet = new Alphabet("12223asd");
        int[] target = {1, 2, 1, 0, 5};
        String s = alphabet.toChars(target);
        assertEquals("2321d", s);
    }

}