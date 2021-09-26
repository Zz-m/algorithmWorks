package cn.denghanxi.leetcode.q7;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 */
class Solution {
    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) ? 0 : (int)result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(1534236469));
        System.out.println(new Solution().reverse(3653456456));
    }
}
