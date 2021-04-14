public class PowerOf4 {
    // Loopy solution
    public boolean isPowerOfFour(int num) {
        if(num == 0) {
            return false;
        }
        while(num != 1) {
            if(num%4 != 0) {
                return false;
            }
            num = num/4;
        }
        return true;
    }
}