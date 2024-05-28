import java.util.*;
import java.io.*;

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int result = 0;
        int sum = 0;
        int start = 0;
        Set set = new HashSet<Character>();
        for(int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])) {
                while(start < i) {
                    set.remove(arr[start]);
                    start += 1;
                    sum -= 1;
                    if(arr[start - 1] == arr[i]) {
                        break;
                    }
                }
            }
            sum += 1;
            set.add(arr[i]);
            result = Math.max(sum, result);
        }
        return result;
    }

    public static void main(String[] args) throws IOException{
        LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
        int a = obj.lengthOfLongestSubstring("abcabcbb");
        int b = obj.lengthOfLongestSubstring("bbbbb");
        int c = obj.lengthOfLongestSubstring("pwwkew");
        int d = obj.lengthOfLongestSubstring("dvdf");
        assert a == 3 : "The expected length is 3 since longest substring is abc, not " + a;
        assert b == 1 : "The expected length is 1 since longest substring is b, not " + b;
        assert c == 3 : "The expected length is 3 since longest substring is wke, not " + c;
        assert d == 3 : "The expected length is 3 since longest substring is vdf, not " + d;
        System.out.println("All test cases ran as expected");
    }

}
