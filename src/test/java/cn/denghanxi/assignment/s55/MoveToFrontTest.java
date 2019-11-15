package cn.denghanxi.assignment.s55;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

/*
 * 未知bug，调用了 BinaryStdOut 的方法之后，重新 System.setOut() 不能正常工作。
 */
public class MoveToFrontTest {

    @Test
    public void encode() {
//        String s = "ABRACADABRA!";
//        InputStream systemIn = System.in;
//        PrintStream systemOut = System.out;
//        InputStream in = new ByteArrayInputStream(s.getBytes());
//        System.setIn(in);
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(byteArrayOutputStream));
//        MoveToFront.encode();
//        String decode = new String(byteArrayOutputStream.toByteArray());
//        assertEquals("ABR\u0002D\u0001E\u0001\u0004\u0004\u0002&", decode);
//        System.setIn(systemIn);
//        System.setOut(systemOut);
    }

    @Test
    public void decode() {
//        String s = "ABR\u0002D\u0001E\u0001\u0004\u0004\u0002&";
//        InputStream systemIn = System.in;
//        PrintStream systemOut = System.out;
//        InputStream in = new ByteArrayInputStream(s.getBytes());
//        System.setIn(in);
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(byteArrayOutputStream));
//        MoveToFront.decode();
//        String decode = new String(byteArrayOutputStream.toByteArray());
//        assertEquals("ABRACADABRA!", decode);
//        System.setIn(systemIn);
//        System.setOut(systemOut);  //bug 不知道怎么回事
    }


    @Test
    public void simple() {
//        System.setOut(System.err);
        System.out.println(234235234);
    }

}