package cn.denghanxi.s54;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
//        Pattern pattern = Pattern.compile("A+|(A*BA*BA*)+");
        Pattern pattern = Pattern.compile("(0|1(01*0)*1)*");
//        Pattern pattern = Pattern.compile("([A]*)");
        Matcher matcher = pattern.matcher("10");
        System.out.println(matcher.matches());
        System.out.println("start");
        while (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println("------------");
        }
        System.out.println("end");


    }
}
