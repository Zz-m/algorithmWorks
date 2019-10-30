package cn.denghanxi.s53;

/**
 * Boyer-Moore 子字符串匹配算法
 */
public class BoyerMoore {

    private int[] right;
    private String pat;

    BoyerMoore(String pat) {
        this.pat = pat;
        int m = pat.length();
        int r = 256;
        //计算跳跃表
        right = new int[r];
        for (int c = 0; c < r; c++)
            right[c] = -1;
        for (int j = 0; j < m; j++)
            right[pat.charAt(j)] = j;
    }

    public int search(String txt) {
        int n = txt.length();
        int m = pat.length();
        int skip;
        for (int i = 0; i <= n - m; i += skip) {
            skip = 0;
            for (int j = m - 1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1) skip = 1;
                    break;
                }
            }
            if (skip == 0) return i;
        }
        return n;
    }
}
