package cn.denghanxi.assignment.s55;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
import edu.princeton.cs.algs4.Queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Burrows–Wheeler 变换
 */
public class BurrowsWheeler {

    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output
    public static void transform() {
        while (!BinaryStdIn.isEmpty()) {
            String s = BinaryStdIn.readString();
            CircularSuffixArray array = new CircularSuffixArray(s);
            for (int i = 0; i < array.length(); i++) {
                if (array.index(i) == 0) {
                    BinaryStdOut.write(i);
                    break;
                }
            }
            for (int i = 0; i < array.length(); i++) {
                BinaryStdOut.write((byte) s.charAt(array.index(i) - 1 >= 0 ? array.index(i) - 1 : array.length() - 1));
            }
        }
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform() {
        int first = BinaryStdIn.readInt();
        ArrayList<Character> data = new ArrayList<>();
        while (!BinaryStdIn.isEmpty()) {
            data.add(BinaryStdIn.readChar());
        }
        char[] rawData = new char[data.size()];
        char[] sortedRawData = new char[data.size()];
        for (int i = 0; i < data.size(); i++) {
            rawData[i] = data.get(i);
            sortedRawData[i] = data.get(i);
        }
        //Arrays.sort(sortedRawData);
        char[] aux = new char[sortedRawData.length];
        int[] count = new int[256 + 1];
        for (char sortedRawDatum : sortedRawData) count[sortedRawDatum + 1]++;
        for (int r = 0; r < 256; r++)
            count[r + 1] += count[r];
        for (char sortedRawDatum : sortedRawData) aux[count[sortedRawDatum]++] = sortedRawDatum;
        System.arraycopy(aux, 0, sortedRawData, 0, sortedRawData.length);
        //sorted finish
        int[] next = new int[data.size()];
        Map<Character, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < sortedRawData.length; i++) {
            char b = rawData[i];
            Queue<Integer> list = map.computeIfAbsent(b, bb -> new Queue<>());
            list.enqueue(i);
        }
        for (int i = 0; i < sortedRawData.length; i++) {
            char b = sortedRawData[i];
            int index = map.get(b).dequeue();
            if (index == i) {
                map.get(b).enqueue(index);
                index = map.get(b).dequeue();
            }
            next[i] = index;
        }
        int cur = first;
        for (int i = 0; i < sortedRawData.length; i++) {
            BinaryStdOut.write(sortedRawData[cur]);
            cur = next[cur];
        }
        BinaryStdOut.close();
    }


    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args) {
        switch (args[0]) {
            case "+":
                inverseTransform();
                break;
            case "-":
                transform();
                break;
            default:
                throw new IllegalArgumentException(" must be + or -");
        }
    }
}
