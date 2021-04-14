import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StringToIntegerAtoi {
    public int myAtoi(String str) {
        String pattern = "(\\D*)(\\d+)(.*)";
        Pattern p = Pattern.compile(pattern);
        Boolean negative = false;
        Boolean canStart = true;
        int i = 0;
        int num;
        Matcher m = p.matcher(str);
        if(m.find()) {
            while(i < m.group(1).length() - 1) {
                if(m.group(1).charAt(i) != ' ') {
                    canStart = false;
                }
                i++;
            }
            if(canStart) {
                if(m.group(1).length() > 0){
                    if(m.group(1).charAt(m.group(1).length() - 1) == '-') {
                        negative = true;
                    }
                    else if(m.group(1).charAt(m.group(1).length() - 1) == '+') {
                        negative = false;
                    }
                    else if(m.group(1).charAt(m.group(1).length() - 1) != ' ') {
                        return 0;
                    }
                }
                try {
                    num = Integer.parseInt((negative)? "-"+m.group(2):m.group(2));
                    return num;
                }
                catch(NumberFormatException e) {
                    return (negative)? -2147483648:2147483647;
                }   
            }
        }
        else {
            return 0;
        }
        return 0;
    }
}