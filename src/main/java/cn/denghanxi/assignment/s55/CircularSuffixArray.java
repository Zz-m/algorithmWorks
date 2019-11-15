package cn.denghanxi.assignment.s55;

import edu.princeton.cs.algs4.Quick3string;

import java.util.Arrays;

/**
 * Burrows–Wheeler 压缩算法的中间数据结构
 */
public class CircularSuffixArray {

    private int[] index;

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        if (s == null) throw new IllegalArgumentException("can not be null.");
        index = new int[s.length()];
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        int[] aux = new int[index.length];

        for (int d = s.length() - 1; d >= 0; d--) {
            int[] count = new int[257];
            for (int i = 0; i < s.length(); i++) {
                count[charAt(s, index[i], d) + 1]++;
            }
            for (int r = 0; r < 256; r++) {
                count[r + 1] += count[r];
            }
            for (int i = 0; i < s.length(); i++) {
                aux[count[charAt(s, index[i], d)]++] = index[i];
            }
            System.arraycopy(aux, 0, index, 0, s.length());
        }
    }

    private char charAt(String s, int start, int index) {
        int cur = (start + index) % s.length();
        return s.charAt(cur);
    }


    // length of s
    public int length() {
        return index.length;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i >= index.length) throw new IllegalArgumentException("out of bound.");
        return index[i];
    }

    // unit testing (required)
    public static void main(String[] args) {
        CircularSuffixArray array = new CircularSuffixArray("ABRACADABRA!");
        array.length();
        array.index(0);
    }
}
