package cn.denghanxi.assignment.s55;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Burrows–Wheeler 压缩算法的中间步骤
 */
public class MoveToFront {

    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode() {
        byte[] bytes = createBytes();
        while (!BinaryStdIn.isEmpty()) {
            byte b = BinaryStdIn.readByte();
            for (int i = 0; i < bytes.length; i++) {
                if (bytes[i] == b) {
                    BinaryStdOut.write((byte) i);
                    swimChar(bytes, i);
                    break;
                }
            }
        }
        BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        byte[] bytes = createBytes();
        while (!BinaryStdIn.isEmpty()) {
            byte b = BinaryStdIn.readByte();
            BinaryStdOut.write((char) bytes[(int) b]);
            swimChar(bytes, (int) b);
        }
        BinaryStdOut.close();
    }

    private static byte[] createBytes() {
        byte[] bytes = new byte[256];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) i;
        }
        return bytes;
    }

    private static void swimChar(char[] chars, int i) {
        char c = chars[i];
        for (; i > 0; i--) {
            chars[i] = chars[i - 1];
        }
        chars[0] = c;
    }

    private static void swimChar(byte[] chars, int i) {
        byte c = chars[i];
        for (; i > 0; i--) {
            chars[i] = chars[i - 1];
        }
        chars[0] = c;
    }

    public static void main(String[] args) {
//        testEncode();
//        decode();
    }

    private static void testEncode() {
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(new File("D:\\z-tmp\\s55\\out.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.setOut(printStream);
        MoveToFront.encode();
    }
}
