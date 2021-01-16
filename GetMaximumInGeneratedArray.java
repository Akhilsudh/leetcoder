/*  https://leetcode.com/problems/get-maximum-in-generated-array/
    You are given an integer n. An array nums of length n + 1 is generated in the following way:
    nums[0] = 0
    nums[1] = 1
    nums[2 * i] = nums[i] when 2 <= 2 * i <= n
    nums[2 * i + 1] = nums[i] + nums[i + 1] when 2 <= 2 * i + 1 <= n
    Return the maximum integer in the array nums​​​.
*/
public class GetMaximumInGeneratedArray {
  public int getMaximumGenerated(int n) {
    int max = 0;
    int arr[] = new int[n + 1];
    arr[0] = 0;
    if(n > 0) {
      arr[1] = 1;
      max = 1;
    }
    int index;
    int value;
    for(int i = 1; i <= n / 2; i++) {
      index = i * 2;
      value = arr[i];
      max = Math.max(max, value);
      arr[index] = value;
      index = i * 2 + 1;
      if(index <= n) {
        value = arr[i] + arr[i + 1];
        max = Math.max(max, value);
        arr[index] = value;
      }
      else {
        break;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    GetMaximumInGeneratedArray obj = new GetMaximumInGeneratedArray();
    System.out.println(obj.getMaximumGenerated(0));
    System.out.println(obj.getMaximumGenerated(7));
    System.out.println(obj.getMaximumGenerated(100));
  }
}
