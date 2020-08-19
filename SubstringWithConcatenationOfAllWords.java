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
        int count = 0;
        int counter = 0;
        int wordsLen = words.length;
        Map<String, Integer> wordSet = new HashMap<String, Integer>();
        for(String word: words) {
            if(!wordSet.containsKey(word)) {
                wordSet.put(word, 1);
            }
            else {
                count = wordSet.get(word);
                wordSet.put(word, ++count);
            }
        }
        Map<String, Integer> wordSetCopy = new HashMap<String, Integer>(wordSet);
        for(int i = 0; i < s.length(); i++) {
            int j = i + wordLen - 1;
            while(!wordSetCopy.isEmpty() && j < s.length()) {
                String subString = s.substring(j - wordLen + 1, j + 1);
                if(wordSetCopy.get(subString) != null && wordSetCopy.get(subString) > 0) {
                    counter++;
                    count = wordSetCopy.get(subString);
                    if(count == 0) {
                        wordSetCopy.remove(subString);
                    }
                    else {
                        wordSetCopy.put(subString, --count);
                    }
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
            wordSetCopy = new HashMap<String, Integer>(wordSet);
        }
        return result;
    }
}