import java.util.*;

public class MissingNumber {
  public int missingNumber(int[] nums) {
    int n = nums.length;
    Set<Integer> set = new HashSet<Integer>();
    for(int num: nums) {
      set.add(num);
    }
    for(int i = 0; i <= n; i++) {
      if(!set.contains(i)) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    MissingNumber obj = new MissingNumber();
    System.out.println("The solution for array [3,0,1] = " + obj.missingNumber(new int[] {3,0,1}));
    System.out.println("The solution for array [0,1] = " + obj.missingNumber(new int[] {0,1}));
    System.out.println("The solution for array [9,6,4,2,3,5,7,0,1] = " + obj.missingNumber(new int[] {9,6,4,2,3,5,7,0,1}));
    System.out.println("The solution for array [0] = " + obj.missingNumber(new int[] {0}));
  }
}
