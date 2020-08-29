public class CountAndSay {
    public static String countAndSay(int n) {
        if(n <= 1) {
            return "1";
        }
        String res = countAndSay(n - 1);
        StringBuffer temp = new StringBuffer();
        char start = res.charAt(0);
        int count = 0;
        for(int j = 0; j < res.length(); j++) {
            if(start != res.charAt(j)) {
                temp.append(count).append(start);
                start = res.charAt(j);
                count = 1;
                continue;
            }
            count++;
        }
        return temp.append(count).append(start).toString();
    }

    public static void main(String args[]) {
        System.out.println(countAndSay(0));
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
    }
}