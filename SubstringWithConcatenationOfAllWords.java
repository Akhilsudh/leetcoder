import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLen = 0;
        List<Integer> result = new ArrayList<Integer>();
        if(words.length != 0) {
            wordLen = words[0].length();
        }
        if(wordLen == 0) {
            return result;
        }
        int counter = 0;
        int wordsLen = words.length;
        List<String> wordSet = Arrays.asList(words);
        List<String> wordSetCopy = new ArrayList<String>(wordSet);
        for(int i = 0; i < s.length(); i++) {
            int j = i + wordLen - 1;
            while(!wordSetCopy.isEmpty() && j < s.length()) {
                String subString = s.substring(j - wordLen + 1, j + 1);
                if(wordSetCopy.contains(subString)) {
                    counter++;
                    wordSetCopy.remove(subString);
                    j = j + wordLen;
                }
                else {
                    break;
                }
            }
            if(counter == wordsLen) {
                result.add( j - wordLen - ((wordsLen * wordLen) - 1));
            }
            counter = 0;
            wordSetCopy = new ArrayList<String>(wordSet);
        }
        return result;
    }
}