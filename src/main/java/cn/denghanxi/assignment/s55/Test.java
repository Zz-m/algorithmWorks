package cn.denghanxi.assignment.s55;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println((char)41);
        System.out.println((char)42);
        String s = ")***))***)";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        System.out.println("---");
        for (char c : chars) {
            System.out.print(c);
        }
        System.out.println("");
        System.out.println("---");
    }
}
