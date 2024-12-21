import java.util.*;
public class TextJustification_68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> wordsPerLine = new ArrayList<>();
        String line = "";
        List<Integer> characterLengthList = new ArrayList<>();
        List<String> lineWords = new ArrayList<>();
        Integer charLength = 0;
        for(int i = 0; i < words.length; i++) {
            String temp = line + words[i] + " ";
            if(temp.length() - 1 <= maxWidth) {
                line = temp;
                lineWords.add(words[i]);
                charLength += words[i].length();
                continue;
            } else {
                i--;
                line = "";
                characterLengthList.add(charLength);
                charLength = 0;
                wordsPerLine.add(lineWords);
                lineWords = new ArrayList<>();
            }
        }
        if(!lineWords.isEmpty()) {
            wordsPerLine.add(lineWords);
            characterLengthList.add(charLength);
        }

        List<String> result = new ArrayList<>();

        for(int i = 0; i < wordsPerLine.size() - 1; i++) {
            int noOfWords = wordsPerLine.get(i).size();
            int noOfSpaces = maxWidth - characterLengthList.get(i);
            int noOfBaseSpaces = noOfSpaces / noOfWords - 1;
            int noOfExtraSpaces = noOfSpaces % noOfWords;
            String currentLine = "";
            for(String word: wordsPerLine.get(i)) {
                currentLine += word;
                int temp = noOfBaseSpaces;
                while(temp > 0) {
                    currentLine += " ";
                    temp--;
                }
                if (noOfExtraSpaces > 0) {
                    currentLine += " ";
                    noOfExtraSpaces--;
                }
            }
            if(wordsPerLine.get(i).size() > 1) {
                currentLine = currentLine.substring(0, currentLine.length() - noOfBaseSpaces);
            }
            result.add(currentLine);
        }
        List<String> tempList = wordsPerLine.get(wordsPerLine.size() - 1);
        String currentLink = "";
        for(String word: tempList) {
            currentLink += word + " ";
        }
        int extraspaceNeeded = maxWidth - currentLink.length();
        for(int i = 0; i < extraspaceNeeded; i++) {
            currentLink += " ";
        }
        result.add(currentLink);
        return result;
    }

    public static void main(String[] args) {
        TextJustification_68 obj = new TextJustification_68();
        System.out.println(obj.fullJustify(new String[] {"This", "is", "an", "example", "of", "text", "justification."}, 16));
//        System.out.println(obj.fullJustify(new String[] {"What","must","be","acknowledgment","shall","be"}, 16));
    }
}
