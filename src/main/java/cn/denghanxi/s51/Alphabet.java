package cn.denghanxi.s51;

import java.util.ArrayList;
import java.util.List;

/**
 * 字母表
 */
public class Alphabet {

    private List<Character> chars = new ArrayList<>();

    /**
     * 根据s中的字符构造字符表
     *
     * @param s 字符串
     */
    public Alphabet(String s) {
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!chars.contains(c)) {
                chars.add(c);
            }
        }
    }

    /**
     * 获取字符表中索引位置的字符
     *
     * @param index 索引位置
     * @return 字符
     */
    public char toChar(int index) {
        return chars.get(index);
    }

    /**
     * 获取c的索引，在 0 到 R-1 之间
     *
     * @param c 字符c
     * @return 索引位置
     */
    public int toIndex(char c) {
        return chars.indexOf(c);
    }

    /**
     * 是否包含字符c
     *
     * @param c 字符c
     * @return 是否在字母表中
     */
    public boolean contains(char c) {
        return chars.contains(c);
    }

    /**
     * 基数-字母表中的字符数量
     * /
     * @return 基数
     */
    public int r() {
        return chars.size();
    }

    /**
     * 一个索引所需要的比特数
     *
     * @return 比特数
     */
    public int lgR() {
        return Double.valueOf(Math.ceil(Math.log(r()) / Math.log(2))).intValue();
    }

    /**
     * 将s转换为R进制的整数
     *
     * @param s s
     * @return 整数数组
     */
    public int[] toIndices(String s) {
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = toIndex(s.charAt(i));
        }
        return result;
    }

    /**
     * 将R进制的整数转换为基于该字母表的字符串
     *
     * @param indices 整数数组
     * @return 字符串
     */
    public String toChars(int[] indices) {
        char[] chars = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            chars[i] = toChar(indices[i]);
        }

        return new String(chars);
    }

}
