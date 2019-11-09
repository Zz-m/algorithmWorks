package cn.denghanxi.assignment.s55;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MoveToFrontTest {

    @Test
    public void encode() throws Exception {
        String s = "ABASD";
        InputStream systemIn = System.in;
        PrintStream systemOut = System.out;
        InputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        MoveToFront.encode();
        System.setOut(systemOut); //bug 不知道怎么回事
        System.setIn(systemIn);
        System.out.println(123);
    }

    @Test
    public void decode() {
        String s = "AB\u0001SE";
        InputStream systemIn = System.in;
        PrintStream systemOut = System.out;
        InputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        MoveToFront.decode();
        String decode = new String(byteArrayOutputStream.toByteArray());
        assertEquals("ABASD", decode);
        System.setIn(systemIn);
        System.setOut(systemOut);  //bug 不知道怎么回事
    }


    @Test
    public void simple() {
//        System.setOut(System.err);
        System.out.println(234235234);
    }

}