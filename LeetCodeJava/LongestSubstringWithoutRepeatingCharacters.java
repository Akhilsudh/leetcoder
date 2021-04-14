import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> substr = new HashSet<Character>();
        int max = 0;
        int i = 0, j = 0, size= s.length();
        
        while(i < size && j < size){
            if(!substr.contains(s.charAt(j))) {
                substr.add(s.charAt(j));
                j++;
                max = (max > j - i) ? max : j - i;
            }
            else {
                substr.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}