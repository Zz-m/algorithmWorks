package cn.denghanxi.assignment.s55;

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
        int[] index2 = new int[index.length];
        StringBuilder stringBuilder = new StringBuilder(s);
        char c = stringBuilder.charAt(s.length() - 1);
        stringBuilder.deleteCharAt(s.length() - 1);
        stringBuilder.insert(0, c);
        String[] aux = new String[s.length()];
        String[] sort = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            c = stringBuilder.charAt(0);
            stringBuilder.deleteCharAt(0);
            stringBuilder.append(c);
            aux[i] = stringBuilder.toString();
            sort[i] = aux[i];
        }
        for (int d = s.length() - 1; d >= 0; d--) {
            int[] count = new int[256 + 1];
            for (int k = 0; k < sort.length; k++)
                count[sort[k].charAt(d) + 1]++;
            for (int r = 0; r < 256; r++)
                count[r + 1] += count[r];
            for (int i = 0; i < sort.length; i++) {
                index2[count[sort[i].charAt(d)]] = index[i];
                aux[count[sort[i].charAt(d)]++] = sort[i];
            }
            for (int i = 0; i < sort.length; i++) {
                index[i] = index2[i];
                sort[i] = aux[i];
            }
        }
        System.out.println();
    }

    // length of s
    public int length() {
        return index.length;
    }

    // returns index of ith sorted suffix
    public int index(int i) {
        if (i < 0 || i > index.length) throw new IllegalArgumentException("out of bound.");
        return index[i];
    }

    // unit testing (required)
    public static void main(String[] args) {
        new CircularSuffixArray("ABRACADABRA!");
    }
}
