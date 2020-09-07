public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) ? 1 : -1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;
        while(dividend - divisor >= 0) {
            int temp = 0;
            while(dividend - (divisor << 1 << temp) >= 0) {
                temp++;
            }
            result += 1 << temp;
            dividend -= divisor << temp;
        }
        return sign * result;
    }
}