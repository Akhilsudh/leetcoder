public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        // All pattern matched case
        if(p.isEmpty()) {
            return s.isEmpty();
        }

        // Initial match case
        boolean match = false;
        if((!s.isEmpty()) && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
            match = true;
        }

        // Wildcard case
        if((p.length() >= 2) && (p.charAt(1) == '*')) {
            return (isMatch(s, p.substring(2))) || ((match) && (isMatch(s.substring(1), p)));
        }

        // Progress to next character match
        else {
            return match && isMatch(s.substring(1), p.substring(1));
        }
    }
}