import java.util.*;

public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<String>();
        generateBrackets("", 0, 0, n, results);
        return results;
    }
    static void generateBrackets(String result, int l, int r, int n, List<String> results) {
        if(l == n && r == n) {
            results.add(result);
            return;
        }
        if(r > l || l > n || r > n) {
            return;
        }
        generateBrackets(result + "(", l + 1, r, n, results);
        generateBrackets(result + ")", l, r + 1, n, results);
    }

    public static void main(String args[]) {
        System.out.println(generateParenthesis(3));
    }
}