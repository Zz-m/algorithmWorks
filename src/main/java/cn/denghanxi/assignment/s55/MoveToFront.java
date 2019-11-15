package cn.denghanxi.assignment.s55;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;


/**
 * Burrows–Wheeler 压缩算法的中间步骤
 */
public class MoveToFront {

    // apply move-to-front encoding, reading from standard input and writing to standard output
    public static void encode() {
        char[] chars = createChars();
        while (!BinaryStdIn.isEmpty()) {
            char c = BinaryStdIn.readChar();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == c) {
                    BinaryStdOut.write((char) i);
                    swimChar(chars, i);
                    break;
                }
            }
        }
        BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from standard input and writing to standard output
    public static void decode() {
        char[] chars = createChars();
        while (!BinaryStdIn.isEmpty()) {
            int index = BinaryStdIn.readChar();
            BinaryStdOut.write(chars[index]);
            swimChar(chars, index);
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

    private static char[] createChars() {
        char[] chars = new char[256];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) i;
        }
        return chars;
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
        switch (args[0]) {
            case "+":
                decode();
                break;
            case "-":
                encode();
                break;
            default:
                throw new IllegalArgumentException(" must be + or -");
        }
    }

}
