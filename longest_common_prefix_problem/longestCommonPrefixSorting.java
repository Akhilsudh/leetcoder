package longest_common_prefix_problem;

import java.io.*;
import java.util.*;

public class longestCommonPrefixSorting {
    public static String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if(strs.length == 0){
            return prefix;
        }
        Arrays.sort(strs);
        int len = (strs[0].length() < strs[strs.length - 1].length())?strs[0].length():strs[strs.length - 1].length();
        int i = 0;
        while(i < len){
            if(strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
                prefix = prefix + strs[0].charAt(i);
                i++;
            }
            else {
                break;
            }
        }
        return prefix;
    }

    public static void main(String args[]) throws IOException {
        String [] arr = {"Aang", "Aang Avatar", "Aang Last Air Bender"};
        System.out.println("The largest common prefix is : " + longestCommonPrefix(arr));
        String [] arr2 = {"Akhil", "Akhil Sudhakaran", "Akhi", "Akhu"};
        System.out.println("The largest common prefix is : " + longestCommonPrefix(arr2));
        String [] arr3 = {"Aang", "Aang Avatar", "Zuko", "Azula"};
        System.out.println("The largest common prefix is : " + longestCommonPrefix(arr3));
    }
}