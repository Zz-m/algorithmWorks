package cn.denghanxi.leetcode.q5;


/**
 * Given a string s, return the longest palindromic substring in s.
 */
public class Solution {


    public String longestPalindrome(String s) {
        int length = -1;
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int j, k, l;
            j = i;
            k = i;
            l = -1;
            while (j >= 0 && k < s.length()) {
                if (s.charAt(j) == s.charAt(k)) {
                    l += 2;
                    if (l > length) {
                        start = j;
                        end = k;
                        length = l;
                    }
                    j--;
                    k++;
                } else {
                    break;
                }
            }
            j = i;
            k = i + 1;
            l = 0;
            while (j >= 0 && k < s.length()) {
                if (s.charAt(j) == s.charAt(k)) {
                    l += 2;
                    if (l > length) {
                        start = j;
                        end = k;
                        length = l;
                    }
                    j--;
                    k++;
                } else {
                    break;
                }
            }
        }
        return s.substring(start, end + 1);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        long begin = System.nanoTime();
        System.out.println(solution.longestPalindrome("ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy"));
//        System.out.println(solution.longestPalindrome("asd"));
        long end = System.nanoTime();
        long used = (end - begin) / 1_000_000;
        System.out.println(used + " ms");
    }

}
