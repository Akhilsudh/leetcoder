/*  https://leetcode.com/problems/valid-number/
    A valid number can be split up into these components (in order):
        A decimal number or an integer.
        (Optional) An 'e' or 'E', followed by an integer.
    A decimal number can be split up into these components (in order):
        (Optional) A sign character (either '+' or '-').
        One of the following formats:
            At least one digit, followed by a dot '.'.
            At least one digit, followed by a dot '.', followed by at least one digit.
            A dot '.', followed by at least one digit.
    An integer can be split up into these components (in order):
        (Optional) A sign character (either '+' or '-').
        At least one digit.
    For example, all the following are valid numbers: 
    ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], 
    while the following are not valid numbers: 
    ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].
*/
import java.util.regex.*;
public class ValidNumber {
  public boolean isNumber(String s) {
    String pattern = "(([+-]?)((\\d+[.]\\d*)|(\\d*[.]\\d+))|([+-]?\\d+))([eE][+-]?\\d+)?";
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(s);
    return m.matches();
  }

  public static void main(String[] args) {
    ValidNumber obj = new ValidNumber();
    System.out.println(obj.isNumber("2"));
    System.out.println(obj.isNumber("0089"));
    System.out.println(obj.isNumber("-0.1"));
    System.out.println(obj.isNumber("+3.14"));
    System.out.println(obj.isNumber("4."));
    System.out.println(obj.isNumber("-.9"));
    System.out.println(obj.isNumber("-9"));
    System.out.println(obj.isNumber("+6e-1"));
    System.out.println(obj.isNumber("3e+7"));
    System.out.println(obj.isNumber("-123.456e789"));
    System.out.println(obj.isNumber("-+3"));
    System.out.println(obj.isNumber("--6"));
    System.out.println(obj.isNumber("99e2.5"));
    System.out.println(obj.isNumber("6+1"));
  }
}
