package cn.denghanxi.leetcode.q9;

public class Solution {
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        StringBuilder sb1 = new StringBuilder(s).reverse();
        return s.equals(sb1.toString());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
    }
}
