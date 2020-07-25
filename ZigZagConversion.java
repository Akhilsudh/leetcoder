public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(numRows < 2){
            return s;
        }
        String[] rows = new String[numRows];
        Arrays.fill(rows, "");
        int rowNum = 0;
        boolean directionDown = true;
        int i = 0;
        int n = s.length();
        while(i < n) {
            if(directionDown) {
                rows[rowNum] = rows[rowNum] + s.charAt(i);
                i++;
                if(rowNum == numRows - 1) {
                    rowNum--;
                    directionDown = false;
                    continue;
                }
                rowNum++;
            }
            else {
                rows[rowNum] = rows[rowNum] + s.charAt(i);
                i++;
                if(rowNum == 0){
                    rowNum++;    
                    directionDown = true;
                    continue;
                }
                rowNum--;
            }
        }
        return String.join("", rows);
    }
}
