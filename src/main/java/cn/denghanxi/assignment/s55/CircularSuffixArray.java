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
        initIndex(s, 0, s.length() - 1, 0);
    }

    private void initIndex(String s, int lo, int hi, int d) {
        if(hi <= lo) return;
        int lt = lo, gt = hi;
        int v = charAt(s, index[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(s, index[i], d);
            if (t < v) exch(lt++, i++);
            else if (t > v) exch(i, gt--);
            else i++;
        }
        initIndex(s, lo, lt - 1, d);
        if (v >= 0) initIndex(s, lt, gt, d + 1);
        initIndex(s, gt + 1, hi, d);
    }

    private void exch(int i, int j) {
        int tmp = index[i];
        index[i] = index[j];
        index[j] = tmp;
    }

    private int charAt(String s, int start, int index) {
        if (index == s.length()) return -1;
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
