public class ImplementstrStr {
    public static int strStr(String haystack, String needle) {
        char[] haystackarr = haystack.toCharArray();
        char[] needlearr = needle.toCharArray();
        if(needlearr.length == 0) {
            return 0;
        }
        if(haystackarr.length < needlearr.length) {
            return -1;
        }
        int j = 0;
        for(int i = 0; i < haystackarr.length; i++) {
            if(haystackarr[i] == needlearr[j]) {
                j++;
            }
            else {
                i = i - j;
                j = 0;
            }
            if(j == needlearr.length) {
                i++;
                return i - j;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        System.out.println(strStr("hello", ""));
        System.out.println(strStr("hello", "lo"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("aaaaa", "aaaaaa"));
    }
}