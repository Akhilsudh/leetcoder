public class CountAndSay {
    public static String countAndSay(int n) {
        String result = "1";
        String temp = "";
        for(int i = 1; i < n; i++) {
            char start = result.charAt(0);
            int count = 0;
            temp = "";
            for(int j = 0; j < result.length(); j++) {
                if(start != result.charAt(j)) {
                    temp = temp + count + start;
                    start = result.charAt(j);
                    count = 1;
                    continue;
                }
                count++;
            }
            result = temp + count + start;
        }
        return result;
    }

    public static void main(String args[]) {
        System.out.println(countAndSay(5));
    }
}