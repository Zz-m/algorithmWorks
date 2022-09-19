package cn.denghanxi.leetcode.q9;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        List<Integer> list = new ArrayList<>();
        while (x != 0) {
            list.add(x % 10);
            x = x / 10;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!Objects.equals(list.get(i), list.get(list.size() - 1 - i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(121));
    }
}
