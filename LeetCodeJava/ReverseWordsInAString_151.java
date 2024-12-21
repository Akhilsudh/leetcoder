import java.util.Stack;

public class ReverseWordsInAString_151 {

    public String reverseWords(String s) {
        StringBuilder sbr = new StringBuilder();
        String[] words = s.split("\\s+");
        for(int i = words.length - 1; i >= 0; i--) {
            if(!words[i].isEmpty()) {
                sbr.append(words[i]);
                sbr.append(" ");
            }
        }
        sbr.deleteCharAt(sbr.length() - 1);
        return sbr.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAString_151 obj = new ReverseWordsInAString_151();
        System.out.println(obj.reverseWords("the sky is blue"));
        System.out.println(obj.reverseWords("  hello    world  "));
    }
}
