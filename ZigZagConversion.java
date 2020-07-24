public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 0 || numRows == 1 || s.length() <= numRows) {
            return s;
        }
        boolean flag = true;
        int row = 0, a = 2 * (numRows - 1) - 1, b = -1, i = 0;
        String res = "";
        while(row < numRows) {
            if(b == -1){
                if(i >= s.length()){
                    b += 2;
                    a -= 2;
                    row++;
                    i  = row;
                    continue;
                }
                res = res + s.charAt(i);
                i += a + 1;
            }
            else if(a == -1){
                if(i >= s.length()){
                    row++;
                    i  = row;
                    continue;
                }
                res = res + s.charAt(i);
                i += b + 1;
            }
            
            else if(flag) {
                if(i >= s.length()){
                    a -= 2;
                    b += 2;
                    row++;
                    i  = row;
                    continue;
                }
                flag = false;
                res = res + s.charAt(i);
                i += a + 1;
            }
            else if(!flag) {
                if(i >= s.length()){
                    a -= 2;
                    b += 2;
                    row++;
                    i  = row;
                    flag = true;
                    continue;
                }
                flag = true;
                res = res + s.charAt(i);
                i += b + 1;
            }
        }
        return res;
    }
}